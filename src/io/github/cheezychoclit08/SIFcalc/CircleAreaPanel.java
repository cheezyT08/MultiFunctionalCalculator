package io.github.cheezychoclit08.SIFcalc;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;

//@author Torin

public class CircleAreaPanel extends JPanel {
	//I Don't Know What This Is, Eclipse Told ME To Add It
	private static final long serialVersionUID = 1L;
	
	//Window and Panel
	private static JPanel p1 = new JPanel();
	private static JPanel p2 = new JPanel();
	private static JPanel p3 = new JPanel();
	private static JPanel p4 = new JPanel();
	
	//Text Fields
	private static JTextField tfR = new JTextField(6);
	
	//Labels
	private static JLabel lER = new JLabel("Enter Circle Radius:");
	
	//Buttons
	private static JButton bC = new JButton("Calculate");
	
	//Radio Buttons And Associated Components
	
	//Panel To Hold Buttons
	private static JPanel prb = new JPanel();
	private static JPanel prbI = new JPanel();
	private static JPanel prbM = new JPanel();
	
	//String To Hold Currant Radio Button Name
	String curM = "ft";
	
	//Borders
	Border brd = BorderFactory.createTitledBorder("Measurements");
	Border brdI = BorderFactory.createTitledBorder("Imperial");
	Border brdM = BorderFactory.createTitledBorder("Metric");
	
	//Imperial
	private static JRadioButton rin = new JRadioButton("in",true);
	private static JRadioButton rft = new JRadioButton("ft");
	private static JRadioButton ryrd = new JRadioButton("yrd");
	private static JRadioButton rmi = new JRadioButton("mi");
	//Metric
	private static JRadioButton rmm = new JRadioButton("mm");
	private static JRadioButton rm = new JRadioButton("m");
	private static JRadioButton rcm = new JRadioButton("cm");
	private static JRadioButton rkm = new JRadioButton("km");

	//Button Groups
	ButtonGroup bg = new ButtonGroup();
	
	//Arrays
	private static JPanel[] pArray= {p1, p2, p3, p4, prb, prbI, prbM};
	private static JRadioButton[] rbArray= {rin, ryrd, rft,
									rmi, rmm, rm, rcm, rkm};

	
	//Error Message Function Using JOptionPane
	public static void errorMsg(boolean b) {
		JOptionPane.showMessageDialog(null, "Whoops! There "
											+ "Was An Error.");
		if(b) {
			System.out.println("Whoops! There Was An Error.");
		}
	}
			
	public CircleAreaPanel() {
		//Panel this Settings
		setLayout(new GridLayout(3, 1));
		
		//Panel prb Settings
		prb.setLayout(new GridLayout(1, 2));
		prb.setBorder(brd);
		
		prbI.setBorder(brdI);
		prbI.setLayout(new GridLayout(2, 2));
		
		prbM.setBorder(brdM);
		prbM.setLayout(new GridLayout(2, 2));
		
		//Adding Buttons To Panel
		//Imperial
		prbI.add(rin);
		prbI.add(rft);
		prbI.add(ryrd);
		prbI.add(rmi);
		//Metric
		prbM.add(rmm);
		prbM.add(rcm);
		prbM.add(rm);
		prbM.add(rkm);
		
		//Adding Buttons To Button Groups
		//Imperial
		bg.add(rin);
		bg.add(rft);
		bg.add(ryrd);
		bg.add(rmi);
		//Metric
		bg.add(rmm);
		bg.add(rcm);
		bg.add(rm);
		bg.add(rkm);

		//Adding Panels And Lables To Main Radio Button Panels
		prb.add(prbI);
		prb.add(prbM);
		
		//Adding ELements To Panels
		p1.add(lER);
		p1.add(tfR);
		//p2.add(lEM);
		p2.add(prb);
		p3.add(bC);
		
		//Add Panels To Window
		add(p1);
		add(p2);
		add(p3);
		
		//Set Colors And Other Styles
		bC.setBackground(new Color(60, 60, 220));
		for(JPanel p : pArray) {
			p.setBackground(new Color(205, 200, 206));
		}
		for(JRadioButton rb : rbArray) {
			rb.setBackground(new Color(205, 200, 206));
		}
		
		//Adding Event Listeners
		bC.addActionListener(new bCLstnr());
		for(JRadioButton rb : rbArray) {
			rb.addActionListener(new rbLstnr());
		}
		
	}
	
	private class bCLstnr implements ActionListener{
		
		public void actionPerformed(ActionEvent a) {
			try {
				//Getting Input And Calculating Area
				double rad = Double.parseDouble(tfR.getText());
				double area = (Math.PI*(rad*rad));
				
				/*
				 * Setting Square Variable
				 * If The ² Doesn't Show Up Right When Running, 
				 * Replace "²" With "sq" or "square"
				*/
				final String square = "²";
				
				//Creating Final String
				String fString = "The Area is: "+area+" "+square+curM+".";
				
				//Displaying Final String
				JOptionPane.showMessageDialog(null, fString);
			} catch (Exception e) {
				errorMsg(false);
			}
		}
		
	}
	
	private class rbLstnr implements ActionListener{
		
		public void actionPerformed(ActionEvent a) {
			try {
				if(a.getSource().equals(rin)) {
					curM = "in";
				} else if(a.getSource().equals(rft)) {
					curM = "ft";
				} else if(a.getSource().equals(ryrd)) {
					curM = "yrd";
				} else if(a.getSource().equals(rmi)) {
					curM = "mi";
				} else if(a.getSource().equals(rmm)) {
					curM = "mm";
				} else if(a.getSource().equals(rcm)) {
					curM = "cm";
				} else if(a.getSource().equals(rm)) {
					curM = "m";
				} else if(a.getSource().equals(rkm)) {
					curM = "km";
				} else {
					errorMsg(false);
				}
			} catch (Exception e) {
				errorMsg(false);
				System.exit(-1);
			}
		}
		
	}

}
