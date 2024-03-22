package randomNumbers.statisticalTest;

public class UniformityTest{
	private double[] data; 
	public UniformityTest(double...ds) {
		data=ds;
	}
	public boolean test(double limit) {
		int sections=(int)Math.sqrt(data.length);
		double chiCuadrado=0;
		for (int i = 0; i < sections; i++) {
			chiCuadrado+=Math.abs((countBySection(i, sections)-sections)*(countBySection(i, sections)-sections)/sections);
		}
		
		return chiCuadrado<limit;
	}
	private int countBySection(int i, int sections) {
		double lower=(i-1)*(1.0/sections);
		double higher=i*(1.0/sections);
		int count=0;
		for (int j = 0; j < data.length; j++) {
			count=(data[i]<=higher&&data[i]>lower)?count+1:count;
		}
		return count;
	}

}
