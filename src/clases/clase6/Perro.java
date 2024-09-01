package clases.clase6;

public class Perro extends Animal {

    private String raza;

    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad);
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public void hacerSonido() {
        System.out.println("Guau.");
    }

    @Override
    public void jugar() {
        System.out.println(getNombre() + " está jugando.");
    }
}
