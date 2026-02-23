package servicios;



import controladores.Inicio;
import dtos.Cliente;

public class ClienteImplementacion {
	
	private long idNuevo() {
		
		long idLista = 0;
		if (!Inicio.listaClientes.isEmpty()) {
			idLista=Inicio.listaClientes.getLast().getId();
		}
		return idLista++;
	}
	

	//Metodo que imprime por pantalla lo que le metas por el parámetro como un String
	
	public static void pt(String msg) {
		System.out.print(msg);
	}
	public static void ptln(String msg) {
		System.out.println(msg);
	}

	public void registroCliente(){
		
		pt("Hola");
		
	    Cliente nuevoCliente = new Cliente(); 
	    
	    // Id Autonumérico
	    idNuevo();
	    
	    //Nombre completo
	    Inicio.sc.nextLine();
		pt("Introduzca su nombre completo separado por comas: \n(Nombre,Apellido,Apellido)");
		String nombreCompleto = Inicio.sc.nextLine();
		String[] partes = nombreCompleto.split(",");
		
		nuevoCliente.setNombre(partes[0]);
		nuevoCliente.setApellido1(partes[1]);
		nuevoCliente.setApellido2(partes[2]);
		
		
		// Dni
		boolean esDniValido = false;
		
		do {
			
		System.out.println("Introduzca su Dni Completo");
		String DniIntroducido = Inicio.sc.next().toUpperCase();
		if (validarDni(DniIntroducido)) {
			esDniValido = true;
			nuevoCliente.setDni(DniIntroducido);
		}else {System.out.println("Dni no Válido, introduzcalo de nuevo");}
		}while(!esDniValido);
		
		// Correo Y Contraseña
		
		boolean esCorrecto = false;
		do {
			System.out.println("Introduzca su Email");
			String email = Inicio.sc.next();
			System.out.println("Introduzca su contraseña");
			String contraseña = Inicio.sc.next();
			
		if (!comprobarEmailYContrasenia(email, contraseña)) {
			nuevoCliente.setEmail(email);
			nuevoCliente.setContrasenia(contraseña);
			System.out.println("Usuario registrado");
			esCorrecto = true;
		}else {
			System.out.println("El email ya existe, pruebe con otro");
		}
		}while(!esCorrecto);
		
		Inicio.listaClientes.add(nuevoCliente);
		
	}
	
	
	
	
	
	
	public boolean accesoCliente() {
		boolean esCerrado = false;
		int intentos = 0;
		do {
			System.out.println("Introduzca su Email");
			String email = Inicio.sc.next();
			
			System.out.println("Introduzca su contraseña");
			String contraseña = Inicio.sc.next();
			
			if (comprobarEmailYContrasenia(email, contraseña)) {
					System.out.println("Inicio de sesión correcto");
					esCerrado = true;
				}else {
					intentos+=1;
					System.out.println("Los datos introducidos no corresponden");
					System.out.println("Le quedan "+(3-intentos)+" intentos");
				}
			if (intentos == 3) {
				esCerrado = true;
			}
		}while((!esCerrado));
		
		if (intentos == 3) {
			System.out.println("Se han agotado sus intentos, pruebe más tarde...");
		}
		return esCerrado;
		
	}
	public static boolean validarDni(String dni) {
				
		if (!dni.matches("^[0-9]{8}[A-Z]$")) {
					
			
				return false;
		}
				
		String numeroString = dni.substring(0, 8);
		char letraDni = dni.toUpperCase().charAt(8);
				
		String letrasReferencia = "TRWAGMYFPDXBNJZSQVHLCKE";
		int numero = Integer.parseInt(numeroString);
		char letraCorrecta = letrasReferencia.charAt(numero % 23);
		boolean control = letraDni == letraCorrecta;
				
		return control;
			}
	private boolean comprobarEmailYContrasenia(String email, String contraseña) {
		boolean coinciden = false;
		for (Cliente c : Inicio.listaClientes) {
			if (c.getEmail().equals(email) && c.getContraseña().equals(contraseña)) {
				coinciden = true;
			}
		}
		return coinciden;
	}
	
	
}
