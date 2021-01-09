package lab3_stack_20244554_EscobarZamorano;

import java.util.ArrayList;
import java.util.Date;
import static lab3_stack_20244554_EscobarZamorano.Main.scanner;

public class Stack {
    //------* Atributos *------
    private ArrayList<Pregunta> listaPreguntas;
    private ArrayList<Usuario> listaUsuarios;
    private Usuario usuarioActivo;
    private ArrayList<Etiqueta> listaEtiquetas;
    
    //------* Constructor *------
    public Stack(){
        this.listaPreguntas = new ArrayList<Pregunta>();
        this.listaUsuarios = new ArrayList<Usuario>();
        this.usuarioActivo = new Usuario(null, null, null, null);
        this.listaEtiquetas = new ArrayList<Etiqueta>();
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

    public void setListaEtiquetas(ArrayList<Etiqueta> listaEtiquetas) {
        this.listaEtiquetas = listaEtiquetas;
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

    public ArrayList<Etiqueta> getListaEtiquetas() {
        return listaEtiquetas;
    }

    //------* Metodos *------
    //------ REGISTER ------
    public Stack register(String username, String password){
        //Se crea un usuario con los datos ingresados
        Usuario nuevoUsuario = new Usuario(username,password);
        
        //Se verifica si el usuario esta registrado
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
            //Se deja como usuario inactivo a un usuario con todos sus atributos null
            this.setUsuarioActivo(new Usuario(null, null, null, null));
            System.out.println("SE HA CERRADO SESION");
            //Se retorna el stack con el usuario inactivo
            return this;
        }
        System.out.println("LAS CREDENCIALES NO COINCIDEN");
        //Se retorna el mismo stack sin cambios
        return this;
    }
    
    //------ ASK ------
    public Stack ask(String tituloPregunta, String contenidoPregunta, ArrayList<Etiqueta> listaEtiquetas){
        //Se verifica que exista una sesion iniciada
        if (this.getUsuarioActivo().getUsername() == null) {
            //SI NO HAY USUARIO CON SESION INICIADA NO SE PUEDE EJECUTAR LA OPERACION
            return this;  
        }
        //Se genera un identificador para la pregunta
        int idNuevo = this.getListaPreguntas().size();
        
        //Se genera una fecha para el proceso
        Date fecha = new Date();
        
        //Se crea una nueva pregunta con los datos ingresados y los generados
        Pregunta preguntaNueva = new Pregunta(idNuevo, listaEtiquetas, tituloPregunta, contenidoPregunta, fecha, this.getUsuarioActivo(), "NO ACEPTADA", 0);
        
        //Se agrega la pregunta creada a la lista de preguntas del stack
        this.getListaPreguntas().add(preguntaNueva);

        //Se retorna el stack con la pregunta agregada
        return this;
    }
    
    //MENU ANSWER
            /*
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
        
        
        */
   
    //------ ANSWER ------
    public Stack answer(int idPreguntaSeleccionada, String contenidoRespuesta){
        //Se verifica que exista una sesion iniciada
        if (this.getUsuarioActivo().getUsername() == null) {
            //SI NO HAY USUARIO CON SESION INICIADA NO SE PUEDE EJECUTAR LA OPERACION
            return this;  
        }  
        //Se genera una fecha para el proceso
        Date fecha = new Date();
        
        //Se genera un nuevo id para la nueva respuesta
        int idNuevaRespuesta = this.getListaPreguntas().get(idPreguntaSeleccionada).getListaRespuestas().size();
        
        //Se crea una nueva respuesta con los datos ingresados y generados
        Respuesta respuestaNueva = new Respuesta(idNuevaRespuesta, this.getUsuarioActivo(), fecha, contenidoRespuesta);
        
        //Se agrega la respuesta creada a la lista de respuestas de la pregunta escogida
        this.getListaPreguntas().get(idPreguntaSeleccionada).getListaRespuestas().add(respuestaNueva);
        
        //Se retorna el stack con la respuesta agregada a la lista de respuestas de la pregunta ingresada
        return this;
    }
    
    //MENU REWARD
            /*
        //Se muestran las pregunta disponibles para ofrecer recompensa
        System.out.println("Elija una pregunta a la que quiere asignar una recompensa:\n");
        for (int i = 0; i < this.getListaPreguntas().size(); i++) {
            System.out.println(this.getListaPreguntas().get(i).getTituloPregunta());
            System.out.println(this.getListaPreguntas().get(i).getTextoPregunta());
            System.out.println("ID: " + this.getListaPreguntas().get(i).getIdPregunta());
            System.out.println("\n");
        }
        System.out.println("Ingrese el id de la pregunta escogida: ");
        
        int idEscogido = Integer.parseInt(scanner.nextLine());*/
    
    //------ REWARD ------
    public Stack reward(int idPreguntaSeleccionada,int recompensa){
        //Se verifica que exista una sesion iniciada
        if (this.getUsuarioActivo().getUsername() == null) {
            //SI NO HAY USUARIO CON SESION INICIADA NO SE PUEDE EJECUTAR LA OPERACION
            return this;
        }
        
        //Se verifica que el usuario tenga los puntos suficientes para ofrecer una recompensa (REPUTACION - REPUTACION RETENIDA)
        if ((this.getUsuarioActivo().getReputacion() - this.getUsuarioActivo().getReputacionRetenida()) < recompensa) {
            System.out.println("NO PUEDE ASIGNAR UNA RECOMPENSA");
            return this;
        }
        /*
        if ( this.getUsuarioActivo().getReputacion() < recompensa) {
            System.out.println("NO PUEDE ASIGNAR UNA RECOMPENSA");
            return this;
        }*/
        
        //La recompensa ofrecida se deja como reputacion retenida
        Integer reputacionRetenidaAntigua = this.getUsuarioActivo().getReputacionRetenida();
        Integer reputacionAntigua = this.getUsuarioActivo().getReputacion();
        this.getUsuarioActivo().setReputacionRetenida(reputacionRetenidaAntigua + recompensa);
        
        //Se agrega el usuario a la lista de usuarios que ofrecieron recompensa de la pregunta, esta lista tiene una copia del usuario con la recompensa restada
        this.getListaPreguntas().get(idPreguntaSeleccionada).getListaUsuariosRecompensa().add(this.getUsuarioActivo());
        
        //Se obtiene el indice del nuevo usuario en la lista de usuarios que ofrecieron recompensas
        int indexUsuarioRecompensa = this.getListaPreguntas().get(idPreguntaSeleccionada).getListaUsuariosRecompensa().size() - 1;
        
        //Se modifican los valores del usuario agregado con la recompensa ofrecida ya descontada y la reputacion retenida reiniciada
        this.getListaPreguntas().get(idPreguntaSeleccionada).getListaUsuariosRecompensa().get(indexUsuarioRecompensa).setReputacion(reputacionAntigua - recompensa);
        this.getListaPreguntas().get(idPreguntaSeleccionada).getListaUsuariosRecompensa().get(indexUsuarioRecompensa).setReputacionRetenida(0);
        
        //Se actualiza la reputacion retenida del usuario en la lista de usuarios registrados
        for (int i = 0; i < this.getListaUsuarios().size(); i++) {
            //Se verifica si se encontro el usuario activo en la lista de usuarios registrados
            if (this.getUsuarioActivo().usuariosIgualesLogin(this.getListaUsuarios().get(i))) {
                //Se actualiza la reputacion retenida al usuario en la lista de usuarios registrados
                this.getListaUsuarios().get(i).setReputacionRetenida(reputacionRetenidaAntigua + recompensa);
            }
        }
        //Se agrega la recompensa a la pregunta escogida
        this.getListaPreguntas().get(idPreguntaSeleccionada).setRecompensaPregunta(recompensa);
        
        //Se entrega el stack con la recompensa agregada a la pregunta escogida
        return this;
    }
    
    //MENU ACCEPT
            /*
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
        
        int idRespuestaEscogida = Integer.parseInt(scanner.nextLine());*/
    
    
    //------ ACCEPT ------
    public Stack accept(int idPreguntaEscogida, int idRespuestaEscogida){
        //Se verifica que exista una sesion iniciada
        if (this.getUsuarioActivo().getUsername() == null) {
            //SI NO HAY USUARIO CON SESION INICIADA NO SE PUEDE EJECUTAR LA OPERACION
            return this;  
        }
        //Se procede a marcar la respuesta como aceptada
        this.getListaPreguntas().get(idPreguntaEscogida).setEstadoPregunta("ACEPTADA");
        
        //Se procede a quitar la reputacion de los usuarios que ofrecieron una recompensa
        for (int i = 0; i < this.getListaPreguntas().get(idPreguntaEscogida).getListaUsuariosRecompensa().size(); i++) {
            for (int j = 0; j < this.getListaUsuarios().size(); j++) {
                //Si el usuario de la lista de recompensa coincide se copian sus reputaciones en el usuario de la lista de usuarios
                if (this.getListaPreguntas().get(idPreguntaEscogida).getListaUsuariosRecompensa().get(i).usuariosIgualesLogin(this.getListaUsuarios().get(j))) {
                    this.getListaUsuarios().get(j).setReputacion(this.getListaPreguntas().get(idPreguntaEscogida).getListaUsuariosRecompensa().get(i).getReputacion());
                    this.getListaUsuarios().get(j).setReputacionRetenida(this.getListaPreguntas().get(idPreguntaEscogida).getListaUsuariosRecompensa().get(i).getReputacionRetenida()); 
                }
            }
        }
        //Luego de actualizar las reputaciones de los usuarios que ofrecieron recompensa se borra la lista
        this.getListaPreguntas().get(idPreguntaEscogida).getListaUsuariosRecompensa().clear();
        
        /*
        //Se procede a quitar la recompensa retenida al usuario que ofrecio la recompensa
        int reputacionRetenida = this.getUsuarioActivo().getReputacionRetenida();
        int reputacion = this.getUsuarioActivo().getReputacion();
         
        //La reputacion retenida se descuenta a la reputacion original
        this.getUsuarioActivo().setReputacion(reputacion - reputacionRetenida);
        //La reputacion retenida vuelve a ser 0
        this.getUsuarioActivo().setReputacionRetenida(0);
        
        //PROVISORIAMENTE SOLO ES SI EL AUTOR DE LA PREGUNTA OFRECIO RECOMPENSA
        this.getUsuarioActivo().setReputacionRetenida(0);*/
        
        //Se copia la recompensa asignada a la respuesta
        int recompensa = this.getListaPreguntas().get(idPreguntaEscogida).getRecompensaPregunta();
        
        //Se deja en 0 la recompensa
        this.getListaPreguntas().get(idPreguntaEscogida).setRecompensaPregunta(0);
        
        //Se busca el usuario que hizo la respuesta aceptada
        for (int i = 0; i < this.getListaUsuarios().size(); i++) {
            if (this.getListaPreguntas().get(idPreguntaEscogida).getListaRespuestas().get(idRespuestaEscogida).getAutorRespuesta().usuariosIgualesRegister(this.getListaUsuarios().get(i))) {
                //Si se encuentra al autor de la respuesta escogida se le suman los puntos de la recompensa a su reputacion
                int reputacionAntigua = this.getListaUsuarios().get(i).getReputacion();
                reputacionAntigua = reputacionAntigua + recompensa;
                this.getListaUsuarios().get(i).setReputacion(reputacionAntigua);
            }
        }
        //Se entrega el stack con las recompensas y descuentos asignados
        return this;
    }
}

