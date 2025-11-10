
//clse main
//universidad del valle de guatemala
//Curso: Programacion orientada a objetos
//Laboratorio 7 - Eduardo Isaac 251832
package cms.app;

import cms.controller.ControladorCatalogo;
import cms.model.*;
import cms.view.VistaConsola;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Catalogo catalogo = new Catalogo();
        VistaConsola vista = new VistaConsola();
        ControladorCatalogo controlador = new ControladorCatalogo(catalogo, vista);


        controlador.iniciarCatalogo();
//ejemplo
        Articulo a = new Articulo("c00","Poo introduccion", LocalDateTime.now(),
                "clase", Arrays.asList("poo","java"), "articulo sobre poo",
                "contenido largo", "resumen");
        controlador.agregarContenido(a);

//usuario ejemplo
        Usuario admin = new Usuario("ui","admin",Permiso.ADMIN);

        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.print(vista.generarMenuPrincipal());
            String opt = sc.nextLine();
            switch (opt) {
                case "1":
                    System.out.println(controlador.listarResumen());
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("opcion no vlida");
            }
        }
        sc.close();
    }
}
