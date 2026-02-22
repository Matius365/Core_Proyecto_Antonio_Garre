import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class emergencyevent {
    private String tipo;
    private String ubicacion;
    private String gravedad;
    private LocalDateTime FechaHora;

    public emergencyevent(String tipo, String ubicacion, String gravedad) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.gravedad = gravedad;
        this.FechaHora = LocalDateTime.now(); //He añadido la fecha y la hora de la emergencia.
    }

    public String getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getGravedad() {
        return gravedad;
    }

    public LocalDateTime getFechaHora(){
        return FechaHora;
    }

    //Damos formato a la fecha y a la hora
    private static final DateTimeFormatter FORMATO =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Override
    public String toString() {
        return "Tipo: " + tipo +
                " | Ubicación: " + ubicacion +
                " | Gravedad: " + gravedad +
                " | Fecha y hora: " + FechaHora.format(FORMATO);//fecha y hora con el formato
    }
}