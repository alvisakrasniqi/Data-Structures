public class NumLinkedList {

    // Field to store the head of the linked list
    private IntegerNode head;
    
    // Field to store the size of the linked list
    private int size;

    // Constructor
    public NumLinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Method to get the number of elements in the list
    public int getSize() {
        return size;
    }

    // Method to get the head of the list
    public IntegerNode getHead() {
        return head;
    }

    // Method to add an element to the end of the list
    public void add(int x) {
        IntegerNode newNode = new IntegerNode(x, null);

        if (head == null) {
            head = newNode;
        } else {
            IntegerNode current = head;
            while (current.getNextNode() != null) {
                current = current.getNextNode();
            }
            current.setNextNode(newNode);
        }
        size++;  // Increment the size after adding the new node
    }

    // Method to check whether the list is sorted in ascending order
    public boolean isSorted() {
        if (head == null || head.getNextNode() == null) {  
            return true;
        }

        IntegerNode current = head;
        while (current.getNextNode() != null) {
            if (current.getElement() > current.getNextNode().getElement()) {
                return false;
            }
            current = current.getNextNode();
        }
        return true; // All elements are sorted
    }

    // Method to reverse the list
    public void reverse() {
        IntegerNode prev = null;
        IntegerNode current = head;
        IntegerNode next = null;

        while (current != null) {
            next = current.getNextNode();
            current.setNextNode(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Method to merge two NumLinkedList instances into one sorted list
    public static NumLinkedList merge(NumLinkedList list1, NumLinkedList list2) {
        NumLinkedList mergedList = new NumLinkedList();
        IntegerNode current1 = list1.head;
        IntegerNode current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.getElement() <= current2.getElement()) {
                mergedList.add(current1.getElement());
                current1 = current1.getNextNode();
            } else {
                mergedList.add(current2.getElement());
                current2 = current2.getNextNode();
            }
        }

        while (current1 != null) {
            mergedList.add(current1.getElement());
            current1 = current1.getNextNode();
        }

        while (current2 != null) {
            mergedList.add(current2.getElement());
            current2 = current2.getNextNode();
        }

        return mergedList;
    }

    // Method to return a duplicate of the given NumLinkedList
    public static NumLinkedList duplicate(NumLinkedList list) {
        NumLinkedList newList = new NumLinkedList();
        IntegerNode current = list.head;
        while (current != null) {
            newList.add(current.getElement());
            current = current.getNextNode();
        }
        return newList;
    }

    // Method for testing which displays the list elements 
    public void display() {
        IntegerNode current = head;
        while (current != null) {
            System.out.print(current.getElement() + " ");
            current = current.getNextNode();
        }
        System.out.println();
    }
}
