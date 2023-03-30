public class MergeSort {
    DoublyLinkedList<Movie> sortedList;
    long time;
    int comparisons;
    int swaps;

    public MergeSort(DoublyLinkedList<Movie> movies, int column, boolean creciente){
        this.sortedList = movies;
        this.time = sort(column, creciente);
        this.comparisons = 0;
        this.swaps = 0;
    }
    public long sort(int column, boolean creciente){

        long startTime = System.nanoTime();
        recSort(sortedList, column);
        long endTime = System.nanoTime();

        return endTime - startTime;
    }

    public void recSort(DoublyLinkedList<Movie> list, int column) {
        if (list.size() > 1) {
            DoublyLinkedList<Movie> leftList = new DoublyLinkedList<>();
            DoublyLinkedList<Movie> rightList = new DoublyLinkedList<>();
            int middle = list.size() / 2;
            DoublyLink<Movie> current = list.getFirst();
            for (int i = 0; i < middle; i++) {
                leftList.insertLast(current.getData());
                current = current.next;
            }
            while (current != null) {
                rightList.insertLast(current.getData());
                current = current.next;
            }
            recSort(leftList, column);
            recSort(rightList, column);
            merge(list, leftList, rightList, column);
        }
    }

    private void merge(DoublyLinkedList<Movie> list, DoublyLinkedList<Movie> leftList, DoublyLinkedList<Movie> rightList, int column) {
        DoublyLink<Movie> current = list.getFirst();
        DoublyLink<Movie> leftCurrent = leftList.getFirst();
        DoublyLink<Movie> rightCurrent = rightList.getFirst();
        while (leftCurrent != null && rightCurrent != null) {
            if (leftCurrent.getData().getByID(column).compareTo(rightCurrent.getData().getByID(column)) < 0) {
                current.setData(leftCurrent.getData());
                leftCurrent = leftCurrent.next;
            } else {
                current.setData(rightCurrent.getData());
                rightCurrent = rightCurrent.next;
            }
            current = current.next;
            
        }
        while (leftCurrent != null) {
            current.setData(leftCurrent.getData());
            leftCurrent = leftCurrent.next;
            current = current.next;
            
        }
        while (rightCurrent != null) {
            current.setData(rightCurrent.getData());
            rightCurrent = rightCurrent.next;
            current = current.next;
        
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



