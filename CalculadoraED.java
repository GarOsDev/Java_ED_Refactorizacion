package calcualdora;

import java.util.Scanner;

/**
 * Clase CalculadoraED será la clase main o ejecutora del proyecto. Esta clase
 * será la encargada de mostrar el menú de operaciones que puede realizar la
 * calculadora y relacionar cada una de ellas con su método y enumeracion
 * correspondiente en las clases CerebroCalculadoraED y Operacones
 * 
 * @author Óscar García
 *
 */


public class CalculadoraED {
	
	/**
	 * Metodo main del proyecto Calculadora
	 * @param args array de Strings presente en el método main de un programa Java.
	 */

	public static void main(String[] args) {

		/**
		 * Se crea una instancia de la clase CerebroCalculadoraED llamada objetoCerebro
		 * para, de esta forma, poder ejecutar cada una de las operaciones del programa
		 * en base a la opcion introducida por teclado. La eleccion del usuario vendrá
		 * recogida por el objeto teclado, perteneciente a la clase Scanner
		 */

		CerebroCalculadoraED objetoCerebro = new CerebroCalculadoraED();
		Scanner teclado = new Scanner(System.in);

		String entrada;

		/**
		 * Se crea bucle do-while que será el encargado de mostrar el menú reiterativamente
		 * una vez el usuario haya ejecutado algua operacion previa. Además tiene la
		 * funcion de mostrar la cabecera del programa, la operacion elegida por el
		 * usuario una vez validada y un mensaje de salida, por si éste ha decidido
		 * finalizar el programa mediante la introduccion del caracter 'x'
		 */

		do {
			imprimirCabecera();
			imprimirSeleccionOp();

			entrada = teclado.next();
			if (validarEntrada(entrada)) {
				objetoCerebro.procesarOperacion(entrada);
			} else {
				System.out.println("Entrada no reconocida");
			}
		} while (!entrada.equals("x"));
		imprimirDespedida();
	}

	private static void imprimirCabecera() {
		System.out.println("*----------------------------------*");
		System.out.println("*----------Calculadora ED----------*");
		System.out.println("*----------------------------------*");
	}

	private static void imprimirDespedida() {
		System.out.println("*-----------------------------------------*");
		System.out.println("*----¡Gracias por usar Calculadora ED!----*");
		System.out.println("*-----------------------------------------*");
	}

	/**
	 * Metodo static imprimirSeleccionOP: será el encargado mostrar el conjunto de
	 * operaciones de las que dispone la calculadora
	 */

	private static void imprimirSeleccionOp() {
		Operaciones[] opciones = Operaciones.values();
		for (Operaciones opcion : opciones) {
			System.out.println(opcion.getOpcionMenu());
		}
		System.out.println("Que operacion desea realizar? (x para terminar)");
	}

	/**
	 * Metodo ValidarEntrada: Verifica que el valor introducido por consola
	 * corresponde con alguna de las operaciones matemáticas desarrolladas
	 * 
	 * @param recibe el valor introducido en consola por el usuario
	 * @return devuelve valor booleano en funcion de si la opcion elegida está o no
	 *         contemplada entre las desarrolladas
	 */

	private static boolean validarEntrada(String entrada) {
		if (entrada.equals("x")) {
			return true;
		} else {
			boolean opValida = false;
			Operaciones[] opciones = Operaciones.values();
			for (Operaciones opcion : opciones) {
				if (Integer.toString(opcion.getId()).equals(entrada)) {
					opValida = true;
				}
			}
			return opValida;
		}
	}

}
