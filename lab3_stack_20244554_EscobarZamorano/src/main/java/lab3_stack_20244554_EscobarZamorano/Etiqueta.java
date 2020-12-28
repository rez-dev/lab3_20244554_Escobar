package lab3_stack_20244554_EscobarZamorano;

public class Etiqueta {
    //------* Atributos *------
    private String nombreEtiqueta;
    private String descripcionEtiqueta;
    
    //------* Constructor *------
    public Etiqueta(String nombreEtiqueta, String descripcionEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
        this.descripcionEtiqueta = descripcionEtiqueta;
    }
    
    //------* Setters *------
    public void setDescripcionEtiqueta(String descripcionEtiqueta) {
        this.descripcionEtiqueta = descripcionEtiqueta;
    }
    
    public void setNombreEtiqueta(String nombreEtiqueta) {
        this.nombreEtiqueta = nombreEtiqueta;
    }
    
    //------* Getters *------
    public String getNombreEtiqueta() {
        return nombreEtiqueta;
    }
    
    public String getDescripcionEtiqueta() {
        return descripcionEtiqueta;
    }
    
    //------* Metodos *------  
}
