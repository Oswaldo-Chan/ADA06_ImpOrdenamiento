public class BinaryInsertionSort {
    DoublyLinkedList<Movie> sortedList;
    private long time;
    private long comparisons;
    private long swaps;

    public BinaryInsertionSort(DoublyLinkedList<Movie> movies, int column, boolean increasing){
        this.sortedList = movies;
        this.time = sort(column, increasing);
    }

    public long sort(int column, boolean increasing){

        long startTime = System.nanoTime();

        binaryInsertionSort(sortedList, column, increasing);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public int binarySearch(DoublyLinkedList<Movie> list, Movie item, int low, int high,int col, boolean increasing){
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (increasing == true) {
                if (item.getByID(col) == list.index(mid).getData().getByID(col))
                    return mid + 1;
                else if (item.getByID(col) > list.index(mid).getData().getByID(col))
                    low = mid + 1;
                else
                    high = mid - 1;
                comparisons++;
            } else {
                if (item.getByID(col) == list.index(mid).getData().getByID(col))
                    return mid + 1;
                else if (item.getByID(col) < list.index(mid).getData().getByID(col))
                    low = mid + 1;
                else
                    high = mid - 1;
                comparisons++;
            }
          
        }
        return low;
    }

    public void binaryInsertionSort(DoublyLinkedList<Movie> list, int col, boolean increasing) {
        int i, loc, j;
        Movie selected;
        int n=list.size();
    
        for (i = 1; i < n; ++i) {
            j = i - 1;

            selected = list.index(i).getData();
    

            loc = binarySearch(list, selected, 0, j,col, increasing);
    
            while (j >= loc) {
                list.index(j + 1).data = list.index(j).getData();
                j--;
                swaps++;
            }
            list.index(j + 1).data = selected;
        }
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