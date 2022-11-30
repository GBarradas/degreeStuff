# Spring Boot + Spring data JPA + PostgreSQL example


Deve criar uma BD em Postgres, de acordo com:
 dbname: db1
 username: user1
 password: sample1


--------------------------------
Sugestão:
--------------------------------
$ sudo su - postgres
postgres@maquina:~$ createuser user1
postgres@maquina:~$ createdb -O user1 db1
postgres@maquina:~$ psql db1
db1=# alter user user1 with password 'sample1';
ALTER ROLE
db1=# \q
postgres@maquina:~$ logout
$ 
--------------------------------




--------------------------------
Build:
--------------------------------
$ mvn package
...
 [INFO] BUILD SUCCESS





--------------------------------
Executar:
--------------------------------
$ java -jar target/spring-boot-data-jpa-1.0.jar

ou

$ mvn spring-boot:run

... verá os logs,
com resultado das operações de consulta, terminando com
 [INFO] BUILD SUCCESS






--------------------------------
Consulte a BD:
--------------------------------
$ psql -U user1 -h localhost db1
Password for user user1: 
psql (12.5 (Ubuntu 12.5-0ubuntu0.20.10.1))
Type "help" for help.

db1=> \dt
       List of relations
 Schema | Name | Type  | Owner 
--------+------+-------+-------
 public | book | table | user1
(1 row)

db1=> select * from book ;
 id |  name 
----+--------
  1 | Java
  2 | Node
  3 | Python
(3 rows)

db1=> exit
--------------------------------








O código deste projeto vem do exemplo mais completo: 
https://www.mkyong.com/spring-boot/spring-boot/spring-boot-spring-data-jpa-postgresql/
