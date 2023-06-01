package HW;

import java.util.Arrays;
import java.util.Random;

public class hw1 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        int[] array = generateRandomArray(1000);

        System.out.println("Исходный массив:");
        printArray(array);

        long startTime = System.nanoTime();
        heapSort(array);
        long endTime = System.nanoTime();

        System.out.println("Отсортированный массив:");
        printArray(array);

        long executionTime = endTime - startTime;
        System.out.println("Время выполнения сортировки: " + executionTime + " наносекунд");
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // Генерация случайного числа от 0 до 999
        }

        return array;
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);
        }
    }

    public static void heapify(int[] array, int n, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        if (leftChild < n && array[leftChild] > array[largest]) {
            largest = leftChild;
        }

        if (rightChild < n && array[rightChild] > array[largest]) {
            largest = rightChild;
        }

        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }

    public static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
