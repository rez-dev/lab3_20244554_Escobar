package lab3_stack_20244554_EscobarZamorano;

import java.util.ArrayList;
import static lab3_stack_20244554_EscobarZamorano.Main.scanner;

public class Stack {
    //------* Atributos *------
    private ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
    private Usuario usuarioActivo;
    
    //------* Constructor *------
    public Stack(){
        this.listaPreguntas = new ArrayList<Pregunta>();
        this.listaUsuarios = new ArrayList<Usuario>();
        this.usuarioActivo = new Usuario(null, null, null, null);
    }
    
    public Stack(Usuario usuarioActivo) {
        this.listaPreguntas = new ArrayList<Pregunta>();
        this.listaUsuarios = new ArrayList<Usuario>();
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
    
    //------* Metodos *------
    //------ REGISTER ------
    //1)VERIFICAR QUE EL USUARIO NO ESTE REGISTRADO
    public Stack register(String username, String password){
        //Se crea un usuario con los datos ingresados
        Usuario nuevoUsuario = new Usuario(username,password);
        
        for (int i = 0; i < this.getListaUsuarios().size() ; i++) {
            if (this.getListaUsuarios().get(i).usuariosIgualesRegister(nuevoUsuario)) {
                System.out.println("EL USUARIO ESTA REGISTRADO xd");
                return this;
            }
        }
        //En el caso de que no se haya encontrado al usuario se registra en la lista
        this.getListaUsuarios().add(nuevoUsuario);
        System.out.println("EL USUARIO NO ESTA REGISTRADO");
        return this;
    }
    
    //------ LOGIN ------
    public Stack login(String username, String password){
        //Se crea un usuario con los datos ingresados
        Usuario nuevoUsuario = new Usuario(username,password);
        
        //Se verifica que las credenciales ingresadas esten correctas
        for (int i = 0; i < this.getListaUsuarios().size(); i++) {
            if (this.getListaUsuarios().get(i).usuariosIgualesLogin(nuevoUsuario)) {
                //Si las credenciales coinciden se deja al usuario como usuario activo
                this.setUsuarioActivo(this.getListaUsuarios().get(i));
                System.out.println("SE PUDO LOGEAR CORRECTAMENTE");
                return this;
            }
        }
        //En caso de que el usuario no coincida o no este registrado se retorna el mismo stack
        System.out.println("NO SE PUDO LOGEAR");
        return this; 
    }
    
    //------ LOGOUT ------
    public Stack logout(String username, String password){
        //Se crea un usuario con los datos ingresados
        Usuario nuevoUsuario = new Usuario(username,password);
        
        //Se verifica que haya una sesion iniciada
        if (this.getUsuarioActivo().getUsername() == null) {
            System.out.println("NO HAY SESION INICIADA");
            return this;
        }
        
        //Se verifica que el usuario activo sea el usuario que quiere cerrar sesion
        if (this.getUsuarioActivo().usuariosIgualesLogin(nuevoUsuario)) {
            this.setUsuarioActivo(new Usuario(null, null, null, null));
            System.out.println("SE HA CERRADO SESION");
            return this;
        }
        
        System.out.println("LAS CREDENCIALES NO COINCIDEN");
        return this;
    }
    
    //------ ASK ------
    public Stack ask(String tituloPregunta, String contenidoPregunta, ArrayList<Etiqueta> listaEtiquetas){
        //VERIFICAR SESION INICIADA
        if (this.getUsuarioActivo().getUsername() == null) {
            //SI NO HAY USUARIO CON SESION INICIADA NO SE PUEDE EJECUTAR LA OPERACION
            return this;  
        }
        int idNuevo = this.getListaPreguntas().size();
        
        Pregunta preguntaNueva = new Pregunta(idNuevo, tituloPregunta, contenidoPregunta, "12-12-2020", this.getUsuarioActivo(), "NO ACEPTADA", 0);
        
        preguntaNueva.setListaEtiquetas(listaEtiquetas);
        
        this.getListaPreguntas().add(preguntaNueva);

        return this;
    }
    
    //------ ANSWER ------
    public Stack answer(String contenidoRespuesta){
        //VERIFICAR SESION INICIADA
        if (this.getUsuarioActivo().getUsername() == null) {
            //SI NO HAY USUARIO CON SESION INICIADA NO SE PUEDE EJECUTAR LA OPERACION
            return this;  
        }
        
        //Se muestran las preguntas disponibles para responder
        System.out.println("Elija una pregunta:\n");
        for (int i = 0; i < this.getListaPreguntas().size(); i++) {
            System.out.println(this.getListaPreguntas().get(i).getTituloPregunta());
            System.out.println(this.getListaPreguntas().get(i).getTextoPregunta());
            System.out.println("ID: " + this.getListaPreguntas().get(i).getIdPregunta());
            System.out.println("\n");
        }
        System.out.println("Ingrese el id de la pregunta escogida: ");
        
        int idEscogido = Integer.parseInt(scanner.nextLine());
        
        //System.out.println("EL ID ESCOGIDO ES: " + idEscogido);
        
        int idNuevaRespuesta = this.getListaPreguntas().get(idEscogido).getListaRespuestas().size();
        
        Respuesta respuestaNueva = new Respuesta(idNuevaRespuesta, this.getUsuarioActivo(), "12-12-2020", contenidoRespuesta);
        
        this.getListaPreguntas().get(idEscogido).getListaRespuestas().add(respuestaNueva);
        
        return this;
    }
    
    //------ REWARD ------
    public Stack reward(int recompensa){
        //VERIFICAR SESION INICIADA
        if (this.getUsuarioActivo().getUsername() == null) {
            //SI NO HAY USUARIO CON SESION INICIADA NO SE PUEDE EJECUTAR LA OPERACION
            return this;  
        }
        
        //VERIFICA QUE TENGA LOS PUNTOS SUFICIENTES PARA PODER DAR UNA RECOMPENSA
        if ( this.getUsuarioActivo().getReputacion() < recompensa) {
            System.out.println("NO PUEDE ASIGNAR UNA RECOMPENSA");
            return this;
        }
        
        //SE DESCUENTA LA REPUTACION Y SE DEJA COMO REPUTACION RETENIDA
        Integer reputacion = this.getUsuarioActivo().getReputacion();
        Integer reputacionNueva = reputacion - recompensa;
        this.getUsuarioActivo().setReputacion(reputacionNueva);
        this.getUsuarioActivo().setReputacionRetenida(recompensa);
        
        //Se muestran las preguntas disponibles para responder
        System.out.println("Elija una pregunta a la que quiere asignar una recompensa:\n");
        for (int i = 0; i < this.getListaPreguntas().size(); i++) {
            System.out.println(this.getListaPreguntas().get(i).getTituloPregunta());
            System.out.println(this.getListaPreguntas().get(i).getTextoPregunta());
            System.out.println("ID: " + this.getListaPreguntas().get(i).getIdPregunta());
            System.out.println("\n");
        }
        System.out.println("Ingrese el id de la pregunta escogida: ");
        
        int idEscogido = Integer.parseInt(scanner.nextLine());
        
        //Se setea la recompensa en la recompensa de la pregunta
        this.getListaPreguntas().get(idEscogido).setRecompensaPregunta(recompensa);
        
        return this;
  
    }
    
    //------ ACCEPT ------
    public Stack accept(){
        //VERIFICAR SESION INICIADA
        if (this.getUsuarioActivo().getUsername() == null) {
            //SI NO HAY USUARIO CON SESION INICIADA NO SE PUEDE EJECUTAR LA OPERACION
            return this;  
        }
        
        //Se deben mostrar las preguntas propias del usuario activo
        System.out.println("Elija una de las preguntas que quiere revisar:\n");
        for (int i = 0; i < this.getListaPreguntas().size(); i++) {
            if (this.getUsuarioActivo().usuariosIgualesRegister(this.getListaPreguntas().get(i).getAutorPregunta())) {
                System.out.println("LA PREGUNTA ES DEL USUARIO ACTIVO");
                System.out.println(this.getListaPreguntas().get(i).getTituloPregunta());
                System.out.println(this.getListaPreguntas().get(i).getTextoPregunta());
                System.out.println("ID: " + this.getListaPreguntas().get(i).getIdPregunta());
                System.out.println("\n");
            }
        }
        System.out.println("Ingrese el id de la pregunta escogida: ");
        
        int idEscogido = Integer.parseInt(scanner.nextLine());
        
        //SE MUESTRAN LAS RESPUESTAS A LA PREGUNTA SELECCIONADA
        System.out.println("Elija la respuesta que desea marcar como aceptada");
        for (int i = 0; i < this.getListaPreguntas().get(idEscogido).getListaRespuestas().size(); i++) {
            System.out.println(this.getListaPreguntas().get(idEscogido).getListaRespuestas().get(i).getTextoRespuesta());
            System.out.println("ID: " + this.getListaPreguntas().get(idEscogido).getListaRespuestas().get(i).getIdRespuesta());
            System.out.println("\n");
        }
        System.out.println("Ingrese el id de la respuesta escogida: ");
        
        int idRespuestaEscogida = Integer.parseInt(scanner.nextLine());
        
        //SE PROCEDE A MARCAR COMO ACEPTADA LA PREGUNTA
        this.getListaPreguntas().get(idEscogido).setEstadoPregunta("RESPUESTA ACEPTADA");
        
        //SE PROCEDE A OTORGAR LOS PUNTOS A LOS USUARIOS
        //Se quitan los puntos retenidos al usuario
        //PROVISORIAMENTE SOLO ES SI EL AUTOR DE LA PREGUNTA OFRECIO RECOMPENSA
        this.getUsuarioActivo().setReputacionRetenida(0);
        
        //se copia la recompensa asignada a la respuesta
        int recompensa = this.getListaPreguntas().get(idEscogido).getRecompensaPregunta();
        
        //Se deja en 0 la recompensa
        this.getListaPreguntas().get(idEscogido).setRecompensaPregunta(0);
        
        //Se busca el usuario que hizo la respuesta aceptada
        for (int i = 0; i < this.getListaUsuarios().size(); i++) {
            if (this.getListaPreguntas().get(idEscogido).getListaRespuestas().get(idRespuestaEscogida).getAutorRespuesta().usuariosIgualesRegister(this.getListaUsuarios().get(i))) {
                //Si se encuentra al autor de la respuesta escogida se le suman los puntos de la recompensa a su reputacion
                int reputacionAntigua = this.getListaUsuarios().get(i).getReputacion();
                reputacionAntigua = reputacionAntigua + recompensa;
                this.getListaUsuarios().get(i).setReputacion(reputacionAntigua);
            }
        }
        return this;
    }
    
    
}

