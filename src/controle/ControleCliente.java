package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import unbhub.util.Tela;


public class ControleCliente implements Initializable {
    @FXML
    private Circle cirAvatar;
    @FXML
    private Button btnSair;
    
    
    // Fecha a janela
    public void close() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }
    
    public void voltar(ActionEvent event) throws IOException {
        Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaEntrada.fxml"));
    }
    
    // Entra na tela de Editar Perfil
    public void abrirPerfil(ActionEvent event) throws IOException {
        Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaPerfil.fxml"));
    }
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /*
        Usuario user = Principal.usuarioLogado;
        cirAvatar.setFill(new ImagePattern(new Image("/imagens/Avatar.png")));
        
        //Carrega foto de perfil
        File foto = new File(String.format("data/imagens/%d.png", user.getId()));     
        
        if (foto.isFile()) {  
            cirAvatar.setFill(new ImagePattern(new Image(foto.toURI().toString())));
        }*/
    }    
}
