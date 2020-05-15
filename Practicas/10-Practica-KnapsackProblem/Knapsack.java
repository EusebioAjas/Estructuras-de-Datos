public class Knapsack {

    public static void solucion(Paquete[] paquetes, int pesoMaximo, int tamanio) {
        int[][] tabla = new int[tamanio + 1][pesoMaximo + 1];

        for (int i = 0; i <= tamanio; i++)

            for (int j = 0; j <= pesoMaximo; j++) {
                tabla[i][j] = 0;
            }

        for (int i = 1; i <= tamanio; i++) {

            for (int j = 0; j <= pesoMaximo; j++) {
                tabla[i][j] = tabla[i - 1][j];

                int peso = paquetes[i - 1].getPeso();
                int valor = paquetes[i - 1].getValor();

                if ((j >= peso) && (tabla[i][j] < tabla[i - 1][j - peso] + valor)) {
                    tabla[i][j] = tabla[i - 1][j - peso] + valor;
                }
            }
        }

        System.out.println("Capacidad maxima:\t" + pesoMaximo);
        System.out.println("valor total:\t" + tabla[tamanio][pesoMaximo]);

        System.out.println("Paquetes seleccionados: ");

        while (tamanio != 0) {

            int peso = paquetes[tamanio - 1].getPeso();
            int valor = paquetes[tamanio - 1].getValor();

            if (tabla[tamanio][pesoMaximo] != tabla[tamanio - 1][pesoMaximo]) {

                System.out.println("\tPaquete " + tamanio + " con Peso: " + peso + " y valor: " + valor);
                pesoMaximo = pesoMaximo - peso;
            }
            tamanio--;
        }
    }
}