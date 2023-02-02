package controle;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unbhub.Loja;
import unbhub.Produto;
import unbhub.util.Tela;



public class ControleItemProdutoDono implements Initializable {
    @FXML
    private Label lblNome, lblPreco;
    @FXML
    private ImageView imgFoto;
    
    private ControleLojaDono pai;
    private Loja loja;
    private Produto produto;
    

    
    
    //Carrega os dados da loja no card
    public void setData(Loja l, ControleLojaDono ctrl, Produto p) {
        loja = l;
        produto = p;
        lblNome.setText(p.getNomeProduto());
        lblPreco.setText(String.format("R$%f", p.getPreco()));
    }
    
    
    
    public void editarProduto() throws IOException {
        ((ControleEditarProduto)Tela.abrirTela("/telas/TelaEditarProduto").getController()).setData(produto, loja);
               
    }   
    
    public void deletarProduto() {
        loja.getListaProdutos().remove(produto);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
}
