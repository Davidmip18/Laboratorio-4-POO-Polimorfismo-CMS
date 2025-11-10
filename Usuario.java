package cms.model;

public class Usuario {
    private String id;
    private String nombre;
    private Permiso rol;

    public Usuario(String id, String nombre, Permiso rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public Permiso getRol() { return rol; }
}
