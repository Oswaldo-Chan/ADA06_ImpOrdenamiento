public class binaryInsertion {
    public static Movie[] binaryInsertionSort(Movie[] arr,int col) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Movie key = arr[i];
            int j = binarySearch(arr, key, 0, i - 1,col);
            if (j < i) {
                System.arraycopy(arr, j, arr, j + 1, i - j);
                arr[j] = key;
            }
        }
        return arr;
    }
    
    private static int binarySearch(Movie[] arr, Movie key, int left, int right,int col) {
        while (left <= right) {
            int mid = (left + right) / 2;
            if (key.getByID(col) < arr[mid].getByID(col)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    

    
    
}
