# Meetup Report #1

## Salesforce Object Query Language
### Short summary
A SOQL query is the equivalent of a SELECT SQL statement and searches the org database. SOSL is a programmatic way of performing a text-based search against the search index.
This meet up was held in our Galvin Library where a language SoQL was introduced to us.We started working on Chicago Civilian office iwth Police Accountability where we were able to access the dataset via SODA API dialog box.The dataset was in JSON format which was later convert to CSV format to do SoQL queries.
Different types of queries were done on the COPA cases to retrieve deired results.There was a color coding where it would show us in different colors if we type a query that is incorrect.
The COPA cases had 19 names where we used filters and SoQL queries.The fields come in three types 1.Fields with text 2.Fields with numbers 3.Fields with timestamp.
The SoQL queries looked similar to SQL queries.The list of available SoQL functions try to devise  aquery that will return the number of complaints filed on a given day of the week like mondays tuesdays
When to Use SOQL
Use SOQL when one know which objects the data resides in, and one want to:
Retrieve data from a single object or from multiple objects that are related to one another.
Count the number of records that meet specified criteria.
Sort results as part of the query.
Retrieve data from number, date, or checkbox fields.
Use SOQL when one know which objects the data resides in, and one want to:
Retrieve data from a single object or from multiple objects that are related to one another.
Count the number of records that meet specified criteria.
Sort results as part of the query.
Retrieve data from number, date, or checkbox fields

### Conclusion
At the end of the meet up I was able to query using SoQL language which was really a great experience.This meet up kindled me to explore other chicago data sets.Overall the meet up was a great to experience. 
 
 
 ### Your observations and comments about the subject.
Use the Salesforce Object Query Language (SOQL) to search a organization’s Salesforce data for specific information. SOQL is similar to the SELECT statement in the widely used Structured Query Language (SQL) but is designed specifically for Salesforce data.
With SOQL, one can construct simple but powerful query strings in the following environments:
In the queryString parameter in the query() call
In Apex statements
In Visualforce controllers and getter methods
In the Schema Explorer of the Force.com IDE
