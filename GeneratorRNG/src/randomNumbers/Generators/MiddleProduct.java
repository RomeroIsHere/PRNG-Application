package randomNumbers.Generators;

public class MiddleProduct extends MiddleSquare implements RandomGenerator{
	private long secondSeed,previousXValue;
	
	
	
public void setSeed(int first, int second) {
	seed=previousXValue=Math.abs(first);
	secondSeed=currentXValue=Math.abs(second);
	digits=Math.max((seed+"").length(),(secondSeed+"").length());
	
}

@Override
public float next() {
	int temp=(int) getMiddle(previousXValue*currentXValue,digits);
	previousXValue=currentXValue;
	currentXValue=temp;
	return temp*(float)Math.pow(.1, digits);
}
@Override
public void setSeed(int seed) {
	setSeed(seed,seed);
}

}
