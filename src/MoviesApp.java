public class MoviesApp {
    public static void main(String[] args) {

        Controlador control = new Controlador();

        control.leer("dataset/movies.csv");
        control.ordenar(20,1,true);
        control.crear("dataset/movies2.csv");

    }
}
