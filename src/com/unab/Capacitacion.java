/**
 * 
 */
package com.unab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Luis Zenteno, Barbara Carvajal, Maria Fernanda
 * @version 1.2
 * 
 * Esta sub clase heredada de Persona, utilizara los siguientes parametros para cada metodo:
	 * @param mensaje se muestra al usuario para solicitar el ingreso del valor que guardará cada atributo.
	 * @param sc Scanner para la entrada de datos por parte del usuario.
	 * @return La cadena de caracteres correspondiente al valor ingresado, validado y asignado a cada atributo.
 */
public class Capacitacion extends Persona{
	
	/*Atributos propios de la clase*/
	String id,rut, dia, hora, lugar, duracion, asistentes, numeroInterno;
	
	/*Constructor que instancia la clase, incluyendo "super" que llamará a la superclase*/
	Capacitacion(){
		super();
	}
	
	public Capacitacion(String id,String rut, String dia, String hora, String lugar, String duracion, String asistentes, String numeroInterno) {
		this.id = id;
		this.rut = rut;
		this.dia = dia;
		this.hora = hora;
		this.lugar = lugar;
		this.duracion = duracion;
		this.asistentes = asistentes;
		this.numeroInterno = numeroInterno;
	}

	/**
	Método toString sobreescrito para la clase Capacitacion.
	Devuelve una representación en forma de cadena de los valores de los atributos de un objeto de la clase Capacitacion.
	@return Una cadena con los valores de los atributos de la capacitación.
	*/
	@Override
	public String toString() {
		return "\n* ID CLIENTE --> " + "#" +  id + "\n* RUT CLIENTE --> " + rut + "\n* DÍA --> " + dia + "\n* HORA --> " + hora + "\n* LUGAR --> "
				+ lugar + "\n* DURACIÓN --> " + duracion + " Horas" + "\n* CANTIDAD ASISTENTES --> " + asistentes;
	}

	// transformar a minutos 

	public String horasAminutos(){

		int horas = Integer.parseInt(this.getDuración());
		int minutos = horas * 60;
	
		String min = Integer.toString(minutos);

		return min;
	}

	// mostrarDetalle(): retorna un mensaje con el texto “La capacitación será en A a las B del día
  // C, y durará D minutos”, en donde A es el lugar, B es la hora, C es el día y D son los minutos.

	public String mostrarDetalle(){

		String detalle = "La capacitación será en "+this.getLugar()+" a las "+this.getHora()+" del día "+ this.getDía()+" y durará "+this.horasAminutos()+" minutos.";
		return detalle;
	}

