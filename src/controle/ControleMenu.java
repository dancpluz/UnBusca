package controle;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import unbhub.Principal;
import unbhub.Usuario;
import java.util.Map;
import javafx.scene.control.DatePicker;
import unbhub.Dono;
import unbhub.util.ObjectSer;
import unbhub.util.Tela;




//Controle das telas "TelaLogin", "TelaCadastro", "TelaEntrada", "TelaCompletarCadastro"
public class ControleMenu implements Initializable {
    @FXML
    private Button btnSair;
    @FXML
    private TextField txtNome, txtUsername, txtSenha, txtCpf, txtCelular;
    @FXML
    private Label lblErro;
    @FXML
    private DatePicker dpDataNascimento;
        
    
    // Fecha a janela
    public void close() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        ObjectSer.salvar();
    }
    
    
    // Troca a tela de Cadastro pela tela de Login
    public void trocarCenaLogin(ActionEvent event) throws IOException {
        Tela.abrirTela("/telas/TelaLogin.fxml");
        
    }
    
    
    // Troca a tela de Login pela tela de Cadastro
    public void trocarCenaCadastro(ActionEvent event) throws IOException {
        Tela.abrirTela("/telas/TelaCadastro.fxml");
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
                    Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaEntrada.fxml"));
                    Principal.usuarioLogado = u;
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
    
    
    
    //metodo para mudar conta de cliente para dono
    public void atualizarConta(ActionEvent event) throws IOException {
        if (txtCelular.getText().equals("") || (dpDataNascimento.getValue() == null)) {
            lblErro.setText("Preencha todos os campos");
        } else if ((Period.between(dpDataNascimento.getValue(), LocalDate.now()).getYears()) < 18) {
            System.out.println("aqui");
            lblErro.setText("Você deve ser maior de 18 anos para criar uma conta de dono");
        } else {
            Usuario u = Principal.usuarioLogado;
            Principal.usuarios.remove(u.getId());
            Dono d = new Dono(u.getNome(), u.getSenha(), u.getUsername(), u.getCpf(), u.getId(), txtCelular.getText(), dpDataNascimento.getValue());
            Principal.usuarios.put(u.getId(), d);
            Principal.usuarioLogado = d;
            Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaDono.fxml"));
        }  
    }
    
    
    
    
    public void voltar(ActionEvent event) throws IOException {
        Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaEntrada.fxml"));
    }
    
    
    
    
    // Após escolhido conta de Dono, troca pra a tela de completar cadastro ou a tela de dono.
    public void contaDono(ActionEvent event) throws IOException {
        // ** se a conta não tiver telefone e de nascimento cadastrada
        if (!(Principal.usuarioLogado instanceof Dono)) {
            Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaCompletarCadastro.fxml"));
        } else {
            Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaDono.fxml"));
        }
    }
    
    
    // Após escolhido conta de Cliente, troca pra a tela do cliente.
    public void contaCliente(ActionEvent event) throws IOException {
        Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaCliente.fxml"));
    }
    
    //logout
    public void logout() throws IOException {
        Principal.usuarioLogado = null;
        Tela.abrirTela("/telas/TelaLogin.fxml");
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
    }    
}
