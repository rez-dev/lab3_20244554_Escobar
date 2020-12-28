package lab3_stack_20244554_EscobarZamorano;

import java.util.ArrayList;

public class Pregunta {
    //------* Atributos *------
    private int idPregunta;
    private ArrayList<Respuesta> listaRespuestas = new ArrayList<Respuesta>();
    private ArrayList<Etiqueta> listaEtiquetas = new ArrayList<Etiqueta>();
    private String tituloPregunta;
    private String textoPregunta;
    private String fechaPregunta;
    private Usuario autorPregunta;
    private String estadoPregunta;
    private int recompensaPregunta;
    
    //------* Constructor *------
    public Pregunta(int idPregunta, String tituloPregunta, String textoPregunta, String fechaPregunta, Usuario autorPregunta, String estadoPregunta, int recompensaPregunta) {
        this.idPregunta = idPregunta;
        this.tituloPregunta = tituloPregunta;
        this.textoPregunta = textoPregunta;
        this.fechaPregunta = fechaPregunta;
        this.autorPregunta = autorPregunta;
        this.estadoPregunta = estadoPregunta;
        this.recompensaPregunta = recompensaPregunta;
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

    public void setFechaPregunta(String fechaPregunta) {
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

    public String getFechaPregunta() {
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
}
