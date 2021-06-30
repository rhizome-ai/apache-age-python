from setuptools import setup, find_packages

setup(
    name='agensgraph',
    version='1.0.0',
    description='Psycopg2 type extension module for AgensGraph',
    install_requires=['psycopg2>=2.5.4'],

    packages=find_packages(exclude=['tests']),
    test_suite = "tests",

    author='Junseok Yang',
    author_email='jsyang@bitnine.net',
    maintainer='Gitae Yun',
    maintainer_email='gtyun@bitnine.net',
    url='https://github.com/bitnine-oss/agensgraph-python',
    license='Apache License Version 2.0',
)
