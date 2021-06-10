from . import age
from .age import *
from . import VERSION 

def version():
    return VERSION.VERSION


def newAge(dsn=None, graph=None, connection_factory=None, cursor_factory=None, **kwargs):
        ag = Age()
        ag.connect(dsn=dsn, graph=graph, connection_factory=connection_factory, cursor_factory=cursor_factory, **kwargs)
        return ag
