   /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unbhub;

import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class Loja {
    private int nota_media; 
    private String horario_funcionamento, local, id_loja, pop_up, rede_social, opcoes_pagamento; /* Criar classe para local e talvez opcoes de pagamento */
    
    private ArrayList<Produto> lista_produtos;
    private ArrayList<Avaliacao> lista_avaliacoes;

    public Loja() {
    }

    public Loja(String id_loja, String horario_funcionamento, String local, String pop_up, String rede_social, String opcoes_pagamento) {
        this.id_loja = id_loja;
        this.horario_funcionamento = horario_funcionamento;
        this.local = local;
        this.pop_up = pop_up;
        this.rede_social = rede_social;
        this.opcoes_pagamento = opcoes_pagamento;
    }

    
    public String getId_loja() {
        return id_loja;
    }

    public void setId_loja(String id_loja) {
        this.id_loja = id_loja;
    }

    public String getHorario_funcionamento() {
        return horario_funcionamento;
    }

    public void setHorario_funcionamento(String horario_funcionamento) {
        this.horario_funcionamento = horario_funcionamento;
    }

    public double getNota_media() {
        if (!lista_avaliacoes.isEmpty()) {
            int c = 0;
            for (Avaliacao a : lista_avaliacoes) {
                c += a.getNota();
            }
            return c/lista_avaliacoes.size();
        } else {return 0;}
    }

    public void setNota_media(int nota_media) {
        this.nota_media = nota_media;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getPop_up() {
        return pop_up;
    }

    public void setPop_up(String pop_up) {
        this.pop_up = pop_up;
    }

    public String getRede_social() {
        return rede_social;
    }

    public void setRede_social(String rede_social) {
        this.rede_social = rede_social;
    }

    public String getOpcoes_pagamento() {
        return opcoes_pagamento;
    }

    public void setOpcoes_pagamento(String opcoes_pagamento) {
        this.opcoes_pagamento = opcoes_pagamento;
    }

    public ArrayList<Produto> getLista_produtos() {
        return lista_produtos;
    }

    public void setLista_produtos(ArrayList<Produto> lista_produtos) {
        this.lista_produtos = lista_produtos;
    }

    public ArrayList<Avaliacao> getLista_avaliacoes() {
        return lista_avaliacoes;
    }

    public void setLista_avaliacoes(ArrayList<Avaliacao> lista_avaliacoes) {
        this.lista_avaliacoes = lista_avaliacoes;
    }   
}
