# Apache AGE Python Driver

[Apache AGE](https://age.apache.org/) is a PostgreSQL extension that provides graph database functionality. The goal of the Apache AGE project is to create single storage that can handle both relational and graph model data so that users can use standard ANSI SQL along with openCypher, the Graph query language. This repository hosts the development of the Python driver for this Apache extension (currently in Incubator status). Thanks for checking it out.

A graph consists of a set of vertices (also called nodes) and edges, where each individual vertex and edge possesses a map of properties. A vertex is the basic object of a graph, that can exist independently of everything else in the graph. An edge creates a directed connection between two vertices. A graph database is simply composed of vertices and edges. This type of database is useful when the meaning is in the relationships between the data. Relational databases can easily handle direct relationships, but indirect relationships are more difficult to deal with in relational databases. A graph database stores relationship information as a first-class entity. Apache AGE gives you the best of both worlds, simultaneously.

Apache AGE is:

- **Powerful** -- AGE adds graph database support to the already popular PostgreSQL database: PostgreSQL is used by organizations including Apple, Spotify, and NASA.
- **Flexible** -- AGE allows you to perform openCypher queries, which make complex queries much easier to write.
- **Intelligent** -- AGE allows you to perform graph queries that are the basis for many next level web services such as fraud & intrustion detection, master data management, product recommendations, identity and relationship management, experience personalization, knowledge management and more.

### Features
* Unmarshal AGE result data (AGType) to Vertex, Edge, Path
* Cypher query support for Psycopg2 PostreSQL driver (enables cypher queries directly)

### Requirements
* Python 3.9 or higher
* This module runs on [psycopg2](https://www.psycopg.org/) and [antlr4-python3](https://pypi.org/project/antlr4-python3-runtime/)
Linux
```
sudo apt-get update
sudo apt-get install python3-dev libpq-dev
pip install --no-binary :all: psycopg2
pip install antlr4-python3-runtime
```

### Install via PIP
``` 
pip install apache-age-python
```

### Build from Source
``` 
git clone https://github.com/apache/incubator-age.git
cd incubator-age/dirivers/python

python setup.py install
```

### Getting Started
* If you are familiar with Psycopg2: Go to [Jupyter Notebook: Basic Sample](samples/apache-age-basic.ipynb) 
* Simple way to access Apache AGE [AGE Sample](samples/apache-age-note.ipynb) in Samples.
* Agtype converting samples: [Agtype Sample](samples/apache-age-agtypes.ipynb) in Samples.

### Tests
```
python -m unittest -v test_age_py.py
python -m unittest -v test_agtypes.py
```

### For more information about [Apache AGE](https://age.apache.org/)
* Apache Incubator Age: https://age.apache.org/
* Github: https://github.com/apache/incubator-age
* Documentation: https://age.incubator.apache.org/docs/
* apache-age-python GitHub: https://github.com/rhizome-ai/apache-age-python

### Troubleshooting
1.) Make sure AGE is installed. 
2.) Check to see if AGE is loaded in PostgreSQL.
```
# psql 
CREATE EXTENSION age;
LOAD 'age';
SET search_path = ag_catalog, "$user", public;
```
### License
Apache-2.0 License