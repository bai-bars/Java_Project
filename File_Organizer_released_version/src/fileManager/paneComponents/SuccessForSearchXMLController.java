package fileManager.paneComponents;

import java.awt.Desktop;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author baibars-barbarossa
 */
public class SuccessForSearchXMLController {
    @FXML
    void resultsBtnOnAction(ActionEvent e){
        Desktop desktop = Desktop.getDesktop();
                try{
                    desktop.open(new File("results.txt"));
                }catch(Exception ex){
                    
                }
    }
    
}