	/** 
	 * Metodo que valida el formato de un evento ingresado por el usuario.
	 */
	public String validarLugar(String mensaje, Scanner sc) {

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
	 * Metodo que valida el formato de un ID ingresado por el usuario, con una longitud de digitos de 5 a 8.
	 */
	public String validarId(String mensaje, Scanner sc) {

		boolean condicionId = true;
		String input = "";

		while (condicionId) {

			System.out.print(mensaje);
			input = sc.nextLine();

			if (input.matches("[a-zA-Z 0-9]{5,8}")) {

				condicionId = false;
			} else {

				System.out.println("ID ingresado no valido, intentelo nuevamente");
			}
		}
		return input;
	}

	/**
	 * Metodo que valida el formato del día de un evento ingresado por el usuario, se compara con las 7 opciones de los días de la semana.
	 */
	public String validarDia(String mensaje, Scanner sc) {

		boolean condDia = true;
		String input = "";

		while (condDia) {

			System.out.print("\n" + mensaje);
			input= sc.nextLine();

			if (input.matches("[a-zA-Z]{1,}")) {

				if (input.equals("lunes") || input.equals("martes") || input.equals("miercoles")
						|| input.equals("jueves") || input.equals("viernes") || input.equals("sabado")
						|| input.equals("domingo")) {
					
					condDia = false;
					
				} else {
					System.out.println("Día ingresado no válido");
				}
			} else {
				System.out.println("Dato ingresado no valido, intentelo nuevamente");
			}
		}
		return input;
	}


	/**
	 * Valida que una entrada de usuario sea una hora en formato "HH:mm".
	 * 	
	 * SimpleDateFormat es una clase de Java que permite formatear o convertir un objeto de tipo Date a una cadena de texto con un formato específico, y viceversa. 
	 * 
	 * La propiedad "lenient" de la clase java.text.DateFormat es una bandera que indica si se permite la interpretación flexible de fechas y horas.
	 * Si está establecido en true, el formato de fecha y hora será más permisivo y permitirá fechas y horas que no cumplen con los requisitos exactos. 
	 * Si está establecido en false, el formato de fecha y hora será más estricto y sólo aceptará fechas y horas que cumplan con los requisitos exactos.	
	 * 
	 * @param mensaje Mensaje a mostrar al usuario para pedir la entrada de hora.
	 * @param sc Objeto Scanner para leer la entrada de usuario.
	 * @return La hora en formato "HH:mm" si es válida, o una cadena vacía en caso contrario.
	 */
	public String validarHora(String mensaje, Scanner sc) {
		
		boolean condHora = true;
		String input = "";
		
		while (condHora) {
			
			System.out.print("\n" + mensaje);
			input = sc.nextLine();
			
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			sdf.setLenient(false); 

			try {
				
			  Date hora = sdf.parse(input);
			  
			  condHora = false;
			} 
			catch (ParseException e) {
			  System.out.println("Formato de hora inválido, intentalo nuevamente");
			}
		}
		
		return input;
	}
	
	
	/**
	 * Este método valida la duración de un evento.
	*/
	public String validarDuracion(String mensaje, Scanner sc) {
		
		boolean condicion3 = true;
		String input = "";
		
		while (condicion3) {
			
			System.out.print("\n" + mensaje);
			input = sc.nextLine();
			
			/*
			 * Esta sección utilizada para la validacion de la duración de un evento, valida que lo ingresado por el usuario sean solo números .
			 * Si la duración del evento está en un rango de 1 a 5, el ciclo continuará.
			 * Si lo ingresado por el usuario no es un dato numerico ni esta dentro del rango establecido, el ciclo volverá a repetirse para pedir los datos nuevamente.
			*/
			if (input.matches("[1-5]{1}")) {
				
				condicion3 = false;
			}
			else {
				
				System.out.println("Cantidad de horas no valida, intentelo nuevamente");
			}
		}
		return input;
	}
	
	/**
	 * Metodo que valida el formato de una cantidad de asistentes a un evento ingresado por el usuario, solo pueden ser datos numericos con un rango de 1 a 999 asistentes.
	 */
	public String validarAsistentes(String mensaje, Scanner sc) {
		
		boolean condAsist = true;
		String input = "";
		
		while (condAsist) {
			
			System.out.print("\n" + mensaje);
			input = sc.nextLine();
			
			if (input.matches("[0-9]{1,3}")) {
				
				if (!input.equals("0")) {
					
					condAsist = false;
				}else {
					
					System.out.println("Tiene que haber al menos 1 asistente, intentelo de nuevo");
				}
			}
			else {
				
				System.out.println("Cantidad de asistenes no validos, intentelo nuevamente");
			}
		}
		return input;
	}

	/**
	Metodo que valida que num interno 
	*/
	public String validarNumeroInterno(String mensaje, Scanner sc) {
		
		boolean condNum = true;
		String entrada = "";
		
		while (condNum) {
			
			System.out.print("\n" + mensaje);
			entrada = sc.nextLine();
			
			if (entrada.matches("[0-9]{3,5}")) {
				
				if (!entrada.equals("0")) {
					
					condNum = false;
				}else {
					
					System.out.println("El código debe ser de mínimo 3 digitos y máximo 5.");
				}
			}
			else {
				
				System.out.println("Código ingresado no valido, intentelo nuevamente");
			}
		}
		return entrada;
	}



	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the rutCliente
	 */
	public String getRutCliente() {
		return rut;
	}

	/**
	 * @param rutCliente the rutCliente to set
	 */
	public void setRutCliente(String rutCliente) {
		this.rut = rutCliente;
	}

	/**
	 * @return the día
	 */
	public String getDía() {
		return dia;
	}

	/**
	 * @param día the día to set
	 */
	public void setDía(String dia) {
		this.dia = dia;
	}

	/**
	 * @return the hora
	 */
	public String getHora() {
		return hora;
	}

	/**
	 * @param hora the hora to set
	 */
	public void setHora(String hora) {
		this.hora = hora;
	}

	/**
	 * @return the lugar
	 */
	public String getLugar() {
		return lugar;
	}

	/**
	 * @param lugar the lugar to set
	 */
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	/**
	 * @return the duración
	 */
	public String getDuración() {
		return duracion;
	}

	/**
	 * @param duración the duración to set
	 */
	public void setDuración(String duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the asistentes
	 */
	public String getAsistentes() {
		return asistentes;
	}

	/**
	 * @param asistentes the asistentes to set
	 */
	public void setAsistentes(String asistentes) {
		this.asistentes = asistentes;
	}

	public String getNumeroInterno() {
		return numeroInterno;
	}

	public void setNumeroInterno(String numeroInterno) {
		this.numeroInterno = numeroInterno;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

}
