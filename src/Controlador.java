
public class Controlador {
    DoublyLinkedList<Movie> movies;
    Movie[] array;


    public Controlador(){
        movies = new DoublyLinkedList<Movie>();
    }

    public void leer(String string) {
        DataSet dataset = new DataSet();
        dataset.readCSV("dataset/movies.csv");
        this.movies = dataset.getMovies();
    }

    public void ordenar(int col, int ordenamiento, boolean ascendente) {
        //this.array = createArray(movies, col);
        
        switch(ordenamiento) {
           case 1:
           binaryInsertion bin = new binaryInsertion(movies,col,ascendente);
           movies=bin.sortedList;
            case 2:

            case 3:

            case 4:
            QuickSort quick = new QuickSort(movies,col,ascendente);
            movies=quick.sortedList;
        }
    }

    public void crear(String name) {
    DataSet.newDataset(movies, name);
    }

    public static Movie[] createArray(DoublyLinkedList<Movie> lista, int col) {

        int tamaño = 0;
        DoublyLink<Movie> actual = lista.getFirst();
    
        while (actual != null) {
            tamaño++;
            actual = actual.next;
        }

        
        Movie[] array = new Movie[tamaño];
    
        actual = lista.getFirst();
        
        for (int i = 0; i < tamaño; i++) {
            array[i] = actual.getData();
            actual = actual.next;
        }
    
        return array;
    }

    public void update(){
       this.movies.clear();

        for (Movie objeto : array) {
            this.movies.insertLast(objeto);
        }
    }
}
