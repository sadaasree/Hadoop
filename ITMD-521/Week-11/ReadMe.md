# ITMD 521 Spring 2018

## Week 11 assignment

### Objectives 

* Install and configure industry standard VPN software 
* Configure and connect to industry standard VPN 
* Configure hadoop 2.6.5 installation to connect to a remote Hadoop cluster 
* Understand and analyze the effect of combiners on large MapReduce jobs

### Outcomes 

At the conclusion of this lab you will understand the reasons behind and be able to conenct to a remote network via a VPN.  You will have configured your Hadoop installation to connect to a remote cluster and will have run large scale jobs and analyzed the effect of Reducer classes upon the run time of the job.


### Part I

Assuming that you have succesfully installed, configured, and connected to the remote network via the VPN provided, you need to clone all of the configuration files (see note below) and properly configure you hadoop installation to connect to the remote Hadoop Cluster

Execute this command from your itmd521-cluster vagrant box ```hadoop fs -ls /user/controller/ncdc/1990/``` and take a screenshot of the output.  Place that image in **Deliverable 1** below. 

### Part II 

Compile the MaxTemperature sample code from the hadoop-book chapter 02.  Place the code into a jar file mt.jar (you may already have this step done, which in that case you can reuse mt.jar).  Run the command ```hadoop jar mt.jar MaxTemperature /user/controller/ncdc/YEAROFYOURBIRTH/YEAROFYOURBIRTH.txt``` and ```hadoop jar mt.jar MaxTemperatureWithCombiner /user/controller/ncdc/YEAROFYOURBIRTH/YEAROFYOURBIRTH.txt```

Repeat the above with this command:  ```hadoop jar mt.jar MaxTemperature /user/controller/ncdc/60-70/60-70.txt``` and ```hadoop jar mt.jar MaxTemperatureWithCombiner /user/controller/ncdc/60-70/60-70.txt```

Run each of these three times, capture a screenshot(s) of only these jobs (not others) include them in **Deliverable 2**   This will give you a total of 12 jobs

Note the execution time and graph all of the occurances (six job runs vs time to execute).  Place an image of that graph in **Deliverable 2**

### Part III

Using the textbook and the previous chapters, explain the effect of the reducer upon the outcomes of the job execution time from Part II in technical detail (It is faster or slower is not an acceptable answer).  Cite page sources from the book explaining how you arrived at your answer.

### Deliverable 1
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/deliverable1.png "Week-11 Deliverable1")

### Deliverable 2
#### Job History for DOB Jobs(1990) 
#### First Run:
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable2DOBJob_0942.PNG "Week-11 Deliverable2")
#### Second Run:
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable2DOBJob_0943.PNG "Week-11 Deliverable2")
#### Third Run:
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable2DOBJob_0944.PNG "Week-11 Deliverable2")

#### Job History for DOB Jobs(1990) with Combiner
#### First Run:
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable2DOBJob_WithCombiner_0945.PNG "Week-11 Deliverable2")
#### Second Run:
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable2DOBJob_WithCombiner_0946.PNG "Week-11 Deliverable2")
#### Third Run:
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable2DOBJob_WithCombiner_0947.PNG "Week-11 Deliverable2")

#### Job History for 60-70 Jobs
#### First Run:
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable26070Job_0996.PNG "Week-11 Deliverable2")
#### Second Run:
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable26070Job_0997.PNG "Week-11 Deliverable2")
#### Third Run:
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable26070Job_0999.PNG "Week-11 Deliverable2")

#### Job History for 60-70 Jobs with Combiner
#### First Run:
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable26070Job_WithCombiner_1000.PNG "Week-11 Deliverable2")
#### Second Run:
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable26070Job_WithCombiner_1001.PNG "Week-11 Deliverable2")
#### Third Run:
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable26070Job_WithCombiner_1002.PNG "Week-11 Deliverable2")

##### Bar Graph for all the occurances
![alt text](https://github.com/illinoistech-itm/sravichandar/blob/8829f2e3bb0e3d4e2c016842af8be2039146ea32/ITMD-521/Week-11/Deliverable2_Graph.png "Week-11 Deliverable2")

### Deliverable 3
#### Effect of reducer on the above jobs 
Too few reducers cause undue load on the node on which the reducer is scheduled. This also leads to very bad failure-recovery scenarios since a single failed reducer has an adverse impact on the latency of the job.Too many reducers affects the shuffle crossbar.In extreme cases too many small files are created as the output of the job which affects both the NameNode and performance of subsequent Map-Reduce applications where it needs to process lots of small files.

The Combiner class is used in between the Map class and the Reduce class to reduce the volume of data transfer between Map and Reduce. Usually, the output of the map task is large and the data transferred to the reduce task is high.A combiner does not have a predefined interface and it must implement the Reducer interface’s reduce() method.A combiner operates on each map output key. It must have the same output key-value types as the Reducer class.A combiner can produce summary information from a large dataset because it replaces the original Map output.Although, Combiner is optional yet it helps segregating data into multiple groups for Reduce phase, which makes it easier to process.

That is why we can see from both the DOB jobs and 60-70 file jobs that the map-reduce job runs faster when used a combiner wrealtive to the jobs that were run without using the combiner,since it reduces the data bandwidth between the map and reduce.

## Setup Remote Hadoop Cluster Notes

Copy all *.xml and .sh files into your ```~/hadoop-2.6.5/etc/hadoop``` directory overwritting the defaults 

Copy the hosts file content into your ```/etc/hosts file``` -- note ```/etc/hosts``` is owned by root so you need to use ```sudo```
