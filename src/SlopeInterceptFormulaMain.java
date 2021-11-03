package javaSlopeInterceptFormulaCalculator;

//@author Torin

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SlopeInterceptFormulaMain {
	//Window and Panel
	private static JFrame w = new JFrame();
	private static JPanel p1 = new JPanel();
	private static JPanel p2 = new JPanel();
	private static JPanel p3 = new JPanel();
	private static JPanel p4 = new JPanel();
	private static JPanel p5 = new JPanel();
	private static JPanel p6 = new JPanel();
	private static JPanel p7 = new JPanel();
	private static JPanel[] pArray= {p1, p2, p3, 
					 p4, p5, p6, p7};
	
	//Text Fields
	private static JTextField tf1X = new JTextField(6);
	private static JTextField tf1Y = new JTextField(6);
	private static JTextField tf2X = new JTextField(6);
	private static JTextField tf2Y = new JTextField(6);
	
	//Labels
	private static JLabel l1X = new JLabel("Enter X1:");
	private static JLabel l1Y = new JLabel("Enter Y1:");
	private static JLabel l2X = new JLabel("Enter X2:");
	private static JLabel l2Y = new JLabel("Enter Y2:");
	
	//Buttons
	private static JButton bC = new JButton("Calculate");
	private static JButton bE = new JButton("Exit");
	
	//Error Message Function Using JOptionPane
		public static void errorMsg(boolean b) {
		JOptionPane.showMessageDialog(null, "Whoops! There "
				+ "Was An Error.");
		if(b) {
			System.out.println("Whoops! There Was An Error.");
		}
	}
	public static void main(String[] args) {
		
		//Set Window Settings
		w.setTitle("Slope Intercept Formula Calculator");
		w.setSize(500, 260);
		w.setDefaultCloseOperation(3);
		w.setLayout(new GridLayout(7, 1));
		w.setLocationRelativeTo(null);
		
		//Adding ELements To Panels
		p1.add(l1X);
		p1.add(tf1X);
		p1.add(l1Y);
		p1.add(tf1Y);
		p2.add(l2X);
		p2.add(tf2X);
		p2.add(l2Y);
		p2.add(tf2Y);
		p3.add(bC);
		p6.add(bE);
		
		//Add Panels To Window
		for(JPanel p : pArray) {
			w.add(p);
		}
		
		//Set Colors And Other Styles
		bE.setBackground(new Color(200, 0, 0));
		bC.setBackground(new Color(60, 60, 220));
		for(JPanel p : pArray) {
			p.setBackground(new Color(205, 200, 206));
		}
		
		//Adding Event Listeners
		bE.addActionListener(new bELstnr());
		bC.addActionListener(new bCLstnr());
		
		//Setting Visibility
		w.setVisible(true);
	}
	
	//Event Listeners
	private static class bELstnr implements ActionListener{

		public void actionPerformed(ActionEvent a) {
			//Exit Program
			System.exit(0);			
		}


	}
	private static class bCLstnr implements ActionListener{

		public void actionPerformed(ActionEvent a) {
			try {
				//Getting Input
					double 
					inX1=Double.parseDouble(tf1X.getText()), 
					inY1=Double.parseDouble(tf1Y.getText()), 
					inX2=Double.parseDouble(tf2X.getText()), 
					inY2=Double.parseDouble(tf2Y.getText());
				
				//Other Vars
				double difX, difY, b, midX, midY, m;
				
				//Finding Difference
				if((inX1 + inY1) > (inX2 + inY2)) {
					difX = (inX1 - inX2);
					difY = (inY1 - inY2);
				} else {
					difX = (inX2 - inX1);
					difY = (inY2 - inY1);
				}
				
				//Setting Slope
				m =(difY / difX);
				
				//Setting Y-Intercept
				midX = (m * inX1);
				midY = (inY1);
				
				if(midX > 0) {
					midY -= midX;
					midX -= midX;
					
					b = midY;
				} else if(midX < 0) {
					midY += midX;
					midX += midX;
					
					b = midY;
				} else {
					b = 0;
				}
				
				//Setting Final String
				String fString;
				if(m%1==0&&b%1==0) {
					if(b<0) {
						fString=("The Slope Intercept "
								+ "Formula"
								+ " Is: Y = "+(int)m+"X - "+
								(int)(Math.abs(b)));
					} else {
						fString=("The Slope Intercept "
								+ "Formula"
								+ " Is: Y = "+(int)m+"X + "+
								(int)b);
					}
				} else if(b%1==0) {
					if(b<0) {
						fString=("The Slope Intercept "
								+ "Formula"
								+" Is: Y = "+m+"X - "
								+Math.abs((int)b));
					} else {
						fString=("The Slope Intercept "
								+ "Formula"
								+ " Is: Y = "+m+"X + "
								+(int)b);
					}
				} else if(m%1==0) {
					if(b<0) {
						fString=("The Slope Intercept "
								+ "Formula"
								+ " Is: Y = "+(int)m+"X - "
								+Math.abs(b));
					} else {
						fString=("The Slope Intercept "
								+ "Formula"
								+ " Is: Y = "
								+(int)m+"X + "+b);
					}
				} else {
					if(b<0) {
						fString=("The Slope Intercept "
								+ "Formula"
								+ " Is: Y = "+m+"X - "
								+Math.abs(b));
					} else {
						fString=("The Slope Intercept "
								+ "Formula"
								+ " Is: Y = "
								+m+"X + "+b);
					}
				}
				//Displaying Final String
				JOptionPane.showMessageDialog(null, fString);
			} catch (Exception e) {
				errorMsg(false);
			}
		}
	}
	
}
