package servicios;

import controladores.Inicio;

public class MenuImplementacion implements MenuInterfaz{

	public static MenuEmpleadoImplementacion mei = new MenuEmpleadoImplementacion();
	public static MenuClienteImplementacion mci = new MenuClienteImplementacion();
	@Override
	public void mostrarMenu() {
		
		System.out.println("··········MENÚ··········");
		System.out.println("··Introduzca su opción··");
		System.out.println("·1. Versión Empleado····");
		System.out.println("·2. Versión Cliente·····");
		System.out.println("·3. Cerrar Aplicación···");
		System.out.println("························");
		
		
		
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
			boolean esCerrado2 = false;
			
			do {
				mei.mostrarMenu();
				byte opcion2 = mei.recogerOpcion();
				esCerrado2= mei.funcionarMenu(opcion2);
				
			}while(!esCerrado2);
			break;
			
		case 2:
			
			boolean esCerrado3 = false;
			
			do {
				mci.mostrarMenu();
				byte opcion3 = mci.recogerOpcion();
				esCerrado3= mci.funcionarMenu(opcion3);
				
			}while(!esCerrado3);
			break;
			
		case 3:
			System.out.println("Cerrando la aplicación");
			esCerrado = true;
			break;
			default: 
				System.out.println("Opción no válida");
		}
		return esCerrado;
		
		
	}

}

