package com.modelo;

import java.util.Scanner;

public class Metodos {
    public static final Scanner INPUT = new Scanner(System.in);

    public static int detectarFraudes(int array[], int dias){
        int contadorFraudes = 0;
        int low = 0;
        int high = dias-1;
        for(int i = dias; i < array.length; i++){
            QuickSort.sort(array, low, high);
            double mediana = calcularMediana(array,dias,low);
            double x = 2*mediana;
            if(x <= array[i]){
                //System.out.println("Mediana: "+ x + "  Gasto del dia: "+array[i]);
                contadorFraudes++;
            }
            low++;
            high++;
        }
        
        return contadorFraudes;
    }
    
    public static double calcularMediana(int[] array, int dias, int low){
        double mediana;
        int numElementos = dias;
        if(numElementos % 2 == 0){
            int index = low + numElementos/2;
            int sumaMedios = array[index] + array[index - 1];
            mediana = sumaMedios / 2.0;
        }else{
            mediana = (array[(numElementos/2)+low]);
        }
        
        return mediana;
    }
    
    public static int[] validarArray(int diasTransaccion){
        int[] array = null;
        boolean salir = false;
        while(!salir){
            array = new int[diasTransaccion];
            String gastos = INPUT.nextLine();
            salir = initArray(array, gastos);

            if(salir == false){
                System.out.println("Error! los gastos deben estar en un rango de [0, 200]");
            }
        }
        return array;
    }
    
    public static String[] validarCadena(){
        boolean salir = false;
        String[] valores;
        do{
           String in = INPUT.nextLine();
           valores = in.split(" ");
           int diasTransaccion = Integer.parseInt(valores[0]);
           int diasPrueba = Integer.parseInt(valores[1]);
           
           if( (diasPrueba > diasTransaccion || diasPrueba < 1) || (diasTransaccion < 1 || diasTransaccion > 10000) ){
               System.out.printf("Error! por favor considere las siguientes restricciones: "
               +"\nEl número de dias en que se realizan las transacciones debe estar en un rango de [1, 10000]"
               +"\nEl número de dias de transacción debe ser mayor a los dias de prueba\n");
               salir = true;
           }
           
        }while(salir);
        
        return valores;
    }
    
    public static boolean initArray(int[] array, String gastos){
        try(Scanner scanner = new Scanner(gastos).useDelimiter(" ")){
            int i = 0;
            while (scanner.hasNext()) {
                array[i] = scanner.nextInt();
                if(array[i] > 200 || array[i] < 0){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
