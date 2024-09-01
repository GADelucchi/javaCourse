package actividadesEnClase.clase6;

import java.util.ArrayList;
import java.util.List;

public class ListarPersonas {

    public static class Persona {

        private String nombre;
        private String apellido;

        public Persona(String nombre, String apellido) {
            this.nombre = nombre;
            this.apellido = apellido;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getApellido() {
            return apellido;
        }

        public void setApellido(String apellido) {
            this.apellido = apellido;
        }
    };

    public static void main(String[] args) {
        ListarPersonas.Persona persona1 = new ListarPersonas.Persona("Gastón", "Deluchi");
        ListarPersonas.Persona persona2 = new ListarPersonas.Persona("Melina", "Beguiristain");
        ListarPersonas.Persona persona3 = new ListarPersonas.Persona("Fabiana", "Marmissolle");
        ListarPersonas.Persona persona4 = new ListarPersonas.Persona("Claudia", "Colman");
        ListarPersonas.Persona persona5 = new ListarPersonas.Persona("Irma", "Ale");

        List<Persona> listaPersonas = new ArrayList<>();

        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);
        listaPersonas.add(persona4);
        listaPersonas.add(persona5);

        listaPersonas.sort((p1, p2) -> {
            int cmp = p1.getNombre().compareTo(p2.getNombre());
            if (cmp == 0) {
                cmp = p1.getApellido().compareTo(p2.getApellido());
            }
            return cmp;
        });

        for (ListarPersonas.Persona persona : listaPersonas) {
            System.out.println(persona.getNombre() + " " + persona.getApellido());
        }

        listaPersonas.sort((p1, p2) -> {
            int cmp = p1.getApellido().compareTo(p2.getApellido());
            if (cmp == 0) {
                cmp = p1.getNombre().compareTo(p2.getNombre());
            }
            return cmp;
        });

        for (ListarPersonas.Persona persona : listaPersonas) {
            System.out.println(persona.getApellido() + " " + persona.getNombre());
        }

        listaPersonas.sort((p1, p2) -> {
            int cmp = p1.getApellido().compareTo(p2.getApellido());
            if (cmp == 0) {
                cmp = p1.getNombre().compareTo(p2.getNombre());
            }
            return cmp;
        });

        for (ListarPersonas.Persona persona : listaPersonas.reversed()) {
            System.out.println(persona.getApellido());
        }
    }
}
