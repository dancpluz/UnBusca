package controle;

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
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import unbhub.Principal;
//import unbhub.Cliente;
import unbhub.Usuario;
import java.util.Map;
import unbhub.ObjectSer;



public class ControleMenu implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    double x=0,y=0;
    
    @FXML
    private Button btnSair;
    @FXML
    private TextField txtNome, txtUsername, txtSenha, txtCpf;
    @FXML
    private Label lblErro;

    
    // Troca a tela de Cadastro pela tela de Login
    public void trocarCenaLogin(ActionEvent event) throws IOException {
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
    
    // Troca a tela de Login pela tela de Cadastro
    public void trocarCenaCadastro(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/telas/TelaCadastro.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        // Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        telaArrastavel(root,stage);
        
        stage.setScene(scene);
        stage.show();
    }
    
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
    
    
    // Criar um novo usuário
    public int criarCliente(){
        String nome = txtNome.getText(), 
               senha = txtSenha.getText(),
               username = txtUsername.getText(),
               cpf = txtCpf.getText();
        
        // Checa se todos os campos estão preenchidos
        if (nome.equals("") || senha.equals("") || username.equals("") || cpf.equals("")) {
            return 2;
        }
        
        // Checa se nome de usuario ja existe
        for (Map.Entry<Integer, Usuario> i : Principal.usuarios.entrySet()) {
            if (i.getValue().getUsername().equals(username)) {
                return 1;
            }   
        }
        
        Principal.usuarios.put(Principal.cIdUsuarios, new Usuario(txtNome.getText(), txtSenha.getText(), txtUsername.getText(), txtCpf.getText(), Principal.cIdUsuarios));
        Principal.cIdUsuarios += 1;
        return 0;
    }
    
    
    
    // Realiza cadastro
    public void entrarCadastro(ActionEvent event) throws IOException {
        switch (criarCliente()) {
            case 2:
                //Caso algum campo nao esteja preenchido:
                lblErro.setTextFill(Color.color(1,0,0));
                lblErro.setText("Preencha todos os campos");
                break;
            case 1:
                //caso username ja exista:
                lblErro.setTextFill(Color.color(1,0,0));
                lblErro.setText("Nome de Usuário ja existe");
                break;
            case 0:
                lblErro.setTextFill(Color.color(0,1,0));
                lblErro.setText("Usuário cadastrado com sucesso");
                txtNome.setText("");
                txtSenha.setText("");
                txtCpf.setText("");
                txtUsername.setText("");
                break;
        }
    }
    
    
    // Confere nome e senha e então realiza o login
    public void realizarLogin(ActionEvent event) throws IOException {
        String user = txtUsername.getText(), senha = txtSenha.getText();
        boolean notFound = true;
        for (Map.Entry<Integer, Usuario> i : Principal.usuarios.entrySet()) {
            Usuario u = i.getValue();
            if (u.getUsername().equals(user)) {
                notFound = false;
                if (u.checkSenha(senha)) {
                    //Usuario e senha corretos:
                    
                    Principal.usuarioLogado = u;
                  
                    root = FXMLLoader.load(getClass().getResource("/telas/TelaEntrada.fxml"));
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);

                    // Aplicar estilo css na cena
                    String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
                    scene.getStylesheets().add(css);

                    telaArrastavel(root,stage);

                    stage.setScene(scene);
                    stage.show();
                    return;
                } else {
                    // Senha incorreta:
                    lblErro.setText("Senha incorreta");
                }
            }
        }
        // Usuario não existe:
        if(notFound) {
        lblErro.setText("Usuário não encontrado");   
        }
    }
    
    
    // Fecha a janela
    public void close() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        ObjectSer.salvar();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
