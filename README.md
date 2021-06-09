# apache-age-python
Python driver for Apache AGE, graph extention for PostgreSQL.


### Build
#### 1) Generate query result data parser with ANTLR4
```
# prerequisites : 
#    - java over 8
#    - download ANTLR4 from https://www.antlr.org/download/antlr-4.9.2-complete.jar
#    - java -cp antlr-4.9.2-complete.jar org.antlr.v4.Tool  -Dlanguage=Python3 -visitor -o ./age/gen antlr/age.g4 
```

#### 2) Python3 Runtime
```
# prerequisites : 
#    - pip install antlr4-python3-runtime
```
