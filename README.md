# apache-age-python
Python driver support for [Apache AGE](https://age.apache.org/), graph extention for PostgreSQL.

### Install
* over Python 3.9
* This module runs on [psycopg2](https://www.psycopg.org/) and [antlr4-python3](https://pypi.org/project/antlr4-python3-runtime/)
```
sudo apt-get update
sudo apt-get install python3-dev libpq-dev

pip install apache-age-python
```

### Build from source
``` 
git clone https://github.com/rhizome-ai/apache-age-python.git
cd apache-age-python
python setup.py install
```

### For more information about [Apache AGE](https://age.apache.org/)
* Apache Incubator Age : https://age.apache.org/
* Github : https://github.com/apache/incubator-age
* Document : https://age.incubator.apache.org/docs/

### Check AGE loaded on your PostgreSQL
Connect to your containerized Postgres instance and then run the following commands:
```
# psql 
CREATE EXTENSION age;
LOAD 'age';
SET search_path = ag_catalog, "$user", public;
```


### Usage
Go to [Jupyter Notebook](https://github.com/rhizome-ai/apache-age-python/blob/main/samples/apache-age-note.ipynb) in Samples.

### License
Apache-2.0 License