import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<CentroSalud> misCentros = new ArrayList<>();

        try {

            ObjectMapper lector = new ObjectMapper();

            CentroSalud[] datosArray = lector.readValue(new File("CentrosdeSalud.json"), CentroSalud[].class);

            misCentros.addAll(Arrays.asList(datosArray));

            System.out.println("Datos cargados correctamente.");
            System.out.println("Total de centros importados: " + misCentros.size());

            for (CentroSalud centro : misCentros) {
                System.out.println(centro);
            }

        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
        emergencydetector detector = new emergencydetector();
        alertsender sender = new alertsender();

        // 1. Detectamos el evento (pregunta al usuario)
        emergencyevent evento = detector.detectEvent();

        // 2. Enviamos la alerta (guarda en alertas.txt)
        sender.sendAlert(evento);

        System.out.println("Fin del proceso.");
    }
}