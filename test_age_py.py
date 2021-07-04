from age.models import Vertex
import unittest
import age 

DSN = "host=172.17.0.2 port=5432 dbname=postgres user=postgres password=agens"
TEST_HOST = "172.17.0.2"
TEST_PORT = 5432
TEST_DB = "postgres"
TEST_USER = "postgres"
TEST_PASSWORD = "agens"
TEST_GRAPH_NAME = "test_graph"

class TestAgeBasic(unittest.TestCase):
    ag = None
    def setUp(self):
        print("Connecting to Test Graph.....")
        self.ag = age.connect(graph=TEST_GRAPH_NAME, host=TEST_HOST, port=TEST_PORT, dbname=TEST_DB, user=TEST_USER, password=TEST_PASSWORD)


    def tearDown(self):
        # Clear test data
        print("Deleting Test Graph.....")
        age.deleteGraph(self.ag.connection, self.ag.graphName)
        self.ag.close()

    def testExec(self):
        ag = self.ag
        cursor = ag.execCypher("CREATE (n:Person {name: %s}) RETURN n", False, ('Jack',))
        row = cursor.fetchone()
        
        self.assertEquals(int, type(row[0].id))
        ag.commit()

        cursor = ag.execCypherWithReturn("CREATE (n:Person {name: %s, title: 'Developer'}) RETURN n", None, ('Andy',))
        for row in cursor:
            print(Vertex, type(row[0]))
            
        
    def testQuery(self):
        ag = self.ag
        ag.execCypher("CREATE (n:Person {name: %s}) RETURN n", True, ('Jack',))
        ag.execCypher("CREATE (n:Person {name: %s}) RETURN n", True, ('Andy',))
        ag.execCypher("CREATE (n:Person {name: %s}) RETURN n", True, ('Smith',))
        ag.execCypher("MATCH (a:Person), (b:Person) WHERE a.name = 'Andy' AND b.name = 'Jack' CREATE (a)-[r:workWith {weight: 3}]->(b)",True)
        ag.execCypher("""MATCH (a:Person), (b:Person) 
                    WHERE  a.name = %s AND b.name = %s 
                    CREATE p=((a)-[r:workWith]->(b)) """, True, 
                    ('Jack', 'Smith',))
        
        cursor = ag.queryCypher("MATCH p=()-[:workWith]-() RETURN p", None)
        for row in cursor:
            path = row[0]
            print("START:", path[0])
            print("EDGE:", path[1])
            print("END:", path[2])  

        cursor = ag.queryCypher("MATCH p=(a)-[b]-(c) WHERE b.weight>2 RETURN a,label(b), b.weight, c", ["a","bl","bw", "c"], (2,))
        for row in cursor:
            start = row[0]
            edgel = row[1]
            edgew = row[2]
            end = row[3]
            print(start["name"] , edgel, edgew, end["name"]) 
            
        
    def createVertices(self):
        ag = self.ag
        # Create Vertices
        # Commit automatically
        ag.execCypher("CREATE (n:Person {name: 'Joe'})", True)
        cursor = ag.execCypher("CREATE (n:Person {name: 'Smith'})", True)
        for row in cursor:
            print("NO RESULT: ", row[0])
            
        # defer Commit 
        cursor = ag.execCypher("CREATE (n:Person {name: %s}) RETURN n", False, ('Jack',))
        for row in cursor:
            print("CREATED: ", row[0]) 
            
        cursor = ag.execCypherWithReturn("CREATE (n:Person {name: %s, title: 'Developer'}) RETURN n", None, ('Andy',))
        for row in cursor:
            print("CREATED: ", row[0])
            

        cursor = ag.execCypherWithReturn("MATCH (n:Person {name: %s}) SET n.title=%s RETURN count(n)", ["a integer"], ('Smith','Manager',))
        for row in cursor:
            print("SET: ", row[0])


        cursor = ag.execCypherWithReturn("MATCH (n:Person {name: %s}) REMOVE n.title RETURN id(n)", ["a bigint"], ('Smith',))
        for row in cursor:
            print("REMOVE Prop: ", row[0])

        # You must commit explicitly
        ag.commit()

    def queryVertices(self):
        ag = self.ag
        # Query Vertices with parsed row cursor.
        print("-- Query Vertices  --------------------")
        cursor = ag.queryCypher("MATCH (n:Person) RETURN n",[])
        for row in cursor:
            vertex = row[0]
            print(vertex.id, vertex.label, vertex["name"])
            print("-->", vertex)

        # Query Vertices with with multi column
        print("-- Query Vertices with with multi columns. --------------------")
        cursor = ag.queryCypher("MATCH (n:Person) RETURN label(n), n.name",['label VARCHAR', 'name'])
        for row in cursor:
            label = row[0]
            name = row[1]
            print(label, name) 

if __name__ == '__main__':
    unittest.main()