package servicios;

import controladores.Inicio;
import dtos.Cliente;




public class EmpleadoImplementacion {
	
	public void validarCliente() {
		
		if (!Inicio.listaClientes.isEmpty()) {
		
			for (Cliente c : Inicio.listaClientes) {
				if(!c.getEsValidado()) {
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
					for(Cliente c : Inicio.listaClientes) {
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
		Cliente cliente = new Cliente();
		boolean esDniValidado = false; 
		boolean existeDni = false; 
		String dniValido = "";
		
		if (!Inicio.listaClientes.isEmpty()) {
			
			//Muestra la lista de clientes
			for (Cliente c : Inicio.listaClientes) {
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
				for (Cliente c : Inicio.listaClientes) {
					if(c.getDni().equals(dniValido)) {
						cliente = c;
					}
				}
				Inicio.listaClientes.remove(cliente);
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
		for (Cliente c : Inicio.listaClientes) {
			if (c.getDni().equals(Dni)) {
				coinciden = true;
			}
		}
		return coinciden;
	}
	
	public void mostrarClientes(){
			if (!Inicio.listaClientes.isEmpty()) {
			
				//Muestra la lista de clientes
				for (Cliente c : Inicio.listaClientes) {
					System.out.println(c.toString());
				}
			}else{
				System.out.println("No hay clientes para mostrar");
			}
	}
}

