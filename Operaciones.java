package calcualdora;

import java.util.Arrays;

/**
 * La clase Operaciones es de tipo enumerada, un archivo .java de valores y
 * parametros constantes utilizados por la clase Cerebro y ejecutora. La
 * finalidad de su uso es para establecer las operaciones que sabemos a ciencia
 * cierta que va a realizar la calculadora, por lo cual no son susceptibles de
 * modificacion.
 * 
 * @author Óscar Miles
 *
 */

	/**
	 * Enumerado que representa las operaciones establecidas para la calculadora.
	 */

public enum Operaciones {

	/**
	 * Clave Suma, se muestra nombre de la operacion, simbolo caracteristico, descripcion de la operacion e identificador propio
	 */
	
	SUMAR("Suma", "+", "Suma dos números", 1), 
	
	/**
	 * Clave Resta, se muestra nombre de la operacion, simbolo caracteristico, descripcion de la operacion e identificador propio
	 */
	
	RESTAR("Resta", "-", "Resta dos números", 2),
	
	/**
	 * Clave Multiplicacion, se muestra nombre de la operacion, simbolo caracteristico, descripcion de la operacion e identificador propio
	 */
	
	MULTIPLICAR("Multiplicacion", "*", "Multiplica dos números", 3), 
	
	/**
	 * Clave Division, se muestra nombre de la operacion, simbolo caracteristico, descripcion de la operacion e identificador propio
	 */
	
	DIVIDIR("Division", "/", "Divide dos números", 4),
	
	/**
	 * Clave Sumar al resultado, se muestra nombre de la operacion, simbolo caracteristico, descripcion de la operacion e identificador propio
	 */
	
	SUMAR_RES("Sumar al resultado", "+=", "Suma un número al resultado actual", 5),
	
	/**
	 * Clave Resta al resultado, se muestra nombre de la operacion, simbolo caracteristico, descripcion de la operacion e identificador propio
	 */
	
	RESTAR_RES("Restar al resultado", "-=", "Al resultado actual le resta un número", 6),
	
	
	/**
	 * Clave Multiplicar al resultado, se muestra nombre de la operacion, simbolo caracteristico, descripcion de la operacion e identificador propio
	 */
	
	MULTIPLICAR_RES("Multiplicar al resultado", "*=", "Multiplica un número al resultado actual", 7),
	
	/**
	 * Clave dividir al resultado, se muestra nombre de la operacion, simbolo caracteristico, descripcion de la operacion e identificador propio
	 */
	
	
	DIVIDIR_RES("Dividir al resultado", "/=", "Resultado actual dividido por un número", 8),
	
	/**
	 * Clave resultado, se muestra nombre de la operacion, simbolo caracteristico, descripcion de la operacion e identificador propio
	 */
	
	
	RESULTADO("Mostrar resultado", "!", "Muestra el último resultado", 9),
	
	/**
	 * Clave Random, se muestra nombre de la operacion, simbolo caracteristico, descripcion de la operacion e identificador propio
	 */
	
	RANDOM("Numero aleatorio", "¿?", "Crea un numero aleatorio 1-100", 10),
	
	/**
	 * Clave historial, se muestra nombre de la operacion, simbolo caracteristico, descripcion de la operacion e identificador propio
	 */
	
	HISTORIAL("Historial", "h", "Muestra las cinco últimas operaciones", 11);

	/**
	 * Atributos de clase autodescriptivos
	 */

	private final String NOMBRE_OPERACION;
	private final String SIMBOLO_OPERACICON;
	private final String INFO_OPERACION;
	private final int ID_OPERACION;

	/**
	 * Constructor del enumerado Operaciones encargado de inicializar cada uno de
	 * los atributos declarados
	 * 
	 * @param nombre  Hace referencia a la operacion escogida por el usuario y/o que
	 *                va a ejecutarse
	 * @param simbolo Ideograma o distintivo de la operacion escogida
	 * @param info    Informacion descriptiva de la ejecucion que va a realizar la
	 *                correspondiente operacion
	 * @param id      Clave identificativa de cada una de las operaciones diseñadas
	 *                en el proyecto calculadora
	 */

	Operaciones(String nombre, String simbolo, String info, int id) {
		this.NOMBRE_OPERACION = nombre;
		this.SIMBOLO_OPERACICON = simbolo;
		this.INFO_OPERACION = info;
		this.ID_OPERACION = id;
	}

	
	/**
	 *Getter de enumerado para el parametro NOMBRE_OPERACION
	 * @return Metodo getter que devuelve el parametro del enumerado vinculado al nombre de la operacion realizada
	 */

	public String getNombre() {
		return NOMBRE_OPERACION;
	}
	
	/**
	 * Getter de enumerado para el parametro INFO_OPERACION
	 * @return Metodo getter que devuelve informacion descriptiva de la operacion
	 */

	public String getInfo() {
		return INFO_OPERACION;
	}
	
	/**
	 * Getter de enumerado para el parametro SIMBOLO_OPERACION
	 * @return Metodo getter para obtener el simbolo caracteristico de la operacion ejecutada
	 */

	public String getSimbolo() {
		return SIMBOLO_OPERACICON;
	}
	
	/**
	 * Getter de enumerado para el parametro ID_OPERACION
	 * @return Getter para recibir el ID caracteristico de cada operacion
	 */

	public int getId() {
		return ID_OPERACION;
	}
	
	/**
	 * Getter de enumerado para los parametros ID_OPERACION Y NOMBRE_OPERACION
	 * @return Getter que devuelve la concatenacion del identificador de la opracion y su nombre correspondiente
	 */

	public String getOpcionMenu() {
		return ID_OPERACION + ".- " + NOMBRE_OPERACION;
	}
	
	
}
