# Meetup Report #2

## Big Data
### Short summary
Big data is a term that describes the large volume of data – both structured and unstructured – that inundates a business on a day-to-day basis. But it’s not the amount of data that’s important. It’s what organizations do with the data that matters. Big data can be analyzed for insights that lead to better decisions and strategic business move.
File system is  away of organising files in a disk.distributed filesystem organises file system in different computer.The main advantage is Redundancy and main disadvantage is complexity.The cluster architecture connects all the CPU at one connection and some have hirarchial architecture.The infinity band connects using 60 GB/s and from core to core.Massive core to core  communictaion and galaxy simulation.Time data are correlated with past data and they are not independent.
The data pre processing is done on tabular data,rows and columns.Independent records are taken and their information are contained on relevant rows.
The filtering process is done using SQL subsetting data columns using SQL query and panda code.Then the data undergoes aprocess called merging where the datasets are being merged using SQL and panda.The transformation that is creating and modifying columns are agian doen using different SQL queries.The join on a single machine can be done but here join join can be doen on multiple machines this is where hadoop comes into big picture
Aggregation is a process where we reduce the data column and hadoop breaks the dat into different partitions and duplicates the partitions onto different machines.The default would be 3 replicas.The hadoop is a clsuter anatomy where it uses Kafka as streaming data and scala and spark.Usually as we do in in our class we ssh to the server then hadoop would assign the work node as the head node.Moving files to and from hadoop using hadopp commands 
hadoop fs - put</path/tofile> <path/to/destination/on hadoop>
hadoop fs -getmerge<path/to/dest/onhadoop> </path/tofile>
Distributed Analytics-counting ages greater than or equal to 22 and group by agw this cannot be done independently by each work.This is where map and reduce are being used.Spark is also a distributed analytics engine.Many map-reduce jobs run one after one on hadoop.It uses similar principles for general processing as mapreduce.
Spark splits execution into stages that are separated by shuffles.Scala is the language used in Spark.

### Conclusion 
At the end of the meet up,I was able to get the overall architecture of big data on how the data is collected,pre-processed,fileterd and the broken down,duplicated so as to do the map reduce.It was a good experience I was able to see how the real world sees hadoop and big data outside of classroom

 
 ### Your observations and comments about the subject.
 The availability of Big Data, low-cost commodity hardware, and new information management and analytic software have produced a unique moment in the history of data analytics and other purposes.Interdisciplinary skills are beneficial for domain science specific big data analytics.
