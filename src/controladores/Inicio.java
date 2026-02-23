package controladores;

import java.util.ArrayList;
import java.util.Scanner;

import dtos.Cliente;
import servicios.MenuImplementacion;

/**
 * Clase Controladora de la aplicación, controla el acceso a los menús y los submenús
 * @author alexis
 */

public class Inicio {
	
	public static Scanner sc = new Scanner(System.in);
	public static MenuImplementacion mi = new MenuImplementacion(); 
	public static ArrayList<Cliente> listaClientes = new ArrayList<>();
	public static ArrayList<Cliente> listaClientesOrdenada = new ArrayList<>();
	
	/**
	 * Método principal de la aplicación, alverga la lógica que mantiene iniciada la aplicación, llamando los métodos necesarios para el control y ejecución de cada funcion en la aplocación
	 * @param args
	 * @author alexis
	*/
	public static void main(String[] args) {
		
		
		Inicio.listaClientesOrdenada = Inicio.listaClientes.sort(Cliente.);
		boolean esCerrado = false;
		
		do {
			mi.mostrarMenu();
			byte opcion = mi.recogerOpcion();
			esCerrado= mi.funcionarMenu(opcion);
			
			
		}while(!esCerrado);
		
		sc.close();
		
	}

}
