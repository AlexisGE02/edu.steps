package servicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import controladores.Inicio;
import dtos.Usuarios;




public class EmpleadoImplementacion {
	
	public void crearPrimerEmpleado(String nombre, String contrasenia) {
		Usuarios PrimerEmpleado = new Usuarios();
		PrimerEmpleado.setNombre(nombre);
		PrimerEmpleado.setApellido1("admin.apellido");
		PrimerEmpleado.setContrasenia(contrasenia);
		PrimerEmpleado.setEmail("admin.email.unico");
		PrimerEmpleado.setRol("Empleado");
		PrimerEmpleado.setEsValidado(true);
		Inicio.listaUsuarios.add(PrimerEmpleado);
	}
	
	public void asignarRol(){
		
		if (!Inicio.listaUsuarios.getLast().equals(Inicio.listaUsuarios.getFirst())) {
			
			//Mostrar Lista De Usuarios Cliente
			for (Usuarios c : ordenarListaAsc()) {
				if(!c.getNombre().equals("Admin1")) {
				System.out.println(c.toString());
				}
			}
			
		System.out.println("·Introduzca una opción:");
		System.out.println("·····1. Asignar Rol");
		System.out.println("·····2. Salir");
		byte opcion = Inicio.sc.nextByte();
		String rolIntroducido = "";
			switch(opcion){
				case 1: 
					
					// Pedimos el nombre
				System.out.println("Introduzca el nombre del Usuario al que quiera asignar un nuevo rol");
				String nombreIntroducido = Inicio.sc.next();
				// ToAdd = Controlar que no utilice Admin1
				boolean estaNombreLista = false;
					do {
					for(Usuarios c : Inicio.listaUsuarios) {
						if(c.getNombre().equals(nombreIntroducido) ) {
							if(c.getRol().equals("")) {
								System.out.println("El usuario no tiene ningún rol asignado");
							}else {
								System.out.println("El usuario tiene el rol de "+ c.getRol());
							}
							System.out.println("¿Qué Rol quiere asignarle, 'Empleado' o 'Cliente' ?");
							rolIntroducido = Inicio.sc.next();
							c.setRol(rolIntroducido);
							estaNombreLista = true;
						}
					}
					if (!estaNombreLista) {
						System.out.println(
						"No hay ningun usuario con ese nombre"
						);
					}else{
						System.out.println("Rol actualizado correctamente como " + rolIntroducido );
					}
					}while(!estaNombreLista);
					break;
				case 2:
					System.out.println("Saliendo...");
					break;
				default: 
					System.out.println("La opcion no es valida");
				}
			
		}else {
			System.out.println("Aun no hay usuarios registrados");
		}
		
		
	}
	
	
	
	public void validarCliente() {
		
		if (!Inicio.listaUsuarios.getLast().equals(Inicio.listaUsuarios.getFirst())) {
		
			for (Usuarios c : ordenarListaAsc()) {
				if(!c.getNombre().equals("Admin1")) {
				System.out.println(c.toString());
				}
			}
		System.out.println("·Introduzca una opción:");
		System.out.println("·····1. Validar Cliente");
		System.out.println("·····2. Salir");
		byte opcion = Inicio.sc.nextByte();
			
			switch(opcion){
				case 1: 
					
				System.out.println("Introduzca el Dni del cliente que quiera validar");
				String dniIntroducido = Inicio.sc.next();
				boolean estaDniLista = false;
					do {
					for(Usuarios c : Inicio.listaUsuarios) {
						if(c.getDni().equals(dniIntroducido) ) {
							c.setEsValidado(true);
							estaDniLista = true;
						}
					}
					if (!estaDniLista) {
						System.out.println(
						"No se ha encontrado ese Dni en ningun usuario que no esté validado"
						);
					}else{
						System.out.println("Cliente validado correctamente");
					}
					}while(!estaDniLista);
					break;
				case 2:
					System.out.println("Saliendo...");
					break;
				default: 
					System.out.println("La opcion no es valida");
				}
			
		}else {
			System.out.println("Aun no hay clientes registrados");
		}
		
	
	}
	
	public boolean borrarCliente() {
		Usuarios usuarios = new Usuarios();
		boolean esDniValidado = false; 
		boolean existeDni = false; 
		String dniValido = "";
		
		if (!Inicio.listaUsuarios.getLast().equals(Inicio.listaUsuarios.getFirst())) {
			
			//Muestra la lista de clientes
			for (Usuarios c : Inicio.listaUsuarios) {
				System.out.println(c.toString());
			}
			
			do {
			System.out.println("Introduzca el Dni del cliente que quiera borrar");
			String Dni = Inicio.sc.next(); 
				if(ClienteImplementacion.validarDni(Dni)) {
						if(comprobarDniExiste(Dni)) {
							existeDni = true;
							dniValido = Dni;
					}
					esDniValidado = true; 
						
				}else {
				System.out.println("El Dni introducido no es válido, pruebe de nuevo");	
				}
			}while(!esDniValidado);
			
			if(existeDni) {
				for (Usuarios c : Inicio.listaUsuarios) {
					if(c.getDni().equals(dniValido)) {
						usuarios = c;
					}
				}
				Inicio.listaUsuarios.remove(usuarios);
				System.out.println("Cliente borrado correctamente");
			}else {
				System.out.println("El Dni introducido no existe");
			}
			
		}else{
			System.out.println("Aun no hay clientes registrados");
		}
		return true;
	}
	
	private boolean comprobarDniExiste(String Dni) {
		boolean coinciden = false;
		for (Usuarios c : Inicio.listaUsuarios) {
			if (c.getDni().equals(Dni)) {
				coinciden = true;
			}
		}
		return coinciden;
	}
	
	
	public static ArrayList<Usuarios> ordenarListaAsc() {
		
		ArrayList<Usuarios> listaClientesOrdenada = new ArrayList<>(Inicio.listaUsuarios);
		listaClientesOrdenada.sort(Comparator.comparing(Usuarios::getApellido1));
		
		return listaClientesOrdenada;
	}

	public static List<Usuarios> ordenarListaDesc() {
			
			ArrayList<Usuarios> listaClientesOrdenada = new ArrayList<>(Inicio.listaUsuarios);
			listaClientesOrdenada.sort(Comparator.comparing(Usuarios::getApellido1));
			
			return  listaClientesOrdenada.reversed();
	}

	public void mostrarClientes(){
			if (!Inicio.listaUsuarios.getLast().equals(Inicio.listaUsuarios.getFirst())) {
				System.out.println("¿En qué orden quiere mostrar la lista?");
				System.out.println("··1) A-Z ···");
				System.out.println("··2) Z-A ···");
				byte opcion = Inicio.sc.nextByte();
				switch (opcion) { 
				case 1: 
					for (Usuarios c : ordenarListaAsc()) {
						if(!c.getNombre().equals("Admin1")) {
						System.out.println(c.toString());
						}
					}
					break;
				case 2:
					for (Usuarios c : ordenarListaDesc()) {
						if(!c.getNombre().equals("Admin1")) {
						System.out.println(c.toString());
						}
					}
					break;
				default:
					System.out.println("Opción no válida");
						
				}
				
				
			}else{
				System.out.println("No hay clientes para mostrar");
			}
	}
}

