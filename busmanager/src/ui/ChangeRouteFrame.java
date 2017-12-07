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
import entity.Route;
import interfaces.Manager;
import manager.BusManager;
import manager.RouteManager;
import util.StaticClass;

/**
 * 
 * @author WangShirong
 * 修改Route信息的窗口
 *
 */
public class ChangeRouteFrame extends JFrame {
	Manager<Route> manager = new RouteManager<>();

	public ChangeRouteFrame() {
		setSize(200, 200);
		setTitle(StaticClass.BTN_ADDDATA + StaticClass.ITEM_BUS);
		setLayout(new GridLayout(3, 2));
		final JTextField id = new JTextField(10);
		add(new JLabel("要修改的id"));
		add(id);

		final JTextField desc = new JTextField(10);
		add(new JLabel("DESC："));
		add(desc);

		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Route r = new Route(id.getText(), desc.getText());
				manager.changeInfo(r);
				JOptionPane.showMessageDialog(ChangeRouteFrame.this, "修改成功");

			}
		});
		add(button);

	}
}
