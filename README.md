# JDBC-Connection

DBC Connection in Java
This repository demonstrates how to establish a JDBC connection in Java using MySQL. 

It covers the five essential steps involved in database connectivity:

Steps to Connect to a Database Using JDBC
# 1) Register the Driver
Dynamically load the MySQL JDBC driver using:

Class.forName("com.mysql.cj.jdbc.Driver");

Since JDBC 4.0, explicit registration is optional if the driver JAR is in the classpath.

# 2) Establish a Connection
Use DriverManager.getConnection() to connect to the database.

Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "password");

# 3) Create a Statement
Create an SQL statement using:

Statement stmt = con.createStatement();

# 4) Execute the Query
Execute SQL queries to retrieve or manipulate data:

ResultSet rs = stmt.executeQuery("SELECT * FROM employees"); 

# 5) Close the Connection
Always close the connection to free resources:

rs.close();

stmt.close();

con.close();


# JDBC URL Format for MySQL
jdbc:mysql://hostname:port/database-name

hostname → localhost (or database server IP)

port → Default is 3306

database-name → Name of the database (e.g., employee)
