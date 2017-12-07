package ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import listener.ButtonListener;
import util.StaticClass;


/**
 * 
 * @author WangShirong
 * 
 * 主界面添加窗口的工具类
 *
 */
public class ViewTools {
	public static JTextArea result = new JTextArea(20,25);
	public static JComboBox managerProject = new JComboBox();
	public static void addView(BusManagerFrame frame) {
		ButtonListener listener = new ButtonListener();
		JPanel top = new JPanel();
		top.add(new JLabel(StaticClass.LABEL_CHOOSE));
		managerProject.addItem(StaticClass.ITEM_BUS);
		managerProject.addItem(StaticClass.ITEM_EMPLOYEE);
		managerProject.addItem(StaticClass.ITEM_PASSENGER);
		managerProject.addItem(StaticClass.ITEM_ROUTE);
		managerProject.addActionListener(listener);
		top.add(managerProject);
		JButton showButton = new JButton(StaticClass.BTN_SHOWDATA);
		showButton.addActionListener(listener);
		top.add(showButton);
		frame.add(top,BorderLayout.NORTH);
		
		
		JPanel middle = new JPanel();
		JButton addDataBtn = new JButton(StaticClass.BTN_ADDDATA);
		JButton changeDataBtn = new JButton(StaticClass.BTN_CHANGEDATA);
		JButton delDataBtn = new JButton(StaticClass.BTN_DELDATA);
		addDataBtn.addActionListener(listener);
		changeDataBtn.addActionListener(listener);
		delDataBtn.addActionListener(listener);
		middle.add(addDataBtn);
		middle.add(changeDataBtn);
		middle.add(delDataBtn);
		frame.add(middle,BorderLayout.CENTER);
		
		
		JScrollPane bottom = new JScrollPane(result);
		frame.add(bottom,BorderLayout.SOUTH);
	}
}
