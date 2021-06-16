package fileManager.paneComponents;


import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author baibars-barbarossa
 */
public class SearchXMLController implements Initializable {
    @FXML
    private AnchorPane searchPane;
    @FXML
    private TextField folderTextField,regExTextField;
    
    @FXML
    private Label headLabel,bodyLabel;
    File[] filesInDir =null;
    String apath= null;
    File folder;
    
    @FXML
    void browseFolderOnAction(ActionEvent e){
        DirectoryChooser folderChooser = new DirectoryChooser();
        Stage stage = (Stage) searchPane.getScene().getWindow();
        
        folder = folderChooser.showDialog(stage);
        
        if(folder!= null){
            apath = folder.getAbsolutePath();
            folderTextField.setText(apath);
            filesInDir = folder.listFiles();
          }
        
        
    }    
    
    @FXML
    void searchOnAction(ActionEvent e){        
        filesInDir = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                System.out.println("name: "+name);
                Pattern pattern = Pattern.compile(regExTextField.getText(), Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(name);
                //System.out.println(matcher.find());
                return matcher.find();
            }
        });
        
        if(filesInDir.length >0){
            headLabel.setText("Those Files Matched");
            int count=0;
            StringBuilder str= new StringBuilder();
            for(File file: filesInDir){
                ++count;
                if(count>1 && count%2==1) str.append("\n");
                else str.append(" ");
                str.append(count+". "+file.getName());
                
            }
            
            bodyLabel.setText(str.toString());
        }else{
            headLabel.setText("No Files Matched");
            bodyLabel.setText("");
        }
        
        }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}