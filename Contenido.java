package cms.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Contenido {
    private String id;
    private String titulo;
    private String autor;
    private LocalDateTime fechaCreacion;
    private String categoria;
    private List<String> etiquetas;
    protected boolean publicado;
    private String descripcion;

    public Contenido(String id, String titulo, String autor, LocalDateTime fechaCreacion,
                     String categoria, List<String> etiquetas, String descripcion) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaCreacion = fechaCreacion;
        this.categoria = categoria;
        this.etiquetas = etiquetas == null ? new ArrayList<>() : new ArrayList<>(etiquetas);
        this.descripcion = descripcion;
        this.publicado = false;
    }

    public String getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public boolean isPublicado() { return publicado; }
    public void setPublicado(boolean publicado) { this.publicado = publicado; }
    public String getCategoria() { return categoria; }
    public List<String> getEtiquetas() { return new ArrayList<>(etiquetas); }
    public void agregarEtiqueta(String etiqueta) { if (etiqueta != null) etiquetas.add(etiqueta); }
    public void eliminarEtiqueta(String etiqueta) { etiquetas.remove(etiqueta); }
    public String getDescripcion() { return descripcion; }

    @Override
    public String toString() {
        return String.format("[%s] %s (autor: %s) - categoria: %s - publicado: %s",
                id, titulo, autor, categoria, publicado);
    }

    // Contratos para polimorfismo
    public abstract void publicar();
    public abstract String visualizar();
}
