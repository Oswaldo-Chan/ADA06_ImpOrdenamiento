public class MoviesApp {
    public static void main(String[] args) {

        Controlador control = new Controlador();


        control.leer("dataset/movies.csv");
        control.ordenar(0,1,true);
        control.ordenar(0, 4, false);
        control.crear("dataset/movies2.csv");
        control.generarTabla();

    }
}
