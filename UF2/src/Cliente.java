public class Cliente {
	
	private String numeroCliente;
	private int[] carroCompra;

	// Constructor
	public Cliente(String numeroCliente, int[] carroCompra) {
		this.numeroCliente = numeroCliente;
		this.carroCompra = carroCompra;
	}
	
	// Getter y setter
	public String getNumeroCliente() {
		return numeroCliente;
	}

	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}

	public int[] getCarroCompra() {
		return carroCompra;
	}

	public void setCarroCompra(int[] carroCompra) {
		this.carroCompra = carroCompra;
	}
}
