import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Activitat4 {

	public static void main(String[] args) {
		
		// Variables que usaremos
		int numClientes = 50;
		
		// Indicamos cuántos hilos queremos que tenga nuestro executor
		ThreadPoolExecutor clientes = (ThreadPoolExecutor) Executors.newFixedThreadPool(numClientes);

	}
	
	public static int procesarPedido() {
		
		// Número aleatorio entre 2 y 8
		int valorEntero = (int) Math.floor(Math.random() * (8-2+1) + 2);
		
		return valorEntero;
	}
}
