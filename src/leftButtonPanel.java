import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class leftButtonPanel extends JPanel implements ActionListener, ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JButton []buttons;
	public static  JSlider slider;
	public final static String [] shapeNames = {"Line","Rectangle", "Circle", "Arc","Rectange Fill"};
	public  String currentShapeName = "Line";
	public static String text;
	
	public leftButtonPanel(){
		buttons = new JButton[5];
		slider = new JSlider();
		
		slider.setValue(0);
		createButtons();
//		this.setBounds(50, 50, 250, 300);
		this.setLayout(new GridLayout(6, 1));
		this.setPreferredSize(new Dimension(100,650));
		this.setBackground(new Color(248,248,255));
//		 this.setBorder(new EmptyBorder(0, 5, 5, 20));
		this.setVisible(true);
		this.setOpaque(true);
//		this.setBounds(50, 50, 250, 300);
	
		
		
	}
	public void createButtons(){
		for (int i=0; i< 5; i++){
			buttons[i] = new JButton(shapeNames[i]);
//			buttons.se
		    this.add(buttons[i]);
		    buttons[i].setOpaque(true);
		    buttons[i].addActionListener(this);
		    buttons[i].setBackground(Color.BLUE);

	
//		    buttons.setSize(50, 100);
		}
		
		
		this.add(slider);
		slider.setOpaque(true);
		slider.setBorder(BorderFactory.createEtchedBorder());
//		slider.setBackground(Color.BLUE);
		slider.setToolTipText(stringGetValue());
		slider.addChangeListener(this);
		
		slider.setMajorTickSpacing(20);
//		slider.setMinorTickSpacing(5);
	    slider.setPaintTicks(true);
//		slider.setPaintLabels(true);
			
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(buttons[0])){
			drawing.setCurrentShape("Line");			
		}
		else if (e.getSource().equals(buttons[1])){
			drawing.setCurrentShape("Rectangle");
			
		}
		else if (e.getSource().equals(buttons[2])){
			drawing.setCurrentShape("Circle");
//			drawPanel.setCurrentShape("Circle");

	    }
		else if (e.getSource().equals(buttons[3])){
			drawing.setCurrentShape("Arc");
//			drawPanel.setCurrentShape("Arc");
	    }
		else if (e.getSource().equals(buttons[4])){
			drawing.setCurrentShape("Rectangle Filled");
			
	    }
		
	}

	public int getValue(){
		return slider.getValue();
	}
	
	public String stringGetValue(){
		return Integer.toString(slider.getValue());
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource().equals(slider)){
		
			drawing.setStrokeValue(slider.getValue());
		}
		
	}
}
