package controle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import unbhub.Dono;
import unbhub.Loja;
import unbhub.Principal;
import unbhub.Usuario;
import unbhub.util.Tela;


public class ControleDono implements Initializable {
    @FXML
    private Circle cirAvatar;
    @FXML
    private Button btnSair, btnSalvar;
    @FXML
    private TextField txtNome, txtLocal, txtHora, txtRede, txtMetodo;
    @FXML
    private TextArea txtText;
    @FXML
    private Label lblTitulo;
    @FXML
    private ImageView imgFotoLoja;
    @FXML
    private VBox vboxMinhasLojas;
     
    
    // Fecha a janela
    public void close() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }
    
    
    
    //muda comportamento dependendo se está adicionando/editando loja 
    public void setTelaEditarLoja(Loja l) {
        txtNome.setText( l.getNome());
        txtLocal.setText(l.getLocal());
        txtHora.setText(l.getHorarioFuncionamento());
        txtRede.setText(l.getRedeSocial());
        txtText.setText(l.getPopUp());
        txtMetodo.setText(l.getOpcoesPagamento());
        lblTitulo.setText("Editar loja");
        btnSalvar.setText("Salvar alterações");
        File foto = new File(String.format("data/imagens/%s.png", l.getIdLoja()));     
        if (foto.isFile()) {  
            imgFotoLoja.setImage(new Image(foto.toURI().toString()));
        }        
    }

 
    
    
    public void adicionarLoja() throws IOException {
        Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaAdicionarLoja.fxml"));
    }
    
    
    public void editarPerfil() throws IOException {
        Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaEditarPerfil.fxml"));
    }
    
            
            
    
    
    public void carregarMinhasLojas() {
        for(Loja l : ((Dono)Principal.usuarioLogado).getLojas()) {
            FXMLLoader fxmll = Tela.telaFxmlLoader("/itens/ItemLojaDono.fxml");
            try {
                HBox hbox = fxmll.load();
                ControleItemLojaDono c = fxmll.getController();
                c.setData(l);
                vboxMinhasLojas.getChildren().add(hbox);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    // Volta pra tela de Login e desloga o perfil
    // ** deslogar perfil
    public void voltar(ActionEvent event) throws IOException {
        Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaEntrada.fxml"));
    }
    
    // Entra na tela de Editar Perfil
    public void abrirPerfil(ActionEvent event) throws IOException {
        Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaPerfil.fxml"));
    }
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        Usuario user = Principal.usuarioLogado;
        cirAvatar.setFill(new ImagePattern(new Image("/imagens/Avatar.png")));
        
        //Carrega foto de perfil
        File foto = new File(String.format("data/imagens/%d.png", user.getId()));     
        
        if (foto.isFile()) {  
            cirAvatar.setFill(new ImagePattern(new Image(foto.toURI().toString())));
        }
        
        carregarMinhasLojas();
    }    
}
