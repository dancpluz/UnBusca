package unbhub;

import java.util.ArrayList;

public class Dono extends Usuario{
    
    private ArrayList<Loja> lojas = new ArrayList();
    private String telefone, data_nascimento;
    private int cIdL = 1;
    
    
    public Dono(String nome, String senha, String username, String cpf, int id, String telefone, String data_nascimento) {
        super(nome, senha, username, cpf, id);
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
    }

    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String t) {
        telefone = t;
    }
    
    public String getData() {
        return data_nascimento;
    }
    
    public void setData(String d) {
        data_nascimento = d;
    }
    
    public void adicionarLoja(String horario, String local, String pop_up, String rede_social, String opcoes_pagamento) {
        String idL = String.format("%d_%d", super.getId(), cIdL);
        lojas.add(new Loja(idL, horario, local, pop_up, rede_social, opcoes_pagamento));
        cIdL++;
    }
    
    public ArrayList<Loja> getLojas() {
        return lojas;
    }
    
    public void deletarLoja(int index) {
        lojas.remove(index);
    }
    
    public void editarLoja(String idl, String horario, String local, String pop_up, String rede_social, String opcoes_pagamento) {
        for (Loja l : lojas) {
            if (l.getId_loja().equals(idl)) {    
                l.setHorario_funcionamento(horario);
                l.setPop_up(pop_up);
                l.setRede_social(rede_social);
                l.setOpcoes_pagamento(opcoes_pagamento);
                return;
            }
        }
    }
}
