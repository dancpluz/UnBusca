package controle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import unbhub.Principal;
//import unbhub.Cliente;
import unbhub.Usuario;
import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class ControlePerfil implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    double x=0,y=0;
    
    @FXML
    private Button btnSair, btnEspacoCliente, btnMinhasLojas, btnMeuPerfil;
    private ImageView imgFoto;
    
    
    // Ao clicar na tela arrastar a janela
    public void telaArrastavel(Parent root, Stage stage) {        
        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
    }
    
    
    
    public void close() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario user = Principal.usuarioLogado;
        /*
        //Carrega foto de perfil
        File foto = new File(String.format("/img/%d.png", user.getId()));     
        
        if (foto.isFile()) {
            System.out.println("aqui");
            imgFoto.setImage(new Image(foto.toURI().toString()));
        }
        */      
    }    
    
}
