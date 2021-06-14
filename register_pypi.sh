#!/bin/bash

python3 setup.py clean --all
rm -Rf build dist 

python3 setup.py install
python3 setup.py sdist bdist_wheel

#python3 -m pip install --user --upgrade twine

python3 -m twine upload dist/*
