package unbhub;

import unbhub.util.ObjectSer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.util.ArrayList;
import java.util.HashMap;
import static javafx.application.Application.launch;
import unbhub.util.Tela;



public class Principal extends Application {
    public static double x=0,y=0;
    
    //Mapa statico e public ocontendo todos os usarios.
    public static HashMap<Integer, Usuario> usuarios = new HashMap<>();
    
    //Variavel public static contento um contador usado para gerar ids unicas para usuarios.
    public static int cIdUsuarios = 1;
    
    //Variavel static que indica qual usuario esta logado no momneto
    public static Usuario usuarioLogado;
    
    //arry static contendo todas as lojas
    public static ArrayList<Loja> todasLojas = new ArrayList<>();
      
    
    public static Stage primaryStage;
     
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaLogin.fxml"));
        Scene scene = new Scene(root,640,360);
        Principal.primaryStage = primaryStage;
        
        // Aplicar estilo css na cena
        String css = this.getClass().getResource("/telas/estilo.css").toExternalForm();
        scene.getStylesheets().add(css);
        
        // Janela sem barra em cima
        primaryStage.initStyle(StageStyle.UNDECORATED);
        
        // Ao clicar na tela arrastar a janela
        Tela.telaArrastavel(root, primaryStage);
        
        // Não redimensionável
        primaryStage.setResizable(false);
        // Título da janela
        primaryStage.setTitle("UnBusca");
        // Ícone da janela
        primaryStage.getIcons().add(new Image("imagens/LogoScene.png"));
        // Determinar cena
        primaryStage.setScene(scene); 
        // Mostrar cena
        primaryStage.show(); 
    }
    
    public static void close() {
        Principal.primaryStage.close();
        ObjectSer.salvar();
    }
    
    
    public static void main(String[] args) {
        ObjectSer.carregar();     
        launch(args);
    }  
}
