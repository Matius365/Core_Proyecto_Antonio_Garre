import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Hola. He hecho cambios para poder guardar las emergencias en un fichero json,
tambien he cambiado el nombre de las clases para que coincidan con la convencion Java,
y se han refactorizado. Espero que estos cambios funcionen bien.
 */

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
        EmergencyDetector detector = new EmergencyDetector();
        AlertSender sender = new AlertSender();

        // 1. Detectamos el evento (pregunta al usuario)
        EmergencyEvent evento = detector.detectEvent();

        // 2. Enviamos la alerta (guarda en alertas.txt)
        sender.sendAlert(evento);

        System.out.println("Fin del proceso.");
    }
}