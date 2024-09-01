package clases;

public class Flujo2 {

	public static void main(String[] args) {
		
		String clima = "lluvios";

		switch (clima) {
			case "soleado": 
				System.out.println("Puedes salir al parque");
				break;
			case "lluvioso": 
				System.out.println("Llevá paraguas");
				break;
			case "nublado": 
				System.out.println("Andá a un museo");
				break;
			case "nevando": 
				System.out.println("Y si hacemos un muñeco");
				break;
			default:
				System.out.println("Ese clima no existe");
				break;
		}
	}

}
