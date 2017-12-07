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
import manager.BusManager;
import manager.RouteManager;
import util.StaticClass;

/**
 * 
 * @author WangShirong
 * 
 * 添加Route数据的Frame
 *
 */
public class AddRouteFrame extends JFrame {
	RouteManager<Route> busManager = new RouteManager<>();

	public AddRouteFrame() {
		setSize(200, 100);
		setTitle(StaticClass.BTN_ADDDATA + StaticClass.ITEM_BUS);
		setLayout(new GridLayout(2, 2));
		final JTextField desc = new JTextField(10);
		add(new JLabel("DESC："));
		add(desc);

		JButton button = new JButton("确认");
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Route r = new Route(System.currentTimeMillis() + "", desc
							.getText());
					busManager.addData(r);

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(AddRouteFrame.this, "添加失败");

					return;
				}
				JOptionPane.showMessageDialog(AddRouteFrame.this, "添加成功");
			}
		});
		add(button);

	}
}
