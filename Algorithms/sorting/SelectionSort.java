public class SelectionSort {
    public void sort(int[] array) {
        int min;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(i, min, array);
        }
    }

    private void swap(int index1, int index2, int[] array) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}