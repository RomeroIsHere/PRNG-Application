package randomNumbers;

import java.util.Scanner;

import randomNumbers.Generators.*;
import randomNumbers.statisticalTest.PruebaVarianza;

public class GeneratorSelector {

	public static void main(String[] args) {
			ConsoleInterface cInterface=new ConsoleInterface(new Scanner(System.in));
			cInterface.registrar();
			cInterface.showMainMenu();
			double[] data=cInterface.registrar();
			double alpha=cInterface.confidence();
			PruebaVarianza pruebaVarianza=new PruebaVarianza(alpha,data);
		    pruebaVarianza.test(cInterface.scanner);
	}
	
	public static void showGeneration(RandomGenerator RNG,int numbersToGenerate) {
		System.out.println("Generador "+RNG.getClass());
		for (int i = 0; i < numbersToGenerate; i++) {	
			System.out.printf("%f%n",RNG.next());
		}
	}

}
