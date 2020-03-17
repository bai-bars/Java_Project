package advanced_file_manager;

import java.awt.Container;
import javax.swing.JFrame;




public class MyFrame extends JFrame {
    private Container c;
    
    
   MyFrame(String title)
   {
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(50,100,400,500);
       setTitle(title);
       setResizable(false);
       setVisible(true);
       
   }
}
