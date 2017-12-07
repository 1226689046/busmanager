package listener;

import interfaces.Manager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import entity.Bus;
import entity.Employee;
import entity.Passenger;
import entity.Route;
import manager.BusManager;
import manager.EmployeeManager;
import manager.PassengerManager;
import manager.RouteManager;
import ui.AddBusFrame;
import ui.AddRouteFrame;
import ui.AddEmployeeFrame;
import ui.AddPassengerFrame;
import ui.ChangeBusFrame;
import ui.ChangeEmployeeFrame;
import ui.ChangePassengerFrame;
import ui.ChangeRouteFrame;
import ui.ViewTools;
import util.StaticClass;

public class ButtonListener implements ActionListener {
	private JTextArea result = ViewTools.result;
	@Override
	public void actionPerformed(ActionEvent e) {
		String managerType = ViewTools.managerProject.getSelectedItem() + "";
		switch (e.getActionCommand()) {
		case StaticClass.BTN_SHOWDATA:
			showData(managerType);
			break;
		case StaticClass.BTN_ADDDATA:
			addData(managerType);
			break;
		case StaticClass.BTN_CHANGEDATA:
			changeData(managerType);
			break;
		case StaticClass.BTN_DELDATA:
			delData(managerType);
			break;
		}
	}

	
	/**
	 * 
	 * @param managerType Ҫ��ʵ��һ���ֵ�����
	 */
	private void showData(String managerType) {
		Manager<Object> manager = null;
		switch (managerType) {
		case StaticClass.ITEM_BUS:
			manager = new BusManager<>();
			break;
		case StaticClass.ITEM_EMPLOYEE:
			manager = new EmployeeManager<>();
			break;
		case StaticClass.ITEM_PASSENGER:
			manager = new PassengerManager<>();
			break;
		case StaticClass.ITEM_ROUTE:
			manager = new RouteManager<>();
			break;
		}
		manager.printAllInfo();
	}

	
	/**
	 * 
	 * @param managerType Ҫ��ӵ��������� 
	 * 
	 * ������Ӧ�Ĵ���
	 */
	private void addData(String managerType) {
		switch (managerType) {
		case StaticClass.ITEM_BUS:
			new AddBusFrame().setVisible(true);
			break;
		case StaticClass.ITEM_EMPLOYEE:
			new AddEmployeeFrame().setVisible(true);
			break;
		case StaticClass.ITEM_PASSENGER:
			new AddPassengerFrame().setVisible(true);
			break;
		case StaticClass.ITEM_ROUTE:
			new AddRouteFrame().setVisible(true);
			break;
		}
	}

	
	/**
	 * 
	 * @param managerType ��������
	 * 
	 * ������Ӧ�Ĵ���
	 */
	private void changeData(String managerType) {
		switch (managerType) {
		case StaticClass.ITEM_BUS:
			new ChangeBusFrame().setVisible(true);;
			break;
		case StaticClass.ITEM_EMPLOYEE:
			new ChangeEmployeeFrame().setVisible(true);
			break;
		case StaticClass.ITEM_PASSENGER:
			new ChangePassengerFrame().setVisible(true);
			break;
		case StaticClass.ITEM_ROUTE:
			new ChangeRouteFrame().setVisible(true);
			break;
		}
	}

	
	/**
	 *  
	 * @param managerType  ��������
	 * 
	 * ɾ������   
	 * ��̬
	 */
	private void delData(String managerType) {
		Manager<Object> manager = null;
		switch (managerType) {
		case StaticClass.ITEM_BUS:
			manager = new BusManager<>();
			break;
		case StaticClass.ITEM_EMPLOYEE:
			manager = new EmployeeManager<>();
			break;
		case StaticClass.ITEM_PASSENGER:
			manager = new PassengerManager<>();
			break;
		case StaticClass.ITEM_ROUTE:
			manager = new RouteManager<>();
			break;
		}
		String result = JOptionPane.showInputDialog(null, "������Ҫɾ����id");
		if (result.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "û����������");
			return;
		}
		manager.delDataById(result);
		JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
	}

}
