package controle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import unbhub.Loja;
import unbhub.ObjectSer;
import unbhub.Principal;


public class MenuClienteController implements Initializable{
    //Atributos da tela do cliente
    private ArrayList<Loja> lojaObjects = new ArrayList<Loja>();
    
    private ArrayList<IdLojaController> controlhes = new ArrayList<IdLojaController>();
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    double x=0,y=0;
    
    @FXML
    private Button bttAvaliacao;
    @FXML
    private Button bttLogout;
    @FXML
    private GridPane gridLojas;
    @FXML
    private HBox hboxLogout;
    @FXML
    private ImageView imgLogout;
    @FXML
    private ImageView imgUnbLogo;
    @FXML
    private Label lblAreaCliente;
    @FXML
    private Label lblCatalogo;
    @FXML
    private Label lblSejaBem;
    @FXML
    private Label lblUnbHub;
    @FXML
    private Label lblUser;
    @FXML
    private ScrollPane scrollLojas;
    @FXML
    private VBox vboxUser;  
    @FXML
    private Button bttBuscarLoja;     
    @FXML
    private TextField fieldBuscarLoja;
    @FXML
    private Button btnSair;
    

    // Ao clicar na tela arrastar a janela
    public void telaArrastavel(Parent root, Stage stage) {        
        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();
        });
        root.setOnMouseDragged(mouseEvent -> {
            stage.setX(mouseEvent.getScreenX() - x);
            stage.setY(mouseEvent.getScreenY() - y);
        });
    }
    
    
    //Botao de X fecha o programa
    public void close() {
        Stage stage = (Stage) btnSair.getScene().getWindow();
        stage.close();
        ObjectSer.salvar();
    }
    
    
    private void loadGridPane(){
        //Define o número de colunas e linhas iniciais para organizá-las (fxml) no gridpane.
        int linha = 1;
        int coluna = 0;
        //Inicializa as fxml referente aos ícones das lojas para navegação e trata as exceções.
        try{
            for (int i=0;i<this.lojaObjects.size(); i++){
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource("/telas/idLoja.fxml"));
                
                AnchorPane anchorpane = fxmlloader.load();
                
                IdLojaController idlojacontrolhe = fxmlloader.getController();
                idlojacontrolhe.setLabel(lojaObjects.get(i).getRede_social());
                
                controlhes.add(idlojacontrolhe);
                
                if (coluna == 2){
                    coluna = 0;
                    linha++;
                }
                
                gridLojas.add(anchorpane, coluna++ , linha);
                gridLojas.setMinWidth(Region.USE_COMPUTED_SIZE);
                gridLojas.setPrefWidth(Region.USE_COMPUTED_SIZE);
                gridLojas.setMaxWidth(Region.USE_COMPUTED_SIZE);
                gridLojas.setMinHeight(Region.USE_COMPUTED_SIZE);
                gridLojas.setPrefHeight(Region.USE_COMPUTED_SIZE);
                gridLojas.setMaxHeight(Region.USE_COMPUTED_SIZE);
                GridPane.setMargin(anchorpane, new Insets(10));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    
    
    /*
    public void lerArquivo() throws FileNotFoundException{
        //Esse método lê o arquivo "Informacoes.txt" que contém os das lojas e
        //armazena os objetos loja com esses atributos no ArrayList.
        //OBS: Criar esse arquivo pelo backend do cadastro de lojas no path "src/unbhub/Informacoes.txt".
        String[] linha;
        Loja loja;
        File file = new File("src/unbhub/Informacoes.txt");
        Scanner scan = new Scanner(file);
        while (scan.hasNextLine()){
            linha = scan.nextLine().split(" ");
            if (linha[0].equals("LojaInfo")){
                loja = new Loja(Integer.parseInt(linha[1]),Integer.parseInt(linha[2]),
                Integer.parseInt(linha[3]),linha[4],linha[5],linha[6],linha[7]);
                if (!(lojaObjects.contains(loja))){
                    this.lojaObjects.add(loja);
                }
            }
        }
    }
    */
    
 
    
    //Logout e tela de login
    public void logout(ActionEvent event) throws IOException {
        Principal.usuarioLogado = null;
        
        root = FXMLLoader.load(getClass().getResource("/telas/TelaLogin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        // Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        telaArrastavel(root,stage);
        
        stage.setScene(scene);
        stage.show();
    }    
    
    
    //Botao de avaliações
    public void meuPerfil(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/telas/TelaPerfilUsuario.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        
        // Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        telaArrastavel(root,stage);
        
        stage.setScene(scene);
        stage.show();
    }
      
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb){
        //Inicializa a tela e implementa as funcionalidades de cada botão
        
        
        //Carrega array com todas as lojas
        lojaObjects = Principal.todasLojas;       
        
        loadGridPane();
        
        bttBuscarLoja.setOnAction(e -> {
            //Aplica a funcionalidade de busca de lojas pelo seu nome
            
            ArrayList<Loja> newOrderLojas = new ArrayList<Loja>();
            for (int i=0;i<lojaObjects.size();i++){
                if (lojaObjects.get(i).getRede_social().equalsIgnoreCase(fieldBuscarLoja.getText())){
                    newOrderLojas.add(0,lojaObjects.get(i));
                }else{
                    if (!(newOrderLojas.isEmpty())){
                        newOrderLojas.add(newOrderLojas.size(), lojaObjects.get(i));
                    }else{
                        newOrderLojas.add(0,lojaObjects.get(i));
                    }
                }
            }
            if (newOrderLojas.equals(lojaObjects)){
                JOptionPane.showMessageDialog(null, "O nome que você digitou não existe. Tente novamente!",
                        "Nome inválido", JOptionPane.WARNING_MESSAGE);
            }else{
                lojaObjects = newOrderLojas;
                for (int i=0;i<controlhes.size(); i++){
                    controlhes.get(i).setLabel(lojaObjects.get(i).getRede_social());
                }
            }
        });
    }
}