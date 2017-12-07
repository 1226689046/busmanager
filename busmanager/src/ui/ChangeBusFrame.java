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
import interfaces.Manager;
import manager.BusManager;
import util.StaticClass;

/**
 * 
 * @author WangShirong
 * 修改Bus信息的窗口
 *
 */
public class ChangeBusFrame extends JFrame{
	Manager<Bus> manager = new BusManager<>();
	
	public ChangeBusFrame() {
		setSize(200,200);
		setTitle(StaticClass.BTN_CHANGEDATA+StaticClass.ITEM_BUS);
		setLayout(new GridLayout(6, 2));
		
		
		final JTextField id = new JTextField(10);
		add(new JLabel("要修改的id:"));
		add(id);
		
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
					Bus bus = new Bus(id.getText(),
							type.getText(), 
							Integer.valueOf(engin.getText()), 
							Integer.valueOf(seating.getText()), 
							Integer.valueOf(route.getText()));
					manager.changeInfo(bus);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,"2,3,4项必须是数字");
					return;
				}
				JOptionPane.showMessageDialog(ChangeBusFrame.this, "修改成功");
			}
		});
		add(button);
		
	}
}
