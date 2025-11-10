//clse controlador catalogo
//universidad del valle de guatemala
//Curso: Programacion orientada a objetos
//Laboratorio 7 - Eduardo Isaac 251832
package cms.controller;

import cms.model.*;
import cms.view.VistaConsola;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ControladorCatalogo {
    private Catalogo catalogo;
    private VistaConsola vista;

    public ControladorCatalogo(Catalogo catalogo, VistaConsola vista) {
        this.catalogo = catalogo;
        this.vista = vista;
    }

    public void iniciarCatalogo() {
        catalogo.init(); 
    }

    public String listarResumen() {
        return vista.generarListado(catalogo.getContenidos());
    }

    public Optional<Contenido> buscarPorId(String id) {
        return catalogo.buscarPorId(id);
    }

    public List<Contenido> buscarPorTitulo(String titulo) {
        return catalogo.buscarPorTitulo(titulo);
    }

    public void agregarContenido(Contenido c) {
        catalogo.agregarContenido(c);
    }

    public boolean eliminarContenido(String id, Usuario user) {
//permisos
        if (user.getRol() != Permiso.ADMIN) {
            return false;
        }
        return catalogo.eliminarPorId(id);
    }

    public Map<String, Long> generarReportePorTipo() {
        return catalogo.generarResumenPorTipo();
    }
}
