import java.util.Scanner;

public class EmergencyDetector {

    public EmergencyEvent detectEvent() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("¿Hay alguna emergencia? (S/N)");
        String respuesta = scanner.nextLine();

        if (!respuesta.equalsIgnoreCase("s")) {
            System.out.println("No se han detectado emergencias.");
            return null;
        }

        System.out.println("Tipo de emergencia: ");
        String tipo = scanner.nextLine();

        System.out.println("Ubicación donde se encuentra: ");
        String ubicacion = scanner.nextLine();

        System.out.print("Nivel de gravedad (baja/alta): ");
        String gravedad = scanner.nextLine();

        return new EmergencyEvent(tipo, ubicacion, gravedad);
    }
}
