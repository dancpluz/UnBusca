package controle;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import unbhub.Loja;



public class ControleItemLojaDono implements Initializable {
    @FXML
    private Label lblNome, lblNotaMedia, lblLocal, lblHorario;
    @FXML
    private ImageView imgFoto;
    
    
    //Carrega os dados da loja no card
    public void setData(Loja l) {
        lblNome.setText(l.getNome());
        lblNotaMedia.setText((new String[]{"SR", "II", "MI", "MM", "MS", "SS"})[l.getMencao()]);
        lblLocal.setText(l.getLocal());
        lblHorario.setText(l.getHorarioFuncionamento());
        
        File foto = new File(String.format("data/imagens/%s.png", l.getIdLoja()));     
        
        if (foto.isFile()) {  
            imgFoto.setImage(new Image(foto.toURI().toString()));
        }
    }
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
}