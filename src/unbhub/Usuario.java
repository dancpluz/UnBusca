package unbhub;

public class Usuario {
    private String nome, senha, username;
    private int cpf, id;
    
    public Usuario(String nome, String senha, String username, int cpf, int id) {
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
    
    public int getCPF() {
        return cpf;
    }
    
    public int getID() {
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
}
