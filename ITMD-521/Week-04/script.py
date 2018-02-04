import MySQLdb
connection=MySQLdb.connect(host='localhost',user='root',passwd='itmd521',db='521')
cursor = connection.cursor()
cursor.execute("""CREATE TABLE IF NOT EXISTS records(id INT NOT NULL AUTO_INCREMENT,
                             year YEAR NOT NULL,
                             temperature INT,
                             PRIMARY KEY (id))""")

with open('1950.txt') as temp:
     for record in temp:
         text = record.strip()
         if record[87] == '+' :
            (year,temperature,q) = (text[15:19], text[88:92], text[92:93])
         else :
            (year,temperature,q) = (text[15:19], text[87:92], text[92:93])
         if temperature !='9999' and q in '01459':
            query="INSERT INTO records (year,temperature) VALUES(%s, %s)"
            cursor.execute(query,(year,temperature))
connection.commit()
connection.close()
