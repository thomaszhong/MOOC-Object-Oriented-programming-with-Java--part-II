
public class Main {

    public static void main(String[] args) {
        // Write your main program here. Implementing your own classes will be very useful.
        System.out.println("Kumpula ski jumping week");
        System.out.println("");
        SkiJumpingUI ui = new SkiJumpingUI();
        ui.start();
        ui.rounds();
        ui.printResults();
    }
}
