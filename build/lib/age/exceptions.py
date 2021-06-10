
from psycopg2.errors import *

class GraphNotFound(Exception):
    def __init__(self, name):
        self.name = name

    def __repr__(self) :
        return 'Graph[' + self.name + '] does not exist.' 


class GraphAlreadyExists(Exception):
    def __init__(self, name):
        self.name = name

    def __repr__(self) :
        return 'Graph[' + self.name + '] already exists.' 

        
class GraphNotSet(Exception):
    def __repr__(self) :
        return 'Graph name is not set.'


class NoConnection(Exception):
    def __repr__(self) :
        return 'No Connection'

class NoCursor(Exception):
    def __repr__(self) :
        return 'No Cursor'
