package randomNumbers.statisticalTest;


public class PruebaMedias extends StatisticalTest{
    
    public PruebaMedias(double alpha,double... ds) {
    	super(alpha, ds);
    	
    }

    
    
    public void calcular() {
        double suma = 0;
        double promedio;
        double Ls;
        double Li;
        int i;
        for (i = 0; i < data.length; i++) {
            suma += data[i];
        }
        promedio = suma / data.length;
        if(alpha==0.01){
            Li=(0.5-( 2.58*(1/Math.sqrt((12*data.length)))));
            Ls= (0.5+( 2.58*(1/Math.sqrt((12*data.length)))));
        }
        else
            if(alpha==0.05){
            	Li=(0.5-( 1.96*(1/Math.sqrt((12*data.length)))));
            	Ls= (0.5+( 1.96*(1/Math.sqrt((12*data.length)))));
            }
            else{
            	Li= (0.5-( 1.65*(1/Math.sqrt((12*data.length)))));
            	Ls= (0.5+( 1.65*(1/Math.sqrt((12*data.length)))));
            }

        if (promedio < Ls && promedio > Li)
            System.out.println("El valor promedio de r es: " + promedio +
                    "\nEl valor del Limite superior es: " + Ls +
                    "\nEl valor del Limite inferior es: " + Li +
                    "\nPor lo tanto se acepta H_0 y se dice que Mri = 0.5");
        else
            System.out.println("\nEl valor promedio de r es: " + promedio +
                    "\nEl valor del Limite superior es: " + Ls +
                    "\nEl valor del Limite inferior es: " + Li +
                    "\nPor lo tanto se rechaza H_0 y se dice que Mri es diferente de 0.5");
    }
}