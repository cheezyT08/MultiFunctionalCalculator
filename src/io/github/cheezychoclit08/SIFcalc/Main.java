package io.github.cheezychoclit08.SIFcalc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//@author Torin

public class Main {
	
	public static void main(String[] args) {
		//Local Vars
		JButton bE = new JButton("Exit");
		JFrame w = new JFrame();
		JPanel pLow = new JPanel();
		JTabbedPane tp = new JTabbedPane();
				
		//Start Settings
		w.setTitle("Slope Intercept Formula Calculator");
		w.setDefaultCloseOperation(3);
		w.setLayout(new BorderLayout());
		w.setResizable(false);
		
		//Adding Panels To TabbedPane
		tp.addTab("                Standard Calculator"
				+ "                 ", new StandardCalculator());
		tp.addTab("            Circlular Area Calculator"
				+ "             ", new CircleAreaPanel());
		tp.addTab("<HTML><p>"
				+ "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
				+ "<span style=\"text-decoration: underlined;\"><em>SIF</em></span> Calculator"
				+ "&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp"
				+ "</p></HTML>", new SlopeInterceptPanel());
		
		//Adding Components To pLow Panel
		pLow.add(bE);

		//Setting Custom Colors
		pLow.setBackground(new Color(205, 200, 206));
		bE.setBackground(new Color(200, 0, 0));
		
		//Adding Action Listeners
		bE.addActionListener(new bELstnr());
		
		//Adding TabbedPane To Window
		w.add(tp, BorderLayout.CENTER);
		w.add(pLow, BorderLayout.SOUTH);
		
		//Setting Visible
		w.pack();
		w.setLocationRelativeTo(null);
		w.setVisible(true);
	}
	
	//Event Listeners
	private static class bELstnr implements ActionListener{
		
		public void actionPerformed(ActionEvent a) {
			//Exit Program
			System.exit(0);			
		}
	
	}
	
}
