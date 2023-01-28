/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unbhub;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Daniel
 */
public class Avaliacao {
    private int nota, idUsuario;
    private String comentario, idLoja;
    private LocalDate data;

    public Avaliacao() {
    }

    public Avaliacao(int nota, String comentario, int idU, String idL, LocalDate d) {
        this.nota = nota;
        this.comentario = comentario;
        idUsuario = idU;
        idLoja = idL;
        data = d;
    }
    
    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
    public int getIdUsuario() {
        return idUsuario;
    }
    
    public String getIdLoja() {
        return idLoja;
    }
    
    public String getDataString() {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
}
