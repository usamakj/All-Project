package Final_Project;

import java.util.Scanner;

public class LinkedList {
    Scanner sc = new Scanner(System.in);

    static int choice1;
    static int item;

    LinkedList() {
        do {
            LinkedListMenu();
            choice1 = sc.nextInt();

            switch (choice1) {
                case 1:
                    new SingleLinkedList();
                    break;
                case 2:
                    // new DoubleLinkedList();
                    break;
            }
        } while (choice1 != 3);
    }

    static void LinkedListMenu() {
        System.out.println("\n<=== Linked List Menu ===>");
        System.out.println("1.Single Linked List \n2.Double Linked List \n3.Exit");
        System.out.print("Choose the Operation (1 to 3) : ");
    }
}

class SingleLinkedList {
    static Scanner sc = new Scanner(System.in);

    static class SLL {
        int info;
        SLL next;

        SLL(int info) {
            this.info = info;
            this.next = null;
        }
    }

    static int choice2;
    static int choice3;

    static SLL start = null;

    SingleLinkedList() {
        do {
            System.out.println("\n<== Single Linked List Menu ==>");
            System.out.println("1.Traverse \n2.Insertion \n3.Exit");
            System.out.print("Choose the Operation (1 to 3) : ");
            choice2 = sc.nextInt();

            switch (choice2) {
                case 1:
                    Traverse_SLL();
                    break;
                case 2:
                    System.out.println(
                            "\n1.Insertion At First \n2.Insertion At Last \n3.Insertion In Middle (Before Given Node) \n4.Insertion In Middle (After Given Node) \n5.Exit");
                    System.out.print("Choose the Operation (1 to 5) : ");
                    choice3 = sc.nextInt();

                    switch (choice3) {
                        case 1:
                            Insertion_AtFirst_SLL();
                            break;
                        case 2:
                            Insertion_AtLast_SLL();
                            break;
                        case 3:
                            SLL ptr = FindMiddleNode();

                            Insertion_InMid_BGN_SLL(ptr);
                            break;
                        case 4:
                            SLL ptr1 = FindMiddleNode();
                            Insertion_InMid_AGN_SLL(ptr1);
                            break;
                    }
                    break;
            }
        } while (choice2 != 3);

    }

    static SLL FindMiddleNode() {
        if (start == null) {
            return null;
        }

        SLL mid = start;
        SLL head = start;

        while (head != null && head.next != null) {
            mid = mid.next;
            head = head.next.next;
        }

        return mid;
    }

    static void Traverse_SLL() {
        if (start == null) {
            System.out.println("\nSingle Linked List is Empty!");
            return;
        }

        SLL ptr = start;

        while (ptr != null) {
            System.out.println(ptr.info);
            ptr = ptr.next;
        }
    }

    static void Insertion_AtFirst_SLL() {
        System.out.print("\nEnter the Item You Want to Insert : ");
        int item = sc.nextInt();

        SLL ptr = new SLL(item);
        ptr.info = item;
        ptr.next = start;

        start = ptr;
    }

    static void Insertion_AtLast_SLL() {
        System.out.print("\nEnter the Item You Want to Insert : ");
        int item = sc.nextInt();

        SLL ptr = new SLL(item);
        ptr.info = item;
        ptr.next = null;

        if (start == null) {
            start = ptr;
            return;
        }

        SLL ptr1 = start;

        while (ptr1.next != null) {
            ptr1 = ptr1.next;
        }

        ptr1.next = ptr;
    }

    static void Insertion_InMid_BGN_SLL(SLL ptr) {
        System.out.print("\nEnter the Item You Want to Insert : ");
        int item = sc.nextInt();

        SLL ptr1 = new SLL(item);
        ptr1.info = item;
        ptr1.next = ptr;

        SLL ptr2 = start;

        if ((ptr2 == null) || (ptr2.next == null) || (ptr == start)) {
            start = ptr1;
        } else {
            while ((ptr2.next != null) && (ptr2.next != ptr)) {
                ptr2 = ptr2.next;
            }

            ptr2.next = ptr1;
        }
    }

    static void Insertion_InMid_AGN_SLL(SLL ptr) {
        System.out.print("\nEnter the Item You Want to Insert : ");
        int item = sc.nextInt();

        SLL ptr1 = new SLL(item);
        ptr1.info = item;

        if (start == null) {
            ptr1.next = start;

            start = ptr1;
        } else {
            ptr1.next = ptr.next;

            ptr.next = ptr1;
        }
    }

}
