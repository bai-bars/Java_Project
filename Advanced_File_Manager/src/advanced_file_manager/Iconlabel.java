
package advanced_file_manager;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;


class IconLabel extends JLabel {
    
    IconLabel(){
        
    }
    
    
    
}

class TextLabel extends JLabel{
    TextLabel(String text,int left,int top,Color bcol,Color fcol){
        //JLabel j=new JLabel();
        setText(text);
        setBounds(left,top, 150,150 );
        setBackground(bcol);
        setForeground(fcol);
        setOpaque(true);
        setFont(new Font("Aerial",  Font.ITALIC, 15));
        
    }
}
