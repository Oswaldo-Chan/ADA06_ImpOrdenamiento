import java.util.Arrays;

public class MergeSort {

    public static Movie[] mergeSort(Movie[] arr, int col) {
        int n = arr.length;
    
        if (n <= 1) {
            return arr;
        }
    
        int mid = n / 2;
        Movie[] left = Arrays.copyOfRange(arr, 0, mid);
        Movie[] right = Arrays.copyOfRange(arr, mid, n);
    
        left = mergeSort(left,col);
        right = mergeSort(right,col);
    
        return merge(left, right,col);
    }
    
    public static Movie[] merge(Movie[] left, Movie[] right,int col) {
        int nLeft = left.length;
        int nRight = right.length;
        Movie[] result = new Movie[nLeft + nRight];
    
        int i = 0, j = 0, k = 0;
    
        while (i < nLeft && j < nRight) {
            if (left[i].getByID(col) <= right[j].getByID(col)) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }
    
        while (i < nLeft) {
            result[k] = left[i];
            i++;
            k++;
        }
    
        while (j < nRight) {
            result[k] = right[j];
            j++;
            k++;
        }
    
        return result;
    }
    
}
