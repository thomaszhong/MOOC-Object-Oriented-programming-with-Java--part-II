
import movable.*;

public class Main {

    public static void main(String[] args) {
        Group group = new Group();
        group.addToGroup(new Organism(55, 100));
        group.addToGroup(new Organism(5, 10));
        group.move(15, 15);
        System.out.println(group);
    }
}
