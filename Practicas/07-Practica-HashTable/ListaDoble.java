public class ListaDoble {
    private Nodo cabeza;
    private Nodo cola;
    private int tamanioLista;

    public void insertarAlInicio(int dato) {
        Nodo nvoNodo = new Nodo(dato);
        if (estaVacio()) {
            cabeza = cola = nvoNodo;
        } else {
            nvoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nvoNodo);
            cabeza = nvoNodo;
        }
        tamanioLista++;
    }

    public void insertarAlFinal(int dato) {
        Nodo nvoNodo = new Nodo(dato);
        if (estaVacio()) {
            cabeza = nvoNodo;
            cola = nvoNodo;
        } else {
            cola.setSiguiente(nvoNodo);
            nvoNodo.setAnterior(cola);
            cola = nvoNodo;
        }
        tamanioLista++;
    }

    public int buscar(int dato) {
        if (!estaVacio()) {
            Nodo temp = cabeza;
            while (temp != null && temp.getDato() != dato) {
                temp = temp.getSiguiente();
            }

            if (temp != null && temp.getDato() == dato) {
                return temp.getDato();
            }
        }
        return -1;
    }

    public void eliminar(int data) {
        if (cabeza == null)
            System.out.println("La lista esta vacia");
        else if (cabeza.getDato() == data) {
            cabeza = cabeza.getSiguiente();
            tamanioLista--;
        } else {
            Nodo anterior = cabeza;
            Nodo actual = cabeza.getSiguiente();
            while (actual != null && data != actual.getDato()) {
                anterior = actual;
                actual = actual.getSiguiente();
            }
            if (actual != null) {
                Nodo temp = actual.getSiguiente();
                anterior.setSiguiente(temp);
                if (temp != null)
                    temp.setAnterior(actual.getAnterior());
                tamanioLista--;
            }
        }
    }

    public boolean estaVacio() {
        return tamanioLista == 0;
    }

    public int getTamanioLista() {
        return tamanioLista;
    }

    public void imprimirLista() {
        Nodo temp = cabeza;
        while (temp != null) {
            System.out.print(temp.getDato() + " --> ");
            temp = temp.getSiguiente();
        }
        System.out.println("null");
    }

}
