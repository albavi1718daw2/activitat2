import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class Activitat3 extends RecursiveTask<Long> {

	long numero;

	public Activitat3(long numero){
		this.numero=numero;
	}    

	@Override
	protected Long compute() {
		double calcul = java.lang.Math.cos(54879854);
		if(numero <= 1) return numero;
		Activitat3 fib1 = new Activitat3(numero-1);
		fib1.fork();
		Activitat3 fib2 = new Activitat3(numero-2);
		fib2.fork();
		return fib1.compute()+ fib2.join();
	}

	public static void main(String[] args){
		// Cogemos el tiempo inicial
		long inicio = System.currentTimeMillis();
		ForkJoinPool pool = new ForkJoinPool();
		long resultado = pool.invoke(new Activitat3(40));   
		// Cogemos el tiempo final
        long fin = System.currentTimeMillis();
     // Lo pasamos a segundos
        double tiempo = (double) ((fin - inicio)/1000);
     // Mostramos tanto el tiempo de ejecución como el resultado
        System.out.println("Segundos: " + tiempo + ", resultado: " + resultado);
	}
}
