import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller {
    DoublyLinkedList<Movie> movies;
    DoublyLinkedList<Movie> orderedMovies;

    binaryInsertion bin;
    QuickSort quick;
    MergeSort merge;
    RadixSort radix;

    public Controller() {
        movies = new DoublyLinkedList<Movie>();
    }

    public void read(String string) {
        DataSet dataset = new DataSet();
        dataset.readCSV("dataset/movies.csv");
        this.movies = dataset.getMovies();
    }

    public void order(int column, boolean increasing) {
        
        this.bin = new binaryInsertion(movies, column, increasing);
        orderedMovies = bin.getSortedList();
        create("output/BinarySortOrdered.csv");
        this.quick = new QuickSort(movies, column, increasing);
        orderedMovies = quick.getSortedList();
        create("output/QuickSortOrdered.csv");
        this.merge = new MergeSort(movies, column, increasing);    
        orderedMovies = merge.getSortedList(); 
        create("output/MergeSortOrdered.csv");
        this.radix = new RadixSort(movies, column, increasing);    
        orderedMovies = radix.getSortedList();
        create("output/RadixSortOrdered.csv");
       
    }

    public void create(String name) {
        DataSet.newDataset(orderedMovies, name);
    }

    public void generateTable() {

        String[][] metrics = {
                { "Algoritmo", "   Tiempo", " Comparaciones "," Intercambios" },
                { "BinarySort:     ", String.valueOf(bin.getTime()+"   "), String.valueOf(bin.getComparisons()),String.valueOf(bin.getSwaps()) },
                { "QuickSort:      ", String.valueOf(quick.getTime()+"   "), String.valueOf(quick.getComparisons()),String.valueOf(quick.getSwaps())},
                { "MergeSort:      ", String.valueOf(merge.getTime()+"   "),String.valueOf(merge.getComparisons()),String.valueOf(merge.getSwaps())},
                { "RadixSort:      ", String.valueOf(radix.getTime()+"   "),String.valueOf(radix.getComparisons()),String.valueOf(radix.getSwaps())}
        };

        try (PrintWriter pw = new PrintWriter(new FileWriter("output/Metricas.txt"))) {

            for (String[] row : metrics) {
                pw.printf("%-10s%-10s%-10s%-10s%n", row[0], row[1], row[2],row[3]);
            }

        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
