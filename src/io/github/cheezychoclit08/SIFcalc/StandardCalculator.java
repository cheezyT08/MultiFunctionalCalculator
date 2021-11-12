package io.github.cheezychoclit08.SIFcalc;

//@author Torin

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
public class StandardCalculator extends JPanel {
	//Creating Text Fields
	private static JTextField tf1 = new JTextField(6);
	private static JTextField tf2 = new JTextField(6);
	
	//Creating Operator Array
	//If '÷' Not Showing Up Or Program Not Working, 
	//Comment Out The First String Array And Uncomment The Second
	private static String[] ops = {"+", "-", "x", "÷", "^"};
	//private static String[] ops = {"+", "-", "x", "/", "^"};
	
	//Creating Combo Box
	private static JComboBox cbOps = new JComboBox(ops);
	
	//Creating Buttons 
	private JButton b = new JButton("Calculate");
	
	//Creating Panal To Hold Components
	private JPanel pTop = new JPanel();
	private JPanel pBottom = new JPanel();
	
	public StandardCalculator() {
		//Start Settings
		setLayout(new BorderLayout());
		setBackground(new Color(205, 200, 206));
		
		//Setting Borders And Colors
		pBottom.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
		
		pTop.setBackground(new Color(205, 200, 206));
		pBottom.setBackground(new Color(205, 200, 206));
		
		b.setBackground(new Color(60, 60, 220));
		
		//Adding Action Listeners
		b.addActionListener(new bLstnr());
		
		//Adding Components
		pTop.add(tf1);
		pTop.add(cbOps);
		pTop.add(tf2);
		
		pBottom.add(b);
		
		add(pBottom, BorderLayout.SOUTH);
		add(pTop, BorderLayout.NORTH);
	}
	
	public static void errorMsg(boolean b) {
		JOptionPane.showMessageDialog(null, "Whoops! There "
											+ "Was An Error.");
		if(b) {
			System.out.println("Whoops! There Was An Error.");
		}
	}
	
	//Event Listeners
	private static class bLstnr implements ActionListener{

		public void actionPerformed(ActionEvent a) {
			try {
				//Getting Input And Setting Other Variable
				int cbIn = cbOps.getSelectedIndex();
				
				double in1 = Double.parseDouble(tf1.getText());
				double in2 = Double.parseDouble(tf2.getText());
				
				double out = 0.00;

				String op = ops[cbIn];
				
				if(cbIn==0) {out = (in1+in2);}
				else if(cbIn==1) {out = (in1-in2);}
				else if(cbIn==2) {out = (in1*in2);}
				else if(cbIn==3) {out = (in1/in2);}
				else if(cbIn==4) {out = (Math.pow(in1,in2)); }
				else {errorMsg(true); System.exit(1);}
				
				JOptionPane.showMessageDialog(null, Double.toString(in1)+" "+op+" "
													+Double.toString(in2)+" = "
													+Double.toString(out));
			} catch(Exception e) {
				errorMsg(false);
				e.printStackTrace();
			}
		}
		
	}
}
