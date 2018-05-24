
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be useful.
        //First part
        Scanner reader = new Scanner(System.in);
        PlanList list = new PlanList();
        FlightMap map = new FlightMap(list);
        
        System.out.println("Airport panel");
        System.out.println("--------------------");

        while (true) {
            System.out.println("");
            System.out.println("Choose operation: ");
            System.out.println("[1] Add airplane");
            System.out.println("[2] Add flight");
            System.out.println("[x] Exit");
            String input = reader.nextLine();
            if (input.equals("1")) {
                addPlane(reader, list);
            } else if (input.equals("2")) {
                addFlight(reader, map);
            } else if (input.equals("x")) {
                break;
            }
        }

        //Second part
        System.out.println("Flight service");
        System.out.println("------------");

        while (true) {
            System.out.println("");
            System.out.println("Choose operation: ");
            System.out.println("[1] Print planes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print plane info");
            System.out.println("[x] Quit");
            String input = reader.nextLine();
            if (input.equals("1")) {
                printPlanes(list);
            } else if (input.equals("2")) {
                printFlights(map);
            } else if (input.equals("3")) {
                printPlaneInfo(reader, list);
            } else if (input.equals("x")) {
                break;
            }
        }

    }

    public static void addPlane(Scanner reader, PlanList list) {
        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();
        System.out.print("Give plane capacity: ");
        int capacity = Integer.parseInt(reader.nextLine());
        list.addPlane(new Plane(ID, capacity));
    }

    public static void addFlight(Scanner reader, FlightMap map) {
        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();
        System.out.print("Give departure airport code: ");
        String airport1 = reader.nextLine();
        System.out.print("Give destination airport code: ");
        String airport2 = reader.nextLine();
        map.assign(ID, airport1 + "-" + airport2);
    }

    public static void printPlanes(PlanList list) {
        list.printList();
    }

    public static void printFlights(FlightMap map) {
        map.printMap();
    }

    public static void printPlaneInfo(Scanner reader, PlanList list) {
        System.out.print("Give plane ID: ");
        String ID = reader.nextLine();
        System.out.println("");
        System.out.println(list.getPlane(ID));
    }
}
