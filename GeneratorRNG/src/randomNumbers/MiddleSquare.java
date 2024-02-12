package randomNumbers;

public class MiddleSquare implements RandomGenerator{
	protected long seed,currentXValue;
	protected int digits;
	
	protected long getMiddle(long value, int digits) {
	int digitsOfSquare=(value+"").length();
	if ((digitsOfSquare+digits)%2==1) {
		value+=Math.pow(10, digitsOfSquare);
		digitsOfSquare++;
	}
	int remove=(digitsOfSquare-digits)/2;
		
	value=value%(int)Math.pow(10,digitsOfSquare-remove);
	
	value=value/(int)Math.pow(10,remove);
	return value;	
	}
	@Override
	public float next() {
		long temp=getMiddle(currentXValue*currentXValue, digits);
		currentXValue=temp;
		
		
		return temp*(float)Math.pow(.1, digits);
	}
	@Override
	public void setSeed(int seed) {
		this.seed=currentXValue=Math.abs(seed);
		digits=(seed+"").length();
	}
	public int getSeed() {
		return (int)seed;
	}
}
