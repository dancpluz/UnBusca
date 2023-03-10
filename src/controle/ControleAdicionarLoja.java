package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import unbhub.Dono;
import unbhub.Principal;
import unbhub.util.Tela;


public class ControleAdicionarLoja implements Initializable {
    @FXML
    private Button btnSair;
    @FXML
    private TextField txtNome, txtLocal, txtHora, txtRede, txtMetodo;
    @FXML
    private TextArea txtText;
    @FXML
    private Label lblErro;


     
    
    // Fecha a janela
    public void close() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }
    
    //Cria uma nova loja
    public void salvarAlteracoes() throws IOException {
        if(!(txtNome.getText().equals("") || txtText.getText().equals("") || txtLocal.getText().equals("") || txtHora.getText().equals("") || txtRede.getText().equals("") || txtMetodo.getText().equals(""))) {
            Principal.todasLojas.add(((Dono)Principal.usuarioLogado).adicionarLoja(txtNome.getText(), txtHora.getText(), txtLocal.getText(), txtText.getText(), txtRede.getText(), txtMetodo.getText()));         
            Tela.abrirTela("/telas/TelaDono.fxml");
        } else {lblErro.setText("Preencha todos os campos");}
    }
    
    //Volta para a tela de dono        
    public void voltarTelaAdicionarLoja() throws IOException {
        Tela.abrirTela("/telas/TelaDono.fxml");
    }       
        
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        //----
    }    
}
