import java.util.Scanner;

public class Main {
    public static Scanner in = new Scanner(System.in);
    public static final int SALIR = 2;

    public static void main(String[] args) {

        int opcion = menu();
        do {
            if (opcion == 1) {
                int tamanio = pedirNumero("\nIngrese cantidad de elementos: ");
                Paquete[] paquetes = new Paquete[tamanio];

                for (int i = 0; i < tamanio; i++) {
                    System.out.println("Paquete: " + (i + 1));
                    int valor = pedirNumero("\tIngrese valor: ");
                    int peso = pedirNumero("\tIngrese peso: ");
                    paquetes[i] = new Paquete(peso, valor);
                }

                int capacidad = pedirNumero("Ingrese capacidad de la mochila: ");

                Knapsack.solucion(paquetes, capacidad, tamanio);
            } else {
                System.out.println("Opcion incorrecta");
            }
            opcion = menu();
        } while (opcion != SALIR);

    }

    public static int menu() {
        System.out.println("\n1.-Ingrese datos\n2.-Salir\nIngrese opcion: ");
        return in.nextInt();
    }

    public static int pedirNumero(String str) {
        System.out.print(str);
        return in.nextInt();
    }

}
