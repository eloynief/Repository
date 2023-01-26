package examen;
/**
 * 
 * @author enieves
 *
 */
// Clase que define una fracción
public class Fraccion {
	// Numerador
	private int num;

	// Denominador
	private int den;

	private String mensaje;
 
	// Constructor por defecto
	
	
	public Fraccion() { // debe generar el valor neutro que es 0/1
		num = 0;
		den = 1;

	}

	// Constructor con parámetros
	/**
	 * el parametro num es una variable int la cual da el valor de num
	 * 
	 * el parametro den hace que el denomiador sea 1 si den es 0
	 * @param num
	 * @param den
	 */
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0) {
			this.den = 1;
		}
		else {
			this.den = den;
		}
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	// Constructor copia
	/**
	 * este parametro hace una operación con dos variables private int
	 * 
	 * @param fraccion
	 */
	public Fraccion(final Fraccion fraccion) {
		num = fraccion.num;
		den = fraccion.den;
	}

	// getters y setters
	/**
	 * el parametro num es una variable int que se iguala a this.num
	 * 
	 * 
	 * @param num
	 */
	public void setNum(int num) {
		this.num = num;

	}
	/**
	 * este return devuelve el valor del num del private int
	 * 
	 * @return num
	 */
	public int getNum() {
		return num;

	}
	/**
	 * este parametro tiene una variable que se iguala con el denominador del private int 
	 * 
	 * @param den
	 */
	public void setDen(int den) {
		this.den = den;
	}
	/**
	 * este return devuelve el denominador
	 * 
	 * @return
	 */
	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	/**
	 * este return devuelve el numerador que se ha creado en la variable
	 * 
	 * @return
	 */
	private int maxComunDivisor() {
		int numerador = Math.abs(num); // valor absoluto del numerador
		int denominador = Math.abs(den); // valor absoluto del denominador
		int resultado;
		while (denominador != 0) {
			resultado = numerador % denominador;
			numerador = denominador;
			denominador = resultado;
		}
		return numerador;
	}

	// método para simplificar fracciones
	public void simplificar() {
		int numero = maxComunDivisor();
		num = num / numero;
		den = den / numero;
	}

	// Método toString
	
	public String toString() {
		mensaje = num + "/" + den;
		return mensaje;

	}

	// suma de fracciones
	/**
	 * este 
	 * 
	 * 
	 * @param fraccion
	 * @return
	 */
	public Fraccion sumar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * fraccion.den;
		int cruce2 = den * fraccion.num;
		aux.num = cruce1 + cruce2;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones
	/**
	 * 
	 * @param fraccion
	 * @return
	 */
	public Fraccion restar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * fraccion.den;
		int cruce2 = den * fraccion.num;
		aux.num = cruce1 - cruce2;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones
	/**
	 * 
	 * @param fraccion
	 * @return
	 */
	public Fraccion multiplicar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.num;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones
	/**
	 * 
	 * @param fraccion
	 * @return
	 */
	public Fraccion dividir(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.den;
		aux.den = den * fraccion.num;
		aux.simplificar();
		return aux;

	}

}
