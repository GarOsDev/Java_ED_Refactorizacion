package calcualdora;

import java.util.Scanner;

/**
 * La clase CerebroCalculadora será la encargada de realizar las operaciones
 * matemáticas diseñadas en la calculadora. La ejecucion de una u otra operacion
 * vendrá determinada directamente por el valor numerico introducido por consola
 * en la clase main
 * 
 * @author Óscar García
 *
 */
public class CerebroCalculadoraED {

	/**
	 * 	Atributos de clase:
	 * 
	 * - Instancia del enumerado Operaciones
	 * - numero1: primer valor numerico introducido por usuario tras elegir operacion
	 * - numero2: segundo valor numerico introducido por usuario tras elegir operacion
	 * - resultado: variable que recoge la salida de datos una vez ejecutada la operacion escogida utilizando las variables numero1 y numero2
	 * - String historial: atributo encargado de registrar las operaciones matemáticas 
	 * - Constante TAMANOHISTORIAL: establece la cantidad maxima de ultimas operaciones que el historial es capaz de guardar.
	 */

	private Operaciones operacion;
	public double resultado, numero1, numero2;
	private String[] historial;
	static final int TAMANOHISTORIAL = 5;
	Scanner tecladoCce = new Scanner(System.in);

	/**
	 * Constructor en el que se aplica el tamaño maximo al historial en funcion del valor registrado en la
	 * constante
	 */

	public CerebroCalculadoraED() {
		historial = new String[TAMANOHISTORIAL];
		resultado = 0;
	}

	/**
	 * Switch case que relaciona directamente la operacion elegida por
	 * consola con el metodo ejecutor de la misma
	 * 
	 * @param opcion Valor vinculado a cada una de las sentencias diseñadas
	 *               que contiene los metodos matematicos de la calculadora
	 */

	public void procesarOperacion(String opcion) {
		System.out.println("Proceso " + opcion);
		switch (opcion) {
		case "1":
			operacion = Operaciones.SUMAR;
			operarSuma(operacion);
			break;
		case "2":
			operacion = Operaciones.RESTAR;
			operarResta(operacion);
			break;
		case "3":
			operacion = Operaciones.MULTIPLICAR;
			operarMultiplica(operacion);
			break;
		case "4":
			operacion = Operaciones.DIVIDIR;
			operarDivide(operacion);
			break;
		case "5":
			operacion = Operaciones.SUMAR_RES;
			operarSumaRes(operacion);
			break;
		case "6":
			operacion = Operaciones.RESTAR_RES;
			operarRestaRes(operacion);
			break;
		case "7":
			operacion = Operaciones.MULTIPLICAR_RES;
			operarMultiplicaRes(operacion);
			break;
		case "8":
			operacion = Operaciones.DIVIDIR_RES;
			operarDivideRes(operacion);
			break;
		case "9":
			operacion = Operaciones.RESULTADO;
			mostrarResultadoActual(operacion);
			break;
		case "10":
			operacion = Operaciones.RANDOM;
			numeroAleatorio(operacion);
			break;
		case "11":
			operacion = Operaciones.HISTORIAL;
			operarHistorial(operacion);
			break;
		default:
			System.out.println("Programa finalizado.");
		}
	}

	/**
	 * Metodo operaSuma: suma los dos valores introducidos por el usuario
	 * 
	 * @param op Valor enlazado al switch case como instancia de la clase
	 *           Operaciones.
	 */

	private void operarSuma(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}

	/**
	 * Metodo operarResta: realiza la diferencia de los valores numericos elegidos
	 * 
	 * @param op Valor enlazado al switch case como instancia de la clase
	 *           Operaciones
	 */

	private void operarResta(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 - this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}

	/**
	 * Método operarMultiplica: ejecuta el producto de ambos valores introducidos
	 * por teclado
	 * 
	 * @param op Valor enlazado al switch case como instancia de la clase
	 *           Operaciones
	 */

	private void operarMultiplica(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();
		this.resultado = this.numero1 * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}

	/**
	 * Método operarDivide: relacion entre ambos numeros introducidos. Contempla que
	 * los valores sean correctos al no permitir un denominador con valor nulo
	 * 
	 * @param op Valor enlazado al switch case como instancia de la clase
	 *           Operaciones
	 */

	private void operarDivide(Operaciones op) {
		infoOperacion(op);
		pedirDosNumeros();

		if (this.numero2 == 0) {
			System.out.println("ERROR, no puede realizarse una division con denominador cero. Repetir proceso.");
		} else {
			this.resultado = this.numero1 / this.numero2;
			mostrarResultado(op);
			anadirHistorial(op);
		}

	}

	/**
	 * Método operarSumaRes: suma a la ultima operacion realizada el valor numerico
	 * elegido por el usuario. En este caso recogido por la variable numero2
	 * 
	 * @param op Valor enlazado al switch case como instancia de la clase
	 *           Operaciones
	 */

