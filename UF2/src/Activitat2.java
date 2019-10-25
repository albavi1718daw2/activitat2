import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Activitat2 {
	public static void main(final String... args) throws InterruptedException, ExecutionException {

		// Mostramos la hora antes de que se ejecute el programa
		Calendar calendario = new GregorianCalendar();
		System.out.println("Inici: "+ calendario.get(Calendar.HOUR_OF_DAY) + ":" + calendario.get(Calendar.MINUTE) +
				":" + calendario.get(Calendar.SECOND));
		
		// Creamos un pool de 4 hilos
		final ScheduledExecutorService schExService = Executors.newScheduledThreadPool(4);
		
		// Creamos un objecto Runnable
		final Runnable ob = new Activitat2().new ExecutaFil();
		
		// Programa Fil, se inicia a los 5 segundos, después se ejecuta cada 6 segundos
		schExService.scheduleWithFixedDelay(ob, 5, 6, TimeUnit.SECONDS);
		
		// Esperamos 30 segundos para acabar porque es lo que tardaba
		schExService.awaitTermination(30, TimeUnit.SECONDS);
		
		// Después de ejecutar todas las tareas, cerramos el grupo de subprocesos
		schExService.shutdownNow();
		
		// Mostramos que se ha completa
		System.out.println("Completat");
	}

	// Fil Runnable
	class ExecutaFil implements Runnable {
		@Override
		public void run() {
			Calendar calendario = new GregorianCalendar();
			System.out.println("Hora execució tasca: "+
					calendario.get(Calendar.HOUR_OF_DAY) + ":" +
					calendario.get(Calendar.MINUTE) + ":" +
					calendario.get(Calendar.SECOND));
			System.out.println("Tasca en execució");
			System.out.println("Execució acabada");
		}
	}
}