package net.mooctest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BPlusTree_ESTest {

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        BPlusTree<String> bPlusTree0 = new BPlusTree<String>(1416, 1416);
        bPlusTree0.insert(1416, "Pufv6=^i");
        bPlusTree0.insert(0, "V&KO:%'8S(-0G ");
        bPlusTree0.insert(Integer.MAX_VALUE, "P");
        assertEquals(1416, bPlusTree0.getMinGap());
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        BPlusTree<Integer> bPlusTree0 = new BPlusTree<Integer>(2);
        Integer integer0 = new Integer((-2263));
        bPlusTree0.insert(2, integer0);
        bPlusTree0.getSize();
        assertEquals(Integer.MAX_VALUE, bPlusTree0.getMinGap());
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        BPlusTree<String> bPlusTree0 = new BPlusTree<String>(1);
        bPlusTree0.insert((-9), "InsertionResult");
        bPlusTree0.insert((-1), "Gyjp%AdT Dh_M");
        // Undeclared exception!
        try {
            bPlusTree0.search(1);
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        BPlusTree<Object> bPlusTree0 = new BPlusTree<Object>(880, 0);
        // Undeclared exception!
        try {
            bPlusTree0.search(0);
            fail("Expecting exception: ArithmeticException");

        } catch (ArithmeticException e) {
            //
            // / by zero
            //
            // verifyException("net.mooctest.IntegerBloomFilter", e);
        }
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        BPlusTree<String> bPlusTree0 = new BPlusTree<String>(1);
        bPlusTree0.insert((-1), "Gyjp%AdT Dh_M");
        bPlusTree0.insert(1, "Gyjp%AdT Dh_M");
        // Undeclared exception!
        try {
            bPlusTree0.order(1979);
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        BPlusTree<String> bPlusTree0 = new BPlusTree<String>(1);
        bPlusTree0.insert((-1), "Gyjp%AdT Dh_M");
        bPlusTree0.insert(1, (String) null);
        // Undeclared exception!
        try {
            bPlusTree0.insert(Integer.MAX_VALUE, (String) null);
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        BPlusTree<Integer> bPlusTree0 = new BPlusTree<Integer>(365, 0);
        Integer integer0 = new Integer(3982);
        // Undeclared exception!
        try {
            bPlusTree0.insert((-1), integer0);
            fail("Expecting exception: ArithmeticException");

        } catch (ArithmeticException e) {
            //
            // / by zero
            //
            // verifyException("net.mooctest.IntegerBloomFilter", e);
        }
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        BPlusTree<LeafNode<Object>> bPlusTree0 = new BPlusTree<LeafNode<Object>>(1, 1);
        // Undeclared exception!
        try {
            bPlusTree0.inOrder();
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        BPlusTree<String> bPlusTree0 = null;
        try {
            bPlusTree0 = new BPlusTree<String>(1623, (-3558));
            fail("Expecting exception: NegativeArraySizeException");

        } catch (NegativeArraySizeException e) {
            //
            // nbits < 0: -103182
            //
            // verifyException("java.util.BitSet", e);
        }
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        BPlusTree<Integer> bPlusTree0 = null;
        try {
            bPlusTree0 = new BPlusTree<Integer>((-110), 0);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Illegal Capacity: -111
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        BPlusTree<Object> bPlusTree0 = null;
        try {
            bPlusTree0 = new BPlusTree<Object>(0);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Illegal Capacity: -1
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        BPlusTree<Object> bPlusTree0 = new BPlusTree<Object>(1);
        bPlusTree0.toString();
        assertEquals(Integer.MAX_VALUE, bPlusTree0.getMinGap());
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        BPlusTree<String> bPlusTree0 = new BPlusTree<String>(2132);
        bPlusTree0.insert(2132, "(c}");
        String string0 = bPlusTree0.inOrder();
        assertEquals("2132", string0);
        assertEquals(Integer.MAX_VALUE, bPlusTree0.getMinGap());
    }

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        BPlusTree<Integer> bPlusTree0 = new BPlusTree<Integer>(2132, Integer.MAX_VALUE);
        Integer integer0 = new Integer((-1));
        bPlusTree0.insert(2132, integer0);
        int int0 = bPlusTree0.order(2132);
        assertEquals(Integer.MAX_VALUE, bPlusTree0.getMinGap());
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        BPlusTree<String> bPlusTree0 = new BPlusTree<String>(1);
        int int0 = bPlusTree0.order(1);
        assertEquals(Integer.MAX_VALUE, bPlusTree0.getMinGap());
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        BPlusTree<String> bPlusTree0 = new BPlusTree<String>(1);
        bPlusTree0.insert((-1), "Gyjp%AdT Dh_M");
        String string0 = bPlusTree0.reverseInOrder();
        assertEquals(Integer.MAX_VALUE, bPlusTree0.getMinGap());
        assertEquals("-1,", string0);
    }

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        BPlusTree<String> bPlusTree0 = new BPlusTree<String>(1);
        bPlusTree0.reverseInOrder();
        assertEquals(Integer.MAX_VALUE, bPlusTree0.getMinGap());
    }

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        BPlusTree<String> bPlusTree0 = new BPlusTree<String>(3532);
        bPlusTree0.insert(3532, "_#bN]JE_jsR=0");
        bPlusTree0.insert(3532, "2");
        assertEquals(Integer.MAX_VALUE, bPlusTree0.getMinGap());
    }

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        BPlusTree<String> bPlusTree0 = new BPlusTree<String>(1);
        bPlusTree0.search(1);
        assertEquals(Integer.MAX_VALUE, bPlusTree0.getMinGap());
    }

    @Test(timeout = 4000)
    public void test20() throws Throwable {
        BPlusTree<Object> bPlusTree0 = new BPlusTree<Object>(1, 1);
        bPlusTree0.insert(0, "");
        Object object0 = bPlusTree0.search(0);
        assertEquals(Integer.MAX_VALUE, bPlusTree0.getMinGap());
        assertNotNull(object0);
    }

    @Test(timeout = 4000)
    public void test21() throws Throwable {
        BPlusTree<Integer> bPlusTree0 = new BPlusTree<Integer>(2132, Integer.MAX_VALUE);
        bPlusTree0.search((-1));
        assertEquals(Integer.MAX_VALUE, bPlusTree0.getMinGap());
    }

    @Test(timeout = 4000)
    public void test22() throws Throwable {
        BPlusTree<LeafNode<Object>> bPlusTree0 = new BPlusTree<LeafNode<Object>>(2132);
        bPlusTree0.getSize();
        assertEquals(Integer.MAX_VALUE, bPlusTree0.getMinGap());
    }

    @Test(timeout = 4000)
    public void test23() throws Throwable {
        BPlusTree<String> bPlusTree0 = new BPlusTree<String>(1);
        int int0 = bPlusTree0.getMinGap();
        assertEquals(Integer.MAX_VALUE, int0);
    }

    @Test(timeout = 4000)
    public void test24() throws Throwable {
        BPlusTree<Integer> bPlusTree0 = new BPlusTree<Integer>(2);
        Integer integer0 = new Integer((-2263));
        bPlusTree0.insert(2, integer0);
        bPlusTree0.insert((-2263), integer0);
        // Undeclared exception!
        try {
            bPlusTree0.insert((-2263), integer0);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.InternalNode", e);
        }
    }
}
