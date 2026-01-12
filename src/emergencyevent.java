public class emergencyevent {
    private String tipo;
    private String ubicacion;
    private String gravedad;

    public emergencyevent(String tipo, String ubicacion, String gravedad) {
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.gravedad = gravedad;
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

    @Override
    public String toString() {
        return "Tipo: " + tipo + " | Ubicación: " + ubicacion + " | Gravedad: " + gravedad;
    }
}