package com.AWT;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;
public class Demo extends JFrame implements ActionListener{
	static Random r=new Random();
	static int num;
	int sc=0,attempt=5,n;
	
	String i;
	JTextField t1,t2,t3,tscore,tattempts;
	JLabel l1,l2,lscore,lattempts;
	JPanel p1,p2,p3,p4,p5,p6;
	JComboBox ch;
	JButton b1,b2,tryagain,close;
	Font f=new Font("Courier",Font.BOLD,15);
	
public Demo(){
	getContentPane().setBackground(new Color(255,255,255));
	setLayout(null);
	
	String s[]= {"1-10","1-100","1-1000","10-100","10-1000","100-1000"};
	l1=new JLabel("Select Range : ");
	l1.setBounds(113,30,302,20);
	l1.setFont(new Font("Engravers MT", Font.BOLD, 18));
	ch=new JComboBox(s);
	ch.setFont(new Font("Tahoma", Font.BOLD, 15));
	ch.setBounds(450,23,136,35);
	ch.setBackground(Color.WHITE);
	ch.addItemListener(new ItemListener() {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			num=r.nextInt(100);
			String str= (String) ch.getSelectedItem();
			if(str.equals("1-10")) {
				 num=0;
				num=r.nextInt(10);
			}
			else if(str.equals("1-100")){
				num=0;
				num=r.nextInt(100);	
			}
			else if(str.equals("1-1000")) {
				num=0;
				num=r.nextInt(1000);	
			}
			else if(str.equals("10-100")) {
				num=r.nextInt(100);
				if(num<10) {
					num+=10;
				}
			}
			else if(str.equals("10-1000")) {
				num=0;
				num=r.nextInt(1000);
				if(num<10) {
					num+=10;
				}
			}
			 else if(str.equals("100-1000")) {
				num=0;
				num=r.nextInt(1000);
				if(num<100) {
					num+=100;
				}
			}
		}
	});
	add(l1);add(ch);
	
	l2=new JLabel("Guess the number :");
	l2.setBounds(113,100,302,20);
	l2.setFont(new Font("Engravers MT", Font.BOLD, 18));
	add(l2);
	t2=new JTextField();
	t2.setFont(new Font("Tahoma", Font.BOLD, 15));
	t2.setBounds(450,97,136,35);	add(t2);
	
	lscore=new JLabel("Score :");
	lscore.setBounds(113,170,302,20);
	lscore.setFont(new Font("Engravers MT", Font.BOLD, 18));
	add(lscore);
	
	tscore=new JTextField("0");
	tscore.setFont(new Font("Tahoma", Font.BOLD, 15));
	tscore.setBounds(450,167,136,35);

	add(tscore);
	lattempts=new JLabel("Remaining Attempts :");
	lattempts.setBounds(113,240,327,20);
	lattempts.setFont(new Font("Engravers MT", Font.BOLD, 18));

	add(lattempts);
	tattempts=new JTextField("5");
	tattempts.setFont(new Font("Tahoma", Font.BOLD, 15));
	tattempts.setBounds(450,237,136,35);
	add(tattempts);
	
	b1=new JButton("Check");
	b1.setBounds(155,330,150,35);
	b1.setFont(new Font("Engravers MT", Font.BOLD, 15));
	b1.setBackground(Color.CYAN);
	add(b1);
	
	
	b2=new JButton("Clear");
	b2.setBounds(423,330,141,35);
	b2.setFont(new Font("Engravers MT", Font.BOLD, 15));
	b2.setBackground(Color.CYAN);
	add(b2);
	
	tryagain=new JButton("Try Again"); 
	tryagain.setForeground(Color.BLACK);
	tryagain.setBounds(265,387,200,35);
	tryagain.setFont(new Font("Engravers MT", Font.BOLD, 15));
	tryagain.setBackground(Color.PINK);
	add(tryagain);
	
	close=new JButton("Close");
	Image i=new ImageIcon(ClassLoader.getSystemResource("c.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	close.setIcon(new ImageIcon(i));
	close.setBounds(288,437,157,55);
	close.setFont(new Font("Engravers MT", Font.BOLD, 15));
	close.setBackground(Color.RED);
	close.setForeground(Color.WHITE);
	add(close);
	
	tryagain.addActionListener(this);
	b1.addActionListener(this);
	b2.addActionListener(this);
	tscore.setEditable(false);
	tattempts.setEditable(false);
	close.addActionListener(this);
	
	
	
	setVisible(true);
	setTitle("Number Guess System Made By KK");
	setSize(735,547);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setResizable(false);
}


public void actionPerformed(ActionEvent ae) {
	
	if(ae.getSource()==b1) {
		try {
	n=Integer.parseInt(t2.getText());
		
	System.out.println(num);
	if(t2.getText().trim().length()>0) {
	
		if(n==num) {
			JOptionPane.showMessageDialog(null,"Congratulations You Guessed Correct Number");
			tscore.setText(""+(++sc));t2.setText("");
			num=r.nextInt(10);
		}
		else {
			JOptionPane.showMessageDialog(null,"Incorrect Number Try again...!");
			t2.setText("");
			tattempts.setText(""+(--attempt));
			if(attempt==0) {
				JOptionPane.showMessageDialog(null,"Remaining attempts : "+attempt+" Your Score : "+sc);
				t2.setEditable(false);
				ch.setVisible(false);
			}
		}
	}
	else {
		JOptionPane.showMessageDialog(null,"Please Enter a number");
	}
	}catch(Exception e) {
		JOptionPane.showMessageDialog(null, "Please enter number ...Character not allowed");
		t2.setText("");
	}
	}
	if(ae.getSource()==b2) {
		t2.setText("");
	}
	if(ae.getSource()==tryagain) {
		t2.setEditable(true);
		ch.setVisible(true);
		attempt=5;sc=0;
		tattempts.setText("5");
		tscore.setText("0");
		
	}
	if(ae.getSource()==close) {
		setVisible(false);
		System.exit(0);
	}
}

public static void main(String[] args) {
	new Demo();
}
}
