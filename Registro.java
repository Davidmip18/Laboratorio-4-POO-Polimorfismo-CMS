package cms.model;

import java.time.LocalDateTime;

public class Registro {
    private LocalDateTime timestamp;
    private String mensaje;

    public Registro(LocalDateTime timestamp, String mensaje) {
        this.timestamp = timestamp;
        this.mensaje = mensaje;
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public String getMensaje() { return mensaje; }

    @Override
    public String toString() {
        return timestamp + " - " + mensaje;
    }
}
