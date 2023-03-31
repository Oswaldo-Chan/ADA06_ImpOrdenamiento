public class binaryInsertion {
    DoublyLinkedList<Movie> sortedList;
    long time;
    int comparisons=0;
    int swaps=0;

    public binaryInsertion(DoublyLinkedList<Movie> movies, int column, boolean creciente){
        this.sortedList = movies;
        this.time = sort(column, creciente);
    }

    public long sort(int column, boolean creciente){

        long startTime = System.nanoTime();

        binaryInsertionSort(sortedList, column);

        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public int binarySearch(DoublyLinkedList<Movie> list, Movie item, int low, int high,int col){
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (item.getByID(col) == list.index(mid).getData().getByID(col))
                return mid + 1;
            else if (item.getByID(col) > list.index(mid).getData().getByID(col))
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public void binaryInsertionSort(DoublyLinkedList<Movie> list, int col) {
        int i, loc, j;
        Movie selected;
        int n=list.size();
    
        for (i = 1; i < n; ++i) {
            j = i - 1;

            selected = list.index(i).getData();
    

            loc = binarySearch(list, selected, 0, j,col);
    
            while (j >= loc) {
                list.index(j + 1).data = list.index(j).getData();
                j--;
            }
            list.index(j + 1).data = selected;
        }
    }

}
