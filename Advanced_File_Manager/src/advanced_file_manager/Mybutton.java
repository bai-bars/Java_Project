
package advanced_file_manager;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

/**
 *
 * @author bai-bars
 */
public class Mybutton extends JButton {
    Mybutton(String text){
        setBounds(0,60,170,28);
        setFont(new Font("Aerial",  Font.BOLD, 15));
        setText(text);
      //JButton b= new Jbutton();
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setBackground(new Color(50,72,75));
    }
}
