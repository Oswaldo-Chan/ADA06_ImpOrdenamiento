import java.util.Scanner;

public class MoviesApp {
    public static void main(String[] args) {

        Controller control = new Controller();
        try (Scanner scanner = new Scanner(System.in)) {
            control.read("dataset/movies.csv");

            System.out.println("Ingrese el numero de la columna a ordenar:");
            System.out.println("\n1. Por Año \n2. Por Duración en minutos \n3. Por Votos \n4. Por Metascore");
            System.out.print("\nIngrese su opcion: ");
            int column = Integer.parseInt(scanner.nextLine());
            
            System.out.println("\nIngrese el numero del tipo de orden que desea:");
            System.out.println("\n1. Orden Ascendente \n2. Orden Descendente");
            System.out.print("\nIngrese su opcion: ");
            int order = Integer.parseInt(scanner.nextLine());

            switch (order) {
                case 1:
                control.order(column,true);
                    break;
                case 2: 
                control.order(column, false);
                    break;
                default:
                    break;
            }
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        control.generateTable();

    }
}
