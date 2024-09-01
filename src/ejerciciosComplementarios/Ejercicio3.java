package ejerciciosComplementarios;

public class Ejercicio3 {

    public static void main(String[] args) {
        int[] array1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] array2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        boolean inversamenteIguales = true;

        if (array1.length == array2.length) {
            for (int i = 0; i <= array1.length - 1; i++) {
//  Comparamos el primer elemento de array1 con el último de array2
                if (array1[i] != array2[array2.length - 1 - i]) {
                    inversamenteIguales = false;
                    break;
                }
            }
        } else {
            System.out.println("los arrays no tienen la misma longitud");
        }


//        Imprimimos el resultado
        if (inversamenteIguales) {
            System.out.println("Los arrays son inversamente iguales.");
        } else {
            System.out.println("Los arrays son diferentes.");
        }
    }
}
