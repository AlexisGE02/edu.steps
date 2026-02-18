package servicios;

public interface MenuInterfaz {

	/**
	 * Muestra las opciones del menú
	 * @author alexis
	 */
	public void mostrarMenu();
	/**
	 * Recoge la opción escrita en consola y la devuelve como Byte
	 * @return byte
	 * @author alexis
	 */
	public byte recogerOpcion();
	
	/**
	 * Utiliza la opción recogida como parámetro para iniciar la parte de la aplicacíon correspondiente
	 * Tambien devuelve, en el caso correspondiente, un valor del boolean esCerrado para determinar si la aplicación sigue iniciada o se cierra
	 * @param opcion
	 * @return
	 */
	public boolean funcionarMenu(byte opcion);
	
	
}
