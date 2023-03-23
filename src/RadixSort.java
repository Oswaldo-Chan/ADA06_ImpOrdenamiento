public class radixSort {

    public static Movie[] radix(Movie[] arr,int col) {
        int maxScore = getMaxScore(arr,col);
    
        for (int exp = 1; maxScore / exp > 0; exp *= 10) {
            countingSort(arr, exp,col);
        }
    
        return arr;
    }
    
    public static int getMaxScore(Movie[] arr, int col) {
        int maxScore = Integer.MIN_VALUE;
    
        for (Movie movie : arr) {
            if (movie.getByID(col) > maxScore) {
                maxScore = movie.getByID(col);
            }
        }
    
        return maxScore;
    }
    
    public static void countingSort(Movie[] arr, int exp,int col) {
        int n = arr.length;
        int[] count = new int[10];
        Movie[] output = new Movie[n];
    
        for (int i = 0; i < n; i++) {
            int digit = (arr[i].getByID(col) / exp) % 10;
            count[digit]++;
        }
    
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
    
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i].getByID(col) / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
    
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
