package advanced_file_manager;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;




public class MyFrame extends JFrame {
    
    Container C;
    ImageIcon homeIcon,frameIcon;
    JLabel imageLabel=new JLabel(homeIcon); 
    
    JLabel menuImageLabelBack=new JLabel(); //for the back part of menu panel
    JLabel menuImageLabelFront=new JLabel(); //for the front part of menu panel
    
    
    JPanel imagePanel=new JPanel();
    JLabel textMsgLabel=new JLabel();
    String textMsg="'IF YOU'RE TIRED OF ORGANIZING YOUR FILES,YOU'VE CHOSEN THE RIGHT ONE'";
    String AllignCenter="                                                               ";
    String showlabelTxt=this.AllignCenter+this.textMsg;
    Color txtMsgBackgroundColor=new Color(23,35,51);
    Timer tm;
    int timeCounter=0;
    int txtlength;
    
    
   MyFrame(String title)
   {
        //back_panel>>>nearly ash colour
       //front_panel>>>blackish-neavy blue
       
       
       //in the back there will be all menu button
       ImageIcon menuFrontIcon=new ImageIcon(getClass().getResource("menuIconFront.png"));
       ImageIcon menuBackIcon=new ImageIcon(getClass().getResource("menuIconBack.png"));
       
       //for mouseEnteredIcon
       ImageIcon enteredfront=new ImageIcon(getClass().getResource("enteredfront_.png"));
       ImageIcon enteredback=new ImageIcon(getClass().getResource("enteredback_.png"));
       
       
       
       menuImageLabelBack.setIcon(menuBackIcon);
       menuImageLabelBack.setBounds(120,15,24,24);
       
       
       
       //in the front there will be intro of this application   
       
       menuImageLabelFront.setIcon(menuFrontIcon);
       menuImageLabelFront.setBounds(120,15,24,24);


       menuImageLabelBack.addMouseListener(new MouseListener(){
       
       public void mouseClicked(MouseEvent me)
       {
           System.out.println("moused has been clicked for ash");
       }
       
     
       
       public void mousePressed(MouseEvent me)
       {
           
       }
      
       public void mouseReleased(MouseEvent me)
       {
           System.out.println("mouse has been released for ash");
       }
       
       public void mouseEntered(MouseEvent me)
       {
            menuImageLabelBack.setIcon(enteredback);
           
       }
      
       public void mouseExited(MouseEvent me)
       {
            menuImageLabelBack.setIcon(menuFrontIcon);
       }
       
       });
       
      
       
        menuImageLabelFront.addMouseListener(new MouseListener(){
       
       public void mouseClicked(MouseEvent me)
       {
           System.out.println("mouse has been clicked for neavy blue");
       }
       
     
       
       public void mousePressed(MouseEvent me)
       {
           
       }
      
       public void mouseReleased(MouseEvent me)
       {
           System.out.println("mouse has been released");
           
       }
       
       public void mouseEntered(MouseEvent me)
       {
            menuImageLabelFront.setIcon(enteredfront);
           
       }
      
       public void mouseExited(MouseEvent me)
       {
            menuImageLabelFront.setIcon(menuFrontIcon);
       }
       
       });
      
       
       
    
       
    
      homeIcon =new ImageIcon(getClass().getResource("home3.jpg"));
       frameIcon=new ImageIcon(getClass().getResource("folderIcon.jpg"));
       this.setIconImage(frameIcon.getImage());
   
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setBounds(200,50,1000,600);
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
       
       
        imageLabel.setBounds(0,0,1000,80);
       
     
     imageLabel.setIcon(i);
     this.C.add(imageLabel);
   }
   
   void labelTheMessage()
   {
       
       this.textMsgLabel.setBounds(0,0,this.getWidth(),15);
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
