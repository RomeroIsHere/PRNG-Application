package randomNumbers.statisticalTest;

import java.util.Scanner;
public class MetodoDeMedias {
Scanner a_teclado;
float alfa, numeros, suma, promedio;
int cantidad;

    public static void main(String[] args) {
        MetodoDeMedias ob=new MetodoDeMedias();
        ob.m_ingrDatos();
    }

    public MetodoDeMedias() {
        a_teclado = new Scanner(System.in);
    }
    
    
    void m_ingrDatos(){
        System.out.println("Ingresa la cantidad de numeros ri");
        cantidad=a_teclado.nextInt();
        System.out.println("Ingresa la lista de numeros ri");
        for(int cont=0; cont<cantidad;cont++){
            
            numeros=a_teclado.nextFloat();
            suma+=numeros;
        }
        promedio=suma/cantidad;
        System.out.println("Ingresa el valor de alfa \n Nota. Los tres valores de alfa a eleguir son: 0.01, 0.05, 0.1");
         alfa=a_teclado.nextFloat();
         m_calculos(alfa, promedio, cantidad);
    }
    
    void m_calculos(float v_alfa, float v_promedio, int v_ndatos){
        float limitei, limites;
        if(v_alfa==0.01){
            limitei=(float) (0.5-( 2.58*(1/Math.sqrt((12*cantidad)))));
            limites= (float) (0.5+( 2.58*(1/Math.sqrt((12*cantidad)))));
        }
        else
            if(v_alfa==0.05){
                 limitei=(float) (0.5-( 1.96*(1/Math.sqrt((12*cantidad)))));
                 limites= (float) (0.5+( 1.96*(1/Math.sqrt((12*cantidad)))));
            }
            else{
             limitei=(float) (0.5-( 1.65*(1/Math.sqrt((12*cantidad)))));
             limites= (float) (0.5+( 1.65*(1/Math.sqrt((12*cantidad)))));
            }
        
        if(v_promedio<=limites && v_promedio>=limitei){
            System.out.println("El promedio de los numeros ri es: "+v_promedio+"\nEl limite superior es: "+limites+" y el inferior es: "+limitei);
            System.out.println("Ho no se rechaza. \nPor lo tanto los numeros ri tienen una media de 0.5");}
        else{
            System.out.println("El promedio de los numeros ri es: "+v_promedio+"\nEl limite superior es: "+limites+" y el inferior es: "+limitei);
            System.out.println("Ho se rechaza. \nPor lo tanto los numeros ri no tienen una media de 0.5");
        }
    }
    
}
