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
import unbhub.Cliente;
import unbhub.Usuario;


public class ControleMenu implements Initializable {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btnSair;
    @FXML
    private TextField txtNome, txtUsername, txtSenha, txtCpf;
    @FXML
    private Label lblErro;

    double x=0,y=0;
    
    // Fecha a janela
    public void close() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
    }
    
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
        for (Usuario user : Principal.usuarios) {
            if (user.getUsername().equals(username)) {
                return 1;
            }    
        }
        
        Principal.usuarios.add(new Cliente(txtNome.getText(), txtSenha.getText(), txtUsername.getText(), Integer.parseInt(txtCpf.getText()), Principal.cIds));
        Principal.cIds += 1;
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
                lblErro.setText("Nome de Usuário já existe");
                break;
            case 0:
                lblErro.setTextFill(Color.color(0,1,0));
                lblErro.setText("Usuário Cadastrado com sucesso");
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
        for (Usuario u : Principal.usuarios) {
            if (u.getUsername().equals(user)) {
                if (u.checkSenha(senha)) {
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
        lblErro.setText("Usuário não encontrado");
        
    }
    
    public void contaDono(ActionEvent event) throws IOException {
        boolean dono = false;
        // ** se a conta não tiver telefone e de nascimento cadastrada
        if (!dono) {
            root = FXMLLoader.load(getClass().getResource("/telas/TelaCompletarCadastro.fxml"));
        } else {
            root = FXMLLoader.load(getClass().getResource("/telas/TelaDono.fxml"));
        }
        
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        // Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);

        telaArrastavel(root,stage);

        stage.setScene(scene);
        stage.show();
    }
    
    public void contaCliente(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/telas/TelaCliente.fxml"));       
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        // Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);

        telaArrastavel(root,stage);

        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
