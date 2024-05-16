package Lineal;

public class Lineal_4 {

    public static double interpolate(double[] x, double[] y, double xTarget) {
        int n = x.length;
        double yTarget = 0;

        int i = 0;
        while (i < n - 1 && x[i] < xTarget) {
            i++;
        }

        if (i == 0) {
            yTarget = y[0];
        } else if (i == n - 1) {
            yTarget = y[n - 1];
        } else {
            double x0 = x[i - 1];
            double x1 = x[i];
            double y0 = y[i - 1];
            double y1 = y[i];

            double m = (y1 - y0) / (x1 - x0);
            double b = y0 - m * x0;
            yTarget = m * xTarget + b;
        }

        return yTarget;
    }

    public static void main(String[] args) {
        double[] x = {2.0, 4.0, 6.0, 8.0, 10.0};
        double[] y = {10.0, 20.0, 30.0, 40.0, 50.0};

        double xTarget = 7.0;
        double yTarget = interpolate(x, y, xTarget);

        System.out.println("El valor de y para x = " + xTarget + " es " + yTarget);
    }
}
