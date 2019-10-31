import java.util.Scanner;

public class Activitat4CatalanRecursiva {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		// Pedimos cuántos números de Catalan quiere mostrar
		System.out.println("Introduce cantidad de números de Catalan a mostrar: ");
		int cantidad = teclado.nextInt();
		
		// Calculamos tantos números como nos dicta el usuario
		for(int i = 0; i < cantidad; i++){
			System.out.println("Número: " + i + ", resultado: " + calcularNumeroCatalan(i));
		}
	}

	static int calcularNumeroCatalan(int num) {
		
		// Variables que usaremos
		int resultado = 0;
		
		// Si el número es 0, devolvemos 1 directamente
		if(num == 0) {
			return 1;
		} 
		
		// Si no, calculamos el número, mientras i sea mas pequeña que el número
		for(int i = 0; i < num; i++) {
			// llamamos al método y vamos multiplicando por él mismo, pasándole cada vez el mismo número -1
			resultado += calcularNumeroCatalan(i) * calcularNumeroCatalan(num - i - 1);
		}
		return resultado;
	}
}