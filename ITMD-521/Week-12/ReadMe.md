# ITMD 521 Spring 2018

## Week 12 assignment

### Objectives 

* Understand the effect (positive and negative) of using multiple reducers on an MR job 
* Understand the effect of using Intermediate Compression on an MR job
* Understand the benefit of using custom counters in the output of an MR job 
* Understand how to modify and change the jobname of an MR job

### Outcomes 

At the conclusion of this lab you will have run through a matrix of MR jobs with various optimizations relating to the number of reducers, use of intermediate compression, and the use of a combiner class.  In addition you will modify the sample MR code to include try/catch logic and a custom counter bad and invalid records.


### Part I

Using the single year of your birth, modify the sample MaxTemperature class to include a custom counter to count all bad (malformed) records and count all invalid ranged records (for instance anyhting greater than 50.0 celsius).  Disply the output of these two counters at the end of your MR output and take a screenshot of the output.  Place that image in **Deliverable 1** below. Submit your modified code into week 12 Github folder as well.

### Part II - Reducers

Using the dataset for the year you were born, run the MaxTemperature and MaxTempertature jobs each using 1, and then 2 reducers; four jobs total.

Capture a screenshot(s) of only these jobs (not others) include them in **Deliverable 2**   

Note the execution time and graph all of the occurances.  Place an image of that graph in **Deliverable 2**

Using the textbook and the previous chapters, explain the effect of the reducer upon the outcomes of the job execution time from Part II in technical detail (It is faster or slower is not an acceptable answer).  **Cite page sources from the book explaining how you arrived at your answer.**

### Part III - Reducers Large

Using the linux command [md5](https://en.wikipedia.org/wiki/MD5 "md5") to take a hash of your Hawk ID: ```echo "hajek" | md5sum```.  Take a screenshot of this output and include it in **Deliverable 3**. 

Based on the output string use two datasets mentioned below:

1) If first character is even number: use 50.txt
1) If first character is odd number use: 60.txt
1) If first character is a letter use: 60-70.txt
1) In addition to the above everyone needs to use 60-90.txt as well.

* Enable **intermediate compression**, Page 118 of epub, for all of your MR jobs in this section.
* Compile your code to contain the job.setName("Initials here and a description") value
* Run 8 jobs on each dataset (8x2=16 total), 
* Run your first dataset assigned above: MaxTemperature
    + with 1, 2, 4, 8 reducers
* Run your first dataset assigned above: MaxTemperatureWithCombiner
    + with 1, 2, 4, 8 reducers
*  * Run your second dataset assigned above: MaxTemperature
    + with 1, 2, 4, 8 reducers
* Run your second dataset assigned above: MaxTemperatureWithCombiner
    + with 1, 2, 4, 8 reducers  

Capture a screenshot(s) of only these jobs (not others) include them in **Deliverable 3**   

Note the execution time and graph all of the occurances.  Place an image of those graphs in **Deliverable 3**

Using the textbook and the previous chapters, explain the effect of the reducer upon the outcomes of the job execution time from Part II in technical detail (It is faster or slower is not an acceptable answer).  **Cite page sources from the book explaining how you arrived at your answer.**  

**Submit your *.java files to your repo in week 12 as well.**

Submit your Github repo URL to blackboard by 11:59 pm April 5th.

### Deliverable 1
#### Output of the two counters
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/Deliverable%201.PNG "Week-12 Deliverable1")

### Deliverable 2
#### Job History for DOB Jobs(1990) With 1 Reducer
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1372.PNG "Week-12 Deliverable2")

#### Job History for DOB Jobs(1990) With 2 Reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1374.PNG "Week-12 Deliverable2")

#### Job History for DOB Jobs(1990) With Combiner and 1 Reducer
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1380.PNG "Week-12 Deliverable2")

#### Job History for DOB Jobs(1990) With Combiner and 2 Reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1382.PNG "Week-12 Deliverable2")

#### Graph of all the occurances
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/Deliverable2.png "Week-12 Deliverable2")

#### Effect of reducer on the above jobs 
The number of reduce tasks is not governed by the size of the input but instead is specified independently.When there are multiple reducers,the map tasks partition their output each creating one partition for each reduce task.There can be many keys and their associated values in each partition but the records for any given key are all in single partition.The partitioning can be controlled by a user-defined partitioning funcction but normally the default partitioner which buckets keys using a hash function works very well.
 The output data from the mapper has to be sent to the reducer,we can see from the above results that the reducer hits the perforamce of the jobs,since each reducer has to create its own file and also each reducer needs to start up and be created/instantiated in the nodes.
