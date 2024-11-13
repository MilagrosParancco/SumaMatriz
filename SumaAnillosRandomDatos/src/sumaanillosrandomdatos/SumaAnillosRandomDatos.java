package sumaanillosrandomdatos;
import java.util.Scanner;
import java.util.Random; 
public class SumaAnillosRandomDatos {
    public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
        System.out.println("Ingrese la dimension de su matriz cuadrada (dxd): ");
        int d=scanner.nextInt(); 
        if(d<0) 
        {
            System.out.println("Ingrese un numero positivo ");
            return; 
        }
        System.out.println("Ingrese el numero del anillo cuyos elementos quiere sumar " +
                "(considerando que se lee de adentro hacia afuera e inicia en 0): ");
        int k=scanner.nextInt(); 
        
        int[][] matriz = MatrizAleatoria(d);
        mostrarMatriz(matriz);

        
        int resultado = SumaAnillos(matriz, d, k);
            System.out.println("La suma del anillo " + k + " es: " + resultado);
               
    }  
    
    public static int [][] MatrizAleatoria(int d) {
        Random random = new Random();
        int [][]matriz=new int[d][d]; 
        
        System.out.println("Ingrese4 los elementos para la matriz: ");
        for(int i=0;i<d;i++) {
            for(int j=0; j<d;j++) {
                //matriz[i][j] = random.nextInt(100); genera datos positivos
                matriz[i][j] = random.nextInt(101)-50; //genera datos negativos entre -50 y 50 
            }
        } return matriz;    
    } 
    
    public static void mostrarMatriz(int[][] matriz) {
        System.out.println("Matriz generada:");
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(elemento + "\t");
            }
            System.out.println();
        }
    } 
    
    public static int SumaAnillos(int [][]matriz, int d, int k) {
        int suma=0; 
        for(int col=k; col<d-k; col++) 
        {
            suma+=matriz[k][col]; 
        }
        for(int col=k; col<d-k; col++) 
        {
            suma+=matriz[d-k-1][col]; 
        }
        for(int fila=k+1; fila<d-k-1; fila++) 
        {
            suma+=matriz[fila][k];
        }
        for(int fila=k+1; fila<d-k-1; fila++) 
        {
            suma+=matriz[fila][d-k-1]; 
        } return suma; 
    }
} 