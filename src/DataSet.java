import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataSet {
    private DoublyLinkedList<Movie> movies;

    public DataSet(){
        movies = new DoublyLinkedList<Movie>();
    }

    public DoublyLinkedList<Movie> getMovies() {
        return movies;
    }

    private void addMovie(Movie m){
        movies.insertLast(m);
    }

    public void readCSV(String filename) {
        BufferedReader br = null;
        String line;
        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] movieData = line.split(",");
                String title = movieData[0];
                int year = Integer.parseInt(movieData[1]);
                double score = Double.parseDouble(movieData[2]);
                int metascore = Integer.parseInt(movieData[3]);
                String genre = movieData[4];
                int vote = Integer.parseInt(movieData[5]);
                String director = movieData[6];
                int runtime = Integer.parseInt(movieData[7]);
                double revenue = Double.parseDouble(movieData[8]);
                Movie movie = new Movie(title, genre, director, year, runtime, vote, score, metascore, revenue);
                addMovie(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }

    public static void newDataset(DoublyLinkedList<Movie> dataset, String filename) {
        BufferedWriter bw = null;

        try {
            bw = new BufferedWriter(new FileWriter(filename));
            while (dataset.isEmpty() == false) {
                DoublyLink<Movie> link = dataset.deleteFirst();
                Movie movie = link.getData();
                bw.write(movie.getTitle() + "," + movie.getYear() + "," + movie.getScore() + "," + movie.getMetascore() 
                + "," + movie.getGenre() + "," + movie.getVote() + "," + movie.getDirector() + "," + movie.getRuntime() + "," + movie.getRevenue());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) bw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }


}
