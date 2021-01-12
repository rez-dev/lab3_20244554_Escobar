package lab3_stack_20244554_EscobarZamorano;

import java.util.ArrayList;
import java.util.Date;

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
    /**
    *Registra un nuevo usuario en el Stack, en caso de que ya este registrado esta operacion no se realiza. 
    *@param username /Nombre de usuario que se desea registrar
    *@param password /Contrasena definida por el usuario para poder iniciar sesion 
    *@return /Entrega un Stack con el nuevo usuario registrado, en caso de que ya este registrado entrega el mismo Stack
    */
    public Stack register(String username, String password){
        //Se crea un usuario con los datos ingresados
        Usuario nuevoUsuario = new Usuario(username,password);
        
        //Se verifica si el usuario esta registrado
        for (int i = 0; i < this.getListaUsuarios().size() ; i++) {
            if (this.getListaUsuarios().get(i).usuariosIgualesRegister(nuevoUsuario)) {
                System.out.println("\nSu registro no se pudo realizar, el username seleccionado ya esta registrado");
                return this;
            }
        }
        //En el caso de que no se haya encontrado al usuario se registra en la lista
        this.getListaUsuarios().add(nuevoUsuario);
        //System.out.println("EL USUARIO NO ESTA REGISTRADO");
        return this;
    }
    
    //------ LOGIN ------
    /**
    *Inicia sesion de un usuario en base a sus credenciales y lo deja como usuario actvio del Stack
    *@param username / Nombre de usuario que desea iniciar sesion
    *@param password /Contrasena para poder iniciar sesion
    *@return /Si las credenciales estan correctas entrega un Stack con el usuario como usuario activo, en caso contrario se entrega el mismo Stack
    */
    public Stack login(String username, String password){
        //Se crea un usuario con los datos ingresados
        Usuario nuevoUsuario = new Usuario(username,password);
        
        //Se verifica que las credenciales ingresadas esten correctas
        for (int i = 0; i < this.getListaUsuarios().size(); i++) {
            if (this.getListaUsuarios().get(i).usuariosIgualesLogin(nuevoUsuario)) {
                //Si las credenciales coinciden se deja al usuario como usuario activo
                this.setUsuarioActivo(this.getListaUsuarios().get(i));
                //System.out.println("SE PUDO LOGEAR CORRECTAMENTE");
                return this;
            }
        }
        //En caso de que el usuario no coincida o no este registrado se retorna el mismo stack
        System.out.println("\nNo se pudo iniciar sesion, las credenciales ingresadas no coinciden");
        return this; 
    }
    
    //------ LOGOUT ------
    /**
    *Cierra la sesion de un usuario activo 
    *@param username / Nombre de usuario que desea cerrar sesion
    *@param password /Contrasena del usuario que desea cerrar sesion
    *@return /En caso de que las credenciales sean correctas, se entrega un Stack con el usuario activo como inactivo, en caso contrario se entrega el mismo Stack
    */
    public Stack logout(String username, String password){
        //Se crea un usuario con los datos ingresados
        Usuario nuevoUsuario = new Usuario(username,password);
        
        //Se verifica que haya una sesion iniciada
        if (this.getUsuarioActivo().getUsername() == null) {
            //System.out.println("NO HAY SESION INICIADA");
            return this;
        }
        
        //Se verifica que el usuario activo sea el usuario que quiere cerrar sesion
        if (this.getUsuarioActivo().usuariosIgualesLogin(nuevoUsuario)) {
            //Se deja como usuario inactivo a un usuario con todos sus atributos null
            this.setUsuarioActivo(new Usuario(null, null, null, null));
            //System.out.println("SE HA CERRADO SESION");
            //Se retorna el stack con el usuario inactivo
            return this;
        }
        System.out.println("\nNo se pudo cerrar su sesion, las credenciales ingresadas no coinciden");
        //Se retorna el mismo stack sin cambios
        return this;
    }
    
    //------ ASK ------
    /**
    *Ingresa una pregunta creado por el usuario activo al Stack
    *@param tituloPregunta /Titulo que se define para la pregunta
    *@param contenidoPregunta /Contenido que tiene la pregunta, de que trata
    *@param listaEtiquetas /Listado de etiquetas para categorizar la pregunta en un tema especifico
    *@return /En caso de que el usuario sea un usuario activo se entrega un Stack con la pregunta agregada al listado de preguntas, en caso contrario entrega el mismo Stack 
    */
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
        Pregunta preguntaNueva = new Pregunta(idNuevo, listaEtiquetas, tituloPregunta, contenidoPregunta, fecha, this.getUsuarioActivo(), "ABIERTA", 0);
        
        //Se agrega la pregunta creada a la lista de preguntas del stack
        this.getListaPreguntas().add(preguntaNueva);

        //Se retorna el stack con la pregunta agregada
        return this;
    }

    //------ ANSWER ------
    //------ ASK ------
    /**
    *Crea una respuesta a una pregunta determinada 
    *@param idPreguntaSeleccionada /Identificador de la pregunta a la que se desea responder
    *@param contenidoRespuesta /Contenido de la respuesta, que es lo que se responde
    *@return /En caso de que el usuario este activo, se entrega un Stack con la respuesta agregada al listado de respuestas de la pregunta indicada, en caso de que el usuario este inactivo se entrega el mismo Stack
    */
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
        Respuesta respuestaNueva = new Respuesta(idNuevaRespuesta, this.getUsuarioActivo(), fecha, contenidoRespuesta,"NO ACEPTADA");
        
        //Se agrega la respuesta creada a la lista de respuestas de la pregunta escogida
        this.getListaPreguntas().get(idPreguntaSeleccionada).getListaRespuestas().add(respuestaNueva);
        
        //Se retorna el stack con la respuesta agregada a la lista de respuestas de la pregunta ingresada
        return this;
    }
    
    //------ REWARD ------
    /**
    *Ofrece una recompensa a una pregunta determinada 
    *@param idPreguntaSeleccionada /Identificador de la pregunta a la que se desea ofrecer una recompensa
    *@param recompensa /Cantidad de puntos que se ofrecen como recompensa a la pregunta
    *@return /En caso de que el usuario tenga sesion iniciada y tenga la reputacion suficiente, se entrega un Stack con la recompensa ofrecida a la pregunta y en caso contrario se entrega el mismo Stack
    */
    public Stack reward(int idPreguntaSeleccionada,int recompensa){
        //Se verifica que exista una sesion iniciada
        if (this.getUsuarioActivo().getUsername() == null) {
            //SI NO HAY USUARIO CON SESION INICIADA NO SE PUEDE EJECUTAR LA OPERACION
            return this;
        }
        
        //Se verifica que el usuario tenga los puntos suficientes para ofrecer una recompensa (REPUTACION - REPUTACION RETENIDA)
        if ((this.getUsuarioActivo().getReputacion() - this.getUsuarioActivo().getReputacionRetenida()) < recompensa) {
            System.out.println("\nNo se pudo asignar una recompensa, no cuenta con la reputacion suficiente");
            return this;
        }
   
        //La recompensa ofrecida se deja como reputacion retenida
        Integer reputacionRetenidaAntigua = this.getUsuarioActivo().getReputacionRetenida();
        Integer reputacionAntigua = this.getUsuarioActivo().getReputacion();
        this.getUsuarioActivo().setReputacionRetenida(reputacionRetenidaAntigua + recompensa);
        
        //Se crea una copia del usuario
        String copiaUsername = this.getUsuarioActivo().getUsername();
        String copiaPassword = this.getUsuarioActivo().getPassword();
        Usuario copiaUsuario = new Usuario(copiaUsername, copiaPassword);
        copiaUsuario.setReputacion(reputacionAntigua);
        copiaUsuario.setReputacionRetenida(reputacionRetenidaAntigua);
        
        //Se agrega el usuario a la lista de usuarios que ofrecieron recompensa de la pregunta, esta lista tiene una copia del usuario con la recompensa restada
        this.getListaPreguntas().get(idPreguntaSeleccionada).getListaUsuariosRecompensa().add(copiaUsuario);
        
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
     
    //------ ACCEPT ------
    /**
    *Se acepta una respuesta a una pregunta 
    *@param idPreguntaEscogida /Identificador de la pregunta a la que se desea revisar sus respuestas
    *@param idRespuestaEscogida /Identificar de la respuesta que se desea aceptar
    *@return /En caso de que el usuario tenga sesion iniciada se entrega un Stack con la respuesta marcada como aceptada y la pregunta como cerrada, en caso contrario se entrega el mismo Stack 
    */
    public Stack accept(int idPreguntaEscogida, int idRespuestaEscogida){
        //Se verifica que exista una sesion iniciada
        if (this.getUsuarioActivo().getUsername() == null) {
            //SI NO HAY USUARIO CON SESION INICIADA NO SE PUEDE EJECUTAR LA OPERACION
            return this;  
        }
        //Se procede a marcar la pregunta como cerrada
        this.getListaPreguntas().get(idPreguntaEscogida).setEstadoPregunta("CERRADA");
        
        //Se procede a marcar la respuesta como aceptada
        this.getListaPreguntas().get(idPreguntaEscogida).getListaRespuestas().get(idRespuestaEscogida).setEstadoRespuesta("ACEPTADA");
        
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
      
    //------ VOTE (CASO PREGUNTA)------
    /**
    *Se vota a favor o en contra de una pregunta
    *@param idPregunta /Identificador de la pregunta que se desea votar
    *@param tipoVoto /Identificador que permite verificar si el voto es a favor o en contra, (1 == a favor)(cualquier otro numero == en contra)
    *@return /En caso de que el usuario tenga sesion iniciada se entrega un Stack con las reputaciones de los usuarios actualizadas segun el voto, en caso contrario se entrega el mismo Stack
    */
    public Stack vote(int idPregunta, int tipoVoto){
        //Se verifica que exista una sesion iniciada
        if (this.getUsuarioActivo().getUsername() == null) {
            //SI NO HAY USUARIO CON SESION INICIADA NO SE PUEDE EJECUTAR LA OPERACION
            return this;  
        }
        //Si el voto es a favor
        if (tipoVoto == 1) {
            for (int i = 0; i < this.getListaUsuarios().size(); i++) {
                if (this.getListaPreguntas().get(idPregunta).getAutorPregunta().usuariosIgualesLogin(this.getListaUsuarios().get(i))) {
                    int reputacion = this.getListaUsuarios().get(i).getReputacion();
                    reputacion = reputacion + 10;
                    this.getListaUsuarios().get(i).setReputacion(reputacion);  
                }
            }
            return this;
        }else{
            //El voto es en contra
            //Se quita reputacion al autor de la pregunta (-2) y se quita reputacion al que vota (-1)
            for (int i = 0; i < this.getListaUsuarios().size(); i++) {
                //Se busca el usuario que hizo la pregunta y se le quitan 2 puntos de reputacion
                if (this.getListaPreguntas().get(idPregunta).getAutorPregunta().usuariosIgualesLogin(this.getListaUsuarios().get(i))) {
                    int reputacion = this.getListaUsuarios().get(i).getReputacion();
                    reputacion = reputacion - 2;
                    this.getListaUsuarios().get(i).setReputacion(reputacion);
                }
                //Se busca el usuario que voto en contra y se le quita 1 punto de reputacion
                if (this.getUsuarioActivo().usuariosIgualesLogin(this.getListaUsuarios().get(i))) {
                    int reputacion = this.getListaUsuarios().get(i).getReputacion();
                    reputacion = reputacion - 1;
                    this.getListaUsuarios().get(i).setReputacion(reputacion);
                    this.getUsuarioActivo().setReputacion(reputacion);
                }
            }
            return this;
        }
    }
    
    //------ VOTE (CASO RESPUESTA)------
    /**
    *Se vota a favor o en contra de una pregunta
    *@param idPregunta /Identificador de la pregunta a la que pertenece la respuesta
    *@param idRespuesta /Identificador de la respuesta que se desea votar
    *@param tipoVoto /Identificador que permite verificar si el voto es a favor o en contra, (1 == a favor)(cualquier otro numero == en contra)
    *@return /En caso de que el usuario tenga sesion iniciada se entrega un Stack con las reputaciones de los usuarios actualizadas segun el voto, en caso contrario se entrega el mismo Stack
    */
    public Stack vote(int idPregunta, int idRespuesta, int tipoVoto){
        //Se verifica que exista una sesion iniciada
        if (this.getUsuarioActivo().getUsername() == null) {
            //SI NO HAY USUARIO CON SESION INICIADA NO SE PUEDE EJECUTAR LA OPERACION
            return this;  
        }
        //Si el voto es a favor
        if (tipoVoto == 1) {
            for (int i = 0; i < this.getListaUsuarios().size(); i++) {
                if (this.getListaPreguntas().get(idPregunta).getListaRespuestas().get(idRespuesta).getAutorRespuesta().usuariosIgualesLogin(this.getListaUsuarios().get(i))) {
                    int reputacion = this.getListaUsuarios().get(i).getReputacion();
                    reputacion = reputacion + 10;
                    this.getListaUsuarios().get(i).setReputacion(reputacion);  
                }               
            }
            return this;
        }else{
            //El voto es en contra
            //Se quita reputacion al autor de la respuesta (-2) y se quita reputacion al que vota (-1)
            for (int i = 0; i < this.getListaUsuarios().size(); i++) {
                //Se busca al usuario que hizo la respuesta y se le quitan 2 puntos de reputacion
                if (this.getListaPreguntas().get(idPregunta).getListaRespuestas().get(idRespuesta).getAutorRespuesta().usuariosIgualesLogin(this.getListaUsuarios().get(i))) {
                    int reputacion = this.getListaUsuarios().get(i).getReputacion();
                    reputacion = reputacion - 2;
                    this.getListaUsuarios().get(i).setReputacion(reputacion);
                }
                //Se busca al usuario que voto en contra y se le quita 1 punto de reputacion
                if (this.getUsuarioActivo().usuariosIgualesLogin(this.getListaUsuarios().get(i))) {
                    int reputacion = this.getListaUsuarios().get(i).getReputacion();
                    reputacion = reputacion - 1;
                    this.getListaUsuarios().get(i).setReputacion(reputacion);
                    this.getUsuarioActivo().setReputacion(reputacion);
                }
            }
            return this;
        }
    }
    
    //METODO PARA SABER SI UN USUARIO TIENE PREGUNTAS ASOCIADAS
    /**
    *Verifica que un usuario tenga por lo menos una pregunta asociada a el
    *@param usuarioActivo /Usuario que se desea verificar si posee preguntas
    *@return /En caso de que el usuario sea autor de por lo menos una pregunta se entrega true, en caso contrario false
    */
    public boolean tienePreguntas(Usuario usuarioActivo){
        for (int i = 0; i < this.getListaPreguntas().size(); i++) {
            if (this.getListaPreguntas().get(i).getAutorPregunta().usuariosIgualesRegister(this.getUsuarioActivo())) {
                return true;    
            }
        }
        return false;
    }
}