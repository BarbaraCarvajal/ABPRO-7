/**
 * 
 */
package com.unab;

import java.util.Scanner;

/**
 * @author Luis Zenteno, Barbara Carvajal
 * @version 1.2
 * 
 * Esta sub clase heredada de Persona,  utilizara los siguientes parametros para cada metodo:
	 * @param mensaje se muestra al usuario para solicitar el ingreso del valor que guardará cada atributo.
	 * @param sc Scanner para la entrada de datos por parte del usuario.
	 * @return La cadena de caracteres correspondiente al valor ingresado, validado y asignado a cada atributo.
 */
public class Cliente extends Persona{
	
	String nombres, apellidos, telefono, afp, sistemaSalud, direccion, comuna, edad;
	
	/*Constructor que instanciará la clase en el Main, incluyendo super que llama a la superclase*/
	public Cliente() {
		super();
	}

	

	public Cliente(String nombres, String apellidos,String rut, String telefono, String afp, String sistemaSalud, String direccion,
			String comuna, String edad) {
				super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.rut = rut;
		this.telefono = telefono;
		this.afp = afp;
		this.sistemaSalud = sistemaSalud;
		this.direccion = direccion;
		this.comuna = comuna;
		this.edad = edad;
	}



	@Override
	public String toString() {
		return "\n* NOMBRES --> " + nombres + "\n* APELLIDOS --> "
				+ apellidos + "\n* RUT  --> " + rut + "\n* EDAD --> " + edad + " años" + "\n* TELÉFONO --> " + " +56 9 "
				+ telefono + "\n* AFP -->  " + afp + "\n* SISTEMA SALUD --> " + obtenerSistemaSalud() + "\n* DIRECCIÓN --> "
				+ direccion + "\n* COMUNA --> " + comuna;
	}

	

//- obtenerNombre(): retorna un String con el nombre completo del cliente (nombres +
//  apellidos)
	public String obtenerNombre(){
		String nombreCompleto = this.nombres + " " + this.apellidos;
		return nombreCompleto;
	}

	//- obtenerSistemaSalud(): de acuerdo al valor registrado en el objeto, despliega el tipo de
	//  sistema de salud

public String obtenerSistemaSalud(){
	String sistema = "Fonasa";

	if (this.sistemaSalud.equals("1")){
		 sistema = "Fonasa";

	}else if (this.sistemaSalud.equals("2")){
		sistema = "Isapre";

	}else{
		System.out.println("norsts");
	}
	
	return sistema;
}

	/**
	 *Metodo que valida el formato del número de telefono, correspondiente a 8 digitos.
	 */
	public String validarTelefono(String mensaje, Scanner sc) {

		boolean condTel = true;
		String input = "";

		while (condTel) {

			System.out.print("\n" + mensaje);
			input = sc.nextLine();

			if (input.matches("[0-9]{8}")) {

				condTel = false;
			} else {

				System.out.println("Número de telefono no valido, intentelo nuevamente");
			}
		}
		return input;
	}

	/**
	 *Metodo que valida el formato del Sistema de salud, teniendo una variable que puede almacenar dos opciones solamente.
	 */
	public String validarSalud(String mensaje, Scanner sc) {

		boolean condSalud = true;
		String input = "fonasa";

		while (condSalud) {

			System.out.print("\n" + mensaje);
			input = sc.nextLine().toLowerCase();

			if (input.matches("[1-2]+")) {

				if (input.equals("1") || input.equals("2")) {
					condSalud = false;
				} else {
					System.out.println("Sistema de salud no existente, intentalo nuevamente");
				}

			} else {
				System.out.println("Dato ingresado no valido, intentalo nuevamente");
			}
		}
		return input;
	}
	
	/**
	 * Valida el formato de la edad ingresada, solo se aceptan tipos númericos con una longitud de uno o dos digitos.
	*/
	public String validarEdad(String mensaje, Scanner sc) {

		boolean condEdad = true;
		String input = "";

		while (condEdad) {

			System.out.print("\n" + mensaje);
			input = sc.nextLine();

			if (input.matches("[0-9]{1,2}")) {

				if (!input.equals("0")) {

					condEdad = false;
				} else {

					System.out.println("La edad no puede ser 0, intentalo nuevamente");
				}
			} else {
				System.out.println("Dato ingresado no valido, intentalo nuevamente");
			}

		}
		return input;
	}
	
	/**
	 * El método toma un mensaje y un objeto Scanner como entradas, y solicita al usuario que ingrese su dirección.
	 * Luego se valida la dirección ingresada para asegurarse de que tenga entre 5 y 50 caracteres y solo contenga letras, números y espacios.
	 * Si la dirección ingresada no es válida, se solicita al usuario que ingrese una nueva dirección.
	 * El método devuelve la dirección válida.
	 */
	public String validarDireccion(String mensaje, Scanner sc) {

		boolean condicion2 = true;
		String input = "";

		while (condicion2) {

			System.out.print("\n" + mensaje);
			input = sc.nextLine();

			if (input.matches("[a-z A-Z 0-9]{2,50}")) {

				condicion2 = false;
			} else {

				System.out.println("Direccion ingresada no valida, intentelo nuevamente");
			}
		}
		return input;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the afp
	 */
	public String getAfp() {
		return afp;
	}

	/**
	 * @param afp the afp to set
	 */
	public void setAfp(String afp) {
		this.afp = afp;
	}

	/**
	 * @return the sistemaSalud
	 */
	public String getSistemaSalud() {
		return sistemaSalud;
	}

	/**
	 * @param sistemaSalud the sistemaSalud to set
	 */
	public void setSistemaSalud(String sistemaSalud) {
		this.sistemaSalud = sistemaSalud;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the comuna
	 */
	public String getComuna() {
		return comuna;
	}

	/**
	 * @param comuna the comuna to set
	 */
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	/**
	 * @return the edad
	 */
	public String getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(String edad) {
		this.edad = edad;
	}
	
	


}
