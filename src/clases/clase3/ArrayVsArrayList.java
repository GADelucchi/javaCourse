package clases.clase3;

import java.util.ArrayList;
import java.util.List;

public class ArrayVsArrayList {

	public static void main(String[] args) {
		
		int[] numeros = {1, 2, 3, 4, 5, 6, 7};
		
		System.out.println("Elemento del array:");
		
		for (int numero : numeros) {
			System.out.println(numero);
		}
		
		List<Integer> listaNumeros = new ArrayList<>();
		
		listaNumeros.add(1);
		listaNumeros.add(2);
		listaNumeros.add(3);
		listaNumeros.add(4);
		listaNumeros.add(5);
		
		System.out.println("Elementos en arrayList:");
		
		for (int numero : listaNumeros) {
			System.out.println(numero);
		}
		
		listaNumeros.add(16);
		
		System.out.println(listaNumeros);
		
		System.out.println(listaNumeros.get(5));
		
		listaNumeros.remove(Integer.valueOf(3));
		
		for (int numero : listaNumeros) {
			System.out.println(numero);
		}
		
		int tamanio = listaNumeros.size();
		
		System.out.println("El tamaño de la lista es de: " + tamanio);
		
		boolean contiene = listaNumeros.contains(5);
		
		System.out.println("El número 15 está?: " + contiene);
		System.out.println("El número 5 está?: " + contiene);
		
		System.out.println("El elemento en la posición 2 es: " + listaNumeros.get(2));
		
		listaNumeros.set(2, 99);
		
		System.out.println("El elemento en la posición 2 ahora es: " + listaNumeros.get(2));
	}
		

}
