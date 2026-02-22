import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlertSender {

    private static final String FILE_PATH = "alertas.json";

    public void sendAlert(EmergencyEvent event) {

        if (event == null) {
            System.out.println("No hay emergencia que enviar.");
            return;
        }
        System.out.println("Enviando alerta: " + event);
        //cambiamos el metodo para crear el JSON
//        String mensaje = "Enviando alerta a los servicios de emergencias: " + event.toString();
//
//        System.out.println(mensaje);
//
//        try (FileWriter writer = new FileWriter("alertas.txt", true)) {
//            writer.write(mensaje + System.lineSeparator());
//        } catch (IOException e) {
//            System.out.println("Error al guardar la alerta: " + e.getMessage());
//        }
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT); // Para que quede bonito

        try {

            File file = new File(FILE_PATH);
            List<EmergencyEvent> listaEventos = new ArrayList<>();

            // Si el archivo ya existe, leemos lo que hay
            if (file.exists()) {
                EmergencyEvent[] eventosArray =
                        mapper.readValue(file, EmergencyEvent[].class);
                listaEventos = new ArrayList<>(Arrays.asList(eventosArray));
            }

            // Añadimos el nuevo evento
            listaEventos.add(event);

            // Guardamos todo otra vez
            mapper.writeValue(file, listaEventos);

            System.out.println("Alerta guardada correctamente.");

        } catch (IOException e) {
            System.out.println("Error al guardar la alerta: " + e.getMessage());
        }

    }
}
