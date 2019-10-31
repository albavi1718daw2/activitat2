public class Activitat32 {
	public static void main(String[] args) {
		
		// Cogemos el tiempo inicial
		long inicio = System.currentTimeMillis();
        
		// Hacemos el cálculo
		long calculo = calculaFibonacci(30);
         
		// Cogemos el tiempo final
        long fin = System.currentTimeMillis();
         
        // Lo pasamos a segundos
        double tiempo = (double) ((fin - inicio)/1000);
         
        // Mostramos tanto el tiempo de ejecución como el resultado
        System.out.println("Segundos: " + tiempo + ", resultado: " + calculo);
       
	}
	
	// Método para calcular Fibonacci
	public static long calculaFibonacci(long numero) {
        double calcul = java.lang.Math.cos(54879854);
        if (numero==0) { return 0; }
        else if (numero==1) { return 1; }
        else {
            return (calculaFibonacci(numero-2) + calculaFibonacci(numero-1));
        }
    }
}
