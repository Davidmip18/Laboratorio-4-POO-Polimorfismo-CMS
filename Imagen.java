package cms.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Imagen extends Contenido {
    private String url;
    private String resolucion;
    private List<Registro> registros;

    public Imagen(String id, String titulo, String autor, LocalDateTime fechaCreacion,
                  String categoria, List<String> etiquetas, String descripcion,
                  String url, String resolucion) {
        super(id, titulo, autor, fechaCreacion, categoria, etiquetas, descripcion);
        this.url = url;
        this.resolucion = resolucion;
        this.registros = new ArrayList<>();
    }

    @Override
    public void publicar() {
        setPublicado(true);
        registrar("Imagen publicada: " + getTitulo());
    }

    @Override
    public String obtenerResumenPublicacion() {
        return String.format("Imagen '%s' resolucion: %s", getTitulo(), resolucion);
    }

    @Override
    public String visualizar() {
        return "Mostrar imagen: " + url + " (" + resolucion + ")";
    }

    public void registrar(String mensaje) {
        registros.add(new Registro(LocalDateTime.now(), mensaje));
    }

    public List<Registro> getRegistros() { return new ArrayList<>(registros); }

    @Override
    public String toString() {
        return super.toString() + " [Imagen]";
    }
}
