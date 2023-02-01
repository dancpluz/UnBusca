package controle;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import unbhub.Loja;
import unbhub.Principal;
import unbhub.Usuario;
import unbhub.util.Tela;


public class ControleLojaDono implements Initializable {
    
    private Loja loja;
    
    @FXML
    private Circle cirAvatar;
    @FXML
    private Label lblMencao, lblNomeLoja;
    @FXML
    private BarChart bcGrafico;
    
       
    
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

    
    
    public void adicionarLoja() throws IOException {
        Tela.abrirTela("/telas/TelaAdicionarLoja.fxml");
    }
    
    
    public void verAvaliacoes() throws IOException {
        ((ControleAvaliacoesLoja)Tela.abrirTela("/telas/TelaAvaliacoesLoja.fxml").getController()).setData(loja);
    }
    
    public void editarPerfil() throws IOException {
        Tela.abrirTela("/telas/TelaEditarPerfil.fxml");
    }
    
            
    public void voltar() throws IOException {
        Tela.abrirTela("/telas/TelaDono.fxml");
    }
    
    
    public void carregarMeusProdutos() {
    
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
        Usuario user = Principal.usuarioLogado;
        cirAvatar.setFill(new ImagePattern(new Image("/imagens/Avatar.png")));
        
        //Carrega foto de perfil
        File foto = new File(String.format("data/imagens/%d.png", user.getId()));     
        
        if (foto.isFile()) {  
            cirAvatar.setFill(new ImagePattern(new Image(foto.toURI().toString())));
        }
        
        
    }    
}
