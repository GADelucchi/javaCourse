package actividadesEnClase.clase4;

public class Actividad1 {
    // Definimos una variable de clase
    private static int miNumero = 10;

    public static void main(String[] args) {
        //  Valor inicial
        System.out.println("El valor inicial es: " + miNumero);

        //  Llamamos al método
        incrementarVariable();

        //  Imprimimos el valor modificado
        System.out.println("El valor modificado es: " + miNumero);

    }

    public static void incrementarVariable() {
        miNumero++;
    }
}
