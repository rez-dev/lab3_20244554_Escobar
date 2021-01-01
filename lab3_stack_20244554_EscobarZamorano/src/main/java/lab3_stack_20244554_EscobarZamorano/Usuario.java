package lab3_stack_20244554_EscobarZamorano;

public class Usuario {
    //------* Atributos *------
    private String username;
    private String password;
    private Integer reputacion;
    
    //------* Constructor *------
    public Usuario(String username, String password, Integer reputacion) {
        this.username = username;
        this.password = password;
        this.reputacion = reputacion;
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
    
    //------* Metodos *------
    public Usuario cambiarUsername(Usuario usuario, String nuevoNombre){
        usuario.setUsername(nuevoNombre);
        return usuario;
    }

    public Usuario cambiarRepu(Usuario user, Integer repu){
        Integer nuevaRepu = user.getReputacion() + repu;
        user.setReputacion(nuevaRepu);
        return user;
    }
    
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