Having two few or two many reducer is also anti-productive.
Too many reducers affects the shuffle crossbar.In extreme cases too many small files are created as the output of the job which affects both the NameNode and performance of subsequent Map-Reduce applications where it needs to process lots of small files.Increasing the number of reducers increases the framework overhead, but increases load balancing and lowers the cost of failures.Since they are run parallel depending upon the keys it reduces the execution time
For map-reduce jobs, it depends on our use case of what needs to done in the mapreduce job. Since we have heavy filtering in the map phase we should be seeing positive linear speed ups. For jobs that send most of their data to the reducers our bottleneck
will be the network, IO or CPU required for the shuffle.In general, more nodes should mean faster (to a point) but we have to
benchmark to find out the exact speedups.
So here in our case we can see that the reducer tries to significantly reduce the time of the job execution but when a combiner is used along them the execution time varies.Here we can see that when a combiner was used the execution time has decreased for the job with one reducer and the execution time has increased for the job with two reducers.

### Deliverable 3
#### md5 
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/Deliverable3_md5.PNG "Week-12 Deliverable3")

#### Job History for 60 Jobs With Intermediate Compression enabled & with 1 reducer
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1386.PNG "Week-12 Deliverable3")

#### Job History for 60 Jobs With Intermediate Compression enabled & with 2 reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1387.PNG "Week-12 Deliverable3")

#### Job History for 60 Jobs With Intermediate Compression enabled & with 4 reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1388.PNG "Week-12 Deliverable3")

#### Job History for 60 Jobs With Intermediate Compression enabled & with 8 reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1390.PNG "Week-12 Deliverable3")

#### Job History for 60 Jobs With Intermediate Compression enabled & with Combiner and 1 reducer
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1392.PNG "Week-12 Deliverable3")

#### Job History for 60 Jobs With Intermediate Compression enabled & with Combiner and 2 reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1394.PNG "Week-12 Deliverable3")

#### Job History for 60 Jobs With Intermediate Compression enabled & with Combiner and 4 reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1395.PNG "Week-12 Deliverable3")

#### Job History for 60 Jobs With Intermediate Compression enabled & with Combiner and 8 reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1396.PNG "Week-12 Deliverable3")

#### Job History for 60-90 Jobs With Intermediate Compression enabled & with 1 reducer
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1397.PNG "Week-12 Deliverable3")

#### Job History for 60-90 Jobs With Intermediate Compression enabled & with 2 reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1398.PNG "Week-12 Deliverable3")

#### Job History for 60 Jobs With Intermediate Compression enabled & with 4 reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1399.PNG "Week-12 Deliverable3")

#### Job History for 60-90 Jobs With Intermediate Compression enabled & with 8 reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1402.PNG "Week-12 Deliverable3")

#### Job History for 60-90 Jobs With Intermediate Compression enabled & with Combiner and 1 reducer
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1407.PNG "Week-12 Deliverable3")

#### Job History for 60-90 Jobs With Intermediate Compression enabled & with Combiner and 2 reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1411.PNG "Week-12 Deliverable3")

#### Job History for 60-90 Jobs With Intermediate Compression enabled & with Combiner and 4 reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1413.PNG "Week-12 Deliverable3")

#### Job History for 60-90 Jobs With Intermediate Compression enabled & with Combiner and 8 reducers
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/1417.PNG "Week-12 Deliverable3")

#### Graph of all the occurances of 60 Jobs
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/Deliverable_3_60Job.png "Week-12 Deliverable2")

#### Graph of all the occurances of 60-90 Jobs
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/master/ITMD-521/Images/Deliverable_3_60-90%20Job.png "Week-12 Deliverable2")

#### Effect of reducer on the above jobs 
Similar to the part II,we can see that the 60 Jobs when incresaing the number of reducers has decreased the execution time while there are few discrepancies when we see the exevution time of the job with 2 reducers,but still it has managed to decrease the job execution time.And when we compare the job where we have used the combiners along the execution time is still more decreased when the combiners ae are being used.This is because the combiners always tries to decrease the bandwidth of the data to help them run faster.
When we see the 60-90 jobs we can see that when using reducer sit has decresaed the time adn when using combiner sit has managed to decresae the time a still more except for the job with two reducers.This may be due to the other factors such as network,IO or CPU required for the shuffle,but in general it tries to increase the performance of the job.

###### Referred Sites: 
http://grokbase.com/t/cloudera/cdh-user/12655xwsxt/does-execution-time-decrease-linearly-with-increase-in-number-of-nodes
https://stackoverflow.com/questions/39541718/why-increasing-the-number-of-reducers-increases-the-time-for-running-reduce-phas
