package advanced_file_manager;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author "Baibars,A_Humble_Pirate"
 */
public class Advanced_File_Manager {
    
    

    public static void main(String[] args) {
        MyFrame frame1 = new MyFrame("ADVANCED_FILE_MANAGER");
        frame1.initComponents(Color.white);
        frame1.C.add(frame1.imagePanel);

        MyPanel panel_front = new MyPanel(0,80, 170, 500, 54, 70, 78);
        
        MyPanel panel_back = new MyPanel(0,80, 170, 500, 23,35,51);
      
        //neavy_blue={23,35,51};
      // frame1.C.add(panel_front);
      frame1.C.add(panel_back);
        
      
      panel_back.add(frame1.menuImageLabelBack);
      panel_front.add(frame1.menuImageLabelFront);
        
        
        
        

        frame1.labelTheImage(frame1.homeIcon);
        frame1.labelTheMessage();

        //   movingText.setFont(new Font("Arial",0,14));
    }

}
