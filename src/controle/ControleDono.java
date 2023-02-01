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
    
    private Loja lojaSelecionada;
    
    @FXML
    private Circle cirAvatar;
    @FXML
    private VBox vboxMinhasLojas;
    @FXML
    private Label lblNotaMedia, lblNomeLoja, lblBemVindo;
    
    
    
    
    
    
    // Fecha a janela
    public void close() {
        Principal.close();
    }
    
    
    
    public void setLojaSelecionada(Loja l) {
        lojaSelecionada = l;
        lblNotaMedia.setText(lojaSelecionada.getMencao());
        lblNomeLoja.setText(lojaSelecionada.getNome());
        
        
    }

 
    
    public void visualizarLoja() throws IOException{
        ((ControleLojaDono)Tela.abrirTela("/telas/TelaLojaDono.fxml").getController()).setLoja(lojaSelecionada);   
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
                Button btn = fxmll.load();
                ControleItemLojaDono c = fxmll.getController();
                c.setData(l, this);
                vboxMinhasLojas.getChildren().add(btn);
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
        
        lblBemVindo.setText(String.format("Bem vindo, %s!", user.getNome()));
        
        cirAvatar.setFill(new ImagePattern(new Image("/imagens/Avatar.png")));
        
        //Carrega foto de perfil
        File foto = new File(String.format("data/imagens/%d.png", user.getId()));     
        
        if (foto.isFile()) {  
            cirAvatar.setFill(new ImagePattern(new Image(foto.toURI().toString())));
        }
        
        carregarMinhasLojas();
    }    
}
