import java.util.Scanner;


public class One {
    public static Double geron(double a, double n) {
        double x = 0.5 * (n + a / n);
        return x;
    }

    public static void main(String[] args) {
        double n = 1;
        double x;
        double d = 0.000000000000001;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число");
        int a = scanner.nextInt();
        while (Math.abs(geron(a, n) - n) > d) {
            x = (geron(a, n));
            n = x;
        }
        System.out.println(n);
    }
}