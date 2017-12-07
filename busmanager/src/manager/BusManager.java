package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import util.JDBCTools;
import util.StaticClass;
import entity.Bus;
import interfaces.Manager;
import ui.ViewTools;

public class BusManager<T> implements Manager<T> {
	private JTextArea resultJTA = ViewTools.result;
	@Override
	public void addData(T newData) {
		Bus bus = (Bus)newData;
		try {
			Connection conn = JDBCTools.getConnection(StaticClass.mysql_database_name);
			String busAddCmd = "insert into "+StaticClass.mysql_table_name_bus
					+" values(?,?,?,?,?);";
			PreparedStatement pstmt = conn.prepareStatement(busAddCmd);

			pstmt.setString(1, bus.getId());
			pstmt.setString(2, bus.getType());
			pstmt.setInt(3, bus.getEngin_number());
			pstmt.setInt(4, bus.getSeating_capacity());
			pstmt.setInt(5, bus.getRoute());
			System.out.println(pstmt.toString());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void delDataById(String id) {
		try {
			Connection conn = JDBCTools.getConnection(StaticClass.mysql_database_name);
			String delCmd = "delete from "+StaticClass.mysql_table_name_bus+" where id=?";
			PreparedStatement pstmt = conn.prepareStatement(delCmd);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public void printAllInfo() {
		try {
			resultJTA.setText("");
			Connection conn = JDBCTools.getConnection(StaticClass.mysql_database_name);
			String selectAllSQL = "select * from "+StaticClass.mysql_table_name_bus;
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(selectAllSQL);
			int count = 0;
			while(result.next()) {
				StringBuilder resultStringBuilder = new StringBuilder();
				resultStringBuilder.append("id:");
				resultStringBuilder.append(result.getString("id"));
				resultStringBuilder.append("\ntype:");
				resultStringBuilder.append(result.getString("type"));
				resultStringBuilder.append("\nenginNumber:");
				resultStringBuilder.append(result.getInt("enginenumber"));
				resultStringBuilder.append("\nseatNum:");
				resultStringBuilder.append(result.getInt("seatnum"));
				resultStringBuilder.append("\nroute:");
				resultStringBuilder.append(result.getInt("route"));
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
	public void changeInfo(T newData) {
		Bus bus = (Bus)newData;
		try {
			String cmd = "update "+StaticClass.mysql_table_name_bus+" set id=?,type=?,enginenumber=?,seatnum=?,route=? where id=?;";
			Connection conn = JDBCTools.getConnection(StaticClass.mysql_database_name);
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, System.currentTimeMillis()+"");
			pstmt.setString(2, bus.getType());
			pstmt.setInt(3, bus.getEngin_number());
			pstmt.setInt(4, bus.getSeating_capacity());
			pstmt.setInt(5, bus.getRoute());
			pstmt.setString(6, bus.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			
		}
	}

}
