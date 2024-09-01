package clases.clase4;

public class Main {
    public static void main(String[] args) {
        //  Instanciamos la clase que creamos
        EjemploPerro.Perro perro1 = new EjemploPerro.Perro();

        //  Le "cargamos" los atributos
        perro1.setNombre("Boby");
        perro1.setTamanio(2);
        perro1.setRaza("Callejero");

        System.out.println("El perro " + perro1.getNombre() + " es un " + perro1.getRaza() + " de " + perro1.getTamanio() + " años.");

        System.out.println("Cuando el perro ladra dice ");
        perro1.ladrar();


        //  Instanciamos el objeto a partir de la clase creada
        CuentaBancaria cuenta1 = new CuentaBancaria();

        CuentaBancaria cuenta2 = new CuentaBancaria();

        cuenta1.setSaldo(1500.0);

        cuenta2.setSaldo(50000.0);

        System.out.println("Saldo inicial: " + cuenta1.getSaldo());

        //  Retirar dinero
        cuenta1.retirar(500.0);

        System.out.println("Saldo despues de retirar: " + cuenta1.getSaldo());

        cuenta1.retirar(2500.0);

        System.out.println("Saldo despues de retirar: " + cuenta1.getSaldo());

        cuenta1.retirar(-2500.0);

        System.out.println("Saldo despues de retirar: " + cuenta1.getSaldo());

    }
}
