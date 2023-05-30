
package seminar;

import java.util.Arrays;
import java.util.Random;

public class task004 {
    public static void main(String[] args) {
        // Создаем и заполняем массив случайными числами
        int[] array = generateRandomArray(500);
        Arrays.sort(array); // Сортируем массив, чтобы использовать бинарный поиск

        // Число, которое мы будем искать
        int target = 42;

        // Вызываем метод бинарного поиска и выводим результат
        int index = binarySearch(array, target);
        if (index != -1) {
            System.out.println("Число " + target + " найдено в массиве на позиции " + index + ".");
        } else {
            System.out.println("Число " + target + " не найдено в массиве.");
        }
    }

    // Метод для генерации массива случайных чисел
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1000); // Генерируем случайное число от 0 до 999
        }
        return array;
    }

    // Метод бинарного поиска в отсортированном массиве
    private static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == target) {
                return mid; // Найдено значение, возвращаем индекс
            }

            if (array[mid] < target) {
                left = mid + 1; // Искомое значение находится в правой половине массива
            } else {
                right = mid - 1; // Искомое значение находится в левой половине массива
            }
        }

        return -1; // Искомое значение не найдено
    }
}
