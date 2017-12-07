package ui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entity.Bus;
import manager.BusManager;
import util.StaticClass;



/**
 * 
 * @author WangShirong
 * 
 * 添加Bus数据的Frame
 *
 */

public class AddBusFrame extends JFrame {				
	BusManager<Bus> busManager = new BusManager<>();
	public AddBusFrame() {
		setSize(200,200);
		setTitle(StaticClass.BTN_ADDDATA+StaticClass.ITEM_BUS);
		setLayout(new GridLayout(5, 2));
		final JTextField type = new JTextField(10);
		add(new JLabel("TYPE："));
		add(type);
		
		
		
		final JTextField engin = new JTextField(10);
		add(new JLabel("ENGIN_NUMBER："));
		add(engin);
		
		final JTextField seating = new JTextField(10);
		add(new JLabel("SEATINGNUM："));
		add(seating);
		
		final JTextField route = new JTextField(10);
		add(new JLabel("ROUTE："));
		add(route);

		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Bus bus = new Bus(System.currentTimeMillis()+"",
							type.getText(), 
							Integer.valueOf(engin.getText()), 
							Integer.valueOf(seating.getText()), 
							Integer.valueOf(route.getText()));
					busManager.addData(bus);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "2,3,4项必须输入数字");
					return;
				}
				JOptionPane.showMessageDialog(AddBusFrame.this, "添加成功");
			}
		});
		add(button);
		
	}
}
