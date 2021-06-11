
from .graph import Graph
from .gen.ageLexer import ageLexer
from .gen.ageParser import ageParser
from .gen.ageListener import ageListener
from .gen.ageVisitor import ageVisitor
from antlr4 import *

class ResultHandler:
    def handleRow(graph, rawString):
        pass
     
class Formatter(ageListener):
    pass
     
def buildResult(cursor, resultHandler:ResultHandler=None):
    graph = Graph(cursor.query)

    if resultHandler == None:
        resultHandler = Antlr4ResultHandler()
    
    for record in cursor:
        resultHandler.handleRow(graph, record[0])

    return graph

class Antlr4ResultHandler(ResultHandler):
    def __init__(self):
        self.lexer = ageLexer()
        stream = CommonTokenStream(self.lexer)
        self.parser = ageParser(stream)
        self.visitor = ResultVisitor()

    def handleRow(self, graph, rawString):
        rawstream = InputStream(rawString)
        self.lexer.inputStream = rawstream
        self.parser.reset()
        tree = self.parser.ageout()
        parsed = tree.accept(self.visitor)
        print(parsed)
        # walker = ParseTreeWalker()
        # walker.walk(self.formatter, tree)

# print raw result String
class DummyResultHandler(ResultHandler):
    def handleRow(self, graph, rawString):
        print(rawString)

class ResultVisitor(ageVisitor):
    def __init__(self) -> None:
        self.root = None

    def visitAgeout(self, ctx:ageParser.AgeoutContext):
        self.root = None
        self.visitChildren(ctx)
        return self.root


    # Visit a parse tree produced by ageParser#vertex.
    def visitVertex(self, ctx:ageParser.VertexContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ageParser#edge.
    def visitEdge(self, ctx:ageParser.EdgeContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ageParser#path.
    def visitPath(self, ctx:ageParser.PathContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ageParser#value.
    def visitValue(self, ctx:ageParser.ValueContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ageParser#properties.
    def visitProperties(self, ctx:ageParser.PropertiesContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ageParser#pair.
    def visitPair(self, ctx:ageParser.PairContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by ageParser#arr.
    def visitArr(self, ctx:ageParser.ArrContext):
        return self.visitChildren(ctx)

