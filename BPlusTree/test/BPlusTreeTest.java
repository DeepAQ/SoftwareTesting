import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BPlusTreeTest {
    
    private BPlusTree<Integer> tree;
    
    private BPlusTree<Integer> tree2;

    @Before
    public void setUp() throws Exception {
        tree = new BPlusTree<>(3, 5);
        tree.insert(35, 1);
        tree.insert(35, 2);
        tree.insert(78, 3);
        tree.insert(12, 4);
        tree.insert(54, 5);
        tree2 = new BPlusTree<>(3);
        tree2.insert(35, 1);
        tree2.insert(35, 2);
        tree2.insert(78, 3);
        tree2.insert(12, 4);
        tree2.insert(54, 5);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testToString() {
        assertEquals("", new BPlusTree<>(3).toString());
        assertEquals("12,35#54,78", tree.toString());
    }
    
    @Test
    public void testInOrder() {
        assertEquals("12,3554,78", tree.inOrder());
        assertEquals("78,54,35,12,", tree.reverseInOrder());
    }
    
    @Test
    public void testSearch() {
        assertEquals(2, tree.search(35).intValue());
        assertEquals(3, tree.search(78).intValue());
        assertEquals(4, tree.search(12).intValue());
        assertEquals(5, tree.search(54).intValue());
        assertNull(tree.search(55));
        
        assertEquals(2, tree2.search(35).intValue());
        assertEquals(3, tree2.search(78).intValue());
        assertEquals(4, tree2.search(12).intValue());
        assertEquals(5, tree2.search(54).intValue());
        assertNull(tree2.search(55));
    }
    
    @Test
    public void testOrder() {
        assertEquals(2, tree.order(35));
        assertEquals(4, tree.order(78));
        assertEquals(1, tree.order(12));
        assertEquals(3, tree.order(54));
        assertEquals(-1, tree.order(55));
    }
    
    @Test
    public void testSize() {
        assertEquals(4, tree.getSize());
    }
    
    @Test
    public void testMinGap() {
        assertEquals(19, tree.getMinGap());
    }
    
    @Test
    public void testInsertMore() {
        Set<Integer> keys = new LinkedHashSet<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            keys.add(random.nextInt(1000));
        }
        BPlusTree<Integer> tree3 = new BPlusTree<>(3, 100);
        for (int key : keys) {
            tree3.insert(key, key * 2);
        }
        for (int key : keys) {
            Integer result = tree3.search(key);
            if (result != null) {
                assertEquals(key * 2, result.intValue());
            }
        }
    }

}
