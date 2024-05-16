# Metodos_Numericos
Realizado por:
  <li> José Antonio Guerrero Lazcano</li>
 
<h2 align = "center"> <font color = "darkorange" size = "+6"  font face = "bauhaus 93">  Indice </font> </h2>
<header> <font color = "red" size="+1" font face = "aharoni">
                <nav class="navegacion">                   
     <li> <a href="#Descripcion"> Descripción </a> <br> </li>
                            <ul class="subindice"> 
                                <li> <a href="#Lineal"> Interpolación lineal (5 ejemplos). </a> </li>
                                <li> <a href="#cuadratica"> Interpolación cuadratica (1 ejemplo). </a> </li>
                                <li> <a href="#langrage"> Interpolación langrage (5 ejemplos). </a> </li> 
                                <li> <a href="#Newton"> Interpolación de newton (5 ejemplos). </a> </li> 
                            </ul>
                    </ul>
                </nav>
            </font> </header>

<h2 align = "center"> <font font face = "forte">  <a name="Descricpcion"> Descripción </a></h2>
La interpolación en métodos numéricos es una técnica utilizada para estimar valores desconocidos de una función a partir de un conjunto de valores conocidos. Es una herramienta fundamental en el análisis numérico y se emplea en diversas áreas como la ingeniería, la física y la economía, donde es necesario trabajar con datos discretos o aproximar funciones.  

  Existen varios métodos de interpolación, cada uno con sus propias características y aplicaciones. Algunos de los más comunes son:
  <li>1.-Interpolación lineal</li>
  <li>2.-Interpolación cuadratica</li>
  <li>3.-Interpolación langrage</li>
  <li>4.-Interpolación de newton</li>

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

<h2 align = "center"> <font font face = "forte">  <a name="Lineal"> 1. Interpolación lineal </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

La interpolación lineal es útil cuando buscamos un valor entre puntos dados. Se puede considerar como "llenar los espacios" de una tabla de datos. La estrategia para la interpolación lineal es usar una línea recta para conectar los datos conocidos a ambos lados del punto desconocido.   

<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>

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
        double[] x = {1.0, 2.0, 3.0, 4.0, 5.0};

        double[] y = {2.0, 4.0, 6.0, 8.0, 10.0};

        double xTarget = 2.5;
        double yTarget = interpolate(x, y, xTarget);

        System.out.println("El valor de y para x = " + xTarget + " es " + yTarget);
    }
}

<h2 align = "center"> <font font face = "forte">  <a name="Cuadratica"> 2.- Interpolación cuadratica </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

La interpolación cuadrática es un método utilizado en matemáticas y ciencias computacionales para encontrar una función cuadrática que pase a través de un conjunto de puntos dados. En lugar de ajustarse a una línea recta como en la interpolación lineal, la interpolación cuadrática utiliza una función de segundo grado (una parábola) para aproximar los valores entre los puntos conocidos. Este método es útil cuando se necesita una aproximación suave y curva entre los puntos de datos, lo que puede proporcionar una representación más precisa de la relación subyacente entre los puntos interpolados.   

<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>

    public static void main(String[] args) {
        System.out.println("Solucion de ecuaciones cuadráticas");
        double a = 1, b = -3, c = 2, x1, x2, producto, cuadrado, diferencia, raiz;

        cuadrado = Math.pow(b, 2);
        producto = 4 * a * c;
        diferencia = cuadrado - producto;
        raiz = Math.sqrt(diferencia);

        x1 = (-b + raiz) / (2 * a);
        x2 = (-b - raiz) / (2 * a);

        System.out.println("La ecuacion es: " + a + "x^2 + " + b + "x + " + c + " = 0");
        System.out.println("Las raices son:");
        System.out.println("El valor de x1 es: " + x1);
        System.out.println("El valor de x2 es: " + x2);
    }
}


<h2 align = "center"> <font font face = "forte"> <a name="Langrage">  3.- Interpolación langrage </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

La interpolación de Lagrange es un método matemático para encontrar un polinomio que pasa a través de un conjunto de puntos dados. A diferencia de la interpolación cuadrática, que utiliza un polinomio de grado 2, la interpolación de Lagrange puede generar polinomios de cualquier grado para ajustarse a los puntos.   

<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>


    public static double interpolate(double[] x, double[] y, double xTarget) {
        double result = 0;

        for (int i = 0; i < x.length; i++) {
            double term = y[i];
            for (int j = 0; j < x.length; j++) {
                if (j != i) {
                    term = term * (xTarget - x[j]) / (x[i] - x[j]);
                }
            }
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        double[] x = {0.5, 1.5, 2.5, 3.5, 4.5};
        double[] y = {2.5, 4.5, 6.5, 8.5, 10.5};
        double xTarget = 3.0;

        double yTarget = interpolate(x, y, xTarget);

        System.out.println("El valor interpolado de y para x = " + xTarget + " es " + yTarget);
    }
}



<h2 align = "center"> <font font face = "forte"> <a name="Newton">  4.Interpolación de newton </a></h2>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

La interpolación de Newton es un método utilizado en matemáticas y análisis numérico para encontrar un polinomio que pase a través de un conjunto de puntos dados. Este método fue desarrollado por Isaac Newton y es una alternativa a la interpolación de Lagrange.   

<h5> <font font face = "arial"> <b> <i> Ejemplo en código. </i> </b> </h5>
  

    public static double interpolate(double[] x, double[] y, double xTarget) {
        double yTarget = y[0];
        for (int i = 0; i < x.length - 1; i++) {
            if (x[i] <= xTarget && x[i + 1] > xTarget) {
                double h = x[i + 1] - x[i];
                double k = (xTarget - x[i]) / h;
                double y0 = y[i];
                double y1 = y[i + 1];
                yTarget = y0 + k * (y1 - y0);
                break;
            }
        }
        return yTarget;
    }

    public static void main(String[] args) {
        double[] x = {10.0, 20.0, 30.0, 40.0, 50.0};
        double[] y = {15.0, 25.0, 35.0, 45.0, 55.0};

        double xTarget = 25.0;

        double yTarget = interpolate(x, y, xTarget);

        System.out.println("El valor interpolado de y para x = " + xTarget + " es " + yTarget);
    }
}
