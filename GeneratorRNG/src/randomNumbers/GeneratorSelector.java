package randomNumbers;



public class GeneratorSelector {

	public static void main(String[] args) {
		// TODO Add Gui
		MiddleSquare MidSq=new MiddleSquare();
		MiddleProduct midProd=new MiddleProduct();
		ConstantMultiplier constantMultiplier=new ConstantMultiplier();
		MidSq.setSeed(3137);
		midProd.setSeed(15367,92463);
		constantMultiplier.setSeed(62473);
		constantMultiplier.setMultiplier(13741);
		//ArrayList<RandomGenerator> list=new ArrayList<RandomGenerator>();
		//for(RandomGenerator rng:list) {
			for (int i = 0; i < 6; i++) {	
				System.out.printf("%f%n",constantMultiplier.next());
			}
		//}
	}

}
