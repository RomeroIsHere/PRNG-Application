package randomNumbers.statisticalTest;


import java.util.Scanner;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class PruebaVarianza extends StatisticalTest{
	public PruebaVarianza(double alpha,double... data) {
		super(alpha, data);
	}

    public void test(Scanner sc) {
        int grados_libertad = data.length - 1;
//Creamos objetos con las tablas de distribución normal y chi cuadrada, y un objeto que nos ayudará a obtener la media y la varianza.

        ChiSquaredDistribution chi = new ChiSquaredDistribution(grados_libertad);
        DescriptiveStatistics estadistica = new DescriptiveStatistics();
        for (double d : data) {
			estadistica.addValue(d);
		}

//Declaramos las variables que necesitaremos en la prueba de varianza
        double varianza, li2, ls2;
        varianza = estadistica.getVariance();
//Obtenemos los valores de la tabla de Chi cuadrada:
        li2 = chi.inverseCumulativeProbability(alpha / 2) / (12 * grados_libertad);
        ls2 = chi.inverseCumulativeProbability(1 - alpha / 2) / (12 * grados_libertad);

//Mostramos los resultados en pantalla:
        System.out.println("---Prueba de varianza---");
        System.out.println("Varianza: " + varianza);
        System.out.println("Limite inferior: " + li2);
        System.out.println("Limite superior: " + ls2);
        if (varianza < ls2 && varianza > li2) {
            System.out.println("H0, no se rechaza");
        } else {
            System.out.println("H0, se rechaza");
        }    }
}
