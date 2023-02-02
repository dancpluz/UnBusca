package controle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import unbhub.Loja;
import unbhub.Principal;
import unbhub.Produto;
import unbhub.util.Tela;


public class ControleLojaDono implements Initializable {
    
    private Loja loja;
    
    @FXML
    private Label lblMencao, lblNomeLoja;
    @FXML
    private BarChart bcGrafico;
    @FXML
    private VBox vboxProdutos;
    
       
    
    // Fecha a janela
    public void close() {
        Principal.close();
    }
    
    
    
    public void setLoja(Loja l) {
        loja = l;
        lblNomeLoja.setText(l.getNome());
        lblMencao.setText(l.getMencao());
        
        //Carrega grafico de barras
        Integer[] notas = loja.getNotas();
        
        XYChart.Series set = new XYChart.Series<>();
        set.getData().add(new XYChart.Data("II", notas[0]));
        set.getData().add(new XYChart.Data("MI", notas[1]));
        set.getData().add(new XYChart.Data("MM", notas[2]));
        set.getData().add(new XYChart.Data("MS", notas[3]));
        set.getData().add(new XYChart.Data("SS", notas[4]));
        //bcGrafico.setCategoryGap());
        bcGrafico.getData().addAll(set);
    }

 
    
    public void perfil() throws IOException {
        Tela.abrirTela("/telas/TelaPerfil.fxml");
    }

    
    
    public void adicionarProduto() throws IOException {
        ((ControleAdicionarProduto)Tela.abrirTela("/telas/TelaAdicionarProduto.fxml").getController()).setData(loja);
    }
    
    
    public void verAvaliacoes() throws IOException {
        ((ControleAvaliacoesLoja)Tela.abrirTela("/telas/TelaAvaliacoesLoja.fxml").getController()).setData(loja);
    }
    
    
            
    public void voltar() throws IOException {
        Tela.abrirTela("/telas/TelaDono.fxml");
    }
    
    
    public void carregarMeusProdutos() {
        for(Produto p : loja.getListaProdutos()) {
            FXMLLoader fxmll = Tela.telaFxmlLoader("/itens/ItemProdutoDono.fxml");
            try {
                HBox hbox = fxmll.load();
                ControleItemProdutoDono c = fxmll.getController();
                c.setData(loja, this, p);
                vboxProdutos.getChildren().add(hbox);
            } catch (IOException e) {}     
        }
    }
    
    
    public void editarLoja() throws IOException {
        
        ControleEditarLoja controle;
        FXMLLoader fmxlloader = Tela.abrirTela("/telas/TelaEditarLoja");
        controle = fmxlloader.getController();
        controle.setLoja(loja);
        //((ControleEditarLoja)Tela.abrirTela("/telas/TelaEditarLoja.fxml").getController()).setLoja(loja);
    }
    
    
    
    
    public void deletarLoja() throws IOException {
        Principal.todasLojas.remove(loja);
        loja.getDono().deletarLoja(loja);
        
        //Deleta foto da loja
        (new File(String.format("data/imagens/%s.png", loja.getIdLoja()))).delete(); 
        Tela.abrirTela("/telas/TelaDono.fxml");
    }
    
    
   

        
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
 
        
    }    
}
