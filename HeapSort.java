public class HeapSort {
    public void heapSort(int arr[]) {
        int n = arr.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Извлечение элементов из кучи по одному
        for (int i = n - 1; i >= 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализация наибольшего значения
        int l = 2 * i + 1; // Левый потомок
        int r = 2 * i + 2; // Правый потомок

        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный
        // момент
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если наибольший элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивный вызов heapify для затронутой поддерева
            heapify(arr, n, largest);
        }
    }

    // Тестирование
    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);

        System.out.println("Отсортированный массив:");
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }
}