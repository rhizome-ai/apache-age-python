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

    def testAll(self):
        self.createVertices()
        self.queryVertices()

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
            
        cursor = ag.execCypher("CREATE (n:Person {name: %s, title: 'Developer'}) RETURN n", False, ('Andy',))
        for row in cursor:
            print("CREATED: ", row[0])
            

        cursor = ag.execCypher("MATCH (n:Person {name: %s}) SET n.title=%s RETURN n", False, ('Smith','Manager',))
        for row in cursor:
            print("SET: ", row[0])


        cursor = ag.execCypher("MATCH (n:Person {name: %s}) REMOVE n.title RETURN n", False, ('Smith',))
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
        print("-- Query Vertices with with multi column. --------------------")
        cursor = ag.queryCypher("MATCH (n:Person) RETURN label(n), n.name",['label VARCHAR', 'name'])
        for row in cursor:
            label = row[0]
            name = row[1]
            print(label, name) 

if __name__ == '__main__':
    unittest.main()