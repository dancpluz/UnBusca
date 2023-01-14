/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Daniel
 */
public class ControleCadastro implements Initializable {

    @FXML
    private AnchorPane apnCadastro;
    @FXML
    private Button btnCadastro;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtSenha;
    @FXML
    private TextField txtCpf;
    @FXML
    private Label lblCriarConta;
    @FXML
    private Rectangle retSide;
    @FXML
    private Label lblBemVindo;
    @FXML
    private Button btnCadastro1;
    @FXML
    private ImageView imgUnB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
