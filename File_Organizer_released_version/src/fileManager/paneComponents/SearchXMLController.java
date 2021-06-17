package fileManager.paneComponents;


import fileManager.utilities.SubDirectories;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    @FXML
    private CheckBox subDirCheckBox;
    File[] filesInDir =null;
    String apath= null;
    File folder;
    
    @FXML
    void browseFolderOnAction(ActionEvent e){
        DirectoryChooser folderChooser = new DirectoryChooser();
        Stage stage = (Stage) searchPane.getScene().getWindow();
        
        folder = folderChooser.showDialog(stage);
        
        if(folder!= null && !subDirCheckBox.isSelected()){
            apath = folder.getAbsolutePath();
            folderTextField.setText(apath);
            filesInDir = folder.listFiles();
          }
        else if(folder!= null && subDirCheckBox.isSelected()){
            apath = folder.getAbsolutePath();
            folderTextField.setText(apath);
            SubDirectories.traverseSubDirectoryIteratively(new File(apath));
        }
        
        
    }    
    
    @FXML
    void searchOnAction(ActionEvent e){

        bodyLabel.setText("");
        String regEx = regExTextField.getText();

        if(regEx.length() > 0 && !subDirCheckBox.isSelected()){
            filesInDir = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(name);
                
                return matcher.find();
            }
        });
        }
        
        try{
            if(filesInDir.length >0 && !subDirCheckBox.isSelected()){
            headLabel.setText("Those Files Matched");
            int count=0;
            StringBuilder str= new StringBuilder();
            for(File file: filesInDir){
                if(file.isFile()){
                    ++count;
                    if(count>1 && count%2==1) str.append("\n");
                    else str.append("   ");
                    str.append(count+". "+file.getName());
                }
            }
            
            bodyLabel.setText(str.toString());
        }
        }catch(Exception exc){
           
        }
        
        if(subDirCheckBox.isSelected()){
            if(regEx.length() > 0 )
                SubDirectories.traverseSubDirectoryIteratively(new File(apath),regEx);
            AnchorPane pane;
            try {
                pane = FXMLLoader.load(getClass().getResource("SuccessForSearchXML.fxml"));
                searchPane.getChildren().add(pane);
            } catch (IOException ex) {
               
            }
            

           }
         
        }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}