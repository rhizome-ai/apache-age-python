
from .graph import Graph
from .gen.ageLexer import ageLexer
from .gen.ageParser import ageParser
from .gen.ageListener import ageListener
from .gen.ageVisitor import ageVisitor
from .models import *
from antlr4 import *

class ResultHandler:
    def handleRow(rawString):
        pass


def buildGraph(cursor, resultHandler:ResultHandler=None):
    if resultHandler == None:
        resultHandler = Antlr4ResultHandler(cursor.query)
   
    graph = Graph(cursor.query)

    for record in cursor:
        parsed = resultHandler.handleRow(record[0])
        graph.append(parsed)

    return graph

def getRows(cursor):
    resultHandler = Antlr4ResultHandler(cursor.query)
    for record in cursor:
        yield resultHandler.handleRow(record[0])

class Antlr4ResultHandler(ResultHandler):
    def __init__(self, query=None):
        self.lexer = ageLexer()
        self.parser = ageParser(None)
        self.visitor = ResultVisitor()
        self.graph = Graph(query)

    def handleRow(self, rawString):
        self.lexer.inputStream = InputStream(rawString)
        self.parser.setTokenStream(CommonTokenStream(self.lexer))
        self.parser.reset()
        tree = self.parser.ageout()
        parsed = tree.accept(self.visitor)
        return parsed

    def getGraph(self):
        return self.graph

# print raw result String
class DummyResultHandler(ResultHandler):
    def handleRow(self, rawString):
        print(rawString)

# default ageout visitor
class ResultVisitor(ageVisitor):
    def visitAgeout(self, ctx:ageParser.AgeoutContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ageParser#vertex.
    def visitVertex(self, ctx:ageParser.VertexContext):
        vertex = Vertex()
        proCtx = ctx.getTypedRuleContext(ageParser.PropertiesContext,0)

        dict = proCtx.accept(self)
        vertex.id = dict["id"]
        vertex.label = dict["label"]
        vertex.properties = dict["properties"]
        
        return vertex


    # Visit a parse tree produced by ageParser#edge.
    def visitEdge(self, ctx:ageParser.EdgeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ageParser#path.
    def visitPath(self, ctx:ageParser.PathContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ageParser#value.
    def visitValue(self, ctx:ageParser.ValueContext):
        c = ctx.getChild(0)
        if isinstance(c, ageParser.PropertiesContext) or isinstance(c,ageParser.ArrContext):
            val = c.accept(self)
            return val
        else:
            val = c.getText().strip('"')
            return val



    # Visit a parse tree produced by ageParser#properties.
    def visitProperties(self, ctx:ageParser.PropertiesContext):
        props = dict()
        for c in ctx.getChildren():
            if isinstance(c, ageParser.PairContext):
                namVal = self.visitPair(c)
                name = namVal[0]
                valCtx = namVal[1]
                val = valCtx.accept(self) 
                props[name] = val
        return props

    # Visit a parse tree produced by ageParser#pair.
    def visitPair(self, ctx:ageParser.PairContext):
        self.visitChildren(ctx)
        return (ctx.STRING().getText().strip('"') , ctx.value())


    # Visit a parse tree produced by ageParser#arr.
    def visitArr(self, ctx:ageParser.ArrContext):
        li = list()
        for c in ctx.getChildren():
            if not isinstance(c, TerminalNode):
                val = c.accept(self)
                li.append(val)
        return li
