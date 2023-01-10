package unbhub;

public class Horario {
    private int hora_inicial;
    private int hora_final;
    
    public Horario(int hora_inicial, int hora_final){
        this.hora_inicial = hora_inicial;
        this.hora_final = hora_final;
    }
    
    public int getHoraInicial(){
        return hora_inicial;
    }
    
    public int getHoraFinal(){
        return hora_final;
    }
}