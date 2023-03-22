public class RadixSort {

    private static int getMax(DoublyLinkedList<Movie> movies, int column){
        
        int max = Integer.MIN_VALUE;
        DoublyLink<Movie> current = movies.getLast();
        while(current != null) {
            if (Integer.valueOf(current.getData().getByID(column)) > max) {
                max = Integer.valueOf(current.getData().getByID(column));
            }
            current = current.previous; 
        }
        return max;
        
    }

    private static void countingSort(DoublyLinkedList<Movie> movies, int max, int column, boolean isIncreasing) {
        int[] count = new int[max + 1];

        DoublyLink<Movie> current = movies.getFirst();

        while (current != null) {
            count[Integer.valueOf(current.getData().getByID(column))]++;
            current = current.next;
        }

        if (isIncreasing == true) {
            for (int i = 1; i <= max; i++) {
                count[i] += count[i - 1];
            }
        } else {
            for (int i = max; i >= 1; i--) {
                count[i - 1] += count[i];
            }
        }

        Movie[] sortedArray = new Movie[movies.size()];

        current = movies.getFirst();
        while (current != null) {
            int index = count[Integer.valueOf(current.getData().getByID(column))] - 1;
            sortedArray[index] = current.getData();
            count[Integer.valueOf(current.getData().getByID(column))]--;
            current = current.next;
        }

        current = movies.getFirst();
        for (int i = 0; i < sortedArray.length; i++) {
            current.setData(sortedArray[i]);
            current = current.next;
        }
    }

    public static void sort(DoublyLinkedList<Movie> movies, int column, boolean isIncreasing){
		int m = getMax(movies, column);

		for (int exp = 1; m / exp > 0; exp *= 10){
            countingSort(movies, m, column, isIncreasing);
        }
	}


}

