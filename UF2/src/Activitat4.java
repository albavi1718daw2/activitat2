import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Activitat4 {

	private static final int numCajeras = 10;
	
	public static void main(String[] args) {
		
		// Variables que usaremos
		int numClientes = 10;
		String numCliente;
		int numAleatorioTiempo;
		int numAleatorioProductos;
		
		// ArrayList para crear los clientes
		ArrayList<Cliente>clientes = new ArrayList<Cliente>();
		
		// Generamos los clientes
		for (int i = 0; i < numClientes; i++) {
			numCliente = "Cliente " + i;
			clientes.add(new Cliente(numCliente, arrayCliente()));
		}
		
		long tiempoInicial = System.currentTimeMillis();
		
		// Le pasamos el número de hilos
		ExecutorService executor = Executors.newFixedThreadPool(numCajeras);
		
		// Recorremos los clientes y los vamos pasandos a cada cajera
        for (Cliente cliente: clientes) {
            Runnable cajera = new Cajera(cliente, tiempoInicial);
            executor.execute(cajera);
        }
        
        // Cerramos el executor
        executor.shutdown();
       
        while (!executor.isTerminated()) {
        	// Esperamos a que pasen todos los clientes
        }
	}
	
	// Método para generar el tiempo que tardarán en pasar los productos de los clientes
	public static int[] arrayCliente() {
		
		// Generamos los números aleatorios
		int numAleatorioProductos = numAleatorioTiempo();
		int numAleatorioTiempo = 0;
		
		// Array que devolveremos
		int[] cliente = new int[numAleatorioProductos];
		
		for (int i = 0; i < numAleatorioProductos; i++) {
			numAleatorioTiempo = numAleatorioTiempo();
			cliente[i] = numAleatorioTiempo;
		}
		return cliente;
	}
	
	// Método para generar número aleatorios entre 2 y 8 / 1 y 30
	public static int numAleatorioTiempo() {
		int numAleatorioTiempo = (int) Math.floor(Math.random() * (8-2+1) + 2);
		return numAleatorioTiempo;
	}
	
	public static int numAleatorioProductos() {
		int numAleatorioProductos = (int) Math.floor(Math.random() * (30-1+1) + 1);
		return numAleatorioProductos;
	}
}
