package randomNumbers.statisticalTest;

import org.apache.commons.math3.distribution.ChiSquaredDistribution;

public class UniformityTest extends StatisticalTest{
	public UniformityTest(double alpha,double...ds) {
		super(alpha, ds);
	}
	public boolean test() {
		return getChiSquared()<getChiLimit(alpha, data.length-1);
	}
	public void testWithOutput() {
		System.out.println("El valor de Chi^2 es: " + getChiSquared() +
                "\nEl valor del Limite superior es: " + getChiLimit(alpha, data.length-1));
		if (test()) {
			System.out.println("Por lo tanto no se Rechaza H_0 y se dice que Los Numeros Ri son Uniformes");
		}else {
			System.out.println("Por lo tanto se Rechaza H_0 y se dice que Los Numeros Ri NO son Uniformes");
		}
	}
	private double getChiLimit(double alpha, int degrees) {
		ChiSquaredDistribution chi = new ChiSquaredDistribution(degrees);
		return chi.cumulativeProbability(alpha/2);
	}
	public double getChiSquared() {
		int sections=(int)Math.sqrt(data.length);
		double chiCuadrado=0;
		for (int i = 0; i < sections; i++) {
			chiCuadrado+=Math.abs((countBySection(i, sections)-sections)*(countBySection(i, sections)-sections)/sections);
		}
		
		return chiCuadrado;
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
