public class Nodo {
    private int dato;
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo(int dato) {
        this.dato = dato;
    }

    public int getDato() {
        return dato;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
