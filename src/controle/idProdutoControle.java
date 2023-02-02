package controle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.Initializable;

public class idProdutoControle implements Initializable{

    @FXML
    private Label nomeProd;

    @FXML
    private Label preco;

    @FXML
    private Label status;
    
    public void setAll(String nome, String preco, String status){
        nomeProd.setText(nome);
        this.preco.setText(preco);
        this.status.setText(status);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}