package org.example;
import java.util.Scanner;

public class Main {
    private static final double ZemlyaR = 6371.0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите долготу первой точки:");
        double dol1 = scanner.nextDouble();
        System.out.println("Введите широту первой точки:");
        double shir1 = scanner.nextDouble();
        System.out.println("Введите долготу второй точки:");
        double dol2 = scanner.nextDouble();
        System.out.println("Введите широту второй точки:");
        double shir2 = scanner.nextDouble();
        double distance = raschetDist(dol1, shir1, dol2, shir2);
        System.out.println("Расстояние между точками: " + distance + " км");
        scanner.close();
    }
    public static double raschetDist(double dol1, double shir1, double dol2, double shir2) {
        double dol1R = Math.toRadians(dol1);
        double shir1R = Math.toRadians(shir1);
        double dol2R = Math.toRadians(dol2);
        double shir2R = Math.toRadians(shir2);
        double rdol = dol2R - dol1R;
        double rshir = shir2R - shir1R;
        double a = Math.pow(Math.sin(rdol / 2), 2) + Math.cos(dol1R) * Math.cos(dol2R) * Math.pow(Math.sin(rshir / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double dist = ZemlyaR * c;
        return dist;
    }
}