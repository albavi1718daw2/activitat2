public class Cajera implements Runnable {

	// Variables
	private Cliente cliente;
	private long tiempoInicial;

	// Constructor
	public Cajera(Cliente cliente, long tiempoInicial) {
		this.cliente = cliente;
		this.tiempoInicial = tiempoInicial;
	}

	@Override
	public void run() {
		
		// El cliente pasa por caja
		System.out.println(cliente.getNumeroCliente() + " pasa por caja...");

		// Vamos procesando productos
		for (int i = 0; i < this.cliente.getCarroCompra().length; i++) { 		
			
			// Se procesa el pedido en un número aleatorio de segundos
			this.tiempoEspera(cliente.getCarroCompra()[i]);
			
			System.out.println(cliente.getNumeroCliente() + " articulo " + (i + 1) + 
					"(" + cliente.getCarroCompra()[i] + " segundos)");
		}

		// Acaba el proceso
		System.out.println(cliente.getNumeroCliente() + " FINALITZAT");

	}

	// Método para el tiempo que se tarda en procesar los pedidos
	private void tiempoEspera(int segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}
