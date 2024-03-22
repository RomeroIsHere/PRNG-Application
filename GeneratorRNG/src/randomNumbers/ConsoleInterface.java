package randomNumbers;

import java.util.Scanner;

public class ConsoleInterface {
	Scanner scanner;
	public ConsoleInterface(Scanner SC) {
		// TODO Auto-generated constructor stub
		scanner=SC;
	}
	public void showMainMenu() {
		//Console Menu
		System.out.println("\t Selecciona el Generador Deseado"
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""
				+ ""); 
	}
	public double[] registrar() {
		System.out.println("Ingrese la cantidad de numeros ri que seran evaluados");
        int cantidad = scanner.nextInt();
        double[] nums = new double [cantidad];
        int i;
        System.out.println("Ingrese el los numeros ri : ");
        for(i = 0; i < cantidad ; i++){
            nums[i] = scanner.nextDouble();
        }
        return nums;
	}
	public double confidence() {
		System.out.println("Escribe el valor de alfa: ");
		return scanner.nextDouble();
	}
	
}
