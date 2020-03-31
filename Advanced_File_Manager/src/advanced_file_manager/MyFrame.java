package advanced_file_manager;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;




public class MyFrame extends JFrame {
    
    Container C;
    ImageIcon homeIcon,frameIcon;
    JLabel textMsgLabel=new JLabel();
    String textMsg="'IF YOU'RE TIRED OF ORGANIZING YOUR FILES,YOU'VE CHOSEN THE RIGHT ONE'";
    String AllignCenter="                                              ";
    String showlabelTxt=this.AllignCenter+this.textMsg;
    Color txtMsgBackgroundColor=new Color(23,35,51);
    Timer tm;
    int timeCounter=0;
    int txtlength;
    
    
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
   
   void labelTheMessage()
   {
       
       this.textMsgLabel.setBounds(0,100,this.getWidth(),15);
       this.textMsgLabel.setBackground(txtMsgBackgroundColor);
       this.textMsgLabel.setForeground(Color.white);
       this.textMsgLabel.setOpaque(true);
       this.C.add(this.textMsgLabel);
       
       
       this.txtlength=this.textMsg.length();
       
       this.tm=new Timer(100, new ActionListener(){
           public void actionPerformed(ActionEvent arg){
               timeCounter++;
               if(timeCounter>txtlength)
               {
                  // textMsgLabel.setText(AllignCenter);
                   textMsgLabel.setText(showlabelTxt);
                   timeCounter=0;
               }
               else{
               textMsgLabel.setText(AllignCenter+textMsg.substring(0,timeCounter));
               }
               if(textMsgLabel.getForeground()==Color.white)
               {
                   textMsgLabel.setForeground(Color.green);
               }
               else if(textMsgLabel.getForeground()==Color.green)
               {
                   textMsgLabel.setForeground(Color.white);
               }
           }
                   
       });
       
       tm.start();
   }
   
   
   

}
