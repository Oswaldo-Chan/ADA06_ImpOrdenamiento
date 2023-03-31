import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Controlador {
    DoublyLinkedList<Movie> movies;
    DoublyLinkedList<Movie> moviesOrdenados;

    binaryInsertion bin;
    QuickSort quick;
    //RadixSprt radix;
    //MergeSort merge;

    public Controlador() {
        movies = new DoublyLinkedList<Movie>();
    }

    public void leer(String string) {
        DataSet dataset = new DataSet();
        dataset.readCSV("dataset/movies.csv");
        this.movies = dataset.getMovies();
    }

    public void ordenar(int col, int ordenamiento, boolean ascendente) {

        switch (ordenamiento) {
            case 1:
                this.bin = new binaryInsertion(movies, col, ascendente);
                moviesOrdenados = bin.sortedList;
            case 2:

            case 3:

            case 4:
                this.quick = new QuickSort(movies, col, ascendente);
                moviesOrdenados = quick.sortedList;
        }
    }

    public void crear(String name) {
        DataSet.newDataset(moviesOrdenados, name);
    }

    public void generarTabla() {

        String[][] datos = {
                { "Algoritmo", "   Tiempo", " Comparaiones "," Swaps" },
                { "BinaryInserion: ",String.valueOf(bin.time), String.valueOf(bin.comparisons),String.valueOf(bin.swaps) },
                { "MergeSort:      ", String.valueOf(bin.time), String.valueOf(bin.time),String.valueOf(bin.time)},
                { "RadixSort:      ", String.valueOf(bin.time), String.valueOf(bin.time),String.valueOf(bin.time)},
                { "QuickSort:      ", String.valueOf(quick.getTime()), String.valueOf(quick.getComparisons()),String.valueOf(quick.getSwaps())}
        };

        try (PrintWriter pw = new PrintWriter(new FileWriter("dataset/Algoritmos.txt"))) {

            for (String[] fila : datos) {
                pw.printf("%-10s%-10s%-10s%-10s%n", fila[0], fila[1], fila[2],fila[3]);
            }

        } catch (IOException e) {
            System.err.println(e);
            e.printStackTrace();
        }
    }
}
