package clases.clase3;

import java.util.ArrayList;
import java.util.List;

public class ForVsForMejoradoVsForEach {

	public static void main(String[] args) {
		
//		Creamos el Array
		int[] numeros = {1,2,3,4,5,6,7};
		
		
//		Creamos la ArrayList
		List<Integer> listaNumeros = new ArrayList<>();
		
		listaNumeros.add(1);
		listaNumeros.add(2);
		listaNumeros.add(3);
		listaNumeros.add(4);
		listaNumeros.add(5);
		listaNumeros.add(6);
		listaNumeros.add(7);
		
		
//		For. Sirve para repetir cosas la cantidad de veces que quieras (solo funciona con Arrays a menos que se use el Iterator en ArrayList o ArrayList.size).
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Número en Array.lenght: " + numeros[i]);
		}
		
		for (int i = 0; i < listaNumeros.size(); i++) {
			System.out.println("Número en ArrayList.size: " + listaNumeros.get(i));
		}

		
//		En este ejemplo no recorrería todo el Array porque le pasamos que vaya solo hasta la posición 5
		for (int i = 0; i < 5; i++) {
			System.out.println("Número en for sin .length: " + numeros[i]);
		}			

		
//		ForMejorado. Funciona solo con Arrays o ArrayLists.
		for (int numero : numeros) {
			System.out.println("Número en forMejorado: " + numero);
		}
		
		for (int numero : listaNumeros) {
			System.out.println("Número en forMejorado: " + numero);
		}
		
		
//		ForEach. Nueva forma que aparece a partir de Java8, solo funciona con ArrayLists.
		listaNumeros.forEach(numero -> {
			System.out.println("Número en forEach: " + numero);
			
		});
		
	}

}
