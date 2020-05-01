public class Metodos {

    public static int random(int N) {
        int maximo = 100 * N;
        return (int) Math.floor(Math.random() * (0 - (maximo + 1)) + (maximo + 1));
    }

    public static boolean esPrimo(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int obtenerPrimoMayorCercano(int num) {
        int i = num;
        while (true) {
            i++;
            if (esPrimo(i))
                break;
        }
        return i;
    }
}
