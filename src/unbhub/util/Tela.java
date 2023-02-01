package unbhub.util;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import unbhub.Principal;



//Classe auxiliar para abrir telas
public class Tela {    
    private static double x=0,y=0;

    // Ao clicar na tela arrastar a janela
    public static void telaArrastavel(Parent root, Stage stage) {        
        
        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
    }
    
    //Metodo para abrir telas novas
    public static FXMLLoader abrirTela(FXMLLoader f) throws IOException {                    
        Parent root = f.load();   
        Stage stage = (Stage)Principal.primaryStage.getScene().getWindow();
        Scene scene = new Scene(root);

        // Aplicar estilo css na cena
        String css = Tela.class.getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        
        telaArrastavel(root,stage);

        stage.setScene(scene);
        stage.show();
        return f;
    }
    
    
    public static FXMLLoader abrirTela(String local) throws IOException {
        return abrirTela(telaFxmlLoader(local));
    }
    
    
    public static FXMLLoader telaFxmlLoader(String local) {
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(Tela.class.getResource(local));
        return fxmlloader;
    }
}
