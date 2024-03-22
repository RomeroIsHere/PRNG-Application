package randomNumbers.statisticalTest;


import java.util.Scanner;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class PruebaVarianza {
	double alpha;
    double [] nums;
    int cantidad;
	public PruebaVarianza(double alpha,double... data) {
		this.alpha = alpha;
    	nums=data;
	}

    public void test(Scanner sc) {
        
//Declaramos las variables que necesitaremos. Note que se establece como nivel de aceptación o confianza el de 95%.
    	System.out.println("Escriba la cantidad de ri: ");
        int cant_datos = sc.nextInt();
        int grados_libertad = cant_datos - 1;
        System.out.println("Escribe el valor de alfa: ");
        double alfa = sc.nextDouble();

        double[] datos = new double[cant_datos];

        // Llenar el arreglo con números ingresados por el usuario
        System.out.println("Ingrese los numeros ri:");
        for (int i = 0; i < cant_datos; i++) {
            System.out.print("Ingrese el numero " + (i + 1) + ": ");
            datos[i] = sc.nextDouble();
        }
//Creamos objetos con las tablas de distribución normal y chi cuadrada, y un objeto que nos ayudará a obtener la media y la varianza.

        ChiSquaredDistribution chi = new ChiSquaredDistribution(grados_libertad);
        DescriptiveStatistics estadistica = new DescriptiveStatistics();


        for (int i = 0; i < cant_datos; i++) {
            estadistica.addValue(datos[i]);
        }

//Declaramos las variables que necesitaremos en la prueba de varianza
        double varianza, li2, ls2;
        varianza = estadistica.getVariance();

//Obtenemos los valores de la tabla de Chi cuadrada:
        li2 = chi.inverseCumulativeProbability(alfa / 2) / (12 * grados_libertad);
        ls2 = chi.inverseCumulativeProbability(1 - alfa / 2) / (12 * grados_libertad);

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
