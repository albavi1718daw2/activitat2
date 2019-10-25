import java.util.*;
import java.util.concurrent.*;

public class Activitat1 {
	
	static class Suma implements Callable<Integer> {
		private int operador1;
		private int operador2;

		public Suma(int operador1, int operador2) {
			this.operador1 = operador1;
			this.operador2 = operador2;
		}

		@Override
		public Integer call() throws Exception {
			return operador1 + operador2;
		}
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// Indicamos cuántos hilos queremos que tenga nuestro executor
		ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
		
		// Instanciamos un ArrayList para guardar las sumas
		List<Suma> llistaTasques= new ArrayList<Suma>();
		
		// Realizamos las tareas, tenemos un bucle que llamá a la clase Suma y le pasamos 2
		// números aleatorios, los cuales sumamos entre si
		for (int i = 0; i < 25; i++) {
			Suma calcula = new Suma((int)(Math.random()*10), (int)(Math.random()*10));
			llistaTasques.add(calcula);
		}
		
		// Lista donde guardaremos los resultados
		List <Future<Integer>> llistaResultats;
		
		// Cuando hemos acabado todas las operaciones, lo agrupamos
		llistaResultats = executor.invokeAll(llistaTasques);

		// Después de ejecutar todas las tareas, cerramos el grupo de subprocesos
		executor.shutdown();

		// Mostramos los resultados
		for (int i = 0; i < llistaResultats.size(); i++) {
			
			Future<Integer> resultat = llistaResultats.get(i);
			
			try {
				System.out.println("Resultat tasca "+ (i + 1) +  " és:" +
						resultat.get());
			}
			catch (InterruptedException | ExecutionException e)
			{
				System.out.println(e);
			}
		}
	}
}
