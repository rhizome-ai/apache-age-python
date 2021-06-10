
from .graph import Graph
from .gen.ageLexer import ageLexer
from .gen.ageParser import ageParser
from .gen.ageListener import ageListener
from antlr4 import *

class ResultHandler:
    def handleRow(graph, rawString):
        pass
     
class Formatter(ageListener):
    pass
     
def buildResult(cursor, resultHandler:ResultHandler=None, formatter:Formatter=None):
    graph = Graph(cursor.query)

    if resultHandler == None:
        if formatter == None:
            formatter = DefaultFormatter()

        resultHandler = Antlr4ResultHandler(formatter)
    
    for record in cursor:
        resultHandler.handleRow(graph, record[0])

    return graph

class Antlr4ResultHandler(ResultHandler):
    def __init__(self, formatter:Formatter):
        self.formatter = formatter
        pass

    def handleRow(self, graph, rawString):
        rawstream = InputStream(rawString)
        lexer = ageLexer(rawstream)
        stream = CommonTokenStream(lexer)
        parser = ageParser(stream)
        tree = parser.ageout()
        walker = ParseTreeWalker()
        walker.walk(self.formatter, tree)

# print raw result String
class DummyResultHandler(ResultHandler):
    def handleRow(self, graph, rawString):
        print(rawString)

class DefaultFormatter(Formatter):   
    def enterVertex(self, ctx:ageParser.VertexContext):
        print("vertex", ctx.properties) 
    def enterProperties(self, ctx:ageParser.PropertiesContext):
        print("Properties", ctx) 
    def enterValue(self, ctx:ageParser.ValueContext):
        print("Value", ctx) 