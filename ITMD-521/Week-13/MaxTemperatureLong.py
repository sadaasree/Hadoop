from pyspark import SparkContext

import re, sys

from pyspark.sql import *

sc = SparkContext("local", "Max Temperature")

sqlContext = SQLContext(sc)

f1=open("aggregation.txt","w")

lines = sc.textFile(sys.argv[1]) \

  .map(lambda s: s.split("\t")) \

  .filter(lambda rec: (int(rec[1]) != 9999 and re.match("[01459]", rec[2]))) \

  .map(lambda rec: (int(rec[0]), int(rec[1]))) \

  .sortByKey(ascending=True)

minlong =-180

print ("Calculating max temperature for longitude range 10...")

while(minlong<180):

    filtered = lines.filter(lambda rec: (int(rec[0])>=minlong and int(rec[0])<=minlong+10)).reduceByKey(max)

    df = sqlContext.createDataFram e(filtered, ['longitude', 'temp'])

    output = df.agg({"temp": "max"})

    print (minlong,minlong+10,output.collect())

    maxtemp=output.collect()

    f1.write(str(minlong)+" to "+str(minlong+10)+" = "+str(output.collect())+"\n")

    minlong=minlong+10

