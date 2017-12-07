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
 * ʹ��ǰ��������util������StaticClass������û���������
 */


public class BusManagerMain {
	public static void main(String[] args) {
		BusManagerFrame frame = new BusManagerFrame();
		ViewTools.addView(frame);
		JDBCTools.initJDBC();
		frame.validate();
	}
}
