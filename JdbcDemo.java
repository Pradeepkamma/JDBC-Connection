import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo01 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//step 1. Register the Driver dynamically (this step was optional from jdbc 4.0, onwards)
		//forName():- this method will load the class from our jar file into jvm
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		 
		
		//Step 2. Get the Connection
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","admin");
			
			
			//Step 3. Create Statement
			Statement statement = connection.createStatement();
			
			//insert query
			String insertQuery = "insert into employees(id,name,designation,salary) values (23,'Pradeep','Student',15000),(2,'Dharani','Student',16000)";
			
			//select query
			String selectQuery = "select * from employees";
			
			//Delete query
			String deleteQuery = "delete from employees where id = 23";
			
		 //int rowsUpdated = statement.executeUpdate(deleteQuery);
		 //System.out.println("Rows affected: "+ rowsUpdated);
			
			//update query
			String updateQuery = "update employees set designation='senior' where id = 2";
			
			int rowsUpdated = statement.executeUpdate(updateQuery);
			System.out.println("Rows affected: "+ rowsUpdated);
			
			
			//Step 4. Execute Query
			//int rowsUpdated = statement.executeUpdate(insertQuery);
			//System.out.println("Rows affected: "+ rowsUpdated);
			
			//executeQuery  is used only for select
			ResultSet resultSet = statement.executeQuery(selectQuery);
			
			//to display
			while(resultSet.next()){
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				String designation = resultSet.getString("designation");
				Double salary = resultSet.getDouble("salary");
				
				System.out.println("ID: "+id+" "+"Name: "+name+" "+"Designation: "+designation+" "+"Salary: "+salary);
			}
			
			//closing statement and connection objects
			statement.close();
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
	}
	
	}

}
