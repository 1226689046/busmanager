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
import entity.Employee;
import interfaces.Manager;
import manager.BusManager;
import manager.EmployeeManager;
import util.StaticClass;

/**
 * 
 * @author WangShirong
 * 修改Employee信息的窗口
 *
 */
public class ChangeEmployeeFrame extends JFrame{
	Manager<Employee> manager  = new EmployeeManager<>();
	public ChangeEmployeeFrame() {
		setSize(200,200);
		setTitle(StaticClass.BTN_CHANGEDATA+StaticClass.ITEM_EMPLOYEE);
		setLayout(new GridLayout(6, 2));

		final JTextField id = new JTextField(10);
		add(new JLabel("要修改的id："));
		add(id);
		
		final JTextField name = new JTextField(10);
		add(new JLabel("NAME："));
		add(name);
		
		
		
		final JTextField age = new JTextField(10);
		add(new JLabel("AGE："));
		add(age);
		
		final JTextField sex = new JTextField(10);
		add( new JLabel("SEX："));
		add(sex);
		
		final JTextField other = new JTextField(10);
		add(new JLabel("OTHER："));
		add(other);

		
		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Employee emp = new Employee(id.getText(),
							name.getText(), 
							Integer.valueOf(age.getText()), 
							sex.getText(), 
							other.getText());
					manager.changeInfo(emp);
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null,"2,3项必须是数字");
					return;
				}
				JOptionPane.showMessageDialog(ChangeEmployeeFrame.this, "修改成功");
			}
		});
		add(button);
		
	}
}
