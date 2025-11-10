//clse catalogo
//universidad del valle de guatemala
//Curso: Programacion orientada a objetos
//Laboratorio 7 - Eduardo Isaac 251832
package cms.model;
import java.util.*;
import java.util.stream.Collectors;

public class Catalogo {
    private List<Contenido> contenidos;

    public Catalogo() {
        this.contenidos = new ArrayList<>();
    }

    public void init() {
    }

    public void agregarContenido(Contenido c) {
        if (c != null) contenidos.add(c);
    }

    public List<Contenido> getContenidos() {
        return Collections.unmodifiableList(new ArrayList<>(contenidos));
    }

    public Optional<Contenido> buscarPorId(String id) {
        return contenidos.stream().filter(c -> c.getId().equalsIgnoreCase(id)).findFirst();
    }

    public List<Contenido> buscarPorTitulo(String titulo) {
        return contenidos.stream()
                .filter(c -> c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Contenido> filtrarPorTipo(Class<?> tipo) {
        return contenidos.stream().filter(c -> tipo.isInstance(c)).collect(Collectors.toList());
    }

    public List<Contenido> filtrarPorCategoria(String categoria) {
        return contenidos.stream()
                .filter(c -> c.getCategoria().equalsIgnoreCase(categoria))
                .collect(Collectors.toList());
    }

    public boolean eliminarPorId(String id) {
        Optional<Contenido> opt = buscarPorId(id);
        if (opt.isPresent()) {
            return contenidos.remove(opt.get());
        }
        return false;
    }

    public Map<String, Long> generarResumenPorTipo() {
        return contenidos.stream()
                .collect(Collectors.groupingBy(c -> c.getClass().getSimpleName(), Collectors.counting()));
    }
}
