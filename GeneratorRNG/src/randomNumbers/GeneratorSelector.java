package randomNumbers;

import randomNumbers.Generators.*;

public class GeneratorSelector {

	public static void main(String[] args) {
		// TODO Add GUI
		
		MiddleSquare MidSq=new MiddleSquare();
		MiddleProduct midProd=new MiddleProduct();
		ConstantMultiplier constantMultiplier=new ConstantMultiplier();
		LinearCongruence linearC=new LinearCongruence();
		
		
		MidSq.setSeed(837462);
		midProd.setSeed(28371,46293);
		constantMultiplier.setSeed(762419);
		constantMultiplier.setMultiplier(163916);
		linearC.setConstants(83,12,37,16);
		showGeneration(MidSq, 8);
		showGeneration(midProd, 8);
		showGeneration(constantMultiplier,8);
		showGeneration(linearC,linearC.getAmountToGenerate());
			
	}
	public static void showGeneration(RandomGenerator RNG,int numbersToGenerate) {
		System.out.println("Generador "+RNG.getClass());
		for (int i = 0; i < numbersToGenerate; i++) {	
			System.out.printf("%f%n",RNG.next());
		}
	}

}
