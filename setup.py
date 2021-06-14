from setuptools import setup, find_packages
from age import VERSION 

with open("README.md", "r", encoding='utf8') as fh:
    long_description = fh.read()

setup(
    name             = 'apache-age-python',
    version          = VERSION.VERSION,
    description      = 'Python driver for Apache AGE',
    long_description=long_description,
    long_description_content_type="text/markdown",
    author           = 'Ikchan Kwon',
    author_email     = 'rhizome.ai@gmail.com',
    url              = 'https://github.com/rhizome-ai/apache-age-python',
    download_url     = 'https://github.com/rhizome-ai/apache-age-python/releases/tag/v'+VERSION.VERSION ,
    license          = 'Apache2.0',
    install_requires = [ 'psycopg2', 'antlr4-python3-runtime' ],
    packages         = find_packages(exclude = ['bisect', 'notebooks', 'samples']),
    keywords         = ['Graph Database', 'Apache AGE', 'PostgreSQL'],
    python_requires  = '>=3.9',
    # package_data     =  {},
    # zip_safe=False,
    classifiers      = [
        'Programming Language :: Python :: 3.9'
    ]
)