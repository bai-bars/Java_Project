package fileManager.paneComponents;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 *
 * @author baibars-barbarossa
 */
public class SuccessXMLController {
    @FXML
    static Label successLabel;
    
    static Label getSuccessLabel(){
        return successLabel;
    }
}
