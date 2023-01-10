package unbhub;

public class Produto {
    private int id_produto;
    private String nome_produto;
    private float preço;
    private boolean disponibilidade;
    
    public Produto(int id_produto, String nome_produto, float preço, boolean disponibilidade){
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.preço = preço;
        this.disponibilidade = disponibilidade;
    }
    
    public int getIdProduto(){
        return id_produto;
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