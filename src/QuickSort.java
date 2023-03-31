public class QuickSort {
    DoublyLinkedList<Movie> sortedList;
    long time;
    int comparisons;
    int swaps;

    public QuickSort(DoublyLinkedList<Movie> movies, int column, boolean creciente){
        this.sortedList = movies;
        this.time = sort(column, creciente);
        this.comparisons = 0;
        this.swaps = 0;
    }

    private long sort(int column, boolean creciente){

        long startTime = System.nanoTime();

        quickSort(sortedList,0,(sortedList.size())-1, column);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private void quickSort(DoublyLinkedList<Movie> arr, int left, int right,int col) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right,col);
            quickSort(arr, left, pivotIndex - 1,col);
            quickSort(arr, pivotIndex + 1, right,col);
        }
    }
    
    private int partition(DoublyLinkedList<Movie> arr, int left, int right, int col) {
        int pivot = arr.index(right).getData().getByID(col);
        int i = left - 1;
    
        for (int j = left; j < right; j++) {
            if (arr.index(j).getData().getByID(col) <= pivot) {
                i++;
                swap(arr, i, j);
                comparisons++;
            }
        }
    
        swap(arr, i + 1, right);
    
        return i + 1;
    }
    
    private void swap(DoublyLinkedList<Movie> arr, int i, int j) {
        Movie temp = arr.index(i).getData();
        arr.index(i).data = arr.index(j).getData();
        arr.index(j).data = temp;
        swaps++;
    }


}
