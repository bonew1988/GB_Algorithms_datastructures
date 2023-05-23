package seminar1;

import java.util.Arrays;
import java.util.Random;

public class task002 {
    public static void main(String[] args) {
        int[] array = generateRandomArray(1000);
        
        System.out.println("Исходный массив:");
        printArray(array);
        
        bubbleSort(array);
        
        System.out.println("Отсортированный массив:");
        printArray(array);
    }
    
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000);
        }
        
        return array;
    }
    
    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Меняем элементы местами
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
                        
            if (!swapped) {
                break;
            }
        }
    }
    
    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
