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
import entity.Passenger;
import manager.BusManager;
import manager.PassengerManager;
import util.StaticClass;

/**
 * 
 * @author WangShirong
 * 
 * 添加Passenger数据的Frame
 *
 */
public class AddPassengerFrame extends JFrame {
	PassengerManager<Passenger> pManager = new PassengerManager<>();

	public AddPassengerFrame() {
		setSize(200, 200);
		setTitle(StaticClass.BTN_ADDDATA + StaticClass.ITEM_PASSENGER);
		setLayout(new GridLayout(5, 2));

		final JTextField name = new JTextField(10);
		add(new JLabel("NAME："));
		add(name);

		final JTextField age = new JTextField(10);
		add(new JLabel("AGE："));
		add(age);

		final JTextField sex = new JTextField(10);
		add(new JLabel("SEX："));
		add(sex);

		final JTextField other = new JTextField(10);
		add(new JLabel("OTHER："));
		add(other);

		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Passenger p = new Passenger(
							System.currentTimeMillis() + "", name.getText(),
							Integer.valueOf(age.getText()), sex.getText(),
							other.getText());
					pManager.addData(p);

				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(null, "2,3项必须输入数字");
					return;
				}
				JOptionPane.showMessageDialog(AddPassengerFrame.this, "添加成功");
			}
		});
		add(button);

	}
}
