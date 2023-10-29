import java.util.Comparator;

public class Genericbryce {

    // Generic Bubble Sort
    public static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    // swap arr[j+1] and arr[i]
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // Generic Merge Sort
    public static <T> void mergeSort(T[] array, Comparator<T> comparator) {
        if (array.length > 1) {
            // split array into two halves
            int mid = array.length / 2;
            T[] left = (T[]) new Object[mid];
            T[] right = (T[]) new Object[array.length - mid];

            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);

            // recursively sort both halves
            mergeSort(left, comparator);
            mergeSort(right, comparator);

            // merge the sorted halves into a sorted whole
            merge(array, left, right, comparator);
        }
    }

    private static <T> void merge(T[] array, T[] left, T[] right, Comparator<T> comparator) {
        int a = 0, l = 0, r = 0;
        while (l < left.length && r < right.length) {
            if (comparator.compare(left[l], right[r]) <= 0) {
                array[a++] = left[l++];
            } else {
                array[a++] = right[r++];
            }
        }
        while (l < left.length) {
            array[a++] = left[l++];
        }
        while (r < right.length) {
            array[a++] = right[r++];
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.println("Original array: ");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }

        Comparator<Integer> comparator = Comparator.naturalOrder();
        bubbleSort(numbers, comparator);
        
        System.out.println("\nSorted array using Bubble Sort: ");
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }

        Integer[] anotherSet = { 64, 34, 25, 12, 22, 11, 90 };
        mergeSort(anotherSet, comparator);

        System.out.println("\nSorted array using Merge Sort: ");
        for (Integer num : anotherSet) {
            System.out.print(num + " ");
        }
    }
}
