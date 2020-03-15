/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author cobhc
 */
public class QuickSort {
    public static void sort(int[] array, int low, int high){
        
        if(low < high){
            int pivot = partition(array, low, high);
            sort(array, low, pivot - 1);
            sort(array, pivot + 1, high);
        }
    }
    
    public static int partition(int[] array, int low, int high){
        int pivot = array[high];
        int i = low - 1;
        for(int j = low ; j < high; j++){
            if(array[j] < pivot){
                i++;
                swap(array, i,j);
            }
        }
        swap(array,i+1,high);
        
        return i + 1;
    }
    
    public static void swap(int[] array, int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
