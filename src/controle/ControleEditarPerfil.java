package controle;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import unbhub.Dono;
import unbhub.Principal;
import unbhub.Usuario;
import unbhub.util.Tela;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;


public class ControleEditarPerfil implements Initializable {
    
    private Boolean boolDono = false;
    private Usuario user;
    private File selectedFile;
    
    @FXML
    private TextField txtNome, txtTelefone, txtUsername, txtPath;
    @FXML
    private PasswordField pfSenha, pfNovaSenha, pfConfirmarSenha;
    @FXML
    private Label lblErro;
       
    
    // Fecha a janela
    public void close() {
        Principal.close();
    }
    
    
    public void selectFile() {
        FileChooser fc = new FileChooser();
        selectedFile = fc.showOpenDialog(null);
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter( "Image Files","*.png");
        fc = new FileChooser();
        fc.getExtensionFilters().add(imageFilter);
        if (selectedFile != null) {
            txtPath.setText(selectedFile.getName());
        }
    }
    
    
    
   
            
    public void voltar() throws IOException {
        Tela.abrirTela("/telas/TelaPerfil.fxml");
    }

    
    //salva mudancas
    public void salvar() throws IOException {
        if (txtNome.getText().equals("") || txtUsername.getText().equals("") || (txtTelefone.getText().equals("") && boolDono)) {
            lblErro.setText("Preencha todos os campos");
        } else if (user.checkSenha(pfSenha.getText())) {
            if (boolDono) {
                ((Dono)user).setTelefone(txtTelefone.getText());
            }
            user.setNome(txtNome.getText());
            user.setUsername(txtUsername.getText());
            if (!pfNovaSenha.getText().equals("")) {
                if (pfNovaSenha.getText().equals(pfConfirmarSenha.getText())){
                    user.setSenha(pfNovaSenha.getText());    
                } else {lblErro.setText("Senhas novas não são iguais");}
            }
            Tela.abrirTela("/telas/TelaPerfil.fxml");
            
            copyFileUsingNIO(selectedFile, new File(String.format("data/imagens/%d.png", user.getId())));
        } else {
            lblErro.setText("Senha incorreta");
        }
    }
 
    
    
    //metodo para salvar imagens   
    private static void copyFileUsingNIO(File sourceFile, File destinationFile) throws IOException {
        FileInputStream inputStream = new FileInputStream(sourceFile);
        FileOutputStream outputStream = new FileOutputStream(destinationFile);
        FileChannel inChannel = inputStream.getChannel();
        FileChannel outChannel = outputStream.getChannel();
        try {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } finally {
            inChannel.close();
            outChannel.close();
            inputStream.close();
            outputStream.close();
        }
    }

    
    
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        user = Principal.usuarioLogado;
        if(Principal.usuarioLogado instanceof Dono d) {
            boolDono = true;
            txtTelefone.setDisable(false);
            txtTelefone.setText(((Dono)user).getTelefone());
        }
        
        txtNome.setText(user.getNome());
        txtUsername.setText(user.getUsername());    
        
        
        
    }    
}
