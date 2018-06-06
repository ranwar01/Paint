import java.awt.BorderLayout;
import java.awt.Color;


import javax.swing.JFrame;

import javax.swing.JPanel;

public class MainPaint extends JFrame  {
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	    private JPanel mainPanel;
		private Drawing drawPanels;
		private FileMenuBar jPanelMenuBar;
		LeftPanel leftPanel;

	public MainPaint (){
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		jPanelMenuBar = new FileMenuBar();
		mainPanel.add(jPanelMenuBar,BorderLayout.PAGE_START);
				
		leftPanel = new LeftPanel();
		mainPanel.add(leftPanel,BorderLayout.LINE_START);
		
		drawPanels = new Drawing();
		mainPanel.add(drawPanels,BorderLayout.CENTER);
		mainPanel.setBackground(Color.WHITE);
		
		this.requestFocus();
		this.add(mainPanel);
		this.setSize(1000,750);
		this.setTitle("Paint");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	    		
	}
	
	
	public static void main(String [] args){
		
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				
				 MainPaint p =   new MainPaint();
				
			}
		});

	}
	
}
