/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unbhub;

/**
 *
 * @author Daniel
 */
public class Avaliacao {
    private int nota, idUsuario, idLoja;
    private String comentario;

    public Avaliacao() {
    }

    public Avaliacao(int nota, String comentario, int idU, int idL) {
        this.nota = nota;
        this.comentario = comentario;
        idUsuario = idU;
        idLoja = idL;
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
    
    public int getIdLoja() {
        return idLoja;
    }
}
