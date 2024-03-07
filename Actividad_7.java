import java.util.*;
public class Actividad_7 {
    
    private int n;
    
    public Actividad_7(int n) {
        this.n = n;
    }
    
    public int[] calcularNumerosPrimos() {
        int[] primos = new int[n];
        int count = 0;
        for (int num = 2; count < n; num++) {
            if (esPrimo(num)) {
                primos[count] = num;
                count++;
            }
        }
        return primos;
    }
    
    private boolean esPrimo(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    public int[] calcularFibonacci() {
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }
        return fibonacci;
    }
    
    public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad de números a calcular: ");
         int n = scanner.nextInt(); // Número de elementos para calcular
        Actividad_7 programa = new Actividad_7(n);
        
        int[] primos = programa.calcularNumerosPrimos();
        System.out.println("Números primos:");
        for (int primo : primos) {
            if (primo != 0) {
                System.out.print(primo + " ");
            }
        }
        System.out.println();
        
        int[] fibonacci = programa.calcularFibonacci();
        System.out.println("Sucesión de Fibonacci:");
        for (int num : fibonacci) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
