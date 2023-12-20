package Final_Project;

import java.util.Scanner;

public class Queue {
    Scanner sc = new Scanner(System.in);

    static int LB = 0; // LB is the Lower Bound of the Queue
    static int F = LB - 1; // F is the Front Index of the Queue
    static int R = LB - 1;// R is the Rear Index of the Queue
    static int choice1; // choice1 is for QueueMenu
    static int choice2; // choice2 is for Simple/CircularQueue
    static int size; // size is the Size of the Queue
    static int[] Q; // Q is the Simple Queue
    static int[] CQ;// Q is the Circular Queue
    static int item; // item is the Number/Value which User Want to Insert/Delete

    Queue() {
        do {
            System.out.println("\n<=== Queue Menu ===>");
            System.out.println("1.Simple Queue \n2.Circular Queue \n3.Exit");
            System.out.print("Choose the Operation (1 to 3) : ");
            choice1 = sc.nextInt();

            switch (choice1) {
                case 1:
                    System.out.print("\nEnter the Size of the Simple Queue: ");
                    size = sc.nextInt();
                    Q = new int[size];

                    do {
                        System.out.println("\n<== Simple Queue Menu ==>");
                        QueueMenu();
                        choice2 = sc.nextInt();

                        switch (choice2) {
                            case 1:
                                System.out.print("\nEnter the Item You Want to Insert: ");
                                item = sc.nextInt();

                                SimpleQueueInsert();
                                break;
                            case 2:
                                SimpleQueueDelete();
                                break;
                            case 3:
                                SimpleQueueDisplay();
                                break;
                        }
                    } while (choice2 != 4);
                    break;
                case 2:
                    System.out.print("\nEnter the Size of the Circular Queue: ");
                    size = sc.nextInt();
                    CQ = new int[size];

                    do {
                        System.out.println("\n<== Circular Queue Menu ==>");
                        QueueMenu();
                        choice2 = sc.nextInt();

                        switch (choice2) {
                            case 1:
                                System.out.print("\nEnter the Item You Want to Insert: ");
                                item = sc.nextInt();

                                CircularQueueInsert();
                                break;
                            case 2:
                                CircularQueueDelete();
                                break;
                            case 3:
                                CircularQueueDisplay();
                                break;
                        }
                    } while (choice2 != 4);
                    break;
            }
        } while (choice1 != 3);
    }

    static void QueueMenu() {
        System.out.println("1.Insert \n2.Delete \n3.Display \n4.Exit");
        System.out.print("Choose the Operation (1 to 4) : ");
    }

    static void SimpleQueueDisplay() {
        if (F == (LB - 1)) {
            System.out.println("\nQueue is Empty!");
        } else {
            System.out.println("\nThe Elements in the Simple Queue are:");

            for (int i = F; i <= R; i++) {
                System.out.println(Q[i]);
            }
        }
    }

    static void SimpleQueueInsert() {
        if (R == (size + LB - 1)) {
            System.out.println("\nSimple Queue is Full!");
            return;
        }

        if (R == (LB - 1)) {
            R = LB;
            F = LB;
        } else {
            R++;
        }

        Q[R] = item;

        System.out.println("\nInsertion is Completed!");
    }

    static void SimpleQueueDelete() {
        if (F == (LB - 1)) {
            System.out.println("\nSimple Queue is Empty!");
            return;
        }

        item = Q[F];

        if (F == R) {
            F = LB - 1;
            R = LB - 1;
        } else {
            F++;
        }

        System.out.println("\nDeletion Completed!");
    }

    static void CircularQueueDisplay() {
        if (F == LB - 1) {
            System.out.println("\nCircular Queue is Empty!");
        } else {
            System.out.println("\nThe Elements in the Circular Queue are:");

            int i = F;
            while (i != R) {
                System.out.println(CQ[i]);
                i = (i + 1) % size;
            }

            System.out.println(CQ[i]);
        }
    }

    static void CircularQueueInsert() {
        if ((R == (size + LB - 1) && F == LB) || R == F - 1) {
            System.out.println("\nInsertion is Not Possible!");
            return;
        }

        if (R == LB - 1) {
            R = LB;
            F = LB;
        } else {
            if (R == size + LB - 1) {
                R = LB;
            } else {
                R++;
            }
        }

        CQ[R] = item;

        System.out.println("\nInsertion is Completed!");
    }

    static void CircularQueueDelete() {
        if (F == LB - 1) {
            System.out.println("\nCircular Queue is Empty!");
            return;
        }

        item = CQ[F];

        if (F == R) {
            F = LB - 1;
            R = LB - 1;
        } else {
            if (F == size + LB - 1) {
                F = LB;
            } else {
                F++;
            }
        }

        System.out.println("\nDeletion Completed!");
    }
}
