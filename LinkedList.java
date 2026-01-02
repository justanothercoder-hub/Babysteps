public class LinkedList {

    // 1. The Node Class
    // Static inner class so main() can access it easily
    static class Node {
        int data;
        Node next;

        // Constructor to create a new node
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Head of the list
    Node head;

    // 2. Insert at the Beginning (Time Complexity: O(1))
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // 3. Insert at the End (Time Complexity: O(n))
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        // If the list is empty, make the new node the head
        if (head == null) {
            head = newNode;
            return;
        }

        // Otherwise, traverse to the last node
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        // Link the last node to the new node
        current.next = newNode;
    }

    // 4. Delete by Key (Time Complexity: O(n))
    public void deleteByKey(int key) {
        Node current = head;
        Node prev = null;

        // Case 1: If head itself holds the key
        if (current != null && current.data == key) {
            head = current.next; // Changed head
            System.out.println(key + " Found and deleted");
            return;
        }

        // Case 2: Search for the key to be deleted
        while (current != null && current.data != key) {
            prev = current;
            current = current.next;
        }

        // Case 3: Key was not present in the list
        if (current == null) {
            System.out.println(key + " not found");
            return;
        }

        // Unlink the node from the linked list
        prev.next = current.next;
        System.out.println(key + " Found and deleted");
    }

    // 5. Display the Linked List
    public void printList() {
        Node current = head;
        System.out.print("Linkedist: ");
        while (current != null) {
            System.out.print(current.data + " ------> ");
            current = current.next;
        }
        System.out.println("Null");
        System.out.println("extra line");
         System.out.println("extra line99922");
         System.out.println("extra line905");
    }

    // Driver Code
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Insertions
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtHead(5); // List: 5 -> 10 -> 20
        list.insertAtEnd(30); // List: 5 -> 10 -> 20 -> 30

        list.printList();

        // Deletion
        list.deleteByKey(10); // Removes 10
        list.printList();

        // Edge case: Delete head
        list.deleteByKey(5);
        list.printList();
    }
}