package manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.JTextArea;

import entity.Passenger;
import entity.Route;
import interfaces.Manager;
import ui.ViewTools;
import util.JDBCTools;
import util.StaticClass;

public class RouteManager<T> implements Manager<T> {
	private JTextArea resultJTA = ViewTools.result;
	@Override
	public void changeInfo( T newData) {
		Route route = (Route)newData;
		try {
			String cmd = "update "+StaticClass.mysql_table_name_route+" set id=?,routedesc=? where id=?;";
			Connection conn = JDBCTools.getConnection(StaticClass.mysql_database_name);
			PreparedStatement pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, System.currentTimeMillis()+"");
			pstmt.setString(2, route.getRouteDesc());
			pstmt.setString(3, route.getId());
			pstmt.executeUpdate();
		} catch (Exception e) {
		}
	}

	
	@Override
	public void addData(T newData) {
		Route route= (Route)newData;
		try {
			Connection conn = JDBCTools.getConnection(StaticClass.mysql_database_name);
			String addCmd = "insert into "+StaticClass.mysql_table_name_route
					+" values(?,?);";
			PreparedStatement pstmt = conn.prepareStatement(addCmd);
			pstmt.setString(1, route.getId());
			pstmt.setString(2, route.getRouteDesc());
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {

		}
	}

	@Override
	public void printAllInfo() {
		try {
			resultJTA.setText("");
			Connection conn = JDBCTools.getConnection(StaticClass.mysql_database_name);
			String selectAllSQL = "select * from "+StaticClass.mysql_table_name_route;
			Statement stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(selectAllSQL);
			int count = 0;
			while(result.next()) {
				StringBuilder resultStringBuilder = new StringBuilder();
				resultStringBuilder.append("id:");
				resultStringBuilder.append(result.getString("id"));
				resultStringBuilder.append("\nroutedesc:");
				resultStringBuilder.append(result.getString("routedesc"));
				resultStringBuilder.append("\n");
				resultStringBuilder.append("----------------------");
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
			String delCmd = "delete from "+StaticClass.mysql_table_name_route+" where id=?";
			PreparedStatement pstmt = conn.prepareStatement(delCmd);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	}
}
