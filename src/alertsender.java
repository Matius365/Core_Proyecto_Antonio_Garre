import java.io.FileWriter;
import java.io.IOException;

public class alertsender {

    public void sendAlert(emergencyevent event) {

        if (event == null) {
            System.out.println("No hay emergencia que enviar.");
            return;
        }

        String mensaje = "Enviando alerta a los servicios de emergencias: " + event.toString();

        System.out.println(mensaje);

        try (FileWriter writer = new FileWriter("alertas.txt", true)) {
            writer.write(mensaje + System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error al guardar la alerta: " + e.getMessage());
        }
    }
}
