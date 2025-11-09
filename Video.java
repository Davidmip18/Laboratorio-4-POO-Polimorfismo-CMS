package cms.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Video extends Contenido {
    private String url;
    private int duracionSegundos;
    private String miniatura;
    private List<Registro> registros;

    public Video(String id, String titulo, String autor, LocalDateTime fechaCreacion,
                 String categoria, java.util.List<String> etiquetas, String descripcion,
                 String url, int duracionSegundos, String miniatura) {
        super(id, titulo, autor, fechaCreacion, categoria, etiquetas, descripcion);
        this.url = url;
        this.duracionSegundos = duracionSegundos;
        this.miniatura = miniatura;
        this.registros = new ArrayList<>();
    }

    @Override
    public void publicar() {
        setPublicado(true);
        registrar("Video publicado: " + getTitulo());
    }

    @Override
    public String obtenerResumenPublicacion() {
        return String.format("Video '%s' (%ds) por %s", getTitulo(), duracionSegundos, getAutor());
    }

    @Override
    public String visualizar() {
        return "Reproducir: " + url + " (duración " + duracionSegundos + "s)";
    }

    public void registrar(String mensaje) {
        registros.add(new Registro(LocalDateTime.now(), mensaje));
    }

    public List<Registro> getRegistros() { return new ArrayList<>(registros); }

    @Override
    public String toString() {
        return super.toString() + " [Video]";
    }
}
