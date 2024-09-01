package clases.clase6;

public class Animal implements Sonido {

    private String nombre;
    private int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public void hacerSonido() {
        System.out.println("Sonido genérico de animal.");
    }

    public void jugar() {
        System.out.println("Juego genérico.");
    }
}
