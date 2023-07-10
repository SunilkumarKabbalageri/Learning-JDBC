package learnigjdbc1;

import java.sql.*;
import java.util.Scanner;

public class NormalStatement {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("The Options are..");
		System.out.println(
				"1.create table\n,2.insert the values\n,3.update the values\n,4.fetch the values,5.delete the values from the row\n,6.drop table");
		System.out.println("Enter which operation you want to do..");
		int n = sc.nextInt();
		switch (n) {
		case 1: {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahantesh", "root",
					"root");
			Statement statement = connection.createStatement();
			boolean x = statement.execute(
	"Create table CustomerBill(customerID integer primary key,Name varchar(20),BillDate date not null,BillAmount integer not null,mob_no BigInt not null)");
			connection.close();
			System.out.println("table is created");
		}
			break;
		case 2: {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahantesh", "root",
					"root");
			Statement statement = connection.createStatement();
			int x = statement
					.executeUpdate("insert into CustomerBill values(3,'Sunil','2000-03-23',12000,9731269070)");
			connection.close();
			System.out.println("Values is inserted");

		}
			break;
		case 3: {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahantesh", "root",
					"root");
			Statement statement = connection.createStatement();
			int x = statement.executeUpdate("update CustomerBill set name='Anil' where customerID=1");
			connection.close();
			System.out.println("Data is updated");
		}
			break;
		case 4: {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahantesh", "root",
					"root");
			Statement statement = connection.createStatement();
			ResultSet m = statement.executeQuery("select * from CustomerBill");
			m.next();
			System.out.println("Id: " + m.getInt(1) + "\nName: " + m.getString(2) + "\nDate: " + m.getDate(3)
					+ "\nBillAmount: " + m.getInt(4) + "\nmob_no: " + m.getLong(5));
			connection.close();

		}
		break;
		case 5:{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahantesh","root","root");
			Statement statement=connection.createStatement();
			statement.execute("delete from CustomerBill where customerID=2");
			connection.close();
			System.out.println("Data is Deleted");
		}
		break;
		case 6:{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahantesh","root","root");
			Statement statement=connection.createStatement();
			statement.execute("drop table CustomerBill");
			connection.close();
			System.out.println("table is Dropped");
		}
		break;
		default :{
			System.out.println("invalid length");
		}
		}

	}
}
