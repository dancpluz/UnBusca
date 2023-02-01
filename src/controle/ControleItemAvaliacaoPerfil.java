package controle;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import unbhub.Avaliacao;
import unbhub.util.Tela;



public class ControleItemAvaliacaoPerfil implements Initializable {
    @FXML
    private Label lblData, lblMencao, lblLoja;
    
    private Avaliacao avaliacao;
    

    
    
    public void editar() throws IOException {
        ((ControleEditarAvaliacao) Tela.abrirTela("/telas/TelaEditarAvaliacao.fxml").getController()).setData(avaliacao);
    }
    
    //Carrega os dados da loja no card
    public void setData(Avaliacao a) {
        avaliacao = a;
        lblData.setText(a.getDataString());
        lblMencao.setText(a.getMencao());
        lblLoja.setText(a.getLoja().getNome());        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
}
