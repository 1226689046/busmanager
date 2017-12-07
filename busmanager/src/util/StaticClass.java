package util;


/**
 * 
 * @author WangShirong
 *
 */
public class StaticClass {
	
	
	//JDBC
	//TODO:请配置以下参数
	public static String mysql_username = "root";
	public static String mysql_password = "123456wsr";
	public static String mysql_database_name = "busmanager";
	
	
	public static String mysql_table_name_bus = "bus";
	public static String mysql_table_name_employee = "employee";
	public static String mysql_table_name_passenger = "passenger";
	public static String mysql_table_name_route = "route";
	
	public final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public final static String JDBC_DATABASES_URL = "jdbc:mysql://localhost:3306/";
	
	
	
	//button名称
	public final static String BTN_SHOWDATA = "显示数据";
	public final static String BTN_ADDDATA = "添加数据";
	public final static String BTN_CHANGEDATA = "修改数据";
	public final static String BTN_DELDATA = "删除数据";
	
	//JLabel
	public final static String LABEL_CHOOSE = "选择管理项目:";
	
	//JCombox Item
	public final static String ITEM_BUS = "公交管理";
	public final static String ITEM_EMPLOYEE = "雇主管理";
	public final static String ITEM_PASSENGER = "乘客管理";
	public final static String ITEM_ROUTE= "路线管理";
	
	//程序默认名称
	public final static String DEFAULT_NAME = "公交管理系统";
	

	
	
}
