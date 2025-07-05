import java.util.NoSuchElementException;

public class BinarySearchTreeMain{

    public static void main(String[] args){

        //part 1 
        //create an instance of the BinarySearchTree
        BinarySearchTree bst = new BinarySearchTree();

        //insert nodes into the tree
        int[] nodesToInsert = {60, 35, 25, 10, 80, 40};
        bst.createTree(nodesToInsert);
    

    System.out.println("Inorder Traversal: " );
    bst.inorderTrav(); // expect an output of: 10 25 35 40 60 80 
   
    System.out.println("Preorder Traversal: ");
    bst.preorderTrav();//expect 60 35 25 10 40 80

    System.out.println("postorder traversal: ");
    bst.postorderTrav(); //expect output of: 10 25 40 35 80 60

    // part 2 - test the CreateTree method
    System.out.println("Testing the createTree method with a new array of integers");
    int[] newNodesToInsert = {30, 45, 60, 10, 13};
    BinarySearchTree newBst = new BinarySearchTree();
    newBst.createTree(newNodesToInsert);

    //display the inorder traversal
    System.out.println("Inorder traversal of the new tree ");
    newBst.inorderTrav(); //expected output of 10 13 30 45 60
    
    //part 3 - testing search method
    System.out.println("Testing Seach method");
    int[] keysToSearch = {45, 10, 13, 55, 34, 98};//3 are found in the newBst and 3 are not

    for(int key: keysToSearch){
        boolean found = newBst.search(key);
        System.out.println("Search for " + key + ": " + (found ? "Found" : "Not Found"));// expect 45, 10, 13 to be found in newBst and the other values to not be found      
    }

    //part 4 - deleting 3 nodes and displaying inorder traversal after each deletion
    int[] nodesToDelete = {30, 13, 60};
    for (int key : nodesToDelete){
        newBst.delete(key);
        System.out.println("Inorder traversal after deleting " + key + ": ");
        newBst.inorderTrav();
    }


    //part 5 - testing findMin and findMax using the first BST tree I created above
    System.out.println("Testing the findMax() and findMin():");
        try {
            int minValue = bst.findMin();
            System.out.println("Minimum value in the BST: " + minValue); //expect a value of 10
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        try {
            int maxValue = bst.findMax();
            System.out.println("Maximum value in the BST: " + maxValue); //expect a value of 80 
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }


        //part 6 - test the heigh method
        System.out.println("Testing the Height of the tree");
        int height = bst.height();
        System.out.println("Height of the BST is: " + height); //expect a value of 3



}





}