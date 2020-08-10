package advanced_file_manager;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author "Baibars,A_Humble_Pirate"
 */
public class Advanced_File_Manager {
    
    

    public static void main(String[] args) {
        MyFrame frame1 = new MyFrame("ADVANCED_FILE_MANAGER");
        frame1.initComponents(Color.white);
        frame1.C.add(frame1.imagePanel);

       
        
          MyPanel panel_front = new MyPanel(0,82, 170, 498, 23, 35, 51); //front panel neavy blue//neavy_blue={23,35,51};
        
        MyPanel panel_back = new MyPanel(0,82, 170, 498, 54,70,78);    //back panel //ash={54,70,78};
      
        frame1.C.add(panel_back); //this panel will have menu Label
      frame1.C.add(panel_front); //this panel will contain the about of mine
      
        
        
      
      
     
          panel_back.add(frame1.menuImageLabelBack);
      panel_front.add(frame1.menuImageLabelFront);
      
     
       frame1.menuImageLabelBack.addMouseListener(new MouseListener(){
       public void mouseClicked(MouseEvent me)
       {
           int x=170;
               panel_back.setSize(170,500);
               
               Thread th=new Thread(){
                   public void run(){
                       try{
                           for(int i=170;i>=0;i--){
                               Thread.sleep(5);
                               panel_back.setSize(i,500);
                           } 
                       }catch(Exception e)
                                   {
                                   JOptionPane.showMessageDialog(null,e);
                                   }
                       }
                   }; th.start();
                   x=0;
          }
          public void mouseEntered(MouseEvent me){frame1.menuImageLabelBack.setIcon(frame1.enteredback);}
        public void mouseExited(MouseEvent me){frame1.menuImageLabelBack.setIcon(frame1.menuBackIcon);}
       public void mousePressed(MouseEvent me){}public void mouseReleased(MouseEvent me){}
     });
       
       
          frame1.menuImageLabelFront.addMouseListener(new MouseListener(){
                public void mouseClicked(MouseEvent me){
                int x=0;
               panel_back.show();
               panel_back.setSize(x,500);
               
               Thread th=new Thread(){
                   public void run(){
                       try{
                           for(int i=0;i<=170;i++){
                               Thread.sleep(5);
                               panel_back.setSize(i,500);
                           }
                       }catch(Exception e){
                                   JOptionPane.showMessageDialog(null,e);
                                   }
                       }
                   };
               th.start();
               x=170;
               }
       public void mouseEntered(MouseEvent me){frame1.menuImageLabelFront.setIcon(frame1.enteredfront);}
       public void mouseExited(MouseEvent me){frame1.menuImageLabelFront.setIcon(frame1.menuFrontIcon);}
       public void mousePressed(MouseEvent me){}public void mouseReleased(MouseEvent me){}
       });
       
      

        
        
        

        frame1.labelTheImage(frame1.homeIcon);
        frame1.labelTheMessage();

        //   movingText.setFont(new Font("Arial",0,14));
        
        Mybutton renameb=new Mybutton("RENAME",0,92);
        Mybutton moveb=new Mybutton("MOVE",0,120);
        Mybutton copyb=new Mybutton("COPY",0,148);
        Mybutton cutb=new Mybutton("CUT",0,176);
        
        Mybutton batchf=new Mybutton("BATCH RENAME",0,92);
        Mybutton auto_movef=new Mybutton("AUTO MOVE",0,120);
        Mybutton auto_copyf=new Mybutton("AUTO COPY",0,148);
        
        
        
        
        panel_back.add(renameb);
        panel_back.add(moveb);
        panel_back.add(copyb);
        panel_back.add(cutb);
        
         panel_front.add(batchf);
         panel_front.add(auto_movef);
         panel_front.add(auto_copyf);
        
        Color b=new Color( 23, 35, 51);
        Color f=new Color(54,70,78);
        TextLabel btext=new TextLabel("     #BASIC TOOLS",15,60,f,Color.WHITE);
        TextLabel ftext=new TextLabel("#ADVANCED TOOLS",15,60,b,Color.WHITE);
        panel_back.add(btext);
        panel_front.add(ftext);
        
        
        CardLayout panelayout;
        MyPanel pcards= new MyPanel(172,82,930,520,50,50,50);
        pcards.setLayout(new CardLayout());
        panelayout= (CardLayout)(pcards.getLayout());
        frame1.C.add(pcards);
        
        MyPanel p1,p2,p3,p4,p5,p6,p7;
        p1=new MyPanel(172,82,930,520,50,50,50);
        p1.setSomeText("this is p1");
        p1.setVisible(false);
        p2=new MyPanel(172,82,930,520,50,50,50);
        p2.setSomeText("this is p2");
        p2.setVisible(false);
        p3=new MyPanel(172,82,930,520,50,50,50);
        p3.setSomeText("this is p3");
        p4=new MyPanel(172,82,930,520,50,50,50);
        p4.setSomeText("this is p4");
        p5=new MyPanel(172,82,930,520,50,50,50);
        p5.setSomeText("this is p5");
        p6=new MyPanel(172,82,930,520,50,50,50);
        p6.setSomeText("this is p6");
        p7=new MyPanel(172,82,930,520,50,50,50);
        p7.setSomeText("this is 7");
        
        pcards.add(p1);
        pcards.add(p2);
        pcards.add(p3);
        pcards.add(p4);
        pcards.add(p5);
        pcards.add(p6);
        pcards.add(p7);
        
        copyb.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
          p1.setVisible(false);
         }
      });
        
        renameb.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            p2.setVisible(false);
         }
      });
        
    }

}
