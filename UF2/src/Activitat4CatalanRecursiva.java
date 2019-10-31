import java.util.Scanner;

public class Activitat4CatalanRecursiva {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		// Pedimos cu�ntos n�meros de Catalan quiere mostrar
		System.out.println("Introduce cantidad de n�meros de Catalan a mostrar: ");
		int cantidad = teclado.nextInt();
		
		// Calculamos tantos n�meros como nos dicta el usuario
		for(int i = 0; i < cantidad; i++){
			System.out.println("N�mero: " + i + ", resultado: " + calcularNumeroCatalan(i));
		}
	}

	static int calcularNumeroCatalan(int num) {
		
		// Variables que usaremos
		int resultado = 0;
		
		// Si el n�mero es 0, devolvemos 1 directamente
		if(num == 0) {
			return 1;
		} 
		
		// Si no, calculamos el n�mero, mientras i sea mas peque�a que el n�mero
		for(int i = 0; i < num; i++) {
			// llamamos al m�todo y vamos multiplicando por �l mismo, pas�ndole cada vez el mismo n�mero -1
			resultado += calcularNumeroCatalan(i) * calcularNumeroCatalan(num - i - 1);
		}
		return resultado;
	}
}