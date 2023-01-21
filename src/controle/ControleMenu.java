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
import javafx.stage.Stage;

public class ControleMenu implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btnSair,btnCadastro;
    double x=0,y=0;
    
    // Troca a tela de Cadastro pela tela de Login
    public void trocarCenaLogin(ActionEvent event) throws IOException {
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
    
    // Troca a tela de Login pela tela de Cadastro
    public void trocarCenaCadastro(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/telas/TelaCadastro.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        // Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        telaArrastavel(root,stage);
        
        stage.setScene(scene);
        stage.show();
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
    
    // ** CRIAR OBJETO CLIENTE E FAZER VERIFICAÇÃO SE JÁ EXISTE ETC **
    // Criar um novo usuário
    public int criarCliente(){
        // ** RETORNAR ERROS E DAR UM NÚMERO, SEM ERRO É 0 E CRIAR O CLIENTE **
        return 0;
    }
    
    
    
    // Troca para a tela de entrada
    public void entrarCadastro(ActionEvent event) throws IOException {
        switch (criarCliente()) {
            case 2:
                //Erro...
                break;
            case 1:
                //Erro...
                break;
            case 0:
                root = FXMLLoader.load(getClass().getResource("/telas/TelaEntrada.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);

                // Aplicar estilo css na cena
                String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
                scene.getStylesheets().add(css);

                telaArrastavel(root,stage);

                stage.setScene(scene);
                stage.show();
                break;
        }
    }
    
    
    // Fecha a janela
    public void close() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
