package lab3_stack_20244554_EscobarZamorano;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        //------ Creacion de un listado de etiquetas que el usuario puede elegir para sus preguntas ------
        //Se genera una lista de etiquetas vacia
        ArrayList<Etiqueta> listaEtiquetas = new ArrayList<>();
        //Se genera una serie de etiquetas
        Etiqueta python = new Etiqueta("Python", "Python es un lenguaje de programación interpretado cuya filosofía hace hincapié en la legibilidad de su código");
        Etiqueta novato = new Etiqueta("Novato", "La persona que usa esta etiqueta esta aprendiendo");
        Etiqueta pro = new Etiqueta("Pro", "La persona que usa esta etiqueta tiene conocimietnos avanzados en la materia");
        Etiqueta git = new Etiqueta("Git", "Git es un software de control de versiones, pensando en la eficiencia, la confiabilidad y compatibilidad del mantenimiento de versiones de aplicaciones");
        Etiqueta java = new Etiqueta("Java", "Java es un lenguaje de programación y una plataforma informática que fue comercializada por primera vez en 1995 por Sun Microsystems");
        Etiqueta c = new Etiqueta("C", "C es un lenguaje de programación de propósito general2?:1 originalmente desarrollado por Dennis Ritchie entre 1969 y 1972 en los Laboratorios Bell");
        
        //------ Creacion de Stack Predeterminado con usuarios, preguntas, respuestas y etiquetas------
        //Se genera un stack vacio
        Stack stack1 = new Stack(); 
        //Se registran 4 usuarios con reputacion inicial de 1000 ptos
        stack1.register("Pepe","colocolo1");
        stack1.register("Carlos","carlitos21");
        stack1.register("Hackerman321","anonymous123");
        stack1.register("MainPython","pythonislife");
        //------ Se crean 5 preguntas ------
        //Pregunta 1 y 2
        listaEtiquetas.add(python);
        listaEtiquetas.add(novato);
        stack1.login("Pepe","colocolo1");
        stack1.ask("Pregunta sobre python", "Python es un lenguaje compilado o interpretado?", listaEtiquetas);
        stack1.ask("Mostrar por pantalla Python", "Como puedo mostrar algo por pantalla en python?", listaEtiquetas);
        stack1.logout("Pepe","colocolo1");
        listaEtiquetas.clear();
        //Pregunta 3
        listaEtiquetas.add(pro);
        listaEtiquetas.add(c);
        stack1.login("Carlos","carlitos21");
        stack1.ask("Millones", "Cuantos millones voy a ganar por saber c?", listaEtiquetas);
        stack1.logout("Carlos","carlitos21");
        listaEtiquetas.clear();
        //Pregunta 4
        listaEtiquetas.add(pro);
        stack1.login("Hackerman321","anonymous123");
        stack1.ask("Camaradas", "Busco camaradas para hackear a SpaceX", listaEtiquetas);
        stack1.logout("Hackerman321","anonymous123");
        listaEtiquetas.clear();
        //Pregunta 5
        listaEtiquetas.add(java);
        listaEtiquetas.add(git);
        stack1.login("MainPython","pythonislife");
        stack1.ask("No tengo idea de Java", "Como hago un commit de mi proyecto de Java?", listaEtiquetas);
        stack1.logout("MainPython","pythonislife");
        listaEtiquetas.clear();
        
        //------ Se realizan 10 respuestas ------
        //Respuestas a pregunta 3
        stack1.login("Pepe","colocolo1");
        stack1.answer(2, "1 millon aprox");
        stack1.logout("Pepe","colocolo1");
        stack1.login("Hackerman321","anonymous123");
        stack1.answer(2, "Yo diria que medio millon");
        stack1.logout("Hackerman321","anonymous123");
        stack1.login("MainPython","pythonislife");
        stack1.answer(2, "Todos saben que no pagan por saber algo");
        stack1.logout("MainPython","pythonislife");
        //Respuestas a pregunta 1
        stack1.login("Carlos","carlitos21");
        stack1.answer(0, "Estimado, python es un lenguaje interpretado");
        stack1.logout("Carlos","carlitos21");
        stack1.login("Hackerman321","anonymous123");
        stack1.answer(0, "Python es piton en ingles");
        stack1.logout("Hackerman321","anonymous123");
        stack1.login("MainPython","pythonislife");
        stack1.answer(0, "Python no corresponde a ninguno de los dos");
        stack1.logout("MainPython","pythonislife");
        //Respuestas a pregunta 4
        stack1.login("Carlos","carlitos21");
        stack1.answer(3, "Yo me uno");
        stack1.logout("Carlos","carlitos21");
        stack1.login("Pepe","colocolo1");
        stack1.answer(3, "Cuenta conmigo");
        stack1.logout("Pepe","colocolo1");
        stack1.login("MainPython","pythonislife");
        stack1.answer(3, "Te voy a denunciar");
        stack1.logout("MainPython","pythonislife");
        //Respuesta a pregunta 5
        stack1.login("Pepe","colocolo1");
        stack1.answer(4, "Solo debes seguir los siguientes pasos...");
        stack1.logout("Pepe","colocolo1");
        
        //Carga de 3 etiquetas predeterminadas en el stack
        listaEtiquetas.add(python);
        listaEtiquetas.add(java);
        listaEtiquetas.add(c);
        stack1.setListaEtiquetas(listaEtiquetas);
        
        //------* MENU *------
        //Se define una variable que va a guardar la opcion seleccionada por el usuario
        int opcion1;
        System.out.println("\n###### Bienvenido a Stack Overflow ######\nQue tipo de Stack desea cargar?");
        System.out.println("\n1. Stack precargado con usuarios, preguntas, respuestas y etiquetas creadas\n2. Stack vacio");
        System.out.println("\nPOR FAVOR, SOLO INTRODUZCA UNA OPCION VALIDA, 1 o 2:");
        //Se recibe el valor ingresado por el usuario y se guarda en opcion1
        opcion1 = Integer.parseInt(scanner.nextLine());
        //System.out.println("Usted ha seleccionado " + opcion1);  
        if (opcion1 == 2) {
            stack1.getListaEtiquetas().clear();
            stack1.getListaPreguntas().clear();
            stack1.getListaUsuarios().clear();
        } 
        //System.out.println("cantidad de preguntas " + stack1.getListaPreguntas().size());
        //System.out.println("cantidad de usuarios " + stack1.getListaUsuarios().size());
        //System.out.println("cantidad de etiquetas " + stack1.getListaEtiquetas().size());
        
        int opcion2;
        System.out.println("\n###### STACK OVERFLOW ######\nQue desea hacer primero?");
        System.out.println("\n1. Registrarse\n2. Iniciar Sesion");
        System.out.println("\nPOR FAVOR, SOLO INTRODUZCA UNA OPCION VALIDA, 1 o 2:");
        //Se recibe el valor ingresado por el usuario y se guarda en opcion2
        opcion2 = Integer.parseInt(scanner.nextLine());
        String username1;
        String password1;
        switch(opcion2){
            case 1:
                System.out.println("Ingrese el nombre de usuario que desea usar:");
                username1 = scanner.nextLine();
                //System.out.println("Su nombre de usuario es: " + username1);
                System.out.println("Ingrese la password que desea usar:");
                password1 = scanner.nextLine();
                //System.out.println("Su contrasena es: " + password1);
                //Se registra el usuario en el stack
                stack1.register(username1, password1);
                System.out.println("\nSe ha registrado de forma exitosa!");
                //Se deja sesion iniciada
                stack1.login(username1, password1);
                break;
                
            case 2:
                System.out.println("Ingrese su nombre de usuario: ");
                username1 = scanner.nextLine();
                //System.out.println("Su nombre de usuario es: " + username1);
                System.out.println("Ingrese su password: ");
                password1 = scanner.nextLine();                
                //System.out.println("Su contrasena es: " + password1);
                //Inicia sesion en el stack con los datos del usuario
                stack1.login(username1, password1);
                System.out.println("\nHa iniciado sesion de forma exitosa!");
                break;
            
            default:
                System.out.println("Usted ha seleccionado una opcion invalida");
        }
        
        System.out.println("\n###### STACK OVERFLOW ######\nSesion Iniciada como: " + stack1.getUsuarioActivo().getUsername());
        System.out.println("\nBienvenido a su plataforma de preguntas y respuestas favorita\nQue desea hacer hoy?");
        System.out.println("\n1. Agregar una pregunta\n2. Responder una pregunta\n3. Dar Recompensa\n4. Aceptar Respuesta\n5. Votar por Pregunta o Respuesta\n6. Cerrar Sesion\n7. Salir del programa");
        System.out.println("\nPOR FAVOR, SOLO INTRODUZCA UNA OPCION VALIDA:");
        
        int opcion3 = Integer.parseInt(scanner.nextLine());
        
        //Dependiendo la opcion que ingrese el usuario se procede a ejecutar el comando
        switch(opcion3){
            case 1:
                System.out.println("\n######################################################################################");
                System.out.println("######################################################################################");
                System.out.println("\n###### Ha seleccionado agregar una pregunta ######");
                System.out.println("\nIngrese el titulo que le quiere dar a la pregunta: ");
                String tituloPregunta = scanner.nextLine();
                //System.out.println("Su titulo es: " + tituloPregunta);
                System.out.println("\nIngrese su pregunta: ");
                String textoPregunta = scanner.nextLine();
                //System.out.println("Su pregunta es: " + textoPregunta);
                System.out.println("\nElija una de las siguientes etiquetas:");
                for (int i = 0; i < stack1.getListaEtiquetas().size(); i++) {
                    System.out.println("\n" + i + ". " + stack1.getListaEtiquetas().get(i).getNombreEtiqueta());
                }
                System.out.println("\nPOR FAVOR, SOLO INTRODUZCA UNA OPCION VALIDA:");
                int etiquetaSeleccionada = Integer.parseInt(scanner.nextLine());
                //System.out.println("Usted ha elegido la etiqueta " + stack1.getListaEtiquetas().get(etiquetaSeleccionada).getNombreEtiqueta());
                //Se agrega la etiqueta a una lista
                ArrayList<Etiqueta> nuevaListaEtiquetas = new ArrayList<Etiqueta>();
                nuevaListaEtiquetas.add(stack1.getListaEtiquetas().get(etiquetaSeleccionada));
                //Se agrega la pregunta al stack
                stack1.ask(tituloPregunta, textoPregunta, nuevaListaEtiquetas);
                System.out.println("\nSu pregunta ha sido ingresada de forma exitosa!");
                break;
                
            case 2:
                System.out.println("\n######################################################################################");
                System.out.println("######################################################################################");
                System.out.println("\n###### Ha seleccionado responder una pregunta ######");
                //Se muestran las preguntas disponibles para responder
                System.out.println("Elija una pregunta a la que quiere responder:\n");
                for (int i = 0; i < stack1.getListaPreguntas().size(); i++) {
                    System.out.println("************************************************************");
                    System.out.println("**    " + stack1.getListaPreguntas().get(i).getTituloPregunta());
                    System.out.println("**    " + stack1.getListaPreguntas().get(i).getTextoPregunta());
                    System.out.println("**    " + "ID: " + stack1.getListaPreguntas().get(i).getIdPregunta());
                    System.out.println("************************************************************");
                    System.out.println("\n");
                }
                System.out.println("\nPOR FAVOR, INGRESE EL ID DE LA PREGUNTA QUE QUIERE RESPONDER: ");
                int idEscogido = Integer.parseInt(scanner.nextLine());
                //System.out.println("Usted ha seleccionado: " + idEscogido);
                System.out.println("\nIngrese el contenido de su respuesta: ");
                String contenidoRespuesta = scanner.nextLine();
                //Se genera la respuesta
                stack1.answer(idEscogido, contenidoRespuesta);
                System.out.println("\nSu respuesta ha sido ingresada de forma exitosa!");
                break;
                
            case 3:
                System.out.println("\n######################################################################################");
                System.out.println("######################################################################################");
                System.out.println("\n###### Ha seleccionado ofrecer recompensa ######");
                //Se muestran las pregunta disponibles para ofrecer recompensa
                System.out.println("Elija una pregunta a la que quiere asignar una recompensa:\n");
                for (int i = 0; i < stack1.getListaPreguntas().size(); i++) {
                    System.out.println("************************************************************");
                    System.out.println("**    " + stack1.getListaPreguntas().get(i).getTituloPregunta());
                    System.out.println("**    " + stack1.getListaPreguntas().get(i).getTextoPregunta());
                    System.out.println("**    " + "ID: " + stack1.getListaPreguntas().get(i).getIdPregunta());
                    System.out.println("************************************************************");
                    System.out.println("\n");
                }
                System.out.println("\nPOR FAVOR, INGRESE EL ID DE LA PREGUNTA A LA QUE DESEA ASIGNAR UNA RECOMPENSA: ");
                int idPregunta = Integer.parseInt(scanner.nextLine());
                //System.out.println("Usted ha seleccionado: " + idPregunta);
                System.out.println("\nIngrese la cantidad de puntos que desea ofrecer como recompensa: ");
                int recompensa = Integer.parseInt(scanner.nextLine());
                //System.out.println("Usted ha asignado como recompensa: " + recompensa);
                //Se ofrece la recompensa
                stack1.reward(idPregunta, recompensa);
                System.out.println("\nSu recompensa ha sido ofrecida de forma exitosa!");
                break;
                
            case 4:
                System.out.println("\n######################################################################################");
                System.out.println("######################################################################################");                
                System.out.println("\n###### Ha seleccionado aceptar respuesta ######");
                //Se verifica si el usuario tiene preguntas asociadas
                if (!(stack1.tienePreguntas(stack1.getUsuarioActivo()))) {
                    System.out.println("Usted no tiene preguntas registradas");
                    break;
                }
                
                //Se muestran las preguntas del usuario activo
                System.out.println("Elija una de las preguntas que quiere revisar:\n");
                for (int i = 0; i < stack1.getListaPreguntas().size(); i++) {
                    if (stack1.getUsuarioActivo().usuariosIgualesRegister(stack1.getListaPreguntas().get(i).getAutorPregunta())) {
                    System.out.println("************************************************************");
                    System.out.println("**    " + stack1.getListaPreguntas().get(i).getTituloPregunta());
                    System.out.println("**    " + stack1.getListaPreguntas().get(i).getTextoPregunta());
                    System.out.println("**    " + "ID: " + stack1.getListaPreguntas().get(i).getIdPregunta());
                    System.out.println("************************************************************");
                    System.out.println("\n");
                    }
                }
                System.out.println("\nPOR FAVOR, INGRESE EL ID DE LA PREGUNTA QUE DESEA REVISAR: ");
                int idPreguntaRevisar = Integer.parseInt(scanner.nextLine());
                //System.out.println("Usted ha seleccionado: " + idPreguntaRevisar);
                
                //SE MUESTRAN LAS RESPUESTAS A LA PREGUNTA SELECCIONADA
                System.out.println("Elija la respuesta que desea marcar como aceptada");
                for (int i = 0; i < stack1.getListaPreguntas().get(idPreguntaRevisar).getListaRespuestas().size(); i++) {
                    System.out.println("************************************************************");
                    System.out.println("**    " + stack1.getListaPreguntas().get(idPreguntaRevisar).getListaRespuestas().get(i).getTextoRespuesta());
                    System.out.println("**    " + "ID: " + stack1.getListaPreguntas().get(idPreguntaRevisar).getListaRespuestas().get(i).getIdRespuesta());
                    System.out.println("************************************************************");
                    System.out.println("\n");
                }
                System.out.println("\nPOR FAVOR, INGRESE EL ID DE LA RESPUESTA QUE DESEA ACEPTAR: ");
                int idRespuestaEscogida = Integer.parseInt(scanner.nextLine());
                //System.out.println("Usted ha seleccionado la respuesta: " + idRespuestaEscogida);
                //Se marca como cerrada la pregunta y se marca como aceptada la respuesta
                stack1.accept(idPreguntaRevisar, idRespuestaEscogida);
                System.out.println("\nLa respuesta ha sido aceptada de forma exitosa!");
                break;
                
            case 5:
                System.out.println("\n######################################################################################");
                System.out.println("######################################################################################");
                System.out.println("\n###### Ha seleccionado votar por una pregunta o respuesta ######");
                System.out.println("Elija una pregunta o respuesta a la cual desea votar:\n");
                for (int i = 0; i < stack1.getListaPreguntas().size(); i++) {
                    System.out.println("        Pregunta");
                    System.out.println("************************************************************");
                    System.out.println("**    " + stack1.getListaPreguntas().get(i).getTituloPregunta());
                    System.out.println("**    " + stack1.getListaPreguntas().get(i).getTextoPregunta());
                    System.out.println("**    " + "ID: " + stack1.getListaPreguntas().get(i).getIdPregunta());
                    System.out.println("************************************************************");
                    if (!(stack1.getListaPreguntas().get(i).getListaRespuestas().isEmpty())) {
                        System.out.println("                Respuestas");
                    }
                    for (int j = 0; j < stack1.getListaPreguntas().get(i).getListaRespuestas().size(); j++) {
                        System.out.println("        ************************************************************");
                        System.out.println("        **    " + stack1.getListaPreguntas().get(i).getListaRespuestas().get(j).getTextoRespuesta());
                        System.out.println("        **    " + "ID: " + stack1.getListaPreguntas().get(i).getListaRespuestas().get(j).getIdRespuesta());
                        System.out.println("        ************************************************************");
                    }
                    System.out.println("\n"); 
                }
                System.out.println("Elija que desea votar: ");
                System.out.println("\n1. Pregunta\n2. Respuesta");
                System.out.println("\nPOR FAVOR, INGRESE UNA OPCION VALIDA: ");
                int tipoDato = Integer.parseInt(scanner.nextLine());
                if (tipoDato == 1) {
                    System.out.println("\nIngrese el ID de la pregunta que desea votar: ");
                    int idPreguntaVotar = Integer.parseInt(scanner.nextLine());
                    System.out.println("Elija si el voto es a favor o en contra: ");
                    System.out.println("\n1. A favor\n2. En Contra");
                    System.out.println("\nPOR FAVOR, INGRESE UNA OPCION VALIDA: ");
                    int tipoVoto = Integer.parseInt(scanner.nextLine());
                    //Se vota por la pregunta ingresada
                    stack1.vote(idPreguntaVotar, tipoVoto);
                    System.out.println("\nSu votacion se ha realizado de forma exitosa!");
                }else{
                    System.out.println("\nIngrese el ID de la pregunta a la que pertenece la respuesta: ");
                    int preguntaParaVotar = Integer.parseInt(scanner.nextLine());
                    System.out.println("\nIngrese el ID de la respuesta que desea votar: ");
                    int respuestaParaVotar = Integer.parseInt(scanner.nextLine());
                    System.out.println("Elija si el voto es a favor o en contra: ");
                    System.out.println("\n1. A favor\n2. En Contra");
                    System.out.println("\nPOR FAVOR, INGRESE UNA OPCION VALIDA: ");
                    int tipoVoto2 = Integer.parseInt(scanner.nextLine());
                    //Se vota por la respuesta ingresada
                    stack1.vote(preguntaParaVotar, respuestaParaVotar, tipoVoto2);
                    System.out.println("\nSu votacion se ha realizado de forma exitosa!");
                }
                break;
            
            case 6:
                System.out.println("\n######################################################################################");
                System.out.println("######################################################################################");
                System.out.println("\n###### Ha seleccionado cerrar sesion ######");
                System.out.println("\nPara evitar problemas, ingrese sus credenciales: ");
                System.out.println("\nIngrese su nombre de usuario: ");
                String username2 = scanner.nextLine();
                //System.out.println("Su nombre de usuario: " + username2);
                System.out.println("\nIngrese su password: ");
                String password2 = scanner.nextLine();
                //System.out.println("Su password: " + password2);
                //Se cierra sesion activa
                stack1.logout(username2, password2);
                break;
                
            case 7:
                System.out.println("\n######################################################################################");
                System.out.println("######################################################################################");
                System.out.println("\n###### Ha seleccionado salir del programa ######");
                System.out.println("\n ADIOS! VUELVA PRONTO!");
                break;
            
            default:
                System.out.println("\n######################################################################################");
                System.out.println("######################################################################################");
                System.out.println("\n###### Ha ingresado una opcion incorrecta ######");
        }
    }
}