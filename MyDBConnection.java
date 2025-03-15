package final_project;
import java.sql.*;
import java.sql.DriverManager;
public class MyDBConnection {

	public static void main(String[] args) {
	
		try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", null);
			System.out.println("Connected to the database successfully!");

		}catch (Exception e) {
			System.out.println("Error while connecting to the database");
		}
	}
}