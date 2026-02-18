package dtos;

public class Cliente {
	
	private long id;
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String email;
	private String contraseña;
	private boolean esValidado = false; 
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContraseña() {
		return contraseña;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setContrasenia(String contraseña) {
		this.contraseña = contraseña;
	}
	public boolean getEsValidado() {
		return esValidado;
	}
	public void setEsValidado(boolean esValidado) {
		this.esValidado = esValidado;
	}
	@Override
	public String toString() {
		return "DNI: " + dni + 
				"\n Nombre: " + apellido1 +" "+ apellido2 +", "+ nombre +
				"\n ESTADO VALIDACIÓN " + ((esValidado) ? "Si" : "No") +
				"\n %%%%%%%%%%";
	}
	
	
	
}
