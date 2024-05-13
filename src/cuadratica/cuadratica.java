/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cuadratica;

import java.util.Scanner;

/**
 *
 * @author tono_
 */
public class cuadratica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Solucion de ecuaciones cuadráticas");
        double a, b, c, x1, x2, producto, cuadrado, diferencia, raiz;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el coeficiente a");
        a = scanner.nextDouble();
        System.out.println("Ingresa el coeficiente b");
        b = scanner.nextDouble();
        System.out.println("Ingresa el coeficiente c");
        c = scanner.nextDouble();

        cuadrado = Math.pow(b, 2);
        producto = 4 * a * c;
        diferencia = cuadrado - producto;
        raiz = Math.sqrt(diferencia);

        x1 = (-b + raiz) / (2 * a);
        x2 = (-b - raiz) / (2 * a);

        System.out.println("La ecuacion es: " + a + "x^2 + " + b + "x + " + c + " = 0");
        System.out.println("Las raices son:");
        System.out.println("El valor de x1 es: " + x1);
        System.out.println("El valor de x2 es: "+x2);
    }
}