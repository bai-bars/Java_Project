package advanced_file_manager;
import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
/**
 *
 * @author "Baibars,A_Humble_Pirate"
 */
public class Advanced_File_Manager{

    public static void main(String[] args) {
        MyFrame frame1=new MyFrame("ADVANCED_FILE_MANAGER");
        frame1.initComponents(Color.white);
               
       
        MyPanel f1_p2=new MyPanel(0,100,300,500,23,35,51);
        frame1.C.add(f1_p2);
       
        frame1.labelTheImage(frame1.homeIcon);
       
        
     //   movingText.setFont(new Font("Arial",0,14));
        
        
    }
    
}
