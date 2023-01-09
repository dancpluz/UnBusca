package unbhub;

import java.util.ArrayList;

public class Cliente extends Usuario{
    
    private ArrayList<avaliacao> avaliacoes = new ArrayList();
    
    public Cliente(String nome, String senha, String username, int cpf, int id, int telefone) {
        super(nome, senha, username, cpf, id);
    }
    
    public void adicionarAvaliacao(int nota, String comentario) {
        avaliacoes.add(new avaliacao(nota, comentario));
    }
    
    public ArrayList<avaliacao> getAvaliacoes() {
        return avaliacoes;
    }
    
    public void deleteAvaliacao(int index) {
        avaliacoes.remove(index);
    }
    
    public void editarAvaliacao(int index, int nota, String comentario) {
        avaliacoes.get(index).setNota(nota);
        avaliacoes.get(index).setComentario(comentario);
    }
}
