package unbhub;

import java.io.*;
import java.util.ArrayList;
import unbhub.Usuario;



//Classe para salvar carregar usuarios na memoria
public class ObjectSer {    
    //Metodo para salvar
    public static void salvar() {
        ArrayList<Usuario> lista = new ArrayList<>(Principal.usuarios.values());
        for (Usuario u : lista) {        
            try {
                FileOutputStream fileOut = new FileOutputStream(String.format("data/usuarios/%s.ser", u.getId()));
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(u);
                out.close();
                fileOut.close();
            } catch (IOException i) {
                i.printStackTrace();
            }
        }
    }
    
    //Metodo para carregar usuarios da memoria
    public static void carregar() {
        File dir = new File("data/usuarios");
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                try {  
                    FileInputStream file = new FileInputStream(child);
                    ObjectInputStream in = new ObjectInputStream(file);
                    Usuario u = (Usuario)in.readObject();             
                    in.close();
                    file.close();
                    Principal.usuarios.put(u.getId(), u);
                    Principal.cIdUsuarios++;
                }      
                catch(IOException ex){}
                catch(ClassNotFoundException ex){}
            }
        }
    }
}
