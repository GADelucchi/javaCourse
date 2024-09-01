package clases.clase4;

public class EjemploPerro {

    //  Definimos la clase perro
    public static class Perro {

        //  Definimos atributos
        private int tamanio;
        private String nombre;
        private String raza;

        //  Definomos Getters
        public int getTamanio() {
            return tamanio;
        }

        public String getNombre() {
            return nombre;
        }

        public String getRaza() {
            return raza;
        }

        //  Definimos Setters
        public void setRaza(String raza) {
            this.raza = raza;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setTamanio(int tamanio) {
            this.tamanio = tamanio;
        }

        //  Definomos métodos
        public void ladrar() {
            System.out.println("Guau!");
        };
    };
}
