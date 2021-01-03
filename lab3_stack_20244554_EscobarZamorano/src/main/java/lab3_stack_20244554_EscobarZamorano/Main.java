package lab3_stack_20244554_EscobarZamorano;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        //Se definen las listas para el stack
        /*
        ArrayList<Pregunta> listaPreguntas = new ArrayList<Pregunta>();
        
        ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
        
        Usuario user1 = new Usuario("pepe1","123",100);
        
        Respuesta r1 = new Respuesta(1010,user1,"12-12-2020","AYUDA");
        
        listaUsuarios.add(user1);
        
        Stack stack1 = new Stack(user1);
        
        stack1.setListaUsuarios(listaUsuarios);
        
        
        //System.out.println(stack1.getListaUsuarios().get(0).getUsername());
        
        //System.out.println(stack1.getUsuarioActivo().getUsername());
        
        //System.out.println(stack1.getListaUsuarios().size());
        
        stack1.register("Rolando","gatito");
        
        stack1.login("Rolando", "gatito");
        
        System.out.println("Usuario Activo ---> "+stack1.getUsuarioActivo().getUsername());
        
        stack1.logout("Rolando","gatito");
        System.out.println("Usuario Activo ---> "+stack1.getUsuarioActivo().getUsername());
        */
        
        //System.out.println(stack1.getListaUsuarios().get(0).getUsername());
        //System.out.println(stack1.getListaUsuarios().get(0).getPassword());
        
        //System.out.println("");
        
        //System.out.println(stack1.getListaUsuarios().get(1).getUsername());
        //System.out.println(stack1.getListaUsuarios().get(1).getPassword());
        
        //System.out.println(stack1.getListaUsuarios().size());
        
        //------ PRUEBA ------
        //Stack stack1 = new Stack();
        
        //Usuario user1 = new Usuario("pepe","123",0);
        //Usuario user2 = new Usuario("pepa","321",0);
        
        
        //stack1.getListaUsuarios().add(user1);
        
        //stack1.getListaUsuarios().add(user2);
        
        //System.out.println("---> " + stack1.getListaUsuarios().get(0).getUsername());
        
        //System.out.println("---> " + stack1.getListaUsuarios().get(1).getUsername());
        
        //System.out.println(stack1.getListaPreguntas().size());
        
        //PRUEBA PREGUNTA
        //Pregunta p1 = new Pregunta(1010, new Etiqueta("et1","es la et1"), new Etiqueta("et2","es la et2"), new Etiqueta("et3","es la et3"), "Primera Pregunta", "Texto Primera Pregunta", "12-12-2020", new Usuario("Rodrigo","123",0), "NO ACEPTADA", 0);
        
        //System.out.println(p1.getTituloPregunta());
        //Stack stack1 = new Stack();
        
        //stack1.register("User1","pass1");
        
        //stack1.login("User1","pass1");
        
        //System.out.println(stack1.getUsuarioActivo().getUsername());
        
        //stack1.logout("User1","pass1");
        
        //System.out.println(stack1.getUsuarioActivo().getUsername());
        
        
        Stack stack1 = new Stack();
        
        stack1.register("Rodrigo","123");
        
        stack1.register("Pepito","321");
        
        stack1.login("Rodrigo", "123");
        
        ArrayList<Etiqueta> listaEtiquetas = new ArrayList<Etiqueta>();
        
        listaEtiquetas.add(new Etiqueta("et1","descripcion et1"));
        
        listaEtiquetas.add(new Etiqueta("et2","descripcion et2"));
        
        listaEtiquetas.add(new Etiqueta("et3","descripcion et3"));
        
        
        stack1.ask("Mi primera pregunta", "COMO ME LLAMO AYUDA", listaEtiquetas);
        
        stack1.login("Pepito","321");
        
        stack1.ask("Mi segunda pregunta", "DONDE ESTOY?", listaEtiquetas);
        
        //System.out.println(stack1.getListaPreguntas().get(0).getAutorPregunta().getUsername());
        
        //System.out.println(stack1.getListaPreguntas().get(0).getListaEtiquetas().get(0).getDescripcionEtiqueta());
        
        //stack1.answer("Estas en Chile");
        
        //System.out.println("cantidad de respuestas -->" + stack1.getListaPreguntas().get(1).getListaRespuestas().size());
        
        //System.out.println("texto respuesta --->" + stack1.getListaPreguntas().get(1).getListaRespuestas().get(0).getTextoRespuesta());
        
        stack1.login("Rodrigo", "123");
        
        System.out.println("recompensa a pregunta antes --->" + stack1.getListaPreguntas().get(1).getRecompensaPregunta());
        
        System.out.println("reputacion antes --> " + stack1.getUsuarioActivo().getReputacion());
        System.out.println("reputacion retenida antes --> " + stack1.getUsuarioActivo().getReputacionRetenida());
       
        stack1.reward(400);
        
        System.out.println("recompensa a pregunta despues --->" + stack1.getListaPreguntas().get(1).getRecompensaPregunta());
        
        System.out.println("reputacion despues --> " + stack1.getUsuarioActivo().getReputacion());
        System.out.println("reputacion retenida despues --> " + stack1.getUsuarioActivo().getReputacionRetenida());        
        
        
        
        
        
        
        
        /*
        Usuario usuario1 = new Usuario("pepe","xd",1000);
        
        String nombre = usuario1.getUsername();
        
        System.out.println(nombre);
        
        usuario1 = usuario1.cambiarUsername(usuario1, "Ricardo");
        
        String nuevoNombre = usuario1.getUsername();
        
        System.out.println(nuevoNombre);
        
        
        usuario1 = usuario1.cambiarRepu(usuario1,500);
        
        int nuevaRepu = usuario1.getReputacion();
        
        System.out.println(nuevaRepu);
        
        
        //Respuesta r1 = new Respuesta(1010, usuario1, "10-10-2020","Como me llamo?");
        
        //int idRespuesta = r1.getIdRespuesta();
        
        //Usuario autorRespuesta = r1.getAutorRespuesta();
        
        //System.out.println(idRespuesta);
        
        //String nombre = usuario1.getUsername();
        
        //System.out.println(nombre);
        */
        
        /*
        //------* MENU *------
        //Se define una variable que va a guardar la opcion seleccionada por el usuario
        int opcion;
        
        //Se muestra por pantalla el menu de opciones que puede elegir el usuario
        System.out.println("\n###### STACK OVERFLOW ######\nRegistrado como: \n\nEscoja su opcion: ");
        System.out.println("\n1. Agregar una pregunta\n2. Responder una pregunta\n3. Dar Recompensa\n4. Aceptar Respuesta\n5. Cerrar Sesion\n6. Salir del programa");
        System.out.println("INTRODUZCA SU OPCION: ");
        
        //Se recibe la opcion ingresada por el usuario
        opcion = Integer.parseInt(scanner.nextLine());
        
        //Dependiendo la opcion que ingrese el usuario se procede a ejecutar el comando
        switch(opcion){
            case 1:
                System.out.println("Ha seleccionado Agregar una pregunta");
                break;
                
            case 2:
                System.out.println("Ha seleccionado Responder una pregunta");
                break;
                
            case 3:
                System.out.println("Ha seleccionado Dar Recompensa");
                break;
                
            case 4:
                System.out.println("Ha seleccionado Aceptar Respuesta");
                break;
                
            case 5:
                System.out.println("Ha seleccionado Cerrar Sesion");
                break;
                
            case 6:
                System.out.println("Ha seleccionado Salir del programa");
                break;
            
            default:
                System.out.println("Ha ingresado una opcion incorrecta");
        }
        */

    }
}
