package controle;

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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class ControleCliente implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Circle cirAvatar;
    @FXML
    private Button btnSair;
    double x=0,y=0;
    
    // Fecha a janela
    public void close() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }
    
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
    
    // Volta pra tela de Login e desloga o perfil
    // ** deslogar perfil
    public void sairConta(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/telas/TelaLogin.fxml"));       
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        // Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);

        telaArrastavel(root,stage);

        stage.setScene(scene);
        stage.show();
    }
    
    // Entra na tela de Editar Perfil
    public void editarConta(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/telas/TelaEditarPerfil.fxml"));       
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        // Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);

        telaArrastavel(root,stage);

        stage.setScene(scene);
        stage.show();
    }
        
    public void voltarCliente(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/telas/TelaCliente.fxml"));       
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
        // TODO
    }    
    
}