	private void operarSumaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado + this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}

	/**
	 * @ Método operarRestaRes: resta a la ultima operacion realizada el valor
	 * numerico elegido por el usuario. En este caso recogido por la variable
	 * numero2
	 * 
	 * @param op Valor enlazado al switch case como instancia de la clase
	 *           Operaciones
	 */

	private void operarRestaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado - this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}

	/**
	 * Método operarMultiplicaRes: multiplica la ultima operacion por el valor
	 * numerico elegido por el usuario. En este caso recogido por la variable
	 * numero2
	 * 
	 * @param op Valor enlazado al switch case como instancia de la clase
	 *           Operaciones
	 */

	private void operarMultiplicaRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		this.resultado = this.resultado * this.numero2;
		mostrarResultado(op);
		anadirHistorial(op);
	}

	/**
	 * Método operarDivideRes: ejecuta la relacion entre el resultado de la ultima
	 * operacion realizada y el valor introducido por teclado (numero2). Al igual
	 * que con el metodo de division, se tiene en cuenta que el denominador no sea
	 * nulo
	 * 
	 * @param op Valor que enlaza al switch case como instancia de la clase
	 *           Operaciones
	 */

	private void operarDivideRes(Operaciones op) {
		infoOperacion(op);
		pedirUnNumero();
		if (this.numero2 == 0) {
			System.out.println("ERROR, no puede realizarse una division con denominador cero. Repetir proceso.");
		} else {
			this.resultado = this.resultado / this.numero2;
			mostrarResultado(op);
			anadirHistorial(op);
		}
	}

	/**
	 * Método mostrarResultadoActual: Muestra el resultado de la ultima operacion
	 * realizada con exito
	 * 
	 * @param op Valor que enlaza al switch case como instancia de la clase
	 *           Operaciones
	 */

	private void mostrarResultadoActual(Operaciones op) {
		infoOperacion(op);
		System.out.println("El valor actual del resultado es: " + this.resultado + "\n");
	}

	/**
	 * Método numeroAleatorio: genera un numero aleatorio comprendido entre 1 y 100
	 * 
	 * @param op Valor que enlaza al switch case como instancia de la clase
	 *           Operaciones
	 */

	private void numeroAleatorio(Operaciones op) {
		infoOperacion(op);
		this.resultado = (double) (Math.random() * 100 + 1);
		System.out.println("El numero aleatorio generado es: " + this.resultado + "\n");
		anadirHistorial(op);
	}

	/**
	 * Método operarHitorial: se encarga de registrar las ultimas operaciones
	 * realizadas en la calculadora, desde la mas reciente a la mas antigua.
	 * 
	 * @param op Valor que enlaza al switch case como instancia de la clase
	 *           Operaciones
	 */

	private void operarHistorial(Operaciones op) {
		System.out.println("*** Historial de las cinco últimas operaciones ***");
		for (String hist : historial) {
			System.out.println(hist);
		}
		System.out.println("\n");
	}

	/**
	 * Método infoOperacion: tras elegir alguna de la operaciones del menu
	 * calculadora, muestra informacion descriptiva de ésta.
	 * 
	 * @param op Valor que enlaza al enumerado Operaciones presentando los
	 *           parametros correspondientes al nombre de la operacion escogida y la
	 *           descripcion de ésta
	 */

	private void infoOperacion(Operaciones op) {
		System.out.println("//////////////////////////////");
		System.out.println("-> " + op.getNombre() + " - " + op.getInfo());
	}

	/**
	 * Metodo pedirUnNumero: aplicado en los metodos que ejecutan operaciones sobre
	 * el ultimo resultado obtenido, solicita al usuario un unico valor numerico
	 * (numero2) para ejecutar la operacion correspondiente
	 */

	private void pedirUnNumero() {
		System.out.println("Introduce el número: ");
		this.numero1 = this.resultado;
		this.numero2 = tecladoCce.nextDouble();
	}

	/**
	 * Método pedirDosNumeros: se encarga de solicitar los valores numericos numero1
	 * y numero2 para poder ejecutar la operacion elegida por el usuario
	 */

	private void pedirDosNumeros() {
		System.out.println("Introduce el primer número: ");
		this.numero1 = tecladoCce.nextDouble();
		System.out.println("Introduce el segundo número: ");
		this.numero2 = tecladoCce.nextDouble();
	}

	/**
	 * Método mostrarResultado: como su nombre indica, muestra por consola el
	 * resultado de la operacion elegida por el usuario. Ademas de éste, tambien
	 * muestra los valores introducidos por teclado al ejecutar dicha operacion.
	 * 
	 * @param op Instancia de la clase Operaciones que recoge y muestra los
	 *           parametros referentes a la operacion realizada y el simbolo
	 *           representativo de la misma
	 */
	private void mostrarResultado(Operaciones op) {
		System.out.println("El resultado de la operación " + op.getNombre().toLowerCase() + " es: "
				+ Double.toString(numero1) + " " + op.getSimbolo() + " " + Double.toString(numero2) + " = "
				+ Double.toString(resultado) + "\n");
	}

	/**
	 * Metodo anadirHistorial: Tras ejecutar alguna de las operaciones diseñadas, se
	 * encarga de añadirla al array inicializado por el valor TAMANOHISTORIAL.
	 * Almacena tanto el tipo de operacion efectuado, como los valores numericos
	 * introducidos y el resultado de operar con los mismos
	 * 
	 * @param op Instancia de la clase Operaciones aqui utilizado para mostrar el
	 *           nombre de la operacion y simbolo vinculado a ésta
	 */

	private void anadirHistorial(Operaciones op) {

		String nuevaOperacion;

		if (op.getSimbolo() == "¿?") {
			nuevaOperacion = op.getNombre() + " -> " + Double.toString(resultado);
		} else {
			nuevaOperacion = op.getNombre() + " -> " + Double.toString(numero1) + " " + op.getSimbolo() + " "
					+ Double.toString(numero2) + " = " + Double.toString(resultado);
		}

		this.historial[4] = this.historial[3];
		this.historial[3] = this.historial[2];
		this.historial[2] = this.historial[1];
		this.historial[1] = this.historial[0];
		this.historial[0] = nuevaOperacion;

	}

}
