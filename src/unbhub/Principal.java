/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package unbhub;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Daniel
 */
public class Principal extends Application {
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("TelaCadastro.fxml"));
        Scene scene = new Scene(root);
        
        String css = this.getClass().getResource("estilo.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
