                                                                            



package advanced_file_manager;

import java.awt.Color;
import javax.swing.JPanel;

class MyPanel extends JPanel{
    
    MyPanel(int xXis,int yXis,int width,int height,int R,int G,int B)
    {
        //this.setLayout(null);
        this.setBounds(xXis,yXis, width, height);
        this.setBackground(new Color(R,G,B));
        this.setLayout(null);
    }
}