package learnigjdbc1;

import java.sql.*;
import java.util.Scanner;

public class UserDefinedStatement {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your option");
		System.out.println(
				"1.create table\n2.insert the values\n3.update the values\n4.fetch the values\n5.delete the values\n6.drop the table");
		System.out.println("Enter your option");
		int num = sc.nextInt();
		switch (num) {
		case 1: {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahantesh", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("create table IPL"
					+ "(id integer primary key, name varchar(20) not null,DOB varchar(20) not null,mob_no Bigint not null,Team varchar(15) not null,"
					+ "Cups integer not null)");
			preparedStatement.execute();
			connection.close();
			System.out.println("Table is created");
		}
			break;
		case 2: {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahantesh", "root",
					"root");
			PreparedStatement preparedStatement = connection.prepareStatement("insert into IPL values(?,?,?,?,?,?)");
			System.out.println("Enter the id");
			preparedStatement.setInt(1, sc.nextInt());
			System.out.println("Enter the name");
			preparedStatement.setString(2, sc.next());
			System.out.println("Enter the DOB");
			preparedStatement.setString(3, sc.next());
			System.out.println("Enter the Mobile no");
			preparedStatement.setLong(4, sc.nextLong());
			System.out.println("Enter the Team");
			preparedStatement.setString(5, sc.next());
			System.out.println("Enter the Cups");
			preparedStatement.setInt(6, sc.nextInt());
			preparedStatement.execute();
			connection.close();
			System.out.println("Data is Entered sucessfully");
		}
		break;
		case 3:{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahantesh","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("update IPL set Name=? where id=?");
			System.out.println("Enter the name");
			preparedStatement.setString(1, sc.next());
			System.out.println("Enter the id");
			preparedStatement.setInt(2, sc.nextInt());
			preparedStatement.executeUpdate();
			connection.close();
			System.out.println("Data is updated sucessfully");
		}
		break;
		case 4:{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahantesh","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("select * from IPL where id=?");
			System.out.println("Enter the id");
			preparedStatement.setInt(1, sc.nextInt());
			ResultSet e=preparedStatement.executeQuery();
			e.next();
			System.out.println("id: "+e.getInt(1)+"\nName: "+e.getString(2)+"\nDOB: "+e.getString(3)+"\nmob_no: "+e.getLong(4)+"\nTeam: "+e.getString(5)+"\nCups: "+e.getInt(6));
			connection.close();
		}
		break;
		case 5:{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahantesh","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("delete from IPL where name=?");
			System.out.println("Enter the Name");
			preparedStatement.setString(1, sc.next());
			preparedStatement.executeUpdate();
			System.out.println("row is deleted");
			connection.close();
		}
		break;
		case 6:{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mahantesh","root","root");
			PreparedStatement preparedStatement=connection.prepareStatement("Drop Table ?");
			System.out.println("Enter the table");
			preparedStatement.setString(1, sc.next());
			preparedStatement.execute();
			connection.close();
		}
		break;
		default :{
			System.out.println("performing an invalid operations");
		}
		}
	}
}
