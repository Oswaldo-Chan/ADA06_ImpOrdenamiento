public class MoviesApp {
    public static void main(String[] args) {
        DataSet dataset = new DataSet();
        dataset.readCSV("dataset/movies.csv");
        DoublyLinkedList<Movie> movies = dataset.getMovies();       

        DataSet.newDataset(movies, "output/nuevo.csv");
        
    }
}
