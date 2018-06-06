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


public class DrawPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String  currentShape;
	public int x, y, lastX, lastY;
	public static Color color;
	public static JTextArea textEditor;
	public String currentText;
	boolean isMousePressed = false;
	private Font font;
	private FontMetrics fm;
	public static Stroke stroke;
	public static int strokeValue;

	private Graphics2D g2d;	
	private BufferedImage img;

	public DrawPanel(){

		font = new Font("Serif", Font.BOLD, 25);//default size;
		fm = getFontMetrics(font);//want to be able to measure my String to draw
		lastX= 0;
		lastY= 0;
		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
		this.setVisible(true);
	}
	
	public static void setStrokeValue(int size){
		strokeValue = size;
	}
	
	public int getStrokeValue(){
		return strokeValue;
	}

	public static void setColor(Color c){
		color = c;
	}
	public static Color getColor(){
		return color;
	}
	@Override
	public void paintComponent (Graphics g){
	
		super.paintComponent(g);

		if (img == null) {
			initBuffer();
		}

		g2d.setColor(getColor());
		g2d.setStroke(new BasicStroke(strokeValue));

		if (getCurrentShape() == "Line"){
			g2d.drawLine(100, 200, 100, 250);
			g2d.drawLine(lastX, lastY, x, y);
		}
		else if (getCurrentShape() == "Rectangle"){
			g2d.drawRect(lastX, lastY, x, y);
			g2d.drawRect(100, 250, 300, 300);
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

	}
	
	private void initBuffer(){
		img = new BufferedImage(1000, 750,BufferedImage.TYPE_INT_ARGB);                       
		g2d = img.createGraphics();
		g2d.setBackground(Color.WHITE); 
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON); 
	}

	public static void setCurrentShape(String shape){
		currentShape = shape;
	}

	public  String getCurrentShape(){
		return currentShape;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		record(e.getX(),e.getY());
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		repaint();
	}

	public void record(int x, int y){
		lastX = x;
		lastY = y;
	}

	public void drawText(String text){
		currentText += text;
	}

	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	@Override
	public void keyPressed(KeyEvent e) {}

}

