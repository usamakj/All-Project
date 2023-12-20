package Final_Project;
import java.util.Scanner;
public class Main_Menu {
    static int choice; // choice is for MainMenu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            MainMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    new Array();
                    break;
                case 2:
                    new LinkedList();
                    break;
                case 3:
                    new Stack();
                    break;
                case 4:
                    new Queue();
                    break;
            }
        } while (choice != 5);
        System.out.println("Exit Successfully.");

        sc.close(); // It is Optional to Close the Scanner
    }

    static void MainMenu() {
        System.out.println("\n<================ MAIN MENU ================>");
        System.out.println("1.Array \n2.Linked List \n3.Stack \n4.Queue \n5.Exit");
        System.out.print("Choose the Operation (1 to 5) : ");
    }
}
