package randomNumbers.statisticalTest;

public abstract class StatisticalTest {
	protected double alpha,data[];
	public StatisticalTest(double alpha,double...ds) {
		data=ds;
		this.alpha=alpha;
	}
}
