package controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import unbhub.Loja;
import unbhub.Principal;
import unbhub.util.Tela;

public class IdLojaController implements Initializable{
    //Atributos das "telinhas" de loja no catálogo da tela do cliente
    private Loja loja;
    
    
    @FXML
    private Button bttVisualizar;

    @FXML
    private Circle circulo;

    @FXML
    private Label lblAvaliacao;

    @FXML
    private Label lblLocal;

    @FXML
    private Label lblLoja;

    @FXML
    private Label lblRedeSocial;
    double x=0,y=0;

    
    
    public void close() {
        Principal.close();
    }
    
    
    public void entrarLoja() throws IOException{
        System.out.println("funciona");
        for (int i = 0; i<unbhub.Principal.todasLojas.size(); i++){                
            if (unbhub.Principal.todasLojas.get(i).getNome().equals(lblLoja.getText())){
                ((ControleLojaCliente)Tela.abrirTela("/telas/TelaLojaCliente.fxml").getController()).setLoja(loja);
            }
        }
    }
    
    public void setLoja(Loja l) {
        loja = l;
    }
    
    public void editarConta(){
        
    }
    
    public void sairConta(){
        
    }
    
    public void setNome(String nome){
        lblLoja.setText(nome);
    }
    
    public String getNome(){
        return lblLoja.getText();
    }
    
    public void setRedeSocial(String rede){
        lblRedeSocial.setText(rede);
    }
    
    public String getRedeSocial(){
        return lblRedeSocial.getText();
    }
    
    public void setLocal(String local){
        lblLocal.setText(local);
    }
    
    public String getLocal(){
        return lblLocal.getText();
    }
    
    public void setAvaliacao(String nota){
        lblAvaliacao.setText(nota);
    }
    
    public String getAvaliacao(){
        return lblAvaliacao.getText();
    }
    
    public void pseudoConstrutor(String nome, String rede, String local, String nota){
        setNome(nome);
        setRedeSocial(rede);
        setLocal(local);
        setAvaliacao(nota);
    }
        
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //circulo.setFill(new ImagePattern(new Image("/imagens/iconLoja.png")));
        //Ação do botão de visualizar loja
        /*bttVisualizar.setOnMouseEntered(e ->{
            bttVisualizar.setCursor(Cursor.HAND);
        });*/
    }
}

