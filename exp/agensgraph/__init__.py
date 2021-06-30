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

from psycopg2 import extensions as _ext

from ._graphid import (
    GraphId, cast_graphid as _cast_graphid, adapt_graphid as _adapt_graphid)
from ._vertex import Vertex, cast_vertex as _cast_vertex
from ._edge import Edge, cast_edge as _cast_edge
from ._graphpath import Path, cast_graphpath as _cast_graphpath
from ._property import Property

_GRAPHID_OID = 7002
_VERTEX_OID = 7012
_EDGE_OID = 7022
_GRAPHPATH_OID = 7032

GRAPHID = _ext.new_type((_GRAPHID_OID,), 'GRAPHID', _cast_graphid)
_ext.register_type(GRAPHID)
_ext.register_adapter(GraphId, _adapt_graphid)

VERTEX = _ext.new_type((_VERTEX_OID,), 'VERTEX', _cast_vertex)
_ext.register_type(VERTEX)

EDGE = _ext.new_type((_EDGE_OID,), 'EDGE', _cast_edge)
_ext.register_type(EDGE)

PATH = _ext.new_type((_GRAPHPATH_OID,), 'PATH', _cast_graphpath)
_ext.register_type(PATH)

__all__ = ['GraphId', 'Vertex', 'Edge', 'Path', 'Property',
           'GRAPHID', 'VERTEX', 'EDGE', 'PATH']

__name__="agensgraph"