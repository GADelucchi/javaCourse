package clases.clase6;

public class Main {

    public static void main(String[] args) {

        Perro miPerro = new Perro("Pepe", 10, "Labrador");
        Gato miGato = new Gato("Michi", 3, "Naranja");

        miPerro.hacerSonido();
        miGato.hacerSonido();

        miPerro.jugar();
        miGato.ronronear();
    }
}
