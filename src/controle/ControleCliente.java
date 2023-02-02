package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import unbhub.Loja;
import unbhub.Principal;
import unbhub.util.Tela;


public class ControleCliente implements Initializable {
    ArrayList<Loja> lojaObjects = new ArrayList<Loja>();
    ArrayList<IdLojaController> controles = new ArrayList<IdLojaController>();
    @FXML
    private Circle cirAvatar;
    @FXML
    private Button btnSair;
    @FXML
    private GridPane gridLojas;
    @FXML
    private VBox vbox;
    @FXML
    private TextField txtPesquisa;
    
    // Fecha a janela
    public void close() {
        Principal.close();
    }
    
    
    
    
    
    public void pesquisar(){
        ArrayList<Loja> reordem = new ArrayList<Loja>();
        for (int i=0; i<lojaObjects.size(); i++){
            if (lojaObjects.get(i).getNome().equalsIgnoreCase(txtPesquisa.getText()) || 
                    lojaObjects.get(i).getNome().startsWith(txtPesquisa.getText())){
                reordem.add(0,lojaObjects.get(i));
            }else{
                reordem.add(reordem.size(),lojaObjects.get(i));
            }
        }
        if (reordem.equals(lojaObjects)){
            JOptionPane.showMessageDialog(null, "O nome digitado não foi encontrado!",
                    "Erro na busca", JOptionPane.WARNING_MESSAGE);
        }else{
            for (int i=0; i<reordem.size();i++){
                controles.get(i).setLoja(lojaObjects.get(i));
                controles.get(i).pseudoConstrutor(reordem.get(i).getNome(),
                        reordem.get(i).getRedeSocial(), reordem.get(i).getLocal(),
                        reordem.get(i).getMencao());
            }
        }
    }
    




    // Entra na tela de Editar Perfil
    public void editarConta(ActionEvent event) throws IOException {
    
    }
    
    public void voltar(ActionEvent event) throws IOException {
        Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaEntrada.fxml"));
    }
    
    // Entra na tela de Editar Perfil
    public void abrirPerfil(ActionEvent event) throws IOException {
        Tela.abrirTela(Tela.telaFxmlLoader("/telas/TelaPerfil.fxml"));
    }
    
    private void getLojas(){
        for (int i=0; i<unbhub.Principal.todasLojas.size(); i++){
            lojaObjects.add(unbhub.Principal.todasLojas.get(i));
        }
    }
    
    private void loadGridPane(){
        //Define o número de colunas e linhas iniciais para organizá-las (fxml) no gridpane.
        int linha = 1;
        int coluna = 0;
        //Inicializa as fxml referente aos ícones das lojas para navegação e trata as exceções.
        try{
            for (int i=0;i<this.lojaObjects.size(); i++){
                //FXMLLoader fxmlloader = new FXMLLoader();
                //fxmlloader.setLocation(getClass().getResource("/itens/ItemGridLoja.fxml"));
                
                
                FXMLLoader fxmlloader = Tela.telaFxmlLoader("/itens/ItemGridLoja.fxml");
                Pane pane = fxmlloader.load();
                //AnchorPane anchorpane = fxmlloader.load();
                
                //vbox.getChildren().add(anchorpane);
                
                
                
                
                
                IdLojaController idlojacontrole = fxmlloader.getController();
                idlojacontrole.setLoja(lojaObjects.get(i));
                idlojacontrole.pseudoConstrutor(lojaObjects.get(i).getNome(),
                        lojaObjects.get(i).getRedeSocial(), lojaObjects.get(i).getLocal(),
                        lojaObjects.get(i).getMencao());
                
                controles.add(idlojacontrole);
                
                if (coluna == 1){
                    coluna = 0;
                    linha++;
                }
                
                gridLojas.add(pane, coluna++ , linha);
                gridLojas.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridLojas.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridLojas.setMaxWidth(Region.USE_COMPUTED_SIZE);
                gridLojas.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridLojas.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridLojas.setMaxHeight(Region.USE_COMPUTED_SIZE);
                GridPane.setMargin(pane, new Insets(10));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /*
        Usuario user = Principal.usuarioLogado;
        cirAvatar.setFill(new ImagePattern(new Image("/imagens/Avatar.png")));
        
        //Carrega foto de perfil
        File foto = new File(String.format("data/imagens/%d.png", user.getId()));     
        
        if (foto.isFile()) {  
            cirAvatar.setFill(new ImagePattern(new Image(foto.toURI().toString())));
        }*/
        
        getLojas();
        loadGridPane();
    }    
}
