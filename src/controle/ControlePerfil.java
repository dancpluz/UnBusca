
package controle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import unbhub.Principal;
import unbhub.Usuario;


public class ControlePerfil implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    double x=0,y=0;
    private int sort = 1;
    
    @FXML
    private Label lblNome, lblUsername;    
    @FXML
    private ImageView imgFoto; 
    @FXML
    private Button btnSair, btnLogout, btnEditarPerfil, btnSort;
    
    
    // Ao clicar na tela arrastar a janela
    public void telaArrastavel(Parent root, Stage stage) {        
        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
    }
      
    //Muda tipo de ordenação
    public void changeSort(ActionEvent event) throws IOException {
        if (sort == 1) {
            sort = -1;
            btnSort.setText("▴");
        } else {
            sort = 1;
            btnSort.setText("▾");
        }
    }
    
    
    
    //Logout e tela de login
    public void logout(ActionEvent event) throws IOException {
        Principal.usuarioLogado = null;
        
        root = FXMLLoader.load(getClass().getResource("/telas/TelaLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        // Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        telaArrastavel(root,stage);
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    //Ao clilcar no perfil voltar para a tela de entrada
    public void perfil(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/telas/TelaEntrada.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        //Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        telaArrastavel(root,stage);
        
        stage.setScene(scene);
        stage.show();
    }
    
    
    //Botao de editar perfil
    public void editarPerfil(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/telas/TelaEditarPerfil.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        //Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);
            
        telaArrastavel(root,stage);
        
        stage.setScene(scene);
        stage.show();
    }
    

    
    //Botao de X fecha o programa
    public void close() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Usuario user = Principal.usuarioLogado;

        //Carrega foto de perfil
        File foto = new File(String.format("%d.png", user.getId()));     
        if (foto.isFile()) {    
            imgFoto.setImage(new Image(foto.toURI().toString()));
        }
        
        if (lblNome != null) {
            lblNome.setText(user.getNome());
            lblUsername.setText("@"+user.getUsername());      
        }
    }    
}
