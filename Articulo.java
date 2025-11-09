package cms.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Articulo extends Contenido {
    private String texto;
    private String resumen;
    private List<Registro> registros;

    public Articulo(String id, String titulo, String autor, LocalDateTime fechaCreacion,
                    String categoria, List<String> etiquetas, String descripcion,
                    String texto, String resumen) {
        super(id, titulo, autor, fechaCreacion, categoria, etiquetas, descripcion);
        this.texto = texto;
        this.resumen = resumen;
        this.registros = new ArrayList<>();
    }

    @Override
    public void publicar() {
        setPublicado(true);
        registrar("Artículo publicado: " + getTitulo());
    }

    public String obtenerResumenPublicacion() {
        return String.format("Artículo '%s' por %s — %s", getTitulo(), getAutor(), resumen);
    }

    @Override
    public String visualizar() {
        return resumen + "\n\n" + (texto.length() > 500 ? texto.substring(0, 500) + "..." : texto);
    }

    public void registrar(String mensaje) {
        registros.add(new Registro(LocalDateTime.now(), mensaje));
    }

    public List<Registro> getRegistros() { return new ArrayList<>(registros); }

    @Override
    public String toString() {
        return super.toString() + " [Articulo]";
    }
}
