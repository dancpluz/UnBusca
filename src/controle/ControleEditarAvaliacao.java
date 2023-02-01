package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import unbhub.Avaliacao;
import unbhub.util.Tela;

/**
 *
 * @author gcrbe
 */
public class ControleEditarAvaliacao implements Initializable { 
    private Avaliacao a;
    private int selecao;
    
    @FXML
    private Button btnII, btnMI, btnMM, btnMS, btnSS;
    @FXML
    private TextArea txtText;
    
    
    public void setData(Avaliacao av) {
       a = av;
       txtText.setText(a.getComentario());
       switch(av.getNota()){
           case 0 -> bII();
           case 1 -> bMI();
           case 2 -> bMM();
           case 3 -> bMS();
           case 4 -> bSS();
       }
        
    }
    
    
    public void salvar() throws IOException {
        a.setComentario(txtText.getText());
        a.setNota(selecao);
        Tela.abrirTela("/telas/TelaPerfil.fxml");
    }
    
    public void cancelar() throws IOException {
        Tela.abrirTela("/telas/TelaPerfil.fxml");
    }
    
    
     public void bII() {
        btnII.setTextFill(Color.web("#7AE582"));
        btnMI.setTextFill(Color.web("#000000"));
        btnMM.setTextFill(Color.web("#000000"));
        btnMS.setTextFill(Color.web("#000000"));
        btnSS.setTextFill(Color.web("#000000"));
        selecao = 0;
    }
    public void bMI() {
        btnII.setTextFill(Color.web("#000000"));
        btnMI.setTextFill(Color.web("#7AE582"));
        btnMM.setTextFill(Color.web("#000000"));
        btnMS.setTextFill(Color.web("#000000"));
        btnSS.setTextFill(Color.web("#000000"));
        selecao = 1;
    }
    public void bMM() {
        btnII.setTextFill(Color.web("#000000"));
        btnMI.setTextFill(Color.web("#000000"));
        btnMM.setTextFill(Color.web("#7AE582"));
        btnMS.setTextFill(Color.web("#000000"));
        btnSS.setTextFill(Color.web("#000000"));
        selecao = 2;
    }
    public void bMS() {
        btnII.setTextFill(Color.web("#000000"));
        btnMI.setTextFill(Color.web("#000000"));
        btnMM.setTextFill(Color.web("#000000"));
        btnMS.setTextFill(Color.web("#7AE582"));
        btnSS.setTextFill(Color.web("#000000"));
        selecao = 3;
    }
    public void bSS() {
        btnII.setTextFill(Color.web("#000000"));
        btnMI.setTextFill(Color.web("#000000"));
        btnMM.setTextFill(Color.web("#000000"));
        btnMS.setTextFill(Color.web("#000000"));
        btnSS.setTextFill(Color.web("#7AE582"));
        selecao = 4;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
}
