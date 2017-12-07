package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * 
 * @author WangShirong
 *
 */
public class JDBCTools {
	// create table bus(type varchar(10),enginenumber integer,seatnum
	// integer,route integer)

	
	/**
	 * 初始化数据库  尝试创建数据库和数据表，存在即创建失败
	 */
	public static void initJDBC() {
		try {
			Connection conn = getConnection("");
			String create_mysql_cmd = "create database "
					+ StaticClass.mysql_database_name;
			Statement stmt = conn.createStatement();
			stmt.execute(create_mysql_cmd);
			System.out.println("创建数据库成功");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("数据库存在");
		}

		try {
			Connection busconn = getConnection(StaticClass.mysql_database_name);
			String busCmd = "create table "+StaticClass.mysql_table_name_bus+"(id varchar(30) not null primary key,type varchar(10),enginenumber integer,seatnum integer"
					+ ",route integer);";
			System.out.println(busCmd);
			Statement busstmt = busconn.createStatement();
			busstmt.execute(busCmd);
			System.out.println("创建bus数据表成功");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		try {
			Connection empconn = getConnection(StaticClass.mysql_database_name);
			String busCmd = "create table "+StaticClass.mysql_table_name_employee
					+"(id varchar(30) not null primary key,name varchar(10),age integer,sex varchar(2)"
					+ ",other varchar(20));";
			Statement empstmt = empconn.createStatement();
			empstmt.execute(busCmd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		}
		
		try {
			Connection conn = getConnection(StaticClass.mysql_database_name);
			String busCmd = "create table "+StaticClass.mysql_table_name_passenger
					+"(id varchar(30) not null primary key,name varchar(10),age integer,sex varchar(2)"
					+ ",other varchar(20));";
			Statement stmt = conn.createStatement();
			stmt.execute(busCmd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		}
		
		try {
			Connection conn = getConnection(StaticClass.mysql_database_name);
			String busCmd = "create table "+StaticClass.mysql_table_name_route
					+"(id varchar(30) not null primary key,routedesc varchar(10));";
			Statement stmt = conn.createStatement();
			stmt.execute(busCmd);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
		}
		
		

	}

	
	
	/**
	 * 
	 * @param databasesName 需要获取连接的数据库名字
	 * @return	数据库的连接
	 * @throws ClassNotFoundException 找不到数据库
	 * @throws SQLException 语句有错
	 */
	public static Connection getConnection(String databasesName)
			throws ClassNotFoundException, SQLException {
		Class.forName(StaticClass.JDBC_DRIVER);
		Connection conn = DriverManager.getConnection(
				StaticClass.JDBC_DATABASES_URL + databasesName,
				StaticClass.mysql_username, StaticClass.mysql_password);
		return conn;
	}
}
