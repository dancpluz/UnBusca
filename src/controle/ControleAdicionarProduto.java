package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import unbhub.Loja;
import unbhub.Principal;
import unbhub.Produto;
import unbhub.util.Tela;



public class ControleAdicionarProduto implements Initializable {
    private Loja loja;
    
    @FXML
    private TextField txtNome, txtPreco;
    @FXML
    private Label lblErro;
    
    
    
    public void setData(Loja l) {
        loja = l;
    }
    
    public void cancelar() throws IOException {
        ((ControleLojaDono)Tela.abrirTela("/telas/TelaLojaDono.fxml").getController()).setLoja(loja);
    }
    
    public void salvar() throws IOException {
        if(txtNome.getText().equals("") || txtPreco.getText().equals("")){
            lblErro.setText("Preencha todos os campos");
        } else {
            loja.addProduto(new Produto("a", txtNome.getText(), Double.parseDouble(txtPreco.getText())));
            ((ControleLojaDono)Tela.abrirTela("/telas/TelaLojaDono.fxml").getController()).setLoja(loja);
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        //----
    }    
}
