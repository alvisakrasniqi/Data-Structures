import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NumLinkedListTest {

    private NumLinkedList listA;
    private NumLinkedList listB;

    @Before
    public void initialize() {

        listA = new NumLinkedList();
        listB = new NumLinkedList();

        // listA with sorted elements
        listA.add(4);
        listA.add(8);
        listA.add(10);
        listA.add(11);

        //listB with sorted elements
        listB.add(1);
        listB.add(4);
        listB.add(9);
        listB.add(13);
    }

    @Test
    public void testSize() {
        assertEquals("List A should have 4 elements", 4, listA.size());
        assertEquals("List B should have 4 elements", 4, listB.size());
    }

    @Test
    public void testElementAddition() {
        listA.add(12);
        assertEquals("List A should now have 5 elements", 5, listA.size());

        // Traverse to the end of the list to verify the last element
        IntegerNode node = listA.getHead();
        while (node.getNextNode() != null) {
            node = node.getNextNode();
        }
        assertEquals("The last element should be 12", 12, node.getElement());
    }

    @Test
    public void testListIsSorted() {
        assertTrue( listA.isSorted());
        assertTrue( listB.isSorted());

        // after adding an out of order element in List A assert false
        listA.add(2);
        assertFalse( listA.isSorted());
    }

    @Test
    public void testListReversal() {
        listA.reverse();
        assertEquals( 11, listA.getHead().getElement());
    }

    @Test
    public void testMergeFunctionality() {
        NumLinkedList combinedList = NumLinkedList.merge(listA, listB);
        assertEquals( 8, combinedList.size());

        IntegerNode node = combinedList.getHead();
        assertEquals( 1, node.getElement());

        // Traverse to the last element to check the final order
        while (node.getNextNode() != null) {
            node = node.getNextNode();
        }
        assertEquals("The last element in the merged list should be 13", 13, node.getElement());
    }

    @Test
    public void testListDuplication() {
        NumLinkedList copyList = NumLinkedList.duplicate(listA);
        assertEquals(4, copyList.size());
        assertEquals(4, copyList.getHead().getElement());
    }

    // test case for merging with an empty list
    @Test
    public void testMergeWithEmptyList() {
        NumLinkedList emptyList = new NumLinkedList();
        NumLinkedList mergedList = NumLinkedList.merge(listA, emptyList);
        assertEquals("Merging with an empty list should retain original size", 4, mergedList.size());
        assertEquals("Merged list should start with the head of List A", 4, mergedList.getHead().getElement());
    }
}

