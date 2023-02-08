package com.unab;

import java.util.Scanner;


/**
 * Super clase que será utilizada con herencia y polimorfismo en clases Cliente, Usuario y Capacitacion
 * @author Luis Zenteno, Barbara Carvajal
 *@version 1.2
 */
public class Persona {
	
	/*Atributo DNI que heredarán las clases Cliente, Usuario y Capacitacion*/
	String rut;
	
	/*Constructor vacio que instancia la clase. */
	public Persona() {
	}


	/**
	 * Metodo que valida el formato de un input, que será utilizado para validar Nombres, Apellidos y otros atributos con las mismas caracteristicas.
	 */
	public String validarLetras(String mensaje, Scanner sc) {

		boolean condicion = true;
		String input = "";

		while (condicion) {

			System.out.print("\n" + mensaje);
			input = sc.nextLine();

			if (input.matches("[a-z A-Z\\s]+$")) {

				condicion = false;
			} else {

				System.out.println("Dato ingresado no valido, intentalo nuevamente");
			}

		}
		return input;

	}

	/**
	 * Método que valida el formato del RUN ingresado por el usuario.
	 */
	public String validarRut(String mensaje, Scanner sc) {

		boolean condRut = true;
		String input = "";

		while (condRut) {

			System.out.print("\n" + mensaje);
			input = sc.nextLine();

			if (input.matches("\\d{2}.\\d{3}.\\d{3}")) {

				condRut = false;
			} else {

				System.out.println("Rut ingresado no valido, intentalo nuevamente");
			}
		}
		return input;
	}
	

	/**
	 * @return the id
	 */
	public String getRut() {
		return rut;
	}

	/**
	 * @param id the id to set
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}

}
