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
    private Loja loja;
    private Usuario user;
    private int nota;
    private String comentario;
    private LocalDate data;

    public Avaliacao() {
    }

    public Avaliacao(int nota, String comentario, Usuario u, Loja l, LocalDate d) {
        this.nota = nota;
        this.comentario = comentario;
        loja = l;
        user = u;
        data = d;
    }
    
    public int getNota() {
        return nota;
    }
        
    public String getMencao() {
        return (new String[]{"II", "MI", "MM", "MS", "SS"})[nota];
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
    
    public Usuario getUsuario() {
        return user;
    }
    
    public Loja getLoja() {
        return loja;
    }
    
    public void setLoja(Loja l) {
        loja = l;
    }
    
    public String getDataString() {
        return data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
    
    public LocalDate getData() {
        return data;
    }
}
