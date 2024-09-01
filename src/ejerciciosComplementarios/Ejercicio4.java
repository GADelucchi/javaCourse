package ejerciciosComplementarios;

import java.util.Scanner;

public class Ejercicio4 {
    public static int suma1;
    public static int suma2;

    //    Método para encontrar el máximo valor en un arreglo
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    //    Método para encontrar el mínimo valor en un arreglo
    public static int findMin(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño de los arreglos: ");
        int size = scanner.nextInt();

        int[] array1 = new int[size];
        int[] array2 = new int[size];

//        Cargar el primer arreglo
        System.out.println("Ingrese los elementos del primer arreglo:");
        for (int i = 0; i < size; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            array1[i] = scanner.nextInt();
        }

//        Cargar el segundo arreglo
        System.out.println("Ingrese los elementos del segundo arreglo:");
        for (int i = 0; i < size; i++) {
            System.out.print("Elemento " + (i + 1) + ": ");
            array2[i] = scanner.nextInt();
        }

//        Sumar elementos de array1
        for (int i = 0; i < size; i++) {
            suma1 = suma1 + array1[i];
            suma2 = suma2 + array2[i];
        }

        System.out.println("Suma array1: " + suma1);
        System.out.println("Suma array2: " + suma2);

//        Encontrar el mayor y menor número en ambos arreglos
        int maxArray1 = findMax(array1);
        int minArray1 = findMin(array1);
        int maxArray2 = findMax(array2);
        int minArray2 = findMin(array2);

//        Comparar y mostrar los resultados
        if (maxArray1 > maxArray2) {
            System.out.println("El mayor número está en el primer arreglo: " + maxArray1);
        } else if (maxArray1 < maxArray2) {
            System.out.println("El mayor número está en el segundo arreglo: " + maxArray2);
        } else {
            System.out.println("Ambos arreglos tienen el mismo mayor número: " + maxArray1);
        }

        if (minArray1 < minArray2) {
            System.out.println("El menor número está en el primer arreglo: " + minArray1);
        } else if (minArray1 > minArray2) {
            System.out.println("El menor número está en el segundo arreglo: " + minArray2);
        } else {
            System.out.println("Ambos arreglos tienen el mismo menor número: " + minArray1);
        }

//        Cerramos el Scanner
        scanner.close();
    }

}
