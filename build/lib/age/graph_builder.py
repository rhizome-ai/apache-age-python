
from .graph import Graph
from .gen.ageLexer import ageLexer
from .gen.ageParser import ageParser
from .gen.ageListener import ageListener
from antlr4 import *

class ResultHandler:
    def handleRow(graph, rawString):
        pass
     
def buildResult(cursor, resultHandler=None):
    graph = Graph(cursor.query)

    if resultHandler == None:
        resultHandler = Antlr4ResultHandler()
    
    for record in cursor:
        resultHandler.handleRow(graph, record[0])

    return graph

class Antlr4ResultHandler(ResultHandler):
    def __init__(self):
        pass

    def handleRow(self, graph, rawString):
        rawstream = InputStream(rawString)
        lexer = ageLexer(rawstream)
        stream = CommonTokenStream(lexer)
        parser = ageParser(stream)
        tree = parser.ageout()
        printer = KeyPrinter()
        walker = ParseTreeWalker()
        walker.walk(printer, tree)
        
        print(rawString)
        print(">>>", tree.toStringTree(recog=parser))


class KeyPrinter(ageListener):     
    def enterVertex(self, ctx:ageParser.VertexContext):
        print("vertex", ctx) 
    def enterProperties(self, ctx:ageParser.PropertiesContext):
        print("Properties", ctx) 
    def enterValue(self, ctx:ageParser.ValueContext):
        print("Value", ctx) 