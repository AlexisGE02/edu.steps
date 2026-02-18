package servicios;

import controladores.Inicio;

public class MenuClienteImplementacion implements MenuInterfaz{
	
	ClienteImplementacion ci = new ClienteImplementacion();

	@Override
	public void mostrarMenu() {
		System.out.println("···········MENÚ CLIENTE········");
		System.out.println("·······Introduzca su opción····");
		System.out.println("·····1. Registro Cliente·······");
		System.out.println("·····2. Acceso Cliente·········");
		System.out.println("·····3. Volver al menú inicial·");
		System.out.println("·······························");
		
		
	}

	@Override
	public byte recogerOpcion() {
		byte opcion = Inicio.sc.nextByte();
		
		return opcion;
	}

	@Override
	public boolean funcionarMenu(byte opcion) {
		
		boolean esCerrado = false;
		
		switch(opcion) {
		case 1:
			ci.registroCliente();
			break;
		case 2:
			esCerrado = ci.accesoCliente();
			break;
		case 3:
			System.out.println("Volviendo al menú principal");
			esCerrado = true;
			break;
			default: 
				System.out.println("Opción no válida");
		}
		return esCerrado;
	

}
}
