package ejerciciosComplementarios;

public class Ejercicio2 {

	public static void main(String[] args) {

		int edad = 18;
		
		if (edad <= 2) {
			System.out.println("Estás en estapa bebé");
		} else if (edad > 2 && edad <= 8) {
			System.out.println("Estás en estapa niño");			
		} else if (edad > 8 && edad <= 13) {
			System.out.println("Estás en estapa preadolescente");	
		} else if (edad > 13 && edad < 18) {
			System.out.println("Estás en estapa adolescente");	
		} else if (edad >= 18 && edad < 60) {
			System.out.println("Estás en estapa adulto");				
		}else if (edad >= 60) {
			System.out.println("Estás en estapa adulto mayor");							
		}
	}
}
