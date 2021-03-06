package fileManager.paneComponents;


import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author baibars-barbarossa
 */
public class RenameXMLController implements Initializable {
    @FXML
    private AnchorPane renamePane;
   // @FXML
    private Button browseFolderbtn,batchRenamebtn;
    @FXML
    private TextField folderTextField,extensionTextField,nameTextField,replacingTextField;
    @FXML
    private DatePicker dp;
    File[] filesInDir =null;
    String apath= null;
    File folder;
    String extension;
  
    @FXML
    void browseFolderOnAction(ActionEvent e){
        DirectoryChooser folderChooser = new DirectoryChooser();
        Stage stage = (Stage) renamePane.getScene().getWindow();
        
        folder = folderChooser.showDialog(stage);
        
        if(folder!= null){
            apath = folder.getAbsolutePath();
            folderTextField.setText(apath);
            filesInDir = folder.listFiles(File::isFile);
          }
        
        
    }
    
    @FXML
    void generateNameOnAction(ActionEvent e){
            String finalName="";
            String date="";
            String replacingWith = replacingTextField.getText();
            try{
                date = ((LocalDate)dp.getValue()).toString();
            }catch(Exception ex){
                date="";
            }
            
            
            finalName = replacingWith+"_"+date;
            nameTextField.setText(finalName);
    }
    @FXML
    void batchRenameOnAction(ActionEvent e){
        try {
            extension = extensionTextField.getText();
            String finalName= nameTextField.getText();
            
            if (!extension.equals("")){
                FilenameFilter filter = new FilenameFilter() {
                    @Override
                    public boolean accept(File f, String name) {
                        return name.toLowerCase().endsWith("."+extension) || name.toUpperCase().endsWith("."+extension)  ;
                    }
                };
                
                if(folder!=null){
                    filesInDir = folder.listFiles(filter);
                    int i =0;
                    for(File file:filesInDir) {
                        i++;
                        String prevName = file.getName();
                        String newName = finalName +"(" +i+ ")." + extension;
                        String newPath = apath + "\\" + newName;
                        file.renameTo(new File(newPath));
                    }
                }
            }else{
                int i =0;
                for(File file:filesInDir) {
                    i++;
                    String prevName = file.getName();
                    int dotIndex = prevName.lastIndexOf('.');
                    if (dotIndex > 0) {
                        extension = prevName.substring(dotIndex);
                    }
                    String newName = finalName +"(" +i+ ")" + extension;
                    String newPath = apath + "\\" + newName;
                    file.renameTo(new File(newPath));
            
                }
            }
            
            AnchorPane pane = FXMLLoader.load(getClass().getResource("SuccessXML.fxml"));
            renamePane.getChildren().add(pane);
        } catch (IOException ex) {
            
        }
        
        

    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
// filesTextField.setEditable(false);
//  browseFilesbtn.setDisable(true);