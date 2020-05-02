/**
 * El juego de las 20 preguntas, consiste en que jugador “tipo A” proporciona un número entre un
 * rango de valores [liminf – limsup], y el jugador “tipo B” tiene que adivinar en el menor número
 * de intentos el número encerrado en dicho intervalo.
 *
 *Ejemplo:
 * 10 es un valor en el intervalo limif=1 y limsup=30.
 *Entrada>1 30 10
 *Salida>15 7 11 9 10
 */


import java.util.Scanner;

public class BinarySearchGame {
    public static final Scanner INPUT = new Scanner(System.in);

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        Scanner s = new Scanner(System.in);
        int validar = 0;
        while (validar == 0) {
            try {
                System.out.print("ENTRADA: ");
                int[] datos = pedirDatos();
                int limInf = datos[0];
                int limSup = datos[1];
                int numAdivinar = datos[2];
                if (validarDatos(limInf, limSup, numAdivinar)) {
                    binarySearch(limInf, limSup, numAdivinar);
                } else {
                    System.out.println(" ¡¡¡ Datos No Validos !!!");
                }
                System.out.println("¿Desea salir del juego? : Si --> (1), No --> (0)");
                validar = s.nextInt();
                // System.out.println(limInf+ " "+limSup+" "+ numAdivinar);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Por favor ingrese solo 3 valores");
            }
        }

    }

    public static void binarySearch(int limInf, int limSup, int num) {
        int low = limInf;
        int high = limSup;
        int cont = 0;
        int numIntentos = 20;
        System.out.print("SALIDA: ");
        while (cont < numIntentos) {
            int middle = (low + high) / 2;
            if (num == middle) {
                System.out.println(num);
                // System.out.println("intento: "+cont + " numero: "+middle+ " ");
                break;
            } else if (num > middle) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
            System.out.print(middle + " ");
            // System.out.println("intento: "+cont + " numero: "+middle+ " ");
            cont++;
        }
    }

    public static int[] pedirDatos() {
        String datos = INPUT.nextLine();
        int[] datosEntrada = new int[3];

        try (Scanner scanner = new Scanner(datos).useDelimiter(" ")) {
            int i = 0;
            while (scanner.hasNext()) {
                datosEntrada[i] = scanner.nextInt();
                i++;
            }
        }
        return datosEntrada;
    }

    public static boolean validarDatos(int limInf, int limSup, int num) {
        return (num <= limSup && num >= limInf);
    }
}

