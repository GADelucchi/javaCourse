package clases.clase4;

public class Edificio {
    // Variable estática, constante y de clase
    private static final int CANTIDAD_MAXIMA_PISOS = 50;

    //  Variable de instancia o de objeto
    private int cantidadPisos;

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) throws Exception {
        // Variable local
        String mensajeDeError = "Un edificio no puede tener más de " + CANTIDAD_MAXIMA_PISOS + " pisos.";

        if (cantidadPisos > CANTIDAD_MAXIMA_PISOS) {
            throw new Exception(mensajeDeError);
        } else {
            this.cantidadPisos = cantidadPisos;
        }
    }
}
