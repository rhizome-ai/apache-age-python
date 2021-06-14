# apache-age-python
Python driver for Apache AGE, graph extention for PostgreSQL.


### Install
This driver runs on [psycopg2](https://www.psycopg.org/) and [antlr4-python3](https://pypi.org/project/antlr4-python3-runtime/)
```
sudo apt-get update
sudo apt-get install python3-dev libpq-dev
pip install --no-binary :all: psycopg2
pip install antlr4-python3-runtime

pip install apache_age_py
```

### Check AGE loaded on your PostgreSQL
Connect to your containerized Postgres instance and then run the following commands:
```
CREATE EXTENSION age;
LOAD 'age';
SET search_path = ag_catalog, "$user", public;
```


### Usage
Go to [Jupyter Notebook](https://github.com/rhizome-ai/apache-age-python/blob/main/samples/apache-age-note.ipynb) in Samples.

