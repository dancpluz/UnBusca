package controle;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import unbhub.Avaliacao;
import unbhub.Loja;
import unbhub.Principal;
import unbhub.util.ObjectSer;
import unbhub.util.SortAvaliacao;
import unbhub.util.Tela;


public class ControleAvaliacoesLoja implements Initializable{
    private int filtro = 1, selecao = 0;
    private Loja loja;
    
    @FXML
    private Button btnFiltro, btnTodos, btnII, btnMI, btnMM, btnMS, btnSS;
    @FXML
    private Label lblTitulo;
    @FXML
    private VBox vboxAvaliacoes;
    
    
    // Fecha a janela
    public void close() {
        Principal.primaryStage.close();
        ObjectSer.salvar();
    }
    
    
    public void voltar() throws IOException {
        Tela.abrirTela("/telas/TelaLojaDono.fxml");
    }
    
    
    
    //muda ordenação das avaliações
    public void mudarFiltro() {
        if(filtro == 1) {
            btnFiltro.setText("Mais antigas");
            filtro = -1;
        } else {
            btnFiltro.setText("Mais recentes");
            filtro = 1;
        }
    }
    
     
    
    //verde: #7AE582;
    //botoes de filtro:
    public void bTodos() {
        btnTodos.setTextFill(Color.web("#7AE582"));
        btnII.setTextFill(Color.web("#000000"));
        btnMI.setTextFill(Color.web("#000000"));
        btnMM.setTextFill(Color.web("#000000"));
        btnMS.setTextFill(Color.web("#000000"));
        btnSS.setTextFill(Color.web("#000000"));
        selecao = -1;
        carregarAvaliacoes();
        
    }
    public void bII() {
        btnTodos.setTextFill(Color.web("#000000"));
        btnII.setTextFill(Color.web("#7AE582"));
        btnMI.setTextFill(Color.web("#000000"));
        btnMM.setTextFill(Color.web("#000000"));
        btnMS.setTextFill(Color.web("#000000"));
        btnSS.setTextFill(Color.web("#000000"));
        selecao = 0;
        carregarAvaliacoes();
    }
    public void bMI() {
        btnTodos.setTextFill(Color.web("#000000"));
        btnII.setTextFill(Color.web("#000000"));
        btnMI.setTextFill(Color.web("#7AE582"));
        btnMM.setTextFill(Color.web("#000000"));
        btnMS.setTextFill(Color.web("#000000"));
        btnSS.setTextFill(Color.web("#000000"));
        selecao = 1;
        carregarAvaliacoes();
    }
    public void bMM() {
        btnTodos.setTextFill(Color.web("#000000"));
        btnII.setTextFill(Color.web("#000000"));
        btnMI.setTextFill(Color.web("#000000"));
        btnMM.setTextFill(Color.web("#7AE582"));
        btnMS.setTextFill(Color.web("#000000"));
        btnSS.setTextFill(Color.web("#000000"));
        selecao = 2;
        carregarAvaliacoes();
    }
    public void bMS() {
        btnTodos.setTextFill(Color.web("#000000"));
        btnII.setTextFill(Color.web("#000000"));
        btnMI.setTextFill(Color.web("#000000"));
        btnMM.setTextFill(Color.web("#000000"));
        btnMS.setTextFill(Color.web("#7AE582"));
        btnSS.setTextFill(Color.web("#000000"));
        selecao = 3;
        carregarAvaliacoes();
    }
    public void bSS() {
        btnTodos.setTextFill(Color.web("#000000"));
        btnII.setTextFill(Color.web("#000000"));
        btnMI.setTextFill(Color.web("#000000"));
        btnMM.setTextFill(Color.web("#000000"));
        btnMS.setTextFill(Color.web("#000000"));
        btnSS.setTextFill(Color.web("#7AE582"));
        selecao = 4;
        carregarAvaliacoes();
    }
    
   
    
    public void setData(Loja l) {
        loja = l;
        lblTitulo.setText(String.format("Avaliações: %s", l.getNome()));
    }
    
    
    //Carrega scrollpane com as avaliacoes
    public void carregarAvaliacoes() {
        for(Avaliacao a : avaliacoesPorNota(avaliacoesOrdenadas(loja.getListaAvaliacoes(), filtro), selecao)) {
            FXMLLoader fxmll = Tela.telaFxmlLoader("/itens/ItemAvaliacaoLojaDono.fxml");
            try {
                Button btn = fxmll.load();
                ControleItemAvaliacaoPerfil c = fxmll.getController();
                c.setData(a);
                vboxAvaliacoes.getChildren().add(btn);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    
    //Ordenacao crescente ou descrescente de data
    private ArrayList<Avaliacao> avaliacoesOrdenadas(ArrayList<Avaliacao> av, int o) {
        if (o == 1) {
            Collections.sort(av, new SortAvaliacao());     
        } else {
            Collections.sort(av, (new SortAvaliacao()).reversed());
        }
        return av;
    }
    
    
    
    //Filtro de avaliacoes por mencao
    private ArrayList<Avaliacao> avaliacoesPorNota(ArrayList<Avaliacao> lista_avaliacoes, int nota) {
        ArrayList<Avaliacao> lista_escolhida = new ArrayList();
        if(nota == -1) {
            return lista_avaliacoes;
        }
        
        for (Avaliacao avaliacao : lista_avaliacoes) {
          if (avaliacao.getNota() == nota) {
              lista_escolhida.add(avaliacao);
          }
        }
        
        return lista_escolhida;
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    
}
