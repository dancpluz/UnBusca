package unbhub;

import java.time.LocalDate;
import java.util.ArrayList;

public class Usuario {
    private String nome, senha, username, cpf;
    private int id;
    
    //Lista com todas as avaliações realizadas pelo usuario
    private ArrayList<Avaliacao> avaliacoes = new ArrayList();
    
    
    public Usuario(String nome, String senha, String username, String cpf, int id) {
        this.nome = nome;
        this.senha = senha;
        this.username = username;
        this.cpf = cpf;
        this.id = id;
    }
    
    public boolean checkSenha(String senha) {
        return this.senha.equals(senha);
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getCPF() {
        return cpf;
    }
    
    public int getId() {
        return id;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public void setUsername(String user) {
        this.username = user;
    }
    
    public void adicionarAvaliacao(int nota, String comentario, String idLoja) {
        avaliacoes.add(new Avaliacao(nota, comentario, id, idLoja, LocalDate.now()));
    }
    
    public ArrayList<Avaliacao> getAvaliacoes() {
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
