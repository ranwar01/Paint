import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

@SuppressWarnings("serial")
public class SixLabels2 extends JPanel {
   private static final int GAP = 8;
   private static final int LABEL_WIDTH = 160;
   private static final Dimension LABEL_SIZE = new Dimension(LABEL_WIDTH, LABEL_WIDTH);
   private static final int ROWS = 2;
   private static final Font LABEL_FONT = new Font("Times New Roman", Font.BOLD, 20);

   public SixLabels2() {
      setBackground(Color.yellow);
      setLayout(new GridLayout(ROWS, 0, GAP, GAP)); 
      setBorder(BorderFactory.createEmptyBorder(GAP, GAP, GAP, GAP));

      // iterate through all the items in the MyColor enum
      for (MyColor myColor : MyColor.values()) {
         JLabel label = new JLabel(myColor.getText(), SwingConstants.CENTER);
         label.setForeground(myColor.getColor());
         label.setPreferredSize(LABEL_SIZE);
         label.setFont(LABEL_FONT);
         label.setOpaque(true);
         label.setBackground(Color.white);
         add(label);
      }
   }

   private static void createAndShowGui() {
      SixLabels2 mainPanel = new SixLabels2();

      JFrame frame = new JFrame("SixLabels2");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.getContentPane().add(mainPanel);
      frame.pack();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}

enum MyColor {
   BLACK("Black", Color.black), BLUE("Blue", Color.blue), 
   CYAN("Cyan", Color.cyan), GREEN("Green", Color.green), 
   MAGENTA("Magenta", Color.magenta), ORANGE("Orange", Color.orange);

   private String text;
   private Color color;

   private MyColor(String text, Color color) {
      this.text = text;
      this.color = color;
   }

   public String getText() {
      return text;
   }

   public Color getColor() {
      return color;
   }

   @Override
   public String toString() {
      return text;
   }

}