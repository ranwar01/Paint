import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.JFrame;

import javax.swing.JPanel;

public class mainPaint extends JFrame  {
		drawing drawPanels;

	public mainPaint (){
		JPanel mainPanel = new JPanel();
//		mainPanel.a
		this.requestFocus();

		mainPanel.setLayout(new BorderLayout());

		FileMenuBar jPanelMenu = new FileMenuBar();
	
		mainPanel.add(jPanelMenu,BorderLayout.PAGE_START);
				
		leftButtonPanel buttons = new leftButtonPanel();
		mainPanel.add(buttons,BorderLayout.LINE_START);
		
		drawPanels = new drawing();
		mainPanel.add(drawPanels,BorderLayout.CENTER);
		

		mainPanel.setBackground(Color.WHITE);
		this.add(mainPanel);
		this.setSize(1000,750);
		setTitle("Paint");
		setLocationRelativeTo(null);
		setResizable(false);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	    
		
	
	}
	public static void main(String [] args){
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				 mainPaint p =   new mainPaint();
				
			}
		});

	}
	
}
