import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class emergencyevent {
    private String tipo;
    private String ubicacion;
    private String gravedad;
    private String fechaHora;

    //cambiamos la forma de guardar las alertas a JSON
    public emergencyevent(String tipo, String ubicacion, String gravedad) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.gravedad = gravedad;

        //Damos formato a la fecha y a la hora
        DateTimeFormatter FORMATO =
                DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.fechaHora = LocalDateTime.now().format(FORMATO); //He añadido la fecha y la hora de la emergencia.
    }
    //constructor vacio para el JSON
    public emergencyevent(){
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

    public String getFechaHora(){
        return fechaHora;
    }


    @Override
    public String toString() {
        return "Tipo: " + tipo +
                " | Ubicación: " + ubicacion +
                " | Gravedad: " + gravedad +
                " | Fecha y hora: " + fechaHora;//fecha y hora con el formato
    }
}