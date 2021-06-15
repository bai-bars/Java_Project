package fileManager.paneComponents;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author baibars-barbarossa
 */
public class MoveXMLController implements Initializable {
    @FXML
    AnchorPane movePane;
    
    @FXML
    TextField folderTextField,categoryTextField,extensionTextField;
    
    File folder;
    File[] filesInDir =null;
    String apath;
    Map<String, ArrayList<String>> map;
    ObservableMap<String, ArrayList<String>> observableMap;
    
    @FXML void createCategoryOnAction(ActionEvent e){
    }
    
    @FXML
    void browseFolderOnAction(ActionEvent e){
        DirectoryChooser folderChooser = new DirectoryChooser();
        Stage stage = (Stage) movePane.getScene().getWindow();
        
        folder = folderChooser.showDialog(stage);
        if(folder!= null){
            apath = folder.getAbsolutePath();
            folderTextField.setText(apath);
            filesInDir = folder.listFiles();
          }
    }
    
    @FXML
    void organizeOnAction(ActionEvent e){
//        File newFolder = new File(apath+"\\images");
//        newFolder.mkdir();
//        String fromFile = newFolder.getAbsolutePath();
//        String toFile = "";
//
//        Path source = Paths.get(fromFile);
//        Path target = Paths.get(toFile);
//
//        try {
//            Files.move(source, target);
//
//            // Files.move(source, target, StandardCopyOption.REPLACE_EXISTING);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       map = new HashMap<String, ArrayList<String> >();
       observableMap = FXCollections.observableMap(map);
       
       observableMap.put("images", new ArrayList<String>());
       observableMap.get("images").add("png");
//       observableMap.get("images").add("jpg");
//       observableMap.get("images").add("jpeg");
//       
//       observableMap.put("vidoes", new ArrayList<String>());
//       observableMap.get("videos").add("mp4");
//       observableMap.get("videos").add("wmv");
//       observableMap.get("videos").add("flv");
//       
//       observableMap.put("audios", new ArrayList<String>());
//       observableMap.get("audios").add("mp3");
//       observableMap.get("images").add("jpg");
//       observableMap.get("images").add("jpeg");
      
//       for (String key : observableMap.keySet())
//            for(String val : observableMap.get(key)){
//                System.out.println("Key: "+key+", Val: "+val);
//            }
       
    }    
    
}
