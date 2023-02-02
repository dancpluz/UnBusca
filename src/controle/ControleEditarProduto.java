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



public class ControleEditarProduto implements Initializable {
    private Produto produto;
    private Loja loja;
    
    @FXML
    private TextField txtNome, txtPreco;
    
    @FXML
    private Label lblErro;
    
    // Fecha a janela e salva
    public void close() {
        Principal.close();
    }
    
    public void setData(Produto p, Loja l) {
        produto = p;
        txtNome.setText(p.getNomeProduto());
        txtPreco.setText(String.valueOf(p.getPreco()));
    }
    
    
    
    public void cancelar() throws IOException {
        ((ControleLojaDono)Tela.abrirTela("/telas/TelaLojaDono.fxml").getController()).setLoja(loja);
    }
    
    public void salvar() {
        if(txtNome.getText().equals("") || txtPreco.getText().equals("")){
            lblErro.setText("Preencha todos os campos");
        } else {
            produto.setNome(txtNome.getText());
            produto.setPreco(Double.parseDouble(txtPreco.getText()));
        }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        //----
    }    
}
