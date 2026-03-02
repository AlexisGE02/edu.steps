package controladores;

import java.util.ArrayList;
import java.util.Scanner;

import dtos.Usuarios;
import servicios.EmpleadoImplementacion;
import servicios.MenuImplementacion;

/**
 * Clase Controladora de la aplicación, controla el acceso a los menús y los submenús
 * @author alexis
 */

public class Inicio {
	
	public static Scanner sc = new Scanner(System.in);
	public static MenuImplementacion mi = new MenuImplementacion(); 
	public static ArrayList<Usuarios> listaUsuarios = new ArrayList<>();
	public static ArrayList<Usuarios> listaUsuariosEmpleados = new ArrayList<>();
	
	
	/**
	 * Método principal de la aplicación, alverga la lógica que mantiene iniciada la aplicación, llamando los métodos necesarios para el control y ejecución de cada funcion en la aplocación
	 * @param args
	 * @author alexis
	*/
	public static void main(String[] args) {
		
		
		EmpleadoImplementacion ei = new EmpleadoImplementacion();
		ei.crearPrimerEmpleado("Admin1", "AdminPass");
		boolean esCerrado = false;
		
		do {
			mi.mostrarMenu();
			byte opcion = mi.recogerOpcion();
			esCerrado= mi.funcionarMenu(opcion);
			
			
		}while(!esCerrado);
		
		sc.close();
		
	}

}
