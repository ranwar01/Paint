import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class LeftPanel extends JPanel implements ActionListener, ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JButton []buttons;
	public static  JSlider slider;
	public final static String [] shapeNames = {"Line","Rectangle", "Circle", "Arc","Rectange Fill"};
	public  String currentShapeName = "Line";
	public static String text;
	
	public LeftPanel(){
		
		buttons = new JButton[5];
		slider = new JSlider();
		slider.setValue(0);
		createButtons();

		this.setLayout(new GridLayout(6, 1));
		this.setPreferredSize(new Dimension(100,650));
		this.setBackground(new Color(248,248,255));
		this.setVisible(true);
		this.setOpaque(true);
	
	}
	
	public void createButtons(){
		
		for (int i=0; i< 5; i++){
			buttons[i] = new JButton(shapeNames[i]);
		    this.add(buttons[i]);
		    buttons[i].setOpaque(true);
		    buttons[i].addActionListener(this);
		    buttons[i].setBackground(Color.BLUE);

		}		
		
		this.add(slider);
		slider.setOpaque(true);
		slider.setBorder(BorderFactory.createEtchedBorder());
		slider.setToolTipText(stringGetValue());
		slider.addChangeListener(this);
		slider.setMajorTickSpacing(20);
	    slider.setPaintTicks(true);
			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if (e.getSource().equals(buttons[0])){
			Drawing.setCurrentShape("Line");			
		}
		else if (e.getSource().equals(buttons[1])){
			Drawing.setCurrentShape("Rectangle");		
		}
		else if (e.getSource().equals(buttons[2])){
			Drawing.setCurrentShape("Circle");
	    }
		else if (e.getSource().equals(buttons[3])){
			Drawing.setCurrentShape("Arc");
		}
		else if (e.getSource().equals(buttons[4])){
			Drawing.setCurrentShape("Rectangle Filled");		
	    }
		
	}
	
	public String stringGetValue(){
		return Integer.toString(slider.getValue());
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		
		if (e.getSource().equals(slider)){
			Drawing.setStrokeValue(slider.getValue());
		}
		
	}
	
}
