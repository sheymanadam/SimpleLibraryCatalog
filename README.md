# Simple Library Catalog (Team D)

(Please see the PROPOSAL doc for details about this project).

There is a library Marc4j needed for proccessing the book records. You'll need to add that to your CLASSPATH. 

# Compile:
javac --classpath lib\marc4j.jar *.java

# Run:
java -classpath lib\marc4j.jar;. SimpleLibraryCatalog

# MARC Records:
The records being imported are in MARC format (This is the format pretty much all libraries and library automation systems use). A good source of records is:

http://metadata.springernature.com/metadata/books

If you would like to see what the tags mean:

https://www.loc.gov/marc/bibliographic/


# Basic Usage

(See demo code in main class)