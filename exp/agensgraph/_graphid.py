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
from psycopg2.extensions import AsIs

_pattern = re.compile(r'(\d+)\.(\d+)')

class GraphId(object):
    def __init__(self, gid):
        self.gid = gid

    def getId(self):
        return self.gid

    def __eq__(self, other):
        if isinstance(self, other.__class__):
            return self.gid == other.gid
        return False

    def __repr__(self):
        return "%s(%s)" % (self.__class__.__name__, self)

    def __str__(self):
        return "%d.%d" % self.gid

def cast_graphid(value, cur):
    if value is None:
        return None

    m = _pattern.match(value)
    if m:
        labid = int(m.group(1))
        locid = int(m.group(2))
        gid = (labid, locid)
        return GraphId(gid)
    else:
        raise InterfaceError("bad graphid representation: %s" % value)

def adapt_graphid(graphid):
    return AsIs("'%s'" % graphid)
