
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Start your program here
        // ATTENTION: In your program, you can create only one instance of class Scanner!
        System.out.println("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit");
        
        Scanner reader = new Scanner(System.in);
        StoreInfo storeinfo = new StoreInfo();
        String input1;
        String input2;
        while (true) {
            System.out.println("");
            System.out.print("command: ");
            input1 = reader.nextLine();
            if (input1.equals("x")) {
                break;
            } else if (input1.equals("1")) {
                System.out.print("whose number: ");
                input1 = reader.nextLine();
                System.out.print("number: ");
                input2 = reader.nextLine();
                storeinfo.command1(input1, input2);
            } else if (input1.equals("2")) {
                System.out.print("whose number: ");
                input1 = reader.nextLine();    
                storeinfo.command2(input1);                
            } else if (input1.equals("3")) {
                System.out.print("number: ");
                input1 = reader.nextLine();        
                storeinfo.command3(input1);                   
            } else if (input1.equals("4")) {
                System.out.print("whose address: ");
                input1 = reader.nextLine();
                System.out.print("street: ");
                input2 = reader.nextLine();
                System.out.print("city: ");
                input2 += " " + reader.nextLine();
                storeinfo.command4(input1, input2);                
            } else if (input1.equals("5")) {
                System.out.print("whose information: ");
                input1 = reader.nextLine();    
                storeinfo.command5(input1);                   
            } else if (input1.equals("6")) {
                System.out.print("whose information: ");
                input1 = reader.nextLine();   
                storeinfo.command6(input1);                   
            } else if (input1.equals("7")) {
                System.out.print("keyword(if empty, all listed): ");
                input1 = reader.nextLine();    
                storeinfo.command7(input1);                   
            }  
        }
        }

    }
