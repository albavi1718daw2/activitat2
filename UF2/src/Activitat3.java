import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Activitat3 extends RecursiveTask<Long> {

	long numero;

	public Activitat3(long numero){
		this.numero=numero;
	}    

	@Override
	protected Long compute() {
		
		// Calculamos el coseno
		double calcul = java.lang.Math.cos(54879854);
		
		// Hacemos el return
		if (numero <= 1) return numero;
		
		// Instanciamos la propia clase
		Activitat3 fib1 = new Activitat3(numero-1);
		
		// Lo dividimos en tareas más pequeñas
		fib1.fork();
		
		// Hacemos el mismo proceso
		Activitat3 fib2 = new Activitat3(numero-2);
		fib2.fork();
		
		// fib1 llama al compute donde implementamos la lógica,
		// fib2 llama al join que espera a que las tareas finalicen
		return fib1.compute()+ fib2.join();
	}

	public static void main(String[] args) {
		
		// Cogemos el tiempo inicial
		long inicio = System.currentTimeMillis();
		
		// Instanciamos la clase ForkJoinPool para dividar una tarea principal
		// en grupos más pequeños
		ForkJoinPool pool = new ForkJoinPool();
		
		// Cogemos el resultado
		long resultado = pool.invoke(new Activitat3(40));   
		
		// Cogemos el tiempo final
        long fin = System.currentTimeMillis();
        
        // Lo pasamos a segundos
        double tiempo = (double) ((fin - inicio)/1000);
        
        // Mostramos tanto el tiempo de ejecución como el resultado
        System.out.println("Segundos: " + tiempo + ", resultado: " + resultado);
	}
}
