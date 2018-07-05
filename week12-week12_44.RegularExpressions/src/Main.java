
public class Main {

    public static void main(String[] args) {
        // write test code here

    }

    public static boolean isAWeekDay(String string) {
        if (string.matches("mon|tue|wed|thu|fri|sat|sun")) {
            System.out.println("The form is right.");
            return true;
        } else {
            System.out.println("The form is wrong.");
            return false;
        }
    }

    public static boolean allVowels(String string) {
        if (string.matches("[aeiouäö]*")) {
            System.out.println("The form is right.");
            return true;
        } else {
            System.out.println("The form is wrong.");
            return false;
        }
    }

    public static boolean clockTime(String string) {
        if (string.matches("([01][0-9]|2[0-3])(:[0-5][0-9]){2}")) {
            System.out.println("The form is right.");
            return true;
        } else {
            System.out.println("The form is wrong.");
            return false;
        }
    }
}
