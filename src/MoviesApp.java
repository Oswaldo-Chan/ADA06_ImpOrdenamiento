public class MoviesApp {
    public static void main(String[] args) {
  
      System.out.println("Ingrese el numero de la columna a ordenar:");
      System.out.println("1. Por Genero \n2. Por Año de lanzamiento \n3. Por Duracion \n4. Por votos \n5. Por Puntuacion \n6. Por Metascore");
      
      System.out.println("Ingrese el numero del tipo de orden que desea:");
      System.out.println("1. Orden Ascendente \n2. Orden Descendente");

      
        DataSet dataset = new DataSet();
        dataset.readCSV("dataset/movies.csv");
        DoublyLinkedList<Movie> movies = dataset.getMovies();       
        String str = "abc";
        int n = str.hashCode();
        System.out.println(n);

        RadixSort r1 = new RadixSort(movies, 3, false);

        //MergeSort m = new MergeSort(movies, 3, false); //creciente por defecto
        //dataset.newDataset(m.getSortedList(), "output/sortMerge.csv");
        DataSet.newDataset(r1.getSortedList(), "output/sortRadix.csv");
      System.out.println(r1.getTime());
      //System.out.println(m.getTime());
      }
}
