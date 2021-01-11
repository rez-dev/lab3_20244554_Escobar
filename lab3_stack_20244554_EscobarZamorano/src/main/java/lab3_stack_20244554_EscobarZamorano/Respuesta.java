package lab3_stack_20244554_EscobarZamorano;

import java.util.Date;

public class Respuesta {
    //------* Atributos *------
    private int idRespuesta;
    private Usuario autorRespuesta;
    private Date fechaRespuesta;
    private String textoRespuesta;
    private String estadoRespuesta;
    
    //------* Constructor *------
    
    public Respuesta(int idRespuesta, Usuario autorRespuesta, Date fechaRespuesta, String textoRespuesta, String estadoRespuesta) {
        this.idRespuesta = idRespuesta;
        this.autorRespuesta = autorRespuesta;
        this.fechaRespuesta = fechaRespuesta;
        this.textoRespuesta = textoRespuesta;
        this.estadoRespuesta = estadoRespuesta;
    }
    
    //------* Setters *------
    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public void setAutorRespuesta(Usuario autorRespuesta) {
        this.autorRespuesta = autorRespuesta;
    }
    
    public void setFechaRespuesta(Date fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }
    
    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }

    public void setEstadoRespuesta(String estadoRespuesta) {
        this.estadoRespuesta = estadoRespuesta;
    }
    
    //------* Getters *------
    public int getIdRespuesta() {
        return idRespuesta;
    }

    public Usuario getAutorRespuesta() {
        return autorRespuesta;
    }
 
    public Date getFechaRespuesta() {
        return fechaRespuesta;
    }    

    public String getTextoRespuesta() {
        return textoRespuesta;
    }

    public String getEstadoRespuesta() {
        return estadoRespuesta;
    }
}
