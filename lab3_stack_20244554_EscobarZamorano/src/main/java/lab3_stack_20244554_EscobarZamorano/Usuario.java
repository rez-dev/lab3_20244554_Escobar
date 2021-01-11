package lab3_stack_20244554_EscobarZamorano;

public class Usuario {
    //------* Atributos *------
    private String username;
    private String password;
    private Integer reputacion;
    private Integer reputacionRetenida;
    
    //------* Constructor *------
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.reputacion = 1000;
        this.reputacionRetenida = 0;
    }
    
    public Usuario(String username, String password, Integer reputacion, Integer reputacionRetenida) {
        this.username = username;
        this.password = password;
        this.reputacion = reputacion;
        this.reputacionRetenida = reputacionRetenida;
    }
      
    //------* Setters *------
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setReputacion(Integer reputacion) {
        this.reputacion = reputacion;
    }

    public void setReputacionRetenida(Integer reputacionRetenida) {
        this.reputacionRetenida = reputacionRetenida;
    }
    
    //------* Getters *------
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getReputacion() {
        return reputacion;
    }

    public Integer getReputacionRetenida() {
        return reputacionRetenida;
    }
    
    //------* Metodos *------
    //------ USUARIOS IGUALES USERNAME Y PASSWORD ------
    /**
    *Verifica que un usuario tenga el mismo username y password que otro
    *@param usuario /Usuario que se desea verificar su username y password
    *@return /En caso de que ambos datos sean iguales se entrega true, en caso contrario enrtrega false
    */
    public boolean usuariosIgualesLogin(Object usuario){
        if(this == usuario){
            return true;
        }
        if(!(usuario instanceof Usuario)){
            return false;
        }
        
        Usuario nuevoUsuario = (Usuario)usuario;
        
        return this.getUsername().equals(nuevoUsuario.getUsername()) && this.getPassword().equals(nuevoUsuario.getPassword()); 
    }
    
    //------ USUARIOS IGUALES USERNAME ------
    /**
    *Verifica que un usuario tenga el mismo username que otro
    *@param usuario /Usuario que se desea verificar su username
    *@return /En caso de que los username sean iguales se entrega true, en caso contrario enrtrega false
    */
    public boolean usuariosIgualesRegister(Object usuario){
        if(this == usuario){
            return true;
        }
        if(!(usuario instanceof Usuario)){
            return false;
        }
        
        Usuario nuevoUsuario = (Usuario)usuario;
        
        return this.getUsername().equals(nuevoUsuario.getUsername()); 
    }    
}
