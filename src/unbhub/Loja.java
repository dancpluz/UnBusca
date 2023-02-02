package unbhub;

import java.util.ArrayList;
import java.util.HashSet;

public class Loja {
    private double nota_media; 
    private String nome, horario_funcionamento, local, id_loja, pop_up, rede_social, opcoes_pagamento; /* Criar classe para local e talvez opcoes de pagamento */
    private Dono dono;
    
    private ArrayList<Produto> lista_produtos = new ArrayList<>();
    private ArrayList<Avaliacao> lista_avaliacoes = new ArrayList<>();

    public Loja() {
    }

    public Loja(Dono d, String nome, String id_loja, String horario_funcionamento, String local, String pop_up, String rede_social, String opcoes_pagamento) {
        dono = d;
        this.nome = nome;
        this.id_loja = id_loja;
        this.horario_funcionamento = horario_funcionamento;
        this.local = local;
        this.pop_up = pop_up;
        this.rede_social = rede_social;
        this.opcoes_pagamento = opcoes_pagamento;
    }

    
    public void setNome(String n) {
        nome = n;
    }
    
    public String getNome() {
        return nome;
    }
    
    public Dono getDono() {
        return dono;
    }
    
    public String getIdLoja() {
        return id_loja;
    }

    public void setIdLoja(String id_loja) {
        this.id_loja = id_loja;
    }

    public String getHorarioFuncionamento() {
        return horario_funcionamento;
    }

    public void setHorarioFuncionamento(String horario_funcionamento) {
        this.horario_funcionamento = horario_funcionamento;
    }

    public double getNotaMedia() {
        if (!lista_avaliacoes.isEmpty()) {
            int c = 0;
            for (Avaliacao a : lista_avaliacoes) {
                c += a.getNota();
            }
            return c/lista_avaliacoes.size();
        } else {return 0;}
    }
    
    public Integer[] getNotas() {
        Integer[] list = new Integer[]{0, 0, 0, 0, 0, 0};
        for(Avaliacao a : lista_avaliacoes) {
            int nota = a.getNota();
            if(nota < 1) {
                list[0]++;
            } else if(nota < 2) {
                list[1]++;
            } else if(nota < 3) {
                list[2]++;
            } else if(nota < 4) {
                list[3]++;
            } else {list[4]++;} 
        }
        return list;
    }
    
    public String getMencao() {
        double nota = getNotaMedia();
        
        if(nota == 0) {
            return "SR";
        } else if(nota < 1) {
            return "II";
        } else if(nota < 2) {
            return "MI";
        } else if(nota < 3) {
            return "MM";
        } else if(nota < 4) {
            return "MS";
        } else {return "SS";}
    }
    
    public void setNotaMedia(int nota_media) {
        this.nota_media = nota_media;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPopUp() {
        return pop_up;
    }

    public void setPopUp(String pop_up) {
        this.pop_up = pop_up;
    }

    public String getRedeSocial() {
        return rede_social;
    }

    public void setRedeSocial(String rede_social) {
        this.rede_social = rede_social;
    }

    public String getOpcoesPagamento() {
        return opcoes_pagamento;
    }

    public void setOpcoesPagamento(String opcoes_pagamento) {
        this.opcoes_pagamento = opcoes_pagamento;
    }

    public ArrayList<Produto> getListaProdutos() {
        return lista_produtos;
    }

    public void setListaProdutos(ArrayList<Produto> lista_produtos) {
        this.lista_produtos = lista_produtos;
    }

    public ArrayList<Avaliacao> getListaAvaliacoes() {
        return lista_avaliacoes;
    }

    public void setListaAvaliacoes(ArrayList<Avaliacao> lista_avaliacoes) {
        this.lista_avaliacoes = lista_avaliacoes;
    }
    
    public void addAvaliacao(Avaliacao a) {
        lista_avaliacoes.add(a);
    }
    
    public void addProduto(Produto p) {
        lista_produtos.add(p);
    }
}
