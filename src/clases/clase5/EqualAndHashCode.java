package clases.clase5;

import clases.clase4.EjemploPerro;

public class EqualAndHashCode {
    public static void main(String[] args) {
        EjemploPerro.Perro unPerro = new EjemploPerro.Perro();
        unPerro.setNombre("Boby");
        unPerro.setRaza("Labrador");
        unPerro.setTamanio(2);

        EjemploPerro.Perro otroPerro = unPerro;

        System.out.println("HashCode de unPerro: " + unPerro.hashCode());
        System.out.println("HashCode de otroPerro: " + otroPerro.hashCode());

        EjemploPerro.Perro otroPerroMas = new EjemploPerro.Perro();
        otroPerroMas.setNombre("Boby");
        otroPerroMas.setRaza("Labrador");
        otroPerroMas.setTamanio(2);

        System.out.println("HashCode de otroPerroMas: " + otroPerroMas.hashCode());
    }
}
