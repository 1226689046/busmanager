package ui;

import java.awt.Dimension;

import javax.swing.JFrame;

import util.StaticClass;


/**
 * 
 * @author WangShirong
 * 
 * 主界面的Frame
 *
 */
public class BusManagerFrame  extends JFrame{
	public BusManagerFrame() {
		this(StaticClass.DEFAULT_NAME);
	}
	public BusManagerFrame(String title) {
		setTitle(title);
		setSize(new Dimension(300,480));
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
