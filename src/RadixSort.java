public class RadixSort {
    private DoublyLinkedList<Movie> sortedList;
    private long time;
    private int comparisons;
    private int swaps;

    public RadixSort(){
        sortedList = new DoublyLinkedList<>();
    }

    public RadixSort(DoublyLinkedList<Movie> movies, int column, boolean creciente){
        this.sortedList = movies;
        this.time = sort(column, creciente);;
        this.comparisons = 0;
        this.swaps = 0;
    }

    public long sort(int column, boolean creciente){
        long startTime = System.nanoTime();
        radixSort(column, creciente);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    private int getMax(int column){
        
        int max = Integer.MIN_VALUE;
        DoublyLink<Movie> current = sortedList.getLast();
        while(current != null) {
            if (Integer.valueOf(current.getData().getByID(column)) > max) {
                max = Integer.valueOf(current.getData().getByID(column));
            }
            current = current.previous; 
        }
        return max;
        
    }

    private void countingSort( int max, int column, boolean creciente) {
        int[] count = new int[max + 1];

        DoublyLink<Movie> current = sortedList.getFirst();

        while (current != null) {
            count[Integer.valueOf(current.getData().getByID(column))]++;
            current = current.next;
        }

        if (creciente == true) {
            for (int i = 1; i <= max; i++) {
                count[i] += count[i - 1];
            }
        } else {
            for (int i = max; i >= 1; i--) {
                count[i - 1] += count[i];
            }
        }

        Movie[] sortedArray = new Movie[sortedList.size()];

        current = sortedList.getFirst();
        while (current != null) {
            int index = count[Integer.valueOf(current.getData().getByID(column))] - 1;
            sortedArray[index] = current.getData();
            count[Integer.valueOf(current.getData().getByID(column))]--;
            current = current.next;
        }

        current = sortedList.getFirst();
        for (int i = 0; i < sortedArray.length; i++) {
            current.setData(sortedArray[i]);
            current = current.next;
        }
    }

    private void radixSort(int column, boolean creciente){
		int m = getMax(column);

		for (int exp = 1; m / exp > 0; exp *= 10){
            countingSort(m, column, creciente);
        }
	}

    public DoublyLinkedList<Movie> getSortedList() {
        return sortedList;
    }

    public long getTime() {
        return time;
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }


}

