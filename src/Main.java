public class Main {

    public static void main(String[] args) {

        emergencydetector detector = new emergencydetector();
        alertsender sender = new alertsender();

        emergencyevent evento = detector.detectEvent();

        sender.sendAlert(evento);

        System.out.println("Alerta envíada con éxito.");
    }
}
