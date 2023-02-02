package unbhub;

public class Produto {
    private String nomeImagem;
    private String nome_produto;
    private double preco;
    
    public Produto(String id_produto, String nome_produto, double preço){
        this.nomeImagem = id_produto;
        this.nome_produto = nome_produto;
        this.preco = preço;
    }
    
    public void setNome(String s) {
        nome_produto = s;
    }
    
    public String getIdProduto(){
        return nomeImagem;
    }
    
    public String getNomeProduto(){
        return nome_produto;
    }
    
    public double getPreco(){
        return preco;
    }
   
        
    public void setPreco(double d) {
        preco = d;
    }
}
