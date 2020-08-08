
package advanced_file_manager;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author bai-bars
 */
public class Mybutton extends JButton {
    Mybutton(String text,int left,int top){
        setBounds(left,top,170,28);
        setFont(new Font("Aerial",  Font.BOLD, 14));
        setText(text);
      //JButton b= new Jbutton();
        setFocusPainted(false);
        setForeground(Color.GRAY);
        setBackground(new Color(23,35,51));
        
    }
}
