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
public class Advanced_File_Manager implements ActionListener {
    
   

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
        Mybutton search_regf=new Mybutton("SEARCH(REG-EX)",0,176);
        
        
        
        
        panel_back.add(renameb);
        panel_back.add(moveb);
        panel_back.add(copyb);
        panel_back.add(cutb);
        
         panel_front.add(batchf);
         panel_front.add(auto_movef);
         panel_front.add(auto_copyf);
         panel_front.add(search_regf);
        
        Color b=new Color( 23, 35, 51);
        Color f=new Color(54,70,78);
        TextLabel btext=new TextLabel("     #BASIC TOOLS",15,60,f,Color.WHITE);
        TextLabel ftext=new TextLabel("#ADVANCED TOOLS",15,60,b,Color.WHITE);
        panel_back.add(btext);
        panel_front.add(ftext);
        
        
        MyPanel homepanel= new MyPanel(172,82,930,520,50,50,50);
        homepanel.setSomeText("Hey,this is your home page");
        frame1.add(homepanel);
        
        MyPanel renamePanel,movePanel,copyPanel,cutPanel,
        batchRenamePanel,autoMovePanel,autoCopyPanel,searchRegPanel;
        
        renamePanel=new MyPanel(172,82,930,520,50,50,50);
        renamePanel.setSomeText("this is renamePanel");
        movePanel=new MyPanel(172,82,930,520,50,50,50);
        movePanel.setSomeText("this is movePanel");
        copyPanel=new MyPanel(172,82,930,520,50,50,50);
        copyPanel.setSomeText("this is copyPanel");
        cutPanel=new MyPanel(172,82,930,520,50,50,50);
        cutPanel.setSomeText("this is cutPanel");
        batchRenamePanel=new MyPanel(172,82,930,520,50,50,50);
        batchRenamePanel.setSomeText("this is batchRenamePanel");
        autoMovePanel=new MyPanel(172,82,930,520,50,50,50);
        autoMovePanel.setSomeText("this is autoMovePanel");
        autoCopyPanel=new MyPanel(172,82,930,520,50,50,50);
        autoCopyPanel.setSomeText("this is autoCopyPanel");
        searchRegPanel=new MyPanel(172,82,930,520,50,50,50);
        searchRegPanel.setSomeText("this is searchRegPanel");
        
        frame1.add(renamePanel);
        frame1.add(movePanel);
        frame1.add(copyPanel);
        frame1.add(cutPanel);
        frame1.add(batchRenamePanel);
        frame1.add(autoMovePanel);
        frame1.add(autoCopyPanel);
        frame1.add(searchRegPanel);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
    }

}
