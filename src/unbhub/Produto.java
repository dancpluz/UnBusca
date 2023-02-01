package unbhub;

public class Produto {
    private String nomeImagem;
    private String nome_produto, categoria;
    private float preço;
    private boolean disponibilidade;
    
    public Produto(String id_produto, String nome_produto, float preço, String c){
        this.nomeImagem = id_produto;
        this.nome_produto = nome_produto;
        this.preço = preço;
        this.disponibilidade = disponibilidade;
        categoria = c;
    }
    
    public String getIdProduto(){
        return nomeImagem;
    }
    
    public String getNomeProduto(){
        return nome_produto;
    }
    
    public float getPreço(){
        return preço;
    }
    
    public boolean isDisponivel(){
        return disponibilidade;
    }
}