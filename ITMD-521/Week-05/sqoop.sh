#!/bin/sh
clear
echo "CREATE TABLE temperature (id INT NOT NULL AUTO_INCREMENT,year YEAR NOT NULL,temperature INT,PRIMARY KEY(id));"
echo "INSERT INTO temperature SELECT * FROM records WHERE temperature >= 38;"
echo "sqoop import --connect jdbc:mysql://localhost/521 --table temperature -m 1 --username root -P"
echo "hadoop fs -tail temperature/part-m-00000"
