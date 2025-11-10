package cms.view;

import cms.model.Contenido;
import java.util.List;

public class VistaConsola {

    public String generarListado(List<Contenido> contenidos) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-6s %-30s %-12s %-10s%n", "ID", "Titulo", "Autor", "Publicado"));
        sb.append("----------------------------------------------------------------\n");
        for (Contenido c : contenidos) {
            sb.append(String.format("%-6s %-30s %-12s %-10s%n",
                    c.getId(), c.getTitulo(), c.getAutor(), c.isPublicado()));
        }
        return sb.toString();
    }

    public String generarDetalle(Contenido c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c.toString()).append("\n");
        sb.append("Categoria: ").append(c.getCategoria()).append("\n");
        sb.append("Etiquetas: ").append(c.getEtiquetas()).append("\n");
        sb.append("Visualizar: ").append(c.visualizar()).append("\n");
        return sb.toString();
    }

    public String generarMenuPrincipal() {
        return "1) Listar contenidos\n2) Crear contenido\n3) Editar contenido\n4) Eliminar contenido\n5) Buscar por id\n6) Filtrar por tipo\n7) Reporte por tipo\n0) Salir\nSelecciona: ";
    }
}
