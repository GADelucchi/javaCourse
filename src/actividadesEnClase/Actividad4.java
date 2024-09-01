package actividadesEnClase;

import java.util.ArrayList;
import java.util.List;

public class Actividad4 {

	public static void main(String[] args) {
		
//		Declarar la lista.
		List<Integer> numerosAleatorios = new ArrayList<>();
		
//		Agregar números aleatorios.		
		for (int i = 0; i <= 9; i++) {
			numerosAleatorios.add((int) (Math.random() * 100) + 1);
		}
		
//		Mostrar los números aleatorios.
		System.out.println(numerosAleatorios);
		
//		Mostrar los restos.
		for (int i = 0; i < numerosAleatorios.size(); i++) {
			System.out.println("El resto de " + numerosAleatorios.get(i) + " y 3 es " + numerosAleatorios.get(i) % 3);
		}
		
//		Declarar variable para iterar.
		int i = 0;
		
//		Declarar while para recorrer.
		while (numerosAleatorios.get(i) % 3 != 0 && i < numerosAleatorios.size()) {
			System.out.println(numerosAleatorios.get(i));
			i++;
		}
		
//		Imprimir el último número que es múltiplo de 3.
		if (numerosAleatorios.get(i) % 3 == 0 && i < numerosAleatorios.size()) {
			System.out.println(numerosAleatorios.get(i));			
		}

	}

}
