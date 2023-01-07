package unbhub;

import java.util.ArrayList;

public class Servico {
    private int id_servico;
    private String nome_servico;
    private float preço;
    private ArrayList<Horario> horarios;
    
    public Servico(int id_servico, String nome_servico, float preço){
        this.id_servico = id_servico;
        this.nome_servico = nome_servico;
        this.preço = preço;
        horarios = new ArrayList<Horario>();
    }
    
    public int getIdServiço(){
        return id_servico;
    }
    
    public String getNomeServiço(){
        return nome_servico;
    }
    
    public float getPreço(){
        return preço;
    }
    
    public void addHorario(Horario horario){
        horarios.add(horario);
    }
    
    public Horario horarioSegunda(){
        if (horarios.size()>0){
            return horarios.get(0);
        }else{
            return null;
        }
    } 
    
    public Horario horarioTerça(){
        if (horarios.size()>1){
            return horarios.get(1);
        }else{
            return null;
        }
    } 
    
    public Horario horarioQuarta(){
        if (horarios.size()>2){
            return horarios.get(2);
        }else{
            return null;
        }
    }
    
    public Horario horarioQuinta(){
        if (horarios.size()>3){
            return horarios.get(3);
        }else{
            return null;
        }
    }
    
    public Horario horarioSexta(){
        if (horarios.size()>4){
            return horarios.get(4);
        }else{
            return null;
        }
    }
    
    public Horario horarioSabado(){
        if (horarios.size()>5){
            return horarios.get(5);
        }else{
            return null;
        }
    }
}