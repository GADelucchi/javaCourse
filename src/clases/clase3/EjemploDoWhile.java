package clases.clase3;

import java.util.Scanner;

public class EjemploDoWhile {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int opcion;

		do {
//			Mostrar el menu.
			System.out.println("=== Menu ===");
			System.out.println("1. Opción 1");
			System.out.println("2. Opción 2");
			System.out.println("3. Opción 3");
			System.out.println("4. Salir");
			
//			Leer la opción del usuario.
			System.out.println("Selecciona una opción: ");
			
			try {
				String input = scanner.nextLine();
				opcion = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Opción no válida. Intentá de nuevo.");
				opcion = 0; // Fuerza a continuar el bucle.
				continue;
			}
			
//			Procesar la opción seleccionada.
			switch (opcion) {
				case 1:
					System.out.println("Has seleccionado la opción 1.");
//					Lógica para opción 1.
					break;
				case 2:
					System.out.println("Has seleccionado la opción 2.");
//					Lógica para opción 2.
					break;
				case 3:
					System.out.println("Has seleccionado la opción 3.");
//					Lógica para opción 3.
					break;
				case 4:
					System.out.println("Saliendo del programa.");
//					Lógica para opción 4.
					break;
				default:
					System.out.println("Opción no válida, intentá de nuevo.");
			}
			
		} while ( opcion != 4); // Continuar hasta que se seleccione la opción 4.
		
		scanner.close();
		
	}

}
