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


public class ControleEntrada implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    double x=0,y=0;
    
    @FXML
    private Button btnSair, btnEspacoCliente, btnMinhasLojas, btnMeuPerfil;
    
    @FXML
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
    
    
    //Botao de X fecha o programa
    public void close() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }
    
    
    //Abre a tela de perfil
    public void telaPerfil(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/telas/TelaPerfilUsuario.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        // Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        telaArrastavel(root,stage);
        
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario user = Principal.usuarioLogado;

        //Carrega foto de perfil
        File foto = new File(String.format("%d.png", user.getId()));     
        if (foto.isFile()) {    
            imgFoto.setImage(new Image(foto.toURI().toString()));
        }
    }    
}
