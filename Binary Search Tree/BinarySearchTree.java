import java.util.NoSuchElementException;

//Alvisa Krasniqi - CSDS 233 - A3

public class BinarySearchTree{


    //a priavte class for the node
    private class Node{
        //fields to intialze 
        int key;
        Node left;
        Node right;

        //constructor to intialize the node
        Node(int key){
            this.key = key;
            this.left= null;
            this.right = null;
           }
    }

    //field for the Node
    private Node root;


    //method to insert a new node
    public void insert(int key){

        Node newNode = new Node(key);

        //set new node as root if the tree is intially empty
        if(root == null){
            root = newNode;
            return;
        }

        //field to track the parent node
        Node parent = null;

        //field to start the traversal from the rood
        Node trav = root;

        //traverse through the tree
        while (trav!= null){
            parent = trav;
            if(key < trav.key){
                trav = trav.left;//go to left child if the key is less then the trav key
            }
            else{
                trav = trav.right; //else go to right child
            }
           }

            //inserting new node
            if (key< parent.key){
                parent.left = newNode;
            }
            else{
                parent.right = newNode;
            }
        }
    
        //method to create a tree from the int array of values using the insert method 
        public void createTree(int[] values){
            //for loop 
            for (int value : values){
                insert(value);//this part inserts each value from values in a bst
            }
        }

        //method to search through the bst for a given key
        public boolean search(int key){
            
            Node trav = root;

            while(trav!= null){
                if (key == trav.key){
                    return true; //given key exists in our bst tree
            }
                else if( key < trav.key){
                    trav = trav.left; //traverse the left subtree 
                }
                else
                    trav = trav.right;//traverse the right subtree

            }
            return false; //given key was not found
        }


        //method to delete a node
        public Node delete(int key){

            Node parent = null;
            Node trav = root;

            //find the node that needs to be delete
            while(trav!= null && trav.key != key){
                parent = trav;
                if(key < trav.key){
                    trav = trav.left;
                }
                else{
                    trav = trav.right;
                }
            }
            
            //if there wasn't any node found
            if (trav == null){
                return null; //node was not found
            }
            
            deleteNode(trav, parent);//calls the helper method below
            return trav;// returns the deleted node
            }
        

        //helper method to delete the node
        private void deleteNode( Node toDelete, Node parent){

            //case 1 - node that is  being deleted is a leaf
            if(toDelete.left == null && toDelete.right ==null){

                //if it is the root of the tree
                if(toDelete == root){
                    root = null;
                }
                else if(toDelete.key< parent.key){
                    parent.left = null;//remove from the left
                }
                else{
                    parent.right=null;
                }

            }

            // case 2 - node has one child
            else if (toDelete.left == null || toDelete.right == null) {
            Node toDeleteChild = null;

            // get the child node
            if (toDelete.left != null) {
                toDeleteChild = toDelete.left; // get the left child
            } else {
                toDeleteChild = toDelete.right; // getting the right child
            }
    
            //if toDelete is the root node
            if (toDelete == root) {
                root = toDeleteChild; //we update the root
            } 
            else if (toDelete.key < parent.key) {
                parent.left = toDeleteChild; 
            }
            else {
                parent.right = toDeleteChild; 
                }
            }

            //case 3 - replace with the inorder succesor
            else{
            Node replacementParent = toDelete;
            Node replacement = toDelete.right;

            while(replacement.left!= null){
                replacementParent= replacement;
                replacement = replacement.left;
            }

            toDelete.key = replacement.key;
            deleteNode(replacement, replacementParent);
            }
         }


         //find the minimum value of the tree by traverising through the left subtree
         public int findMin(){

            if(root==null){
                throw new NoSuchElementException("there are NO elements in the tree");
            }

            //
            Node trav = root;
            
            while(trav.left!=null){
                trav = trav.left;
            }
            return trav.key;
         }   


         //find the maximum value by traversing in the right subtree
         public int findMax(){

            if(root == null){
                throw new NoSuchElementException("there are No elements in the tree");
            }

            Node trav = root;
            while(trav.right!=null){
                trav = trav.right;

            }
            return trav.key;

         }

        // method to return the height of the tree
          public int height() {
              if (this.root == null) {
             return -1; // height of tree is -1 if tree is empty
             }
            return nodeHeight(this.root); // calls the helper method with the root
        }       

        // helper method to calculate height of tree using recursion
         private int nodeHeight(Node node) {
             //base case: if the node is null, return -1
             if (node == null) {
            return -1; 
            }
             // Calculate left and right heights
              int leftHeight = nodeHeight(node.left); // recursive call for left child
              int rightHeight = nodeHeight(node.right); // recursive call for right child
    
              // return the maximum height between left and right, +1
               return Math.max(leftHeight, rightHeight) + 1;
            }

            

            //method to print in ordere traversal
           public void inorderTrav(){
            inorderHelper(root);
            System.out.println();
            }

            //helpeth method for the inorderTrav method
            private void inorderHelper(Node node){
                if(node != null){
                    inorderHelper(node.left);//traverse left subtree first
                    System.out.print(node.key + " ");//visit the node
                    inorderHelper(node.right); //tranverse right subtree
                }
            }

            //method to print preorder traversal
            public void preorderTrav(){
                preorderHelper(root);
                System.out.println();
            }

            //helper method for preorderTrav method
            private void preorderHelper(Node node){
                if(node!= null){
                    System.out.print(node.key + " ");//visit node first
                    preorderHelper(node.left);//traverse left subtree
                    preorderHelper(node.right);//traverse right subtree
                }
            }

            //method to print post order traversal
            public void postorderTrav(){
                postorderHelper(root);
                System.out.println();
            }

            //helper method for postorder traversal
            private void postorderHelper(Node node){
                if(node!=null){
                    postorderHelper(node.left);//traverse left subtree
                    postorderHelper(node.right);//traverse right subtree
                    System.out.print(node.key + " ");//lastly - visit the node
                }
            }

         }




    