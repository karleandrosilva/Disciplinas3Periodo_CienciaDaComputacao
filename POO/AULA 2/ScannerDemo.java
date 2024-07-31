import java.util.Scanner;

public class ScannerDemo {
    public static void main (String[] args) {
        System.out.print("Entre com um nome: ");
        Scanner scn = new Scanner(System.in);
        String entrada = scn.nextLine();
        System.out.printf("Nome: %s", entrada);
    }
}