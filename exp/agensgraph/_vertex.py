'''
Copyright (c) 2014-2017, Bitnine Inc.

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

import re

from psycopg2 import InterfaceError
from psycopg2.extras import json

from ._graphid import cast_graphid

_pattern = re.compile(r'(.+?)\[(.+?)\](.*)', re.S)

class Vertex(object):
    def __init__(self, label, vid, props):
        self.label = label
        self.vid = vid
        self.props = props

    def __eq__(self, other):
        if isinstance(self, other.__class__):
            return self.vid == other.vid
        return False

    def __repr__(self):
        return "%s(%s)" % (self.__class__.__name__, self)

    def __str__(self):
        return "%s[%s]%s" % (self.label, self.vid, json.dumps(self.props))

def cast_vertex(value, cur):
    if value is None:
        return None

    m = _pattern.match(value)
    if m:
        label = m.group(1)
        vid = cast_graphid(m.group(2), cur)
        props = json.loads(m.group(3))
        return Vertex(label, vid, props)
    else:
        raise InterfaceError("bad vertex representation: %s" % value)
