/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileManager;

import java.io.IOException;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author mirza
 */
public class FXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        PauseTransition delay = new PauseTransition(Duration.seconds(3));
        
        Parent startPane = FXMLLoader.load(getClass().getResource("HomeXML.fxml"));
        Scene startScene = new Scene(startPane);
        primaryStage.setTitle("File Manager - JavaFX");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream( "logo/appIcon.png" ))); 
        primaryStage.setScene(startScene);
        primaryStage.show();
        
        Stage mainStage = new Stage();
        Parent mainPane = FXMLLoader.load(getClass().getResource("MainXML.fxml"));
        Scene mainScene = new Scene(mainPane);
        mainStage.setTitle("File Manager - JavaFX");
        mainStage.getIcons().add(new Image(getClass().getResourceAsStream( "logo/appIcon.png" ))); 
        mainStage.setScene(mainScene);
        
        delay.setOnFinished( e->{
           primaryStage.close();
           mainStage.show();
               });
        
        delay.play();
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
