public class emergencyevent {
    private String tipo;
    private String ubicacion;

    // Constructor
    public emergencyevent(String tipo, String ubicacion) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
    }

//get y set

    public String gettipo() {
        return tipo;
    }

    public String getubicacion() {
        return ubicacion;
    }

    public String toString() {
        return "Tipo: " + tipo +
                ", Ubicación: " + ubicacion;
    }
}