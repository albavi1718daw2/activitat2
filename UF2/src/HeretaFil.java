public class HeretaFil extends Thread {

	// Varibales que utilitzarem
	String strImprimir;
	
	// mètode per heretar
	public HeretaFil(String strP) {
		
		strImprimir = strP;
	}

	// execució
	public void run() {
		
		for(int x = 0; x < 5; x++) {
			
			System.out.println(strImprimir+ " " + x);
		}
	}

	public static void main(String[] args) {

		// creem elss fils
		Thread primer = new HeretaFil("Fil 1");
		Thread segon = new HeretaFil("Fil 2");
		Thread tercer = new HeretaFil("Fil 3");
		Thread quart = new HeretaFil("Fil 4");
		Thread cinque = new HeretaFil("Fil 5");
		Thread sise = new HeretaFil("Fil 6");
		Thread sete = new HeretaFil("Fil 7");
		Thread vuite = new HeretaFil("Fil 8");
		Thread nove = new HeretaFil("Fil 9");
		Thread dese = new HeretaFil("Fil 10");
		
		// Cridem al mètode run per la seva execució
		primer.run();
		segon.run();
		tercer.run();
		quart.run();
		cinque.run();
		sise.run();
		sete.run();
		vuite.run();
		nove.run();
		dese.run();
		
		// Mostrem el final del fil principal
		System.out.println("Final Fil Principal");
	}
}

