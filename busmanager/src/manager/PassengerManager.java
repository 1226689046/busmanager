package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JTextArea;

import entity.Employee;
import entity.Passenger;
import interfaces.Manager;
import ui.ViewTools;
import util.JDBCTools;
import util.StaticClass;

public class PassengerManager<T> implements Manager<T> {
	private JTextArea resultJTA = ViewTools.result;
	@Override
	public void changeInfo( T newData) {
		Passenger emp = (Passenger)newData;
		try {
			String cmd = "update "+StaticClass.mysql_table_name_passenger+" set id=?,name=?,age=?,sex=?,other=? where id=?;";
			Connection conn = JDBCTools.getConnection(StaticClass.mysql_database_name);
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, System.currentTimeMillis()+"");
			pstmt.setString(2, emp.getName());
			pstmt.setInt(3, emp.getAge());
			pstmt.setString(4, emp.getSex());
			pstmt.setString(5, emp.getOther());
			pstmt.setString(6, emp.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
		}
	}

	
	@Override
	public void addData(T newData) {
		Passenger passenger= (Passenger)newData;
		try {
			Connection conn = JDBCTools.getConnection(StaticClass.mysql_database_name);
			String busAddCmd = "insert into "+StaticClass.mysql_table_name_passenger
					+ " values(?,?,?,?,?);";
			PreparedStatement pstmt = conn.prepareStatement(busAddCmd);
			pstmt.setString(1, passenger.getId());
			pstmt.setString(2, passenger.getName());
			pstmt.setInt(3, passenger.getAge());
			pstmt.setString(4, passenger.getSex());
			pstmt.setString(5, passenger.getOther());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {

		}
	}

	@Override
	public void printAllInfo() {
		try {
			resultJTA.setText("");
			Connection conn = JDBCTools.getConnection(StaticClass.mysql_database_name);
			String selectAllSQL = "select * from "+StaticClass.mysql_table_name_passenger;
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(selectAllSQL);
			int count = 0;
			while(result.next()) {
				StringBuilder resultStringBuilder = new StringBuilder();
				resultStringBuilder.append("id:");
				resultStringBuilder.append(result.getString("id"));
				resultStringBuilder.append("\nname:");
				resultStringBuilder.append(result.getString("name"));
				resultStringBuilder.append("\nage:");
				resultStringBuilder.append(result.getInt("age"));
				resultStringBuilder.append("\nsex:");
				resultStringBuilder.append(result.getString("sex"));
				resultStringBuilder.append("\nother:");
				resultStringBuilder.append(result.getString("other"));
				resultStringBuilder.append("\n");
				resultStringBuilder.append("----------------------\n");
				resultJTA.append(resultStringBuilder.toString());
				count++;
			}
			
			resultJTA.append("共有"+count+"条数据");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void delDataById(String id) {
		try {
			Connection conn = JDBCTools.getConnection(StaticClass.mysql_database_name);
			String delCmd = "delete from "+StaticClass.mysql_table_name_passenger+" where id=?";
			PreparedStatement pstmt = conn.prepareStatement(delCmd);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}
}
