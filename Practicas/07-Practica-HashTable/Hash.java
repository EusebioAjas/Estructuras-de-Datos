public class Hash {
    private int tamanio;
    private ListaDoble[] lista;

    public Hash(int N) {
        this.tamanio = N;
        if (!Metodos.esPrimo(N)) {
            tamanio = Metodos.obtenerPrimoMayorCercano(N);
        }
        this.lista = new ListaDoble[tamanio];
    }

    public void insertar(int valor) {
        int loc = funHash(valor);
        ListaDoble nvaLista = new ListaDoble();
        if (lista[loc] != null) {
            lista[loc].insertarAlFinal(valor);
        } else {
            lista[loc] = nvaLista;
            nvaLista.insertarAlFinal(valor);
        }
    }

    public void eliminar(int valor) {
        int loc = funHash(valor);
        if (lista[loc] != null) {
            lista[loc].eliminar(valor);
        }
    }

    public int buscar(int valor) {
        int loc = funHash(valor);
        if (lista[loc] != null) {
            return lista[loc].buscar(valor);
        }
        return -1;
    }

    public void imprimirTabla() {
        for (int i = 0; i < tamanio; i++) {
            if (lista[i] != null) {
                System.out.printf("hash[%d]: ", i);
                lista[i].imprimirLista();
            }
        }
    }

    public int funHash(int k) {
        return k % tamanio;
    }

}
