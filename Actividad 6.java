import java.util.*;

class calificaciones {
    private String nombre;
    private int[] calificaciones;

    public calificaciones(String nombre, int[] calificaciones) {
        this.nombre = nombre;
        this.calificaciones = calificaciones;
    }

    public double promedio() {
        int sum = 0;
        for (int calificacion : calificaciones) {
            sum += calificacion;
        }
        return (double) sum / calificaciones.length;
    }

    public char nota(double promedio) {
        char nota;
        if (promedio >= 90 && promedio <= 100) {
            nota = 'A';
        } else if (promedio >= 80 && promedio < 90) {
            nota = 'B';
        } else if (promedio >= 70 && promedio < 80) {
            nota = 'C';
        } else if (promedio >= 60 && promedio < 70) {
            nota = 'D';
        } else if (promedio >= 50 && promedio < 60) {
            nota = 'E';
        } else {
            nota = 'F';
        }
        return nota;
    }

    public void imprimirResultados() {
        System.out.println("Nombre del estudiante: " + nombre);
        for (int i = 0; i < calificaciones.length; i++) {
            System.out.println("Calificación " + (i + 1) + ": " + calificaciones[i]);
        }
        double promedio = promedio();
        char calificacion = nota(promedio);
        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación: " + calificacion);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] calificaciones = {90, 80, 70, 60, 50};
        calificaciones c = new calificaciones("Juan", calificaciones);
        c.imprimirResultados();
    }
}
