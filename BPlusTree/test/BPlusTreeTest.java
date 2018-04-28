package net.mooctest;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.BitSet;

import static org.junit.Assert.*;

public class BPlusTreeTest {

    private BPlusTree<Integer> tree;

    private BPlusTree<Integer> tree2;

    @Test
    public void test1() throws IOException {
        BPlusTree<Integer> tree = new BPlusTree<>(3, 5);
        BPlusTree<Integer> tree2 = new BPlusTree<>(3);
        tree.insert(35, 1);
        tree.insert(35, 2);
        tree.insert(78, 3);
        tree.insert(12, 4);
        tree.insert(54, 5);
        tree2.insert(35, 1);
        tree2.insert(35, 2);
        tree2.insert(78, 3);
        tree2.insert(12, 4);
        tree2.insert(54, 5);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        assertEquals("", new BPlusTree<>(3).toString());
        assertEquals("12,35#54,78", tree.toString());
        assertEquals("12,3554,78", tree.inOrder());
        assertEquals("78,54,35,12,", tree.reverseInOrder());

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

        assertEquals(2, tree.order(35));
        assertEquals(4, tree.order(78));
        assertEquals(1, tree.order(12));
        assertEquals(3, tree.order(54));
        assertEquals(-1, tree.order(55));

        assertEquals(4, tree.getSize());
        assertEquals(19, tree.getMinGap());

        assertTrue(os.toString().contains("Filter stopped the search."));
        assertTrue(os.toString().contains("Current False Positive Probability: 8.89124548750276E-7"));
    }

    @Test
    public void test2() {
        BPlusTree<Integer> tree = new BPlusTree<>(4, 100);
        BPlusTree<Integer> tree2 = new BPlusTree<>(3, 100);
        for (int i = 50; i >= 1; i--) {
            tree.insert(i, i * 3);
            tree2.insert(i, i * 3);
        }
        for (int i = 51; i <= 100; i++) {
            tree.insert(i, i * 2);
            tree2.insert(i, i * 2);
        }
        for (int i = 1; i <= 50; i++) {
            assertEquals(i * 3, tree.search(i).intValue());
            assertEquals(i * 3, tree2.search(i).intValue());
        }
        for (int i = 51; i <= 100; i++) {
            assertEquals(i * 2, tree.search(i).intValue());
            assertEquals(i * 2, tree2.search(i).intValue());
        }
    }

    @Test
    public void testIntBF() throws IllegalAccessException, NoSuchFieldException {
        IntegerBloomFilter bf1 = new IntegerBloomFilter(7, 4, 3);
        assertEquals(7, bf1.getBitsPerElement());
        assertEquals(28, bf1.getFilterSize());
        assertEquals(3, bf1.getTotalHashFunctions());
        assertEquals(0.042348, bf1.getExpectedFalsePositiveProbability(), 1E-6);
        assertEquals(0.0, bf1.getCurrentFalsePositiveProbability(), 1E-6);

        Field bs = IntegerBloomFilter.class.getDeclaredField("bitset");
        bs.setAccessible(true);
        bf1.add(1);
        assertFalse(((BitSet) bs.get(bf1)).isEmpty());
        bf1.clear();
        assertTrue(((BitSet) bs.get(bf1)).isEmpty());
    }

}
