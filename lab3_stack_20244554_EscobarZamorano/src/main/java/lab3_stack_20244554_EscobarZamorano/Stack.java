package lab3_stack_20244554_EscobarZamorano;

import java.util.ArrayList;

public class Stack {
    //------* Atributos *------
    private ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private Usuario usuarioActivo;
    
    //------* Constructor *------
    public Stack(Usuario usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }
    
    //------* Setters *------
    public void setListaPreguntas(ArrayList<Pregunta> listaPreguntas) {
        this.listaPreguntas = listaPreguntas;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public void setUsuarioActivo(Usuario usuarioActivo) {
        this.usuarioActivo = usuarioActivo;
    }
    
    //------* Getters *------
    public ArrayList<Pregunta> getListaPreguntas() {
        return listaPreguntas;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public Usuario getUsuarioActivo() {
        return usuarioActivo;
    }
}
