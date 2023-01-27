package controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import unbhub.Loja;

public class IdLojaController implements Initializable{
    //Atributos das "telinhas" de loja no catálogo da tela do cliente
    @FXML
    private ImageView imgLoja;

    @FXML
    private Label lblNomeLoja;

    @FXML
    private BorderPane borderPaneLoja;
    
    public void setLabel(String nome){
        lblNomeLoja.setText(nome);
    }
    
    public String getLabel(){
        return lblNomeLoja.getText();
    }
    
    public void InicializarTelaLoja() throws FileNotFoundException{
        String[] linha;
        File file = new File("src/unbhub/Informacoes.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            linha = scan.nextLine().split(" ");
            if (lblNomeLoja.getText().equals(linha[6])){
                //Inserir código de inicialização aqui.
                System.out.println("Loja existe");
            }
        }    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Define as ações dos botões e ícones de loja.
        borderPaneLoja.setOnMouseClicked(event -> {
            //Inicializa a tela da loja.
            try{
                InicializarTelaLoja();
            }catch(IOException e){
                e.printStackTrace();
            }
        });
        borderPaneLoja.setOnMouseEntered(event -> {
            //Muda o cursor ao passar por cima do ícone.
            borderPaneLoja.setCursor(Cursor.HAND);
        });
    }
}

