import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de discos: ");
        int numDiscos = scanner.nextInt();
        C_Jhanoi juego = new C_Jhanoi(numDiscos);
        juego.ejecutar(numDiscos);
        scanner.close();
    }
}