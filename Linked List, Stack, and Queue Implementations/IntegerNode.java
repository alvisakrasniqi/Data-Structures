public class IntegerNode {

     // Fields
     private int element;
     private IntegerNode nextNode;
 
     // Constructor
     public IntegerNode(int element, IntegerNode nextNode) {
         this.element = element;
         this.nextNode = nextNode;
     }
 
     // Getter for element
     public int getElement() {
         return element;
     }
 
     // Setter for element
     public void setElement(int element) {
         this.element = element;
     }
 
     // Getter for nextNode
     public IntegerNode getNextNode() {
         return nextNode;
     }
 
     // Setter for nextNode
     public void setNextNode(IntegerNode nextNode) {
         this.nextNode = nextNode;
     }
 }
 