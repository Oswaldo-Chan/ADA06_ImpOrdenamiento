public class QuickSort {
    DoublyLinkedList<Movie> sortedList;
    private long time;
    private long comparisons;
    private long swaps;

    public QuickSort(DoublyLinkedList<Movie> movies, int column, boolean creciente){
        this.sortedList = movies;
        this.time = sort(column, creciente);
    }

    private long sort(int column, boolean increasing){

        long startTime = System.nanoTime();

        quickSort(sortedList,0,(sortedList.size())-1, column, increasing);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    private void quickSort(DoublyLinkedList<Movie> arr, int left, int right,int col, boolean increasing) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right,col, increasing);
            quickSort(arr, left, pivotIndex - 1,col, increasing);
            quickSort(arr, pivotIndex + 1, right,col, increasing);
        }
    }
    
    private int partition(DoublyLinkedList<Movie> arr, int left, int right, int col, boolean increasing) {
        int pivot = arr.index(right).getData().getByID(col);
        int i = left - 1;
    
        for (int j = left; j < right; j++) {
            if (arr.index(j).getData().getByID(col) <= pivot) {
                i++;
                swap(arr, i, j);
                this.comparisons++;
            }
        }
    
        swap(arr, i + 1, right);
    
        return i + 1;
    }
    
    private void swap(DoublyLinkedList<Movie> arr, int i, int j) {
        Movie temp = arr.index(i).getData();
        arr.index(i).data = arr.index(j).getData();
        arr.index(j).data = temp;
        this.swaps++;
    }

    public DoublyLinkedList<Movie> getSortedList() {
        return sortedList;
    }

    public long getTime() {
        return time;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

}
