package randomNumbers;



public class GeneratorSelector {

	public static void main(String[] args) {
		// TODO Add GUI
		MiddleSquare MidSq=new MiddleSquare();
		MiddleProduct midProd=new MiddleProduct();
		ConstantMultiplier constantMultiplier=new ConstantMultiplier();
		LinearCongruence linearC=new LinearCongruence(); 
		MidSq.setSeed(3137);
		midProd.setSeed(15367,92463);
		constantMultiplier.setSeed(62473);
		constantMultiplier.setMultiplier(13741);
		linearC.setConstants(57,43, 93, 8);
			for (int i = 0; i < 8; i++) {	
				System.out.printf("%f%n",linearC.next());
			}
	}

}
