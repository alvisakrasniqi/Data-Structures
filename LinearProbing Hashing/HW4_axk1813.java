public class HW4_axk1813{

    private class Entry{
        private String key;
        private String etymology;
        private boolean removed;

        private Entry(String key, String etymology){
            this.key = key;
            this.etymology = etymology;
            removed = false;
        }
        
    }

    private Entry[] table;
    private int tableSize;

    public HW4_axk1813(int size){
        table = new Entry[size];
        this.tableSize = size;
    }


    public void linearProbingInsert(int key){

        int index = key % tableSize; // field to store intial index
        int iterations = 0; // field to track the number of attempts to find empty slot


        //while loop to find an empty or removed slot in the hash table
        while(table[index]!= null && table[index].removed == false){
            index = (index + 1) % tableSize;
            iterations++;
        
            //if the hash table is full
        if(iterations == tableSize){
            System.out.println("Hash Table is full! We cannot insert " + key);
            return;
         }

        }

         //insert the key as new entry if the table is not full
         table[index] = new Entry(Integer.toString(key), "");

         printTable();

    }

    public void doubleHashingInsert(int key, int prime){

        int index= key % tableSize; //first hash funtion
        int probeIndex = index; //store probe index
        int iterations = 0; //track iterations

        int step = prime - (key% prime); // second hash function


        while (table[probeIndex] != null && !table[probeIndex].removed){
            probeIndex = (probeIndex + step) % tableSize;
            iterations++;

            if (iterations == tableSize){
                System.out.println("Table is full! we cannot insert " + key);
                return;
            }
        }

        table[probeIndex] = new Entry(Integer.toString(key), " ");

        printTable();
    }

    //helper method to print the table
    private void printTable(){
        System.out.print("Table State now is: ");
        for(int i =0; i< tableSize; i++){
            if(table[i] != null &&  !table[i].removed){
                System.out.print(table[i].key + " ");
            }else{
                System.out.print("null ");
            }
            if (i < tableSize - 1) {
                System.out.print(", "); 
              }
          }
          System.out.println();
     
    }

       // Testing both Linear Probing and Double Hashing insertions
       public static void main(String[] args) {

        int[] keys = {10, 3, 17, 14, 18, 3, 8, 1, 18, 11};  // keys for linear probing test
        int tableSize = 7;  // the small size will increase collisions

        HW4_axk1813 linearHashTable = new HW4_axk1813(tableSize);

        System.out.println("Testing Linear Probing Insertions:");
        // test linear probing insertions
        for (int key : keys) {
            linearHashTable.linearProbingInsert(key);
        }

    
        // keys for double hashing test
        int[] keysDoubleHashing = {7, 17, 27, 37, 47, 57, 67, 77, 87, 97};
        int tableSize2 = 10;
        int prime = 7;

        HW4_axk1813 doubleHashTable = new HW4_axk1813(tableSize2);

        System.out.println("Testing Double Hashing Insertions:");

        // Test double hashing insertions
        for (int key2 : keysDoubleHashing) {
            doubleHashTable.doubleHashingInsert(key2, prime);
        }
    }
}

