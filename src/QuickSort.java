public class QuickSort {
    public static Movie[] quickSort(Movie[] arr, int left, int right,int col) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right,col);
            quickSort(arr, left, pivotIndex - 1,col);
            quickSort(arr, pivotIndex + 1, right,col);
        }
        return arr;
    }
    
    public static int partition(Movie[] arr, int left, int right, int col) {
        int pivot = arr[right].getByID(col);
        int i = left - 1;
    
        for (int j = left; j < right; j++) {
            if (arr[j].getByID(col) <= pivot) {
                i++;
                swap(arr, i, j);
            }
        }
    
        swap(arr, i + 1, right);
    
        return i + 1;
    }
    
    public static void swap(Movie[] arr, int i, int j) {
        Movie temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
