package lab3_stack_20244554_EscobarZamorano;

import java.util.ArrayList;
import java.util.Date;

public class Pregunta {
    //------* Atributos *------
    private int idPregunta;
    private ArrayList<Respuesta> listaRespuestas;
    private ArrayList<Etiqueta> listaEtiquetas;
    private String tituloPregunta;
    private String textoPregunta;
    private Date fechaPregunta;
    private Usuario autorPregunta;
    private String estadoPregunta;
    private int recompensaPregunta;
    private ArrayList<Usuario> listaUsuariosRecompensa;
    
    //------* Constructor *------
    public Pregunta(int idPregunta, ArrayList<Etiqueta> listaEtiquetas, String tituloPregunta, String textoPregunta, Date fechaPregunta, Usuario autorPregunta, String estadoPregunta, int recompensaPregunta) {
        this.idPregunta = idPregunta;
        this.listaRespuestas = new ArrayList<Respuesta>();
        this.listaEtiquetas = listaEtiquetas;
        this.tituloPregunta = tituloPregunta;
        this.textoPregunta = textoPregunta;
        this.fechaPregunta = fechaPregunta;
        this.autorPregunta = autorPregunta;
        this.estadoPregunta = estadoPregunta;
        this.recompensaPregunta = recompensaPregunta;
        this.listaUsuariosRecompensa = new ArrayList<Usuario>();
    }
    
    
    //------* Setters *------
    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public void setListaRespuestas(ArrayList<Respuesta> listaRespuestas) {
        this.listaRespuestas = listaRespuestas;
    }

    public void setListaEtiquetas(ArrayList<Etiqueta> listaEtiquetas) {
        this.listaEtiquetas = listaEtiquetas;
    }

    public void setTituloPregunta(String tituloPregunta) {
        this.tituloPregunta = tituloPregunta;
    }

    public void setTextoPregunta(String textoPregunta) {
        this.textoPregunta = textoPregunta;
    }

    public void setFechaPregunta(Date fechaPregunta) {
        this.fechaPregunta = fechaPregunta;
    }

    public void setAutorPregunta(Usuario autorPregunta) {
        this.autorPregunta = autorPregunta;
    }

    public void setEstadoPregunta(String estadoPregunta) {
        this.estadoPregunta = estadoPregunta;
    }

    public void setRecompensaPregunta(int recompensaPregunta) {
        this.recompensaPregunta = recompensaPregunta;
    }

    public void setListaUsuariosRecompensa(ArrayList<Usuario> listaUsuariosRecompensa) {
        this.listaUsuariosRecompensa = listaUsuariosRecompensa;
    }
    
    //------* Getters *------
    public int getIdPregunta() {
        return idPregunta;
    }

    public ArrayList<Respuesta> getListaRespuestas() {
        return listaRespuestas;
    }

    public ArrayList<Etiqueta> getListaEtiquetas() {
        return listaEtiquetas;
    }

    public String getTituloPregunta() {
        return tituloPregunta;
    }

    public String getTextoPregunta() {
        return textoPregunta;
    }

    public Date getFechaPregunta() {
        return fechaPregunta;
    }

    public Usuario getAutorPregunta() {
        return autorPregunta;
    }

    public String getEstadoPregunta() {
        return estadoPregunta;
    }

    public int getRecompensaPregunta() {
        return recompensaPregunta;
    }

    public ArrayList<Usuario> getListaUsuariosRecompensa() {
        return listaUsuariosRecompensa;
    }
}