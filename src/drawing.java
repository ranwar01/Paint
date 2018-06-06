import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Stroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public  class Drawing extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String  currentShape;
	public int x, y, lastX, lastY;
	public static Color color;
    public static BufferedImage image;
    public static JTextArea textEditor;
    String currentText;
    boolean isMousePressed = false;
    boolean isMouse = true;
	public static Stroke stroke;
	public static int strokeValue;
	
	Graphics2D g2d;	
	
	public Drawing(){
		setBackGround();
		textEditor = new JTextArea();
		textEditor.setBounds(0,0,1000,500);
		textEditor.setEditable(true);
		textEditor.setLineWrap(true);
		textEditor.setText("");
	
		this.add(textEditor);
//		image = new BufferedImage(1000, 750, BufferedImage.TYPE_4BYTE_ABGR);
		lastX= 0;
		lastY= 0;
//		this.setBackground(Color.WHITE);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
//		super.addKeyListener(this);
		this.setVisible(true);
	}
	public  void setBackGround(){
		this.setBackground(Color.WHITE);
	}
	
	public static void setStrokeValue(int size){
		strokeValue = size;

	}

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
//		g2d.setBackground(Color.red);
//		Graphics2D g = getBufferedImageGraphics();
		 g2d = (Graphics2D) g;
		g2d.setColor(getColor());
		g2d.setStroke(new BasicStroke(strokeValue));
//		g2d.draw
		
		if (getCurrentShape() == "Line"){

			g2d.drawLine(lastX, lastY, x, y);
//			System.out.println(lastX + " " +  lastY + " " + x +" " +  y);
//			System.out.println("Drawing a Line ");
		}
		else if (getCurrentShape() == "Rectangle"){
			g2d.drawRect(lastX, lastY, x, y);
		
		}
		else if (getCurrentShape() == "Circle"){
		
			g2d.drawOval(lastX, lastY,x, y);
			
		}
		else if (getCurrentShape() == "Arc"){
			
			g2d.drawArc(lastX, lastY, x, y , 48, 160);
		}
		else if (getCurrentShape() =="Rectangle Filled"){
			g2d.fillRect(lastX, lastY, x, y);
			
		}
	
//		repaint();
	}


	public static void setCurrentShape(String shape){
		currentShape = shape;
		System.out.println(currentShape);
	}
	public  String getCurrentShape(){
		return currentShape;
	}

	@Override
	public void mousePressed(MouseEvent e) {

		record(e.getX(),e.getY());
		repaint();

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
////			g.dispose();
//			repaint();
//		}
	}
	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub	

	}
	public void drawText(String text){
	
	 currentText += text;

	}

}
