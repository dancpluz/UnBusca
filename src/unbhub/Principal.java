package unbhub;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Principal extends Application {
    double x=0,y=0;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaLogin.fxml"));
        Scene scene = new Scene(root,640,360);
        
        // Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        // Janela sem barra em cima
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        // Ao clicar na tela arrastar a janela
        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(mouseEvent -> {
            primaryStage.setX(mouseEvent.getScreenX() - x);
            primaryStage.setY(mouseEvent.getScreenY() - y);
        });
        
        primaryStage.setResizable(false);
        // Título da janela
        primaryStage.setTitle("UnBusca");
        // Ícone da janela
        primaryStage.getIcons().add(new Image("imagens/LogoScene.png"));
        // Determinar cena
        primaryStage.setScene(scene); 
        // Mostrar cena
        primaryStage.show(); 
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
