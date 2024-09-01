package actividadesEnClase;

public class Actividad1 {

	public static void main(String[] args) {
		
		int capitalSolicitado = 10;
		
		double interes = capitalSolicitado * 1.50;
		
		int periodoDeMeses = 3;
		
		double interesAPagar = capitalSolicitado * interes * periodoDeMeses;
		
		System.out.println("El monto total a pagar al banco es " + interesAPagar);

	}

}
