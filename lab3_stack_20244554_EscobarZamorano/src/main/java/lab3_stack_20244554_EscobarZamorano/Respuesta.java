package lab3_stack_20244554_EscobarZamorano;

public class Respuesta {
    //------* Atributos *------
    private int idRespuesta;
    private Usuario autorRespuesta;
    private String fechaRespuesta;
    private String textoRespuesta;
    
    //------* Constructor *------
    public Respuesta(int idRespuesta, Usuario autorRespuesta, String fechaRespuesta, String textoRespuesta) {
        this.idRespuesta = idRespuesta;
        this.autorRespuesta = autorRespuesta;
        this.fechaRespuesta = fechaRespuesta;
        this.textoRespuesta = textoRespuesta;
    }
    
    //------* Setters *------
    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public void setAutorRespuesta(Usuario autorRespuesta) {
        this.autorRespuesta = autorRespuesta;
    }
    
    public void setFechaRespuesta(String fechaRespuesta) {
        this.fechaRespuesta = fechaRespuesta;
    }
    
    public void setTextoRespuesta(String textoRespuesta) {
        this.textoRespuesta = textoRespuesta;
    }
    
    //------* Getters *------
    public int getIdRespuesta() {
        return idRespuesta;
    }

    public Usuario getAutorRespuesta() {
        return autorRespuesta;
    }
 
    public String getFechaRespuesta() {
        return fechaRespuesta;
    }    

    public String getTextoRespuesta() {
        return textoRespuesta;
    }
}
