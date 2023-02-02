package controle;

import static com.sun.javafx.scene.control.skin.Utils.getResource;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import unbhub.Dono;
import unbhub.Loja;
import unbhub.Principal;
import unbhub.Produto;
import unbhub.util.Tela;

public class ControleLojaCliente implements Initializable {
    private Loja loja;
    private ArrayList<idProdutoControle> controles = new ArrayList<idProdutoControle>();

    @FXML
    private Label lblNotaMedia, lblNomeLoja, lblPagLoja, lblLocalLoja, lblRedeLoja, lblHoraLoja;
    @FXML
    private BarChart bcGrafico;
    @FXML
    private VBox vboxProdutos;
    @FXML
    private Label popup;
    @FXML
    private Circle cirLoja;
    @FXML
    private GridPane gridProdutos;



    // Fecha a janela
    public void close() {
        Principal.close();
    }
 
    public void voltar() throws IOException {
        Tela.abrirTela("/telas/TelaCliente.fxml");
    }

    public void avaliar() {

    }

    public void verAvaliacao() {

    }

    public void buscar() {

    }
    
    public void setLoja(Loja store){
        loja = store;
        popup.setText(loja.getPopUp());
        lblNomeLoja.setText(loja.getNome());
        lblNotaMedia.setText(loja.getMencao());
        lblPagLoja.setText(loja.getOpcoesPagamento());
        lblLocalLoja.setText(loja.getLocal());
        lblRedeLoja.setText(loja.getRedeSocial());
        lblHoraLoja.setText(loja.getHorarioFuncionamento());
               
        loadGridPane();
    }
    
    private void loadGridPane(){
        //Define o número de colunas e linhas iniciais para organizá-las (fxml) no gridpane.
        int linha = 1;
        int coluna = 0;
        //Inicializa as fxml referente aos ícones das lojas para navegação e trata as exceções.
        try{
            for (int i=0;i<loja.getListaProdutos().size(); i++){
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/telas/idProduto.fxml"));
                
                AnchorPane anchorpane = fxmlloader.load();
                
                idProdutoControle prodControle = fxmlloader.getController();
                
                String disp = "Disponível";
                //if (loja.getListaProdutos().get(i).isDisponivel()){
                 //   disp = "Disponível";
                //}else{
                //    disp = "Em falta";
                //}
                
                prodControle.setAll(loja.getListaProdutos().get(i).getNomeProduto(),
                        String.valueOf(loja.getListaProdutos().get(i).getPreco()), disp);
                                              
                
                controles.add(prodControle);
                
                if (coluna == 1){
                    coluna = 0;
                    linha++;
                }
                
                gridProdutos.add(anchorpane, coluna++ , linha);
                gridProdutos.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridProdutos.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridProdutos.setMaxWidth(Region.USE_COMPUTED_SIZE);
                gridProdutos.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridProdutos.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridProdutos.setMaxHeight(Region.USE_COMPUTED_SIZE);
                GridPane.setMargin(anchorpane, new Insets(10));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        

    }
}
