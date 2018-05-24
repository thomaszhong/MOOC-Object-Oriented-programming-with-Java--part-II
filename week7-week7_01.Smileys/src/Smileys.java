
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        // printWithSmileys("Method");
        // printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }

    private static void printWithSmileys(String characterString) {
        int length;
        if (characterString.length() % 2 == 1) {
            length = characterString.length() + 7;
            characterString += " ";
        } else {
            length = characterString.length() + 6;
        }

        for (int i = 0; i < length / 2; i++) {
            System.out.print(":)");
        }
        System.out.println("");
        
        System.out.println(":) " + characterString + " :)");

        for (int i = 0; i < length / 2; i++) {
            System.out.print(":)");
        }

    }

}
