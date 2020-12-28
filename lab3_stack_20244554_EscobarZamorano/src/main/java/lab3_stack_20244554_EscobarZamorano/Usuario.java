package lab3_stack_20244554_EscobarZamorano;

public class Usuario {
    //------* Atributos *------
    private String username;
    private String password;
    private int reputacion;
    
    //------* Constructor *------
    public Usuario(String username, String password, int reputacion) {
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

    public void setReputacion(int reputacion) {
        this.reputacion = reputacion;
    }
    
    //------* Getters *------
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getReputacion() {
        return reputacion;
    }
    
    //------* Metodos *------
    public Usuario cambiarUsername(Usuario usuario, String nuevoNombre){
        usuario.setUsername(nuevoNombre);
        return usuario;
    }

    public Usuario cambiarRepu(Usuario user, int repu){
        int nuevaRepu = user.getReputacion() + repu;
        user.setReputacion(nuevaRepu);
        return user;
    }
}
