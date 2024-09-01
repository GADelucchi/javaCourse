package clases.clase5;

public class Animal {
    public void hacerSonido() {
        System.out.println("Sonido de animal");
    }
}

class Perro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Guau");
    }
}

class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Miau");
    }
}

class Pajaro extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Pio");
    }
}