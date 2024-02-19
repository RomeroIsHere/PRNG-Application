package randomNumbers.Generators;

public class ConstantMultiplier extends MiddleSquare implements RandomGenerator{
	private int multiplier;

@Override
	public float next() {
		long temp=getMiddle(currentXValue*multiplier, digits);
		
		currentXValue=temp;
		return temp*(float)Math.pow(.1, digits);
	}
	
	public int getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(int multiplier) {
		this.multiplier = Math.abs(multiplier);
	}
	
}
