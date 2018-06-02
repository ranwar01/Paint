import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TopMenuPanel extends JPanel implements ActionListener, ItemListener, ChangeListener{
	
	 public static JLabel label;
	 public final static String [] shapeNames = {"Clear", "Background", "Change", "Color"};
	 public JButton [] topPanelButtons;
	 String [] setFonts = {"Serif", "SansSerif", "Monospaced","Dialog", "DialogInput"};
	 static drawing draw;
	public JSlider textSize;
	 
	 
	public JComboBox fontComboBox;
	int size;
	
	public static Color d;
	@SuppressWarnings("unchecked")
	public TopMenuPanel(){
		 topPanelButtons = new JButton[4];
		 label = new JLabel("Current Color");
		 label.setBorder(BorderFactory.createEtchedBorder());
		 fontComboBox = new JComboBox(setFonts);
		
		 
		 textSize = new JSlider();
		 textSize.setMajorTickSpacing(4);
//		 textSize.setMinorTickSpacing(8);
		 textSize.setPaintTicks(true);
//		 textSize.setPaintLabels(true);
		 textSize.setSize(new Dimension(20, 50));
		 textSize.setPreferredSize(new Dimension(150, 60));
		 textSize.setOpaque(true);
//		 textSize.setBackground(Color.BLUE);
	     textSize.setBorder(BorderFactory.createEtchedBorder());
		 textSize.addChangeListener(this);
		 textSize.setToolTipText("Change Font Size: ");

		
		 	
		 this.setBackground(new Color(248,248,255));
		 this.setLayout(new FlowLayout(FlowLayout.CENTER));
		 this.setPreferredSize(new Dimension(1000, 75));
		 this.setBorder(new EmptyBorder(0, 5, 5, 5));

		
		 for (int i = 0; i<4; i++){
			 topPanelButtons[i] = new JButton(shapeNames[i]);
			 topPanelButtons[i].setPreferredSize(new Dimension(65,65));			
			 topPanelButtons[i].setOpaque(true);
			 topPanelButtons[i].setBackground(Color.BLUE);
			 topPanelButtons[i].addActionListener(this);
			 this.add(topPanelButtons[i]);
			 
		 }

		 fontComboBox.addItemListener(this);
		 this.add(fontComboBox, FlowLayout.LEFT);
		 this.add(textSize, FlowLayout.LEFT);
		 this.add(label);
		   
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Color"){
			Color c = JColorChooser.showDialog(null, "Choose a Color", label.getForeground());
		      if (c != null)
		        label.setForeground(c);
		      drawing.setColor(c);
		      topPanelButtons[3].setBackground(drawing.getColor());
		      drawing.textEditor.setForeground(c);
			}
			
			else if (e.getActionCommand()== "Clear"){
				drawing.textEditor.setText("");
				drawing.setCurrentShape(null);
			}	
//			else if (e.getSource()== fontSize){
//				String x = fontSize.getText();
//				setTextSize(x);
//				
//				
//			}
			else if (e.getActionCommand()=="Background"){
				 Color c = JColorChooser.showDialog(null, "Choose a Color", label.getForeground());
				 this.setBackground(c);
			}
	}
	public void BackGroundColor(Color c ){
		 d = c;
	}
	public static Color getBackGroundColor( ){
		return d;
	}
//	public void setTextSize(String x){
//		 size = Integer.parseInt(x);
//	}
//	public int getTextSize(){
//		if (size < 10){
//			return 10;
//			
//		}
//		else {
//		 return size;
//		}
//	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		 String x = e.getItem().toString();
		 
//		 System.out.println(x + size);
		 Font font = new Font(x,Font.PLAIN, size);
	
	     drawing.textEditor.setFont(font);
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		size = textSize.getValue();
		
	}
}
