package unbhub;

import java.time.LocalDate;
import java.util.ArrayList;

public class Dono extends Usuario{
    
    private ArrayList<Loja> lojas = new ArrayList();
    private String telefone;
    private LocalDate data_nascimento;
    private int cIdL = 1;
    
    
    public Dono(String nome, String senha, String username, String cpf, int id, String telefone, LocalDate data_nascimento) {
        super(nome, senha, username, cpf, id);
        this.telefone = telefone;
        this.data_nascimento = data_nascimento;
    }

    public int getCIdL() {
        return cIdL;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String t) {
        telefone = t;
    }
    
    public LocalDate getData() {
        return data_nascimento;
    }
    
    public void setData(LocalDate d) {
        data_nascimento = d;
    }
    
    public Loja adicionarLoja(String nome, String horario, String local, String pop_up, String rede_social, String opcoes_pagamento) {
        String idL = String.format("%d_%d", super.getId(), cIdL);
        Loja l = new Loja(this, nome, idL, horario, local, pop_up, rede_social, opcoes_pagamento);
        lojas.add(l);
        cIdL++;
        return l;
    }
    
    public ArrayList<Loja> getLojas() {
        return lojas;
    }
    
    public void deletarLoja(int index) {
        lojas.remove(index);
    }
    
    public void deletarLoja(Loja l) {
        lojas.remove(l);
    }
    
    public void editarLoja(String idl, String nome, String horario, String local, String pop_up, String rede_social, String opcoes_pagamento) {
        for (Loja l : lojas) {
            if (l.getIdLoja().equals(idl)) {    
                l.setHorarioFuncionamento(horario);
                l.setPopUp(pop_up);
                l.setRedeSocial(rede_social);
                l.setOpcoesPagamento(opcoes_pagamento);
                return;
            }
        }
    }
}
