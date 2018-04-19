
f = open('spark1950long.txt', 'w')
with open('1950.txt') as temp:

     for record in temp:

         text = record.strip()

         if record[87] == '+' :

            (longitude,temperature,q) = (text[34:41], text[88:92], text[92:93])
            longitude=int(longitude)/1000
            longitude=str(longitude)
            f.write(longitude + "\t" + temperature +"\t"+q +"\n")


         else :

            (longitude,temperature,q) = (text[35:41], text[87:92], text[92:93])
            longitude=int(longitude)/1000
            longitude=str(longitude)
            f.write(longitude + "\t" + temperature +"\t"+ q +"\n")
f.close()
