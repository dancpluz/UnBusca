package unbhub;

import java.util.ArrayList;

public class Dono extends Usuario{
    
    private ArrayList<Loja> lojas = new ArrayList();
    private String telefone, data_nascimento;
    
    
    public Dono(String nome, String senha, String username, int cpf, int id, String telefone, String data_nascimento) {
        super(nome, senha, username, cpf, id);
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
    }
   /* 
    public void adicionarLoja(int id, String horario, String local, String pop_up, String rede_social, String opcoes_pagamento) {
        lojas.add(new Loja(id, horario_funcionamento, nota_media, local, pop_up, rede_social, opcoes_pagamento));
    }
    
    public ArrayList<Loja> getLojas() {
        return lojas;
    }
    
    public void deletarLoja(int index) {
        lojas.remove(index);
    }
    
    public void editarLoja(int index, String horario, String local, String pop_up, String rede_social, String opcoes_pagamento) {
        lojas.get(index).setHorario_funcionamento(horario);
        lojas.get(index).setPop_up(pop_up);
        lojas.get(index).setRede_social(rede_social);
        lojas.get(index).setOpcoes_pagamento(opcoes_pagamento);
    }*/
}
