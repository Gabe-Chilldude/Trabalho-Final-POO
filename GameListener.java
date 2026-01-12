import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class GameListener implements ActionListener{
   public int opc;
   public JFrame frame; 
   public GameListener(int opc, JFrame frame)  {
      super();
      this.opc = opc;
      this.frame = frame;
   }
   public void actionPerformed(ActionEvent e)  {
      System.out.println("a");
   }
}
