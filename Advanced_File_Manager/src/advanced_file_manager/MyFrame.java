package advanced_file_manager;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class MyFrame extends JFrame {
    
    Container C;
    ImageIcon homeIcon,frameIcon;
    JLabel movingText;
    
    
   MyFrame(String title)
   {
       homeIcon =new ImageIcon(getClass().getResource("home.jpg"));
       frameIcon=new ImageIcon(getClass().getResource("folderIcon.jpg"));
       this.setIconImage(frameIcon.getImage());
   
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(200,100,800,500);
       setTitle(title);
       setResizable(false);
       setVisible(true);
       this.setLayout(null);

      
   }
   
   void initComponents(Color C)
   {
        this.C=getContentPane();
       this.C.setBackground(C);
       
   }
   
   void labelTheImage(ImageIcon i)
   {
       JLabel imageLabel=new JLabel(i);
       imageLabel.setBounds(0,0,800,100);
       imageLabel.setIcon(i);
       this.C.add(imageLabel);
       
   }
   
//   void movingText()
//   {
//         movingText=new JLabel("IF YOU'RE TIRED OF ORGANIZING YOUR FILES,YOU'VE CHOSEN THE RIGHT ONE");
//         movingText.setFont(new Font("Arial",0,14));
//   }
}
