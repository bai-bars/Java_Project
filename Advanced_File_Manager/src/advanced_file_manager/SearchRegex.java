package advanced_file_manager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.*;
/**
 *
 * @author "Baibars,A_Humble_Pirate"
 */
public class SearchRegex implements ActionListener{
    JFileChooser chooser;
    Mybutton directoryBtn;
    TextLabel text;
    int top,right;
    String selected="";
    
    SearchRegex(int top,int right){
        this.top=top;
        this.right=right;
        chooser= new JFileChooser();
        directoryBtn=new Mybutton("Select Directory",this.top,this.right);
        directoryBtn.setForeground(new Color(80,80,80));
        directoryBtn.addActionListener(this);
        text=new TextLabel(" ",this.top,this.right+50,new Color(80,80,80),Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        chooser=new JFileChooser("d:");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int result=chooser.showOpenDialog(null);
        if(result==JFileChooser.APPROVE_OPTION){
            File selectedFolder=chooser.getSelectedFile();
            selected=selectedFolder.getName();
            text.setText(selected);
            if(selected.equals("")){
                
            }
            else{
                File[] files=new File(selectedFolder.getAbsolutePath()).listFiles();
                
                for(File file: files){
                    System.out.println(file.getName());
                }
            }
            
        }
        
    }
    
    
}
   