package com.AWT;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
	Main(){
	setLayout(null);
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("number.png"));
		Image i2=i1.getImage().getScaledInstance(1550, 800, Image.SCALE_SMOOTH);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l1=new JLabel(i3);
		l1.setBounds(0,0,1550,800);
		add(l1);
		setUndecorated(true);
		setSize(1550,800);
		setVisible(true);
	
			new Demo();
	
	}

	public static void main(String[] args) {
	new Main();
	}

}
