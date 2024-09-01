package edu.coder.Preentrega;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Preentrega implements CommandLineRunner {

	@Autowired
	private DaoFactory daoFactory;

	public static void main(String[] args) {
		SpringApplication.run(Preentrega.class, args);
		System.out.println("Aplicación levantada");
	}

	@Override
	public void run(String... args) throws Exception {
		try {
			// Crear un cliente
			Cliente cliente1 = new Cliente("Melina", "Beguiristain", 41705571);

			// Crear un domicilio
			Domicilio domicilioParticular = new Domicilio("50", 1559, 3, "B", "1900", "La Plata", "Buenos Aires");
			Domicilio domicilioLaboral = new Domicilio("4", 924, 0, "Local", "1900", "La Plata", "Buenos Aires");

			// Asignamos el cliente a los dos domicilios
			domicilioParticular.setCliente(cliente1);
			domicilioLaboral.setCliente(cliente1);

			// Asignamos los domicilios al cliente
			List<Domicilio> domicilios = new ArrayList<Domicilio>();
			domicilios.add(domicilioParticular);
			domicilios.add(domicilioLaboral);

			cliente1.setDomicilio(domicilios);

			// Crear cliente en el factory
			daoFactory.create(cliente1);

			// Buscar cliente guardado
			Cliente clienteGuardado = daoFactory.getCliente(cliente1);
			imprimirCliente(clienteGuardado, "Cliente guardado: ");

			// Modificar cliente guardado
			modificarCliente(clienteGuardado);

			// Buscar cliente modificado
			Cliente clienteModificado = daoFactory.getCliente(clienteGuardado);
			imprimirCliente(clienteModificado, "Cliente clienteModificado: ");




		} catch (Exception e) {
			// Manejo de errores
			System.out.println("Ocurrió un error durante la ejecución: " + e.getMessage());
		}
	}

	private void modificarCliente(Cliente clienteGuardado) {
		// Modifico un dato del cliente
		clienteGuardado.setNombre("Juan Pedro");
		clienteGuardado.setApellido("JRodriguez");
		daoFactory.update(clienteGuardado);
	}

	private void imprimirCliente(Cliente clienteGuardado, String s) {
		System.out.println("--------------------------");
		System.out.println(s + clienteGuardado.toString());
	}

}
