package controle;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import unbhub.Loja;
import unbhub.Principal;
import unbhub.util.Tela;


public class ControleEditarLoja implements Initializable {
    
    private Loja loja;
    
    @FXML
    private TextField txtNome, txtLocal, txtHora, txtRede, txtMetodo;
    @FXML
    private TextArea txtText;
    @FXML
    private Label lblErro;
       
    
    // Fecha a janela
    public void close() {
        Principal.close();
    }
    
    
    public void setLoja(Loja l) {
        loja = l;
        txtNome.setText(loja.getNome());
        txtLocal.setText(loja.getLocal());
        txtHora.setText(loja.getHorarioFuncionamento());
        txtRede.setText(loja.getRedeSocial());
        txtMetodo.setText(loja.getOpcoesPagamento());
        txtText.setText(loja.getPopUp());
    }
    
            
    public void voltar() throws IOException {
        ((ControleLojaDono)Tela.abrirTela("/telas/TelaLojaDono.fxml").getController()).setLoja(loja);
    }

    
    //salva mudancas
    public void salvarAlteracoes() throws IOException {
        if(!(txtNome.getText().equals("") || txtText.getText().equals("") || txtLocal.getText().equals("") || txtHora.getText().equals("") || txtRede.getText().equals("") || txtMetodo.getText().equals(""))) {
            loja.setNome(txtNome.getText());
            loja.setHorarioFuncionamento(txtHora.getText());
            loja.setLocal(txtLocal.getText());
            loja.setRedeSocial(txtRede.getText());
            loja.setOpcoesPagamento(txtMetodo.getText());
            loja.setPopUp(txtText.getText());
            ((ControleLojaDono)Tela.abrirTela("/telas/TelaLojaDono.fxml").getController()).setLoja(loja);
        } else {lblErro.setText("Preencha todos os campos");}
    }
    
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
 
        
    }    
}
