package clases.clase6;

public class Interfaz {
    public interface Mascota {

        boolean amistosa();

        void jugar();
    }

    public class Perro implements Mascota {
        @Override
        public boolean amistosa() {
            return true;
        }

        @Override
        public void jugar() {
            System.out.println("Juega a traer un palo");
        }
    }

    public class Arania implements Mascota {
        @Override
        public boolean amistosa() {
            return false;
        }

        @Override
        public void jugar() {
            System.out.println("Juega haciendo telas de araña");
        }
    }
}
