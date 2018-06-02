import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;
import javax.swing.JTextArea;


public class drawPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

	public static String  currentShape;
	public int x, y, lastX, lastY;
	public static Color color;
//    public static BufferedImage image;
    public static JTextArea textEditor;
    String currentText;
    boolean isMousePressed = false;
    private Font font;
	private FontMetrics fm;
	public static Stroke stroke;
	public static int strokeValue;
	
	Graphics2D g2d;	
	 private BufferedImage img;
	
	public drawPanel(){
//		textEditor = new JTextArea(10,1);
//		textEditor.setEditable(true);
//		textEditor.setLineWrap(true);
//		textEditor.setText("a");
//		stroke = new BasicStroke(strokeValue);
		
		
//		img = new BufferedImage(600, 500, BufferedImage.TYPE_INT_ARGB);
	
		
		font = new Font("Serif", Font.BOLD, 25);//default size;
		fm = getFontMetrics(font);//want to be able to measure my String to draw
//		super.setFocusable(true);
	
//		this.add(textEditor);
		
//		image = new BufferedImage(1000, 750, BufferedImage.TYPE_4BYTE_ABGR);
//		image  = new BufferedImage(1000, 750, BufferedImage.TYPE_INT_ARGB);
		lastX= 0;
		lastY= 0;
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
//		this.requestFocus();
		this.addKeyListener(this);
		this.setVisible(true);
	}
	public static void setStrokeValue(int size){
		strokeValue = size;
		
	
//		System.out.println(strokeValue);
	}
	public int getStrokeValue(){
		System.out.println(strokeValue);
		return strokeValue;
//		System.out.println(strokeValue);
	}

//	  @Override
//	    public void paint(Graphics g){
//	        super.paint(g);
//
//	        // Draw Buffered Image
//	        g.drawImage(image, 1, 1, image.getWidth(), image.getHeight(), this);
//
//	        // If mouse dragging then draw temporary shape
////	        if(shape == LINE && dragging){
////	            g.setColor(color);
////	            g.drawLine((int)start_loc.getX(), (int)start_loc.getY(), (int)end_loc.getX(), (int)end_loc.getY());
////	        }
//	    }
	
	public static void setColor(Color c){
		color = c;
	}
    public static Color getColor(){
		return color;
	}
	@Override
	public void paintComponent (Graphics g){
//		Graphics g2d = image.getGraphics();
		

		super.paintComponent(g);
//		g2d.drawImage(img,0,0, null);
//		 if (img != null) {
//		         g.drawImage(img, 0, 0, null);
//		      }
//		Graphics2D g2 = (Graphics2D)g;
		if (img == null) {
	          initBuffer();
	        }
//		g2d = img.createGraphics();
//		Graphics2D g = getBufferedImageGraphics();
//		 g2d = (Graphics2D) g;
		g2d.setColor(getColor());
		g2d.setStroke(new BasicStroke(strokeValue));
		
	
//		System.out.println(currentShape);
		if (getCurrentShape() == "Line"){
			g2d.drawLine(100, 200, 100, 250);
			g2d.drawLine(lastX, lastY, x, y);
			System.out.println(lastX + " " +  lastY + " " + x +" " +  y);
			System.out.println("Drawing a Line ");
		}
		else if (getCurrentShape() == "Rectangle"){
			g2d.drawRect(lastX, lastY, x, y);
			g2d.drawRect(100, 250, 300, 300);
//			System.out.println("Drawing a Rectangle ");
		}
		else if (getCurrentShape() == "Circle"){
		
			g2d.drawOval(lastX, lastY,x, y);
		}
		else if (getCurrentShape() == "Arc"){
			
			g2d.drawArc(lastX, lastY, x, y , 48, 160);
		}
		else if (getCurrentShape() =="Text"){
			g2d.drawString("XRAY",x,y);
			
		}
		g.drawImage(img,0,0, null);
//		repaint();
	}
	  private void initBuffer(){
	                             
	        img = new BufferedImage(1000, 750,
	               BufferedImage.TYPE_INT_ARGB);                       
	        g2d = img.createGraphics();
	        g2d.setBackground(Color.WHITE); 
	        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
	                                  RenderingHints.VALUE_ANTIALIAS_ON); 
	    }
//	public void drawText(){
//		 
//		g2d.drawString(leftButtonPanel.getText(), x, y);
//		repaint();
//	}
//	public static void setText(String text){
//		 String currentText = text;
//		 drawText();
//	}


	public static void setCurrentShape(String shape){
		currentShape = shape;
		System.out.println(currentShape);
	}
	public  String getCurrentShape(){
		return currentShape;
	}



	@Override
	public void mousePressed(MouseEvent e) {
//		x = e.getX();
//		y = e.getY();
		record(e.getX(),e.getY());
//		repaint();
//		draw();
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		 x = e.getX();
		 y = e.getY();
//		record(x,y);
		repaint();
//		draw();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	   
		 x = e.getX();
		  y = e.getY();
//		 record(x,y);
//		 draw();
		 repaint();
	}
	public void record(int x, int y){
		lastX = x;
		lastY = y;
	}

	@Override
	public void mouseEntered(MouseEvent e) { }
	@Override
	public void mouseExited(MouseEvent e) {	}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {
//		String s = String.valueOf(e.getKeyChar());
//		System.out.println(s);
////		if (!isMousePressed){
//			Graphics g = getGraphics();
//			lastX += fm.stringWidth(s);
//			g.drawString(s, lastX, lastY);
//			g.dispose();
////		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub	

	}
	public void drawText(String text){
	
	 currentText += text;
//	g2d.drawString(currentText,x,y);
//	repaint();
}


}

