package randomNumbers.statisticalTest;

import java.util.Scanner;

public class Proceso{
    
    double alpha;
    double [] nums;
    int cantidad;
    Scanner sc = new Scanner(System.in);
    
    public Proceso(double alpha){
        this.alpha = alpha;
    }
    
    public void registrar(){
        System.out.println("Ingrese la cantidad de numeros ri que seran evaluados");
        cantidad = sc.nextInt();
        nums = new double [cantidad];
        int i;
        System.out.println("Ingrese el los numeros ri : ");
        for(i = 0; i < cantidad ; i++){
            nums[i] = sc.nextDouble();
        }
        calcular();
    }
    
    
    private void calcular() {
        double suma = 0;
        double promedio;
        double Ls;
        double Li;
        int i;
        for (i = 0; i < cantidad; i++) {
            suma += nums[i];
        }
        promedio = suma / cantidad;

        Ls = 0.5 + alpha * (1 / Math.sqrt(12 * cantidad));
        Li = 0.5 - alpha * (1 / Math.sqrt(12 * cantidad));

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