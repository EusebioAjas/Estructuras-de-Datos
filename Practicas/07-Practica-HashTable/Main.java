import java.util.Scanner;

//Ejecutar javac *.java ; java Main
public class Main {
    public static int SALIR = 3;
    public static int VALOR;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Ingrese numero de elementos: ");
        int numDatos = in.nextInt();
        Hash hash = new Hash(numDatos);
        llenarDatos(hash, numDatos);
        hash.imprimirTabla();
        int op = menu();
        do {
            switch (op) {
                case 1:
                    System.out.print("Ingrese numero a buscar: ");
                    VALOR = in.nextInt();
                    // Devuelve el valor si se encontró, de lo contrario devuele un -1
                    System.out.println("Resultado: " + hash.buscar(VALOR));
                    break;
                case 2:
                    System.out.print("Ingrese numero a eliminar: ");
                    VALOR = in.nextInt();
                    hash.eliminar(VALOR);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
            // Al imprimir la tabla aquella direccion que no contenga ningun dato no se
            // imprime
            hash.imprimirTabla();
            op = menu();
        } while (op != SALIR);
    }

    public static int menu() {
        Scanner op = new Scanner(System.in);
        System.out.println("1.-Buscar elemento:\n2.-Eliminar elemento:\n3.-Salir\nIngrese opcion: ");
        return op.nextInt();
    }

    public static void llenarDatos(Hash hash, int n) {
        int numElementos = 5 * n;
        for (int i = 0; i < numElementos; i++) {
            hash.insertar(Metodos.random(n));
        }
    }
}
