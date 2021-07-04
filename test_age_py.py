import unittest
import age 

DSN = "host=172.17.0.3 port=5432 dbname=postgres user=postgres password=agens"
TEST_HOST = "172.17.0.3"
TEST_PORT = 5432
TEST_DB = "postgres"
TEST_USER = "postgres"
TEST_PASSWORD = "agens"
TEST_GRAPH_NAME = "test_graph5"

class TestAgeBasic(unittest.TestCase):
    ag = None
    def setUp(self):
        print("Connecting to Test Graph.....")
        self.ag = age.connect(graph=TEST_GRAPH_NAME, host=TEST_HOST, port=TEST_PORT, dbname=TEST_DB, user=TEST_USER, password=TEST_PASSWORD)


    def tearDown(self):
        # Clear test data
        print("Deleting Test Graph.....")
        self.ag.deleteGraph(self.ag.graphName)
        self.ag.close()

    
    def test_all(self):
        ag = self.ag
        # Create Vertices
        ag.execCypher("CREATE (n:Person {name: 'Joe'})")
        ag.execCypher("CREATE (n:Person {name: 'Smith', bigInt:123456789012345678901234567890::numeric})")
        ag.execCypher("CREATE (n:Person {name: %s, bigFloat:123456789012345678901234567890::numeric})", ('Jack',))
        ag.execCypher("CREATE (n:Person {name: 'Andy', title: 'Developer'})")
        ag.execCypher("CREATE (n:Person {name: %s, title: %s})", ('Tom','Developer',))
        ag.commit()

        # Query Vertices with result parsed full graph.
        ag.queryCypher("MATCH (n:Person) RETURN n")
        graph = ag.graph()
        self.assertEqual(5, len(graph), "Create and retrieve vertices.")

        for vertex in graph:
            self.assertEqual( age.models.Vertex, type(vertex), "Retrieve and unmarshal Vertex.")

        # Query Vertices with parsed row cursor.
        ag.queryCypher("MATCH (n:Person) RETURN n")
        for vertex in ag.rows():
            self.assertIsNotNone(vertex.id)
            self.assertIsNotNone(vertex.properties["name"])
            self.assertIsNotNone(vertex.toJson())

        # Create Edges
        ag.execCypher("MATCH (a:Person), (b:Person) WHERE a.name = 'Joe' AND b.name = 'Smith' CREATE (a)-[r:workWith {weight: 3}]->(b)")
        ag.execCypher("MATCH (a:Person), (b:Person) WHERE  a.name = 'Andy' AND b.name = 'Tom' CREATE (a)-[r:workWith {weight: 1}]->(b)")
        ag.execCypher("MATCH (a:Person {name: 'Jack'}), (b:Person {name: 'Andy'}) CREATE (a)-[r:workWith {weight: 5}]->(b)")
        ag.execCypher("MATCH (a:Person {name: 'Joe'}), (b:Person {name: 'Jack'}) CREATE (a)-[r:workWith {weight: 5}]->(b)")
        ag.commit()

        ag.queryCypher("MATCH p=()-[:workWith]-() RETURN p")
        graph = ag.graph()
        self.assertEqual(8, len(graph), "Create and retrieve paths.")
        for path in graph:
            self.assertEqual(3, len(path), "Path length must be 3")
            self.assertEqual( age.models.Path, type(path), "Retrieve and unmarshal Path.")
            print(path[0].label, path[0]["name"] , "-",  path[1].label, path[1]["weight"] , "-", path[2].label, path[2]["name"])


            

if __name__ == '__main__':
    unittest.main()