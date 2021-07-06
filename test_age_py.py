from age.models import Vertex
import unittest
import decimal
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
        # Create and Return single column
        cursor = ag.execCypher("CREATE (n:Person {name: %s, title: 'Developer'}) RETURN n", params=('Andy',))
        for row in cursor:
            print(Vertex, type(row[0]))

        
        # Create and Return multi columns
        cursor = ag.execCypher("CREATE (n:Person {name: %s, title: %s}) RETURN id(n), n.name", cols=['id','name'], params=('Jack','Manager'))
        row = cursor.fetchone()
        print(row[0], row[1])
        self.assertEqual(int, type(row[0]))
        ag.commit()

            
        
    def testQuery(self):
        ag = self.ag
        ag.execCypher("CREATE (n:Person {name: %s}) ", params=('Jack',))
        ag.execCypher("CREATE (n:Person {name: %s}) ", params=('Andy',))
        ag.execCypher("CREATE (n:Person {name: %s}) ", params=('Smith',))
        ag.execCypher("MATCH (a:Person), (b:Person) WHERE a.name = 'Andy' AND b.name = 'Jack' CREATE (a)-[r:workWith {weight: 3}]->(b)")
        ag.execCypher("""MATCH (a:Person), (b:Person) 
                    WHERE  a.name = %s AND b.name = %s 
                    CREATE p=((a)-[r:workWith]->(b)) """, params=('Jack', 'Smith',))
        
        ag.commit()

        cursor = ag.execCypher("MATCH p=()-[:workWith]-() RETURN p")
        for row in cursor:
            path = row[0]
            print("START:", path[0])
            print("EDGE:", path[1])
            print("END:", path[2])  

        cursor = ag.execCypher("MATCH p=(a)-[b]-(c) WHERE b.weight>2 RETURN a,label(b), b.weight, c", cols=["a","bl","bw", "c"], params=(2,))
        for row in cursor:
            start = row[0]
            edgel = row[1]
            edgew = row[2]
            end = row[3]
            print(start["name"] , edgel, edgew, end["name"]) 
            
        
    def testChangeData(self):
        ag = self.ag
        # Create Vertices
        # Commit automatically
        ag.execCypher("CREATE (n:Person {name: 'Joe'})")

        cursor = ag.execCypher("CREATE (n:Person {name: %s, title: 'Developer'}) RETURN n", params=('Smith',))
        row = cursor.fetchone()
        print("CREATED: ", row[0])
        
        # You must commit explicitly
        ag.commit()

        cursor = ag.execCypher("MATCH (n:Person {name: %s}) SET n.title=%s RETURN n", params=('Smith','Manager',))
        row = cursor.fetchone()
        vertex = row[0] 
        title1 = vertex["title"]
        print("SET title: ", title1)

        ag.commit()
    
        cursor = ag.execCypher("MATCH (p:Person {name: 'Smith'}) RETURN p.title")
        row = cursor.fetchone()
        title2 = row[0]

        self.assertEqual(title1, title2)

        cursor = ag.execCypher("MATCH (n:Person {name: %s}) SET n.bigNum=-6.45161e+46::numeric RETURN n", params=('Smith',))
        row = cursor.fetchone()
        vertex = row[0]
        for row in cursor:
            print("SET bigNum: ", vertex)
        
        bigNum1 = vertex["bigNum"]

        self.assertEqual(decimal.Decimal("-6.45161e+46"), bigNum1)
        ag.commit()


        cursor = ag.execCypher("MATCH (p:Person {name: 'Smith'}) RETURN p.bigNum")
        row = cursor.fetchone()
        bigNum2 = row[0]

        self.assertEqual(bigNum1, bigNum2)


        cursor = ag.execCypher("MATCH (n:Person {name: %s}) REMOVE n.title RETURN n", params=('Smith',))
        for row in cursor:
            print("REMOVE Prop title: ", row[0])

        # You must commit explicitly
        ag.commit()

    def testEdge(self):
        ag = self.ag

        ag.execCypher("CREATE (n:Person {name: %s}) ", params=('Jone',))
        ag.execCypher("CREATE (n:Person {name: %s}) ", params=('Jack',))
        ag.execCypher("CREATE (n:Person {name: %s}) ", params=('Andy',))
        ag.execCypher("CREATE (n:Person {name: %s}) ", params=('Smith',))
        ag.execCypher("CREATE (n:Person {name: %s}) ", params=('Tom',))

        # You must commit explicitly
        ag.commit()

        # Create Edges
        ag.execCypher("MATCH (a:Person), (b:Person) WHERE a.name = 'Joe' AND b.name = 'Smith' CREATE (a)-[r:workWith {weight: 3}]->(b)")
        ag.execCypher("MATCH (a:Person), (b:Person) WHERE  a.name = 'Andy' AND b.name = 'Tom' CREATE (a)-[r:workWith {weight: 1}]->(b)")
        ag.execCypher("MATCH (a:Person {name: 'Jack'}), (b:Person {name: 'Andy'}) CREATE (a)-[r:workWith {weight: 5}]->(b)")

        # You must commit explicitly
        ag.commit()
        
        # With Params
        cursor = ag.execCypher("""MATCH (a:Person), (b:Person) 
                WHERE  a.name = %s AND b.name = %s 
                CREATE p=((a)-[r:workWith]->(b)) RETURN p""", 
                params=('Andy', 'Smith',))

        for row in cursor:
            print(row[0])
            
        cursor = ag.execCypher("""MATCH (a:Person {name: 'Joe'}), (b:Person {name: 'Jack'}) 
                CREATE p=((a)-[r:workWith {weight: 5}]->(b))
                RETURN p """)

        for row in cursor:
            print(row[0])
            

if __name__ == '__main__':
    unittest.main()