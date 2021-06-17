package fileManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
/**
 * FXML Controller class
 *
 * @author baibars-barbarossa
 */
public class MainXMLController implements Initializable {
    
    @FXML
    private Button renamebtn,movebtn,searchbtn;
    @FXML
    private AnchorPane containerPane;
    
    @FXML
    void changePaneOnContainer(ActionEvent event) throws IOException{
        Parent pane = null;
        containerPane.getChildren().clear();
        
        if((Button) event.getSource()== renamebtn)
            pane = FXMLLoader.load(getClass().getResource("paneComponents/RenameXML.fxml"));
        else if((Button) event.getSource()== movebtn)
            pane = FXMLLoader.load(getClass().getResource("paneComponents/MoveXML.fxml"));
        else if((Button) event.getSource()== searchbtn)
            pane = FXMLLoader.load(getClass().getResource("paneComponents/SearchXML.fxml"));
        
        containerPane.getChildren().add(pane);
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
