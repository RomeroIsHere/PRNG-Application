package randomNumbers;

public class LinearCongruence implements RandomGenerator{
	private int seed,additiveConstant,multiplicativeConstant,currentXValue,amountToGenerate;
	/*
	 * 
	 * @param seed
	 * is a Seed for the start of generation
	 * 
	 * */
	public void setConstants(int seed, int kappa, int adding,int generateNumber) {
		setSeed(seed);
		calculateMultiplicator(kappa);
		additiveConstant=adding;
		setAmountToGenerate(generateNumber);
		
	}
	public void setAmountToGenerate(int amountToGenerate) {
		this.amountToGenerate = Math.abs(amountToGenerate);
	}
	private void calculateMultiplicator(int kappa) {
		multiplicativeConstant=4*kappa+1;
	}
	@Override
	public float next() {
		currentXValue=(multiplicativeConstant*currentXValue+additiveConstant)%amountToGenerate;
		System.out.println(currentXValue);
		return currentXValue/(amountToGenerate-1.0f);
	}

	@Override
	public void setSeed(int seed) {
		this.seed=seed;
		currentXValue=this.seed;
	}
	

}
