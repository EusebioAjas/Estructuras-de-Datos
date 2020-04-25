public class Main {
    /*
    *ENTRADA:   
    * 9 5   
    * 2 3 4 2 3 6 8 4 5
    *
    * SALIDA:
    * 2
    */
    public static void main(String[] args) {
        
           String[] valores = Metodos.validarCadena();
           int diasTransaccion = Integer.parseInt(valores[0]);
           int diasPrueba = Integer.parseInt(valores[1]);
           int[] array = Metodos.validarArray(diasTransaccion);
           int numFraudes = Metodos.detectarFraudes(array, diasPrueba);
           System.out.println(numFraudes);

    }
}
