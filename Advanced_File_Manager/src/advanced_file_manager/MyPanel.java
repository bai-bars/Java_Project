                                     
package advanced_file_manager;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author "Baibars,A_Humble_Pirate"
 */
class MyPanel extends JPanel{
    MyPanel(int xXis,int yXis,int width,int height,Color C)
    {
        //this.setLayout(null);
        this.setBounds(xXis,yXis, width, height);
        this.setBackground(C);
        this.setLayout(null);
    }
    
    void setSomeText(String s){
        TextLabel txt=new TextLabel(s,300,300,Color.YELLOW,Color.WHITE);
        txt.setOpaque(true);
        this.add(txt);
    }
}