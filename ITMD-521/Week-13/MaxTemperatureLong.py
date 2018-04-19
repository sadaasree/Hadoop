from pyspark import SparkContext

import re, sys

from pyspark.sql import *

sc = SparkContext("local", "Max Temperature")

sqlContext = SQLContext(sc)

f1=open("results.txt","w")

lines = sc.textFile(sys.argv[1]) \
 .map(lambda s: s.split("\t")) \
 .filter(lambda rec: (int(rec[1]) != 9999 and re.match("[01459]", rec[2]))) \
 .map(lambda rec: (int(rec[0]), int(rec[1]))) \
 .sortByKey(ascending=True)
longitude =-180
print ("Calculating max temperature for longitude range 10...")
while(longitude<180):
    filtered = lines.filter(lambda rec: (int(rec[0])>=longitude and int(rec[0])<=longitude+10)).reduceByKey(max)
    df = sqlContext.createDataFrame(filtered, ['longitude', 'temp'])
    output = df.agg({"temp": "max"})
    print (longitude,longitude+10,output.collect())
    maxtemp=output.collect()
    f1.write(str(longitude)+" to "+str(longitude+10)+" = "+str(output.collect())+"\n")
    longitude=longitude+10

