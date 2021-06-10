import psycopg2 
from psycopg2 import errors
from .exceptions import *
from .graph_builder import buildResult, ResultHandler, Formatter


_EXCEPTION_NoConnection = NoConnection()
_EXCEPTION_GraphNotSet = GraphNotSet()
_EXCEPTION_NoCursor = NoCursor()


class Age:
    def __init__(self):
        self.conn = None    # psycopg2 connection
        self.cursor = None  # psycopg2 cursor
        self.graphName = None

    def connect(self, dsn=None, graph=None, connection_factory=None, cursor_factory=None, **kwargs):
        conn = psycopg2.connect(dsn, connection_factory, cursor_factory, **kwargs)
        cursor = conn.cursor()
        self.conn = conn
        self.cursor = cursor
        self.cursor.execute("LOAD 'age'")
        self.cursor.execute("SET search_path = ag_catalog, '$user', public;")
        if graph != None:
            self.setGraph(graph)
        return self

    def close(self):
        self.cursor.close()
        self.conn.close()

    def setGraph(self, graph):
        if self.graphExists(graph) :
            # apache age doesn't have configuration parameter "graph_path" 
            # self.cursor.execute("SET graph_path = %s", (graph,))
            self.graphName = graph
            return self
        else:
            raise GraphNotFound(graph)
        return self

    def graphExists(self, graph):
        self.cursor.execute("SELECT count(*) FROM ag_graph WHERE name=%s", (graph,))
        return self.cursor.fetchone()[0] > 0 

    def createGraph(self, graphName):
        if self.graphExists(graphName) :
            raise GraphAlreadyExists(graphName)
        else:
            self.cursor.execute("SELECT create_graph(%s)", (graphName,))

    def newCursor(self):
        self.cursor.close()
        self.cursor = self.conn.cursor()
        return self

    def _checkReady(self):
        if self.graphName == None:
            raise execptions._EXCEPTION_GraphNotSet
        if self.conn == None:
            raise _EXCEPTION_NoConnection
        if self.cursor == None:
            raise _EXCEPTION_NoCursor

    def _checkGraphName(self):
        if self.graphName == None:
            raise _EXCEPTION_GraphNotSet
            

    def commit(self):
        self.cursor.commit()
        
    def rollback(self):
        self.cursor.rollback()
        
    def execSql(self, stmt, *args):
        self._checkReady()
        self.cursor.execute(stmt, *args)
        return self.cursor
        

    def execCypher(self, cypherStmt, *args):
        self._checkGraphName()
        stmt = "SELECT * from cypher('"+self.graphName+"', $$ "+cypherStmt+" $$) as (v agtype);"
        return self.execSql(stmt, *args)

    def querySql(self, stmt, *args):
        return self.execSql(stmt, *args)
        

    def queryCypher(self, cypherStmt, resultHandler:ResultHandler=None, formatter:Formatter=None, *args):
        cur = self.execCypher(cypherStmt, *args)
        return buildResult(cur, resultHandler=resultHandler, formatter=formatter)

