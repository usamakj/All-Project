package Final_Project;

import java.util.Scanner;

public class Stack {
    Scanner sc = new Scanner(System.in);

    static int LB = 0; // LB is the Lower Bound of the Stack
    static int Top = LB - 1;
    static int choice1; // choice1 is for StackMenu
    static int size; // size is the Size of the Stack
    static int[] St;
    static int item; // item is the Number/Value which User Want to PUSH/POP

    Stack() {
        System.out.print("\nEnter the Size of the Stack: ");
        size = sc.nextInt();
        St = new int[size];
        do {
            StackMenu();
            choice1 = sc.nextInt();

            switch (choice1) {
                case 1:
                    System.out.print("\nEnter the Item You Want to PUSH: ");
                    item = sc.nextInt();
                    Push();
                    break;
                case 2:
                    Pop();
                    break;
                case 3:
                    Display();
                    break;
            }
        } while (choice1 != 4);
    }

    static void StackMenu() {
        System.out.println("\n<=== Stack Menu ===>");
        System.out.println("1.PUSH \n2.POP \n3.Display \n4.Exit");
        System.out.print("Choose the Operation (1 to 4) : ");
    }

    static void Display() {
        if (Top == (LB - 1)) {
            System.out.println("\nStack is Empty!");
        } else {
            System.out.println("\nThe Elements in the Stack are:");

            for (int i = LB; i <= Top; i++) {
                System.out.println(St[i]);
            }
        }
    }

    static void Push() {
        if (Top == (size + LB - 1)) {
            System.out.println("\nStack Overflow!");
            return;
        }

        Top++;
        St[Top] = item;

        System.out.println("\nPUSH Completed!");
    }

    static void Pop() {
        if (Top == (LB - 1)) {
            System.out.println("\nStack is Empty!");
            return;
        }

        System.out.println(St[Top]);
        Top--;

        System.out.println("\nPOP Completed!");
    }
}
