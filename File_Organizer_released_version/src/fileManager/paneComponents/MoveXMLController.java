package fileManager.paneComponents;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * MoveXML Controller class
 *
 * @author baibars-barbarossa
 */
public class MoveXMLController implements Initializable {
    @FXML
    AnchorPane movePane;
   // @FXML
   // AnchorPane successPane;
    //@FXML
    //private ListView<String>listview;
    @FXML
    private Label folderTypeLabel;
    //@FXML
    //private Label successLabel;
    
    @FXML
    TextField folderTextField,categoryTextField,extensionTextField;
    
    File folder;
    File[] filesInDir =null;
    String apath;
    Map<String, ArrayList<String>> map;
    //ObservableList <String> list;
    ArrayList<String> list;
    
    @FXML void createCategoryOnAction(ActionEvent e){
        String category= categoryTextField.getText();
        String extension= extensionTextField.getText();
        
        if(!map.containsKey(category)) map.put(category, new ArrayList<String>(Arrays.asList(extension)));
        else map.get(category).add(extension);
        
        StringBuilder str= new StringBuilder();
        for(String key : map.keySet()){
            str.append("'"+key+"'"+" allows : ");
            for(String val: map.get(key)){
                str.append("("+val+") ");
            }
          
            str.append("\n");
        }
        folderTypeLabel.setText(str.toString());
    }
    
    @FXML
    void browseFolderOnAction(ActionEvent e){
        DirectoryChooser folderChooser = new DirectoryChooser();
        Stage stage = (Stage) movePane.getScene().getWindow();
        
        folder = folderChooser.showDialog(stage);
        if(folder!= null){
            apath = folder.getAbsolutePath();
            folderTextField.setText(apath);
            filesInDir = folder.listFiles(File::isFile);
          }
    }
    
    @FXML
    void organizeOnAction(ActionEvent e){
          try{
              for(String key : map.keySet() ){
              File newFolder = new File(apath+"\\"+key);
              if(!newFolder.isDirectory()) newFolder.mkdir();
              
              for(File file : filesInDir){
               String extension="";
               String name = file.getName();
               int dotIndex = name.lastIndexOf('.');
               if (dotIndex > 0) extension = name.substring(dotIndex+1);
               
               for(String folder : map.keySet()){
                   if(map.get(folder).contains(extension)){
                       
                       Path source = Paths.get(file.getAbsolutePath());
                       Path target = Paths.get(apath+"\\"+folder+"\\"+file.getName());
                       try{
                           Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
                       }catch(Exception ex){
                            
                        }
                   }
               }
               
               AnchorPane pane = FXMLLoader.load(getClass().getResource("SuccessXML.fxml"));
               movePane.getChildren().add(pane);
          }
              }
              
          }catch(Exception exc){
             
          }
          
          
          
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      map = new HashMap<String, ArrayList<String> >();
      
      map.put("videos", new ArrayList<String>(Arrays.asList("mp4","wmv" ,"flv")));
      map.put("images", new ArrayList<String>(Arrays.asList("png","jpg" ,"jpeg")));
      map.put("audios", new ArrayList<String>(Arrays.asList("mp3")));
      
      StringBuilder str= new StringBuilder();
      for(String key : map.keySet()){
          str.append("'"+key+"'"+" allows : ");
          for(String val: map.get(key)){
              str.append("("+val+") ");
          }
          
         str.append("\n");
      }
      
        folderTypeLabel.setText(str.toString());
    }    
    
}
