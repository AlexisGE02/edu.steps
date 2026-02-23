package servicios;

import controladores.Inicio;

public class MenuEmpleadoImplementacion implements MenuInterfaz{
	
	EmpleadoImplementacion ei = new EmpleadoImplementacion();

	@Override
	public void mostrarMenu() {
		System.out.println("···········MENÚ EMPLEADO·······");
		System.out.println("·······Introduzca su opción····");
		System.out.println("·····1. Validar Cliente········");
		System.out.println("·····2. Borrar Cliente·········");
		System.out.println("·····3. Mostrar Cliente········");
		System.out.println("·····4. Volver al menú inicial·");
		System.out.println("·······························");
		
		
	}

	@Override
	public byte recogerOpcion() {
		byte opcion = Inicio.sc.nextByte();
		
		return opcion;
	}

	@Override
	public boolean funcionarMenu(byte opcion) {
		
		boolean esCerrado1 = false;
		
		switch(opcion) {
		case 1:
			System.out.println("Ha elegido Validar Cliente");
			ei.validarCliente();
			break;
		case 2:
			System.out.println("Ha elegido Borrar Cliente");
			esCerrado1= ei.borrarCliente();
			break;
		case 3:
			ei.mostrarClientes();
			break;
		case 4:
			System.out.println("Volviendo al menú principal");
			esCerrado1 = true;
			break;
			default: 
				System.out.println("Opción no válida");
		}
		return esCerrado1;
	

}
}