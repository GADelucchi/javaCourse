package clases.clase5;

public class Main {
    public static void main(String[] args) {
        //  Instanciamos el objeto a partir de la clase creada
        CuentaBancaria cuenta1 = new CuentaBancaria(1500.0, "Carlos");

        CuentaBancaria cuenta2 = new CuentaBancaria(50000.0, "Fernanda");

        System.out.println("Saldo inicial: " + cuenta1.getSaldo());

        //  Retirar dinero
        cuenta1.retirar(500.0);

        System.out.println("Saldo después de retirar: " + cuenta1.getSaldo());
        System.out.println("Titular: " + cuenta1.getTitular());

        cuenta2.retirar(2500.0);

        System.out.println("Saldo después de retirar: " + cuenta2.getSaldo());
        System.out.println("Titular: " + cuenta2.getTitular());

        cuenta1.retirar(-2500.0);

        System.out.println("Saldo después de retirar: " + cuenta1.getSaldo());

        Perro perro = new Perro();
        Gato gato = new Gato();
        Pajaro pajaro = new Pajaro();
        Animal animalito = new Animal();

        perro.hacerSonido();
        gato.hacerSonido();
        pajaro.hacerSonido();
        animalito.hacerSonido();
    }
}
