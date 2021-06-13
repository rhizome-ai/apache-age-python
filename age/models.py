import json
from io import StringIO 


TP_NONE = 0
TP_VERTEX = 1
TP_EDGE = 2
TP_PATH = 3

class AGObj:
    @property
    def type():
        return TP_NONE

class Vertex(AGObj):
    def __init__(self, id=None, label=None, properties=None) -> None:
        self.id = id
        self.label = label
        self.properties = properties

    @property
    def type():
        return TP_VERTEX

    def toString(self) -> str:
        from io import StringIO 
        buf = StringIO()
        buf.write("{")
        if self.label != None:
            buf.write("label:")
            buf.write(self.label)
            
        if self.id != None:
            buf.write(", id:")
            buf.write(self.id)
            
        if self.properties != None:
            buf.write(", properties:{")
            for k,v in self.properties.items():
                buf.write(k)
                buf.write(": ")
                buf.write(v)
                buf.write(",")
            buf.write("}")
        buf.write("}::VERTEX")
        return buf.getvalue()

    def toJson(self) -> str:
        buf = StringIO()
        buf.write("{\"gtype\": \"vertex\", ")
        if self.label != None:
            buf.write("\"label\":\"")
            buf.write(self.label)
            buf.write("\"")
            
        if self.id != None:
            buf.write(", \"id\":")
            buf.write(self.id)
            
        if self.properties != None:
            buf.write(", \"properties\":{")
            for k,v in self.properties.items():
                buf.write("\"")
                buf.write(k)
                buf.write("\": \"")
                buf.write(v)
                buf.write("\",")
            buf.write("}")
        buf.write("}")
        return buf.getvalue()

    def __str__(self) -> str:
        return self.toString()

    def __repr__(self) -> str:
        return self.toString()
