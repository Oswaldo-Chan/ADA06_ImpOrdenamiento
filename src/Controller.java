public class Controller {
    private DoublyLinkedList<Movie> movies;
    private int column;
    private boolean creciente;
    private String file;


    public Controller(DoublyLinkedList<Movie> movies, int column, boolean creciente, String file){
        this.movies = movies;
        this.column = column;
        this.creciente = creciente;
        this.file = file;
    }

    public void init(){
        leer(file);
        ordenar(column, creciente);
    }

    private void leer(String string) {
        DataSet dataset = new DataSet();
        dataset.readCSV("dataset/movies.csv");
        this.movies = dataset.getMovies();
    }

    public void ordenar(int col, boolean ascendente) {
        
        
        switch(col) {
           case 1: //genero
            MergeSort ms  = new MergeSort(movies, col, ascendente);
            crearCSV(ms.getSortedList(), "output/MergeSortCSV");
                break;
            case 2: //año
            case 3: //duracion
            case 4: //voto
            RadixSort rs = new RadixSort(movies, col, ascendente);
            crearCSV(rs.getSortedList(), "output/RadixSortCSV");
            MergeSort ms2  = new MergeSort(movies, col, ascendente);
            crearCSV(ms2.getSortedList(), "output/MergeSortCSV");
                break;
            default: 
                return;
                
        }
        
        System.out.println("Se ordeno con exito");
    }

    public void crearCSV(DoublyLinkedList<Movie> movies, String fileName){
        DataSet.newDataset(movies, fileName);
    }
    

    

}
