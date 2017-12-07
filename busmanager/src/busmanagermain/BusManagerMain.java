package busmanagermain;

import java.awt.event.KeyEvent;
import java.sql.SQLException;

import ui.BusManagerFrame;
import ui.ViewTools;
import util.JDBCTools;


/**
 * 
 * @author Wangshirong
 * 
 * 使用前请先配置util包下面StaticClass里面的用户名和密码
 * 
 * 本项目github地址  
 * https://github.com/1226689046/busmanager
 * 
 * 
 * 哈哈哈哈哈
 */


public class BusManagerMain {
	public static void main(String[] args) {
		BusManagerFrame frame = new BusManagerFrame();
		ViewTools.addView(frame);
		JDBCTools.initJDBC();
		frame.validate();
	}
}
