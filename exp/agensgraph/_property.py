'''
Copyright (c) 2014-2018, Bitnine Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
'''

import sys

from psycopg2.extensions import ISQLQuote
from psycopg2.extras import json

# borrowed from simplejson's compat.py
if sys.version_info[0] < 3:
    string_types = (basestring,)
    integer_types = (int, long)
    def dict_items(o):
        return o.iteritems()
else:
    string_types = (str,)
    integer_types = (int,)
    def dict_items(o):
        return o.items()

def quote_string(s):
    s = s[1:-1]
    s = "'" + s.replace("'", "''") + "'"
    return s

class PropertyEncoder(object):
    def encode(self, o):
        chunks = self.iterencode(o)
        if not isinstance(chunks, (list, tuple)):
            chunks = list(chunks)
        return ''.join(chunks)

    def iterencode(self, o):
        markers = {}
        _iterencode = _make_iterencode(markers, json.dumps, quote_string)
        return _iterencode(o)

def _make_iterencode(markers, _encoder, _quote_string,
                     dict=dict,
                     float=float,
                     id=id,
                     isinstance=isinstance,
                     list=list,
                     tuple=tuple,
                     string_types=string_types,
                     integer_types=integer_types,
                     dict_items=dict_items):
    def _iterencode_list(o):
        if not o:
            yield '[]'
            return

        markerid = id(o)
        if markerid in markers:
            raise ValueError('Circular reference detected')
        markers[markerid] = o

        yield '['
        first = True
        for e in o:
            if first:
                first = False
            else:
                yield ','

            for chunk in _iterencode(e):
                yield chunk
        yield ']'

        del markers[markerid]

    def _iterencode_dict(o):
        if not o:
            yield '{}'
            return

        markerid = id(o)
        if markerid in markers:
            raise ValueError('Circular reference detected')
        markers[markerid] = o

        yield '{'
        first = True
        for k, v in dict_items(o):
            if isinstance(k, string_types):
                pass
            elif (k is True or k is False or k is None or
                  isinstance(k, integer_types) or isinstance(k, float)):
                k = _encoder(k)
            else:
                raise TypeError('keys must be str, int, float, bool or None, '
                                'not %s' % k.__class__.__name__)

            if first:
                first = False
            else:
                yield ','

            yield _quote_string(_encoder(k))
            yield ':'
            for chunk in _iterencode(v):
                yield chunk
        yield '}'

        del markers[markerid]

    def _iterencode(o):
        if isinstance(o, string_types):
            yield _quote_string(_encoder(o))
        elif isinstance(o, (list, tuple)):
            for chunk in _iterencode_list(o):
                yield chunk
        elif isinstance(o, dict):
            for chunk in _iterencode_dict(o):
                yield chunk
        else:
            yield _encoder(o)

    return _iterencode

_default_encoder = PropertyEncoder()

class Property(object):
    def __init__(self, value):
        self.value = value

    def __conform__(self, proto):
        if proto is ISQLQuote:
            return self

    def prepare(self, conn):
        self._conn = conn

    def getquoted(self):
        return _default_encoder.encode(self.value)
