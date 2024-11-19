package anillosdematriz;

import java.util.Random;
import java.util.Scanner;

public class AnillosdeMatriz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Ingrese el número de matrices que desea procesar: ");
        int numMatrices = scanner.nextInt();

        int[] dimensiones = new int[numMatrices];
        long[] tiemposEjecucion = new long[numMatrices];

        for (int i = 0; i < numMatrices; i++) {
            System.out.println("Ingrese la dimension de su matriz cuadrada (dxd): ");
            int d = scanner.nextInt();
            if (d <= 0) {
                System.out.println("Ingrese un número positivo ");
                return;
            }
            dimensiones[i] = d;

            int k=1; 

            int[][] matriz = generarMatrizAleatoria(d, random);
            mostrarMatriz(matriz);

            long totalTiempoEjecucion = 0; 

            for (int j = 0; j < 100000; j++) { 
                long inicio = System.nanoTime();
                SumaAnillos(matriz, d, k); 
                long fin = System.nanoTime();
                totalTiempoEjecucion += (fin - inicio); 
            }

        
            tiemposEjecucion[i] = totalTiempoEjecucion / 100000;

            System.out.println("La suma del anillo " + k + " es: " + SumaAnillos(matriz, d, k));
        }

        System.out.println("\nResultados finales:");
        for (int i = 0; i < numMatrices; i++) {
            System.out.println("Dimensión: " + dimensiones[i] + "x" + dimensiones[i] +
                    ", Tiempo de ejecución: " + tiemposEjecucion[i] + " ms");
        }
    }

    public static int[][] generarMatrizAleatoria(int d, Random random) {
        int[][] matriz = new int[d][d];

        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                matriz[i][j] = random.nextInt(101) - 50; 
            }
        }
        return matriz;
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

    public static int SumaAnillos(int[][] matriz, int d, int k) {
                int suma = 0;

        for (int col = k; col < d - k; col++) {
            suma += matriz[k][col]; 
            suma += matriz[d - k - 1][col]; 
        }

        for (int fila = k + 1; fila < d - k - 1; fila++) {
            suma += matriz[fila][k];       
            suma += matriz[fila][d - k - 1]; 
        }

        return suma;
    }
} 