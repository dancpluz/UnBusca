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
    private int id_loja, horario_funcionamento, nota_media; 
    private String local, pop_up, rede_social, opcoes_pagamento; /* Criar classe para local e talvez opcoes de pagamento */
    
    private ArrayList<Produto> lista_produtos;
    private ArrayList<Avaliacao> lista_avaliacoes;

    public Loja() {
    }

    public Loja(int id_loja, int horario_funcionamento, int nota_media, String local, String pop_up, String rede_social, String opcoes_pagamento) {
        this.id_loja = id_loja;
        this.horario_funcionamento = horario_funcionamento;
        this.nota_media = nota_media;
        this.local = local;
        this.pop_up = pop_up;
        this.rede_social = rede_social;
        this.opcoes_pagamento = opcoes_pagamento;
    }

    
    public int getId_loja() {
        return id_loja;
    }

    public void setId_loja(int id_loja) {
        this.id_loja = id_loja;
    }

    public int getHorario_funcionamento() {
        return horario_funcionamento;
    }

    public void setHorario_funcionamento(int horario_funcionamento) {
        this.horario_funcionamento = horario_funcionamento;
    }

    public int getNota_media() {
        return nota_media;
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
