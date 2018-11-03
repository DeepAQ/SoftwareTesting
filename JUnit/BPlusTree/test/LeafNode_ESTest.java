package net.mooctest;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

// import static org.evosuite.runtime.EvoAssertions.verifyException;

public class LeafNode_ESTest {

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(2044);
        LinkedList<Object> linkedList0 = new LinkedList<Object>();
        Integer integer0 = new Integer((-562));
        leafNode0.insert(2044, integer0);
        leafNode0.insert((-492), linkedList0);
        leafNode0.reverseToString();
        assertEquals(2, leafNode0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(814);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        LinkedList<String> linkedList1 = new LinkedList<String>();
        LeafNode<String> leafNode1 = new LeafNode<String>(814, leafNode0, linkedList0, linkedList1);
        leafNode1.t = (-1);
        // Undeclared exception!
        try {
            leafNode1.insert(0, "InsertionResult");
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Illegal Capacity: -2
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(2044);
        LinkedList<Object> linkedList0 = new LinkedList<Object>();
        Integer integer0 = new Integer((-562));
        InsertionResult<Object> insertionResult0 = leafNode0.insert(2044, integer0);
        leafNode0.insert((-492), linkedList0);
        leafNode0.insert((-1844), insertionResult0);
        assertEquals(3, leafNode0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(201);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        Integer integer0 = new Integer(201);
        linkedList0.add(integer0);
        LinkedList<String> linkedList1 = new LinkedList<String>();
        LeafNode<String> leafNode1 = new LeafNode<String>(201, leafNode0, linkedList0, linkedList1);
        int int0 = leafNode1.order(201);
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(2044);
        LinkedList<Object> linkedList0 = new LinkedList<Object>();
        Integer integer0 = new Integer(2044);
        leafNode0.insert(2044, integer0);
        leafNode0.insert((-492), linkedList0);
        int int0 = leafNode0.order(2044);
        assertEquals(2, leafNode0.getNodeSize());
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(201);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        Integer integer0 = new Integer(201);
        linkedList0.add(integer0);
        LinkedList<String> linkedList1 = new LinkedList<String>();
        LeafNode<String> leafNode1 = new LeafNode<String>(201, leafNode0, linkedList0, linkedList1);
        leafNode0.insert(0, "");
        leafNode1.insert(0, "s|{}6utuf%RTn>;Pn");
        assertEquals(2, leafNode1.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(291);
        LeafNode<Object> leafNode1 = new LeafNode<Object>(1, leafNode0);
        LeafNode<Object> leafNode2 = leafNode1.getPrev();
        assertSame(leafNode2, leafNode0);
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(201);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        LinkedList<String> linkedList1 = new LinkedList<String>();
        LeafNode<String> leafNode1 = new LeafNode<String>(201, leafNode0, linkedList0, linkedList1);
        InsertionResult<String> insertionResult0 = leafNode0.insert(3718, "InsertionResult");
        assertEquals(Integer.MAX_VALUE, insertionResult0.getMinGap());

        LeafNode<String> leafNode2 = leafNode1.getPrev();
        assertEquals(1, leafNode2.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(291);
        LeafNode<Object> leafNode1 = new LeafNode<Object>(1, leafNode0);
        LeafNode<Object> leafNode2 = leafNode0.getNext();
        assertSame(leafNode2, leafNode1);
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(431);
        LeafNode<Object> leafNode1 = new LeafNode<Object>(1, leafNode0);
        Object object0 = new Object();
        leafNode1.insert(1, object0);
        LeafNode<Object> leafNode2 = leafNode0.getNext();
        assertNotSame(leafNode2, leafNode0);
    }

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(890);
        int int0 = leafNode0.calculateGap((-1115));
        assertEquals(Integer.MAX_VALUE, int0);
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        LeafNode<Integer> leafNode0 = new LeafNode<Integer>(384);
        leafNode0.keys = null;
        // Undeclared exception!
        try {
            leafNode0.toString();
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.LeafNode", e);
        }
    }

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(2);
        LeafNode<Object> leafNode1 = new LeafNode<Object>(2029, leafNode0);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        leafNode1.keys = (List<Integer>) linkedList0;
        // Undeclared exception!
        try {
            leafNode1.toString();
            fail("Expecting exception: IndexOutOfBoundsException");

        } catch (IndexOutOfBoundsException e) {
            //
            // Index: -1, Size: 0
            //
            // verifyException("java.util.LinkedList", e);
        }
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(431);
        LeafNode<Object> leafNode1 = new LeafNode<Object>(1, leafNode0);
        leafNode1.keys = null;
        // Undeclared exception!
        try {
            leafNode1.reverseToString();
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.LeafNode", e);
        }
    }

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(431);
        LeafNode<Object> leafNode1 = new LeafNode<Object>(1, leafNode0);
        leafNode1.keys = null;
        // Undeclared exception!
        try {
            leafNode1.order(0);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.LeafNode", e);
        }
    }

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(201);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        linkedList0.add((Integer) null);
        LinkedList<String> linkedList1 = new LinkedList<String>();
        LeafNode<String> leafNode1 = new LeafNode<String>(201, leafNode0, linkedList0, linkedList1);
        // Undeclared exception!
        try {
            leafNode1.insert(201, "InsertionResult");
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.Node", e);
        }
    }

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(291);
        LeafNode<Object> leafNode1 = new LeafNode<Object>(291, leafNode0);
        leafNode1.t = 0;
        // Undeclared exception!
        try {
            leafNode1.insert(291, leafNode0);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Illegal Capacity: -1
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        LeafNode<Integer> leafNode0 = new LeafNode<Integer>(384);
        leafNode0.keys = null;
        // Undeclared exception!
        try {
            leafNode0.getValue(2);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.LeafNode", e);
        }
    }

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(201);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        Integer integer0 = new Integer(201);
        linkedList0.add(integer0);
        LinkedList<String> linkedList1 = new LinkedList<String>();
        LeafNode<String> leafNode1 = new LeafNode<String>(201, leafNode0, linkedList0, linkedList1);
        // Undeclared exception!
        try {
            leafNode1.getValue(201);
            fail("Expecting exception: IndexOutOfBoundsException");

        } catch (IndexOutOfBoundsException e) {
            //
            // Index: 0, Size: 0
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(369);
        leafNode0.keys = null;
        // Undeclared exception!
        try {
            leafNode0.calculateGap(369);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.LeafNode", e);
        }
    }

    @Test(timeout = 4000)
    public void test20() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(210);
        // Undeclared exception!
        try {
            leafNode0.calculateGap(210);
            fail("Expecting exception: IndexOutOfBoundsException");

        } catch (IndexOutOfBoundsException e) {
            //
            // Index: 209, Size: 0
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test21() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(2044);
        // Undeclared exception!
        try {
            leafNode0.calculateGap(Integer.MAX_VALUE);
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test22() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(1);
        List<Integer> list0 = leafNode0.keys;
        LinkedList<String> linkedList0 = new LinkedList<String>();
        LeafNode<String> leafNode1 = null;
        try {
            leafNode1 = new LeafNode<String>(1, (LeafNode<String>) null, list0, linkedList0);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.LeafNode", e);
        }
    }

    @Test(timeout = 4000)
    public void test23() throws Throwable {
        LeafNode<Integer> leafNode0 = new LeafNode<Integer>(1380);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        LeafNode<Integer> leafNode1 = null;
        try {
            leafNode1 = new LeafNode<Integer>((-1), leafNode0, linkedList0, linkedList0);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Illegal Capacity: -2
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test24() throws Throwable {
        LeafNode<Object> leafNode0 = null;
        try {
            leafNode0 = new LeafNode<Object>(6, (LeafNode<Object>) null);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.LeafNode", e);
        }
    }

    @Test(timeout = 4000)
    public void test25() throws Throwable {
        LeafNode<Object> leafNode0 = null;
        try {
            leafNode0 = new LeafNode<Object>(0, (LeafNode<Object>) null);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Illegal Capacity: -1
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test26() throws Throwable {
        LeafNode<Object> leafNode0 = null;
        try {
            leafNode0 = new LeafNode<Object>((-1524));
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Illegal Capacity: -1525
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test27() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(431);
        int int0 = leafNode0.order(0);
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test28() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(210);
        leafNode0.insert(210, "=");
        leafNode0.insert(4, "=");
        leafNode0.toString();
        assertEquals(2, leafNode0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test29() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(431);
        // Undeclared exception!
        try {
            leafNode0.toString();
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test30() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(431);
        String string0 = leafNode0.reverseToString();
        assertEquals("", string0);
    }

    @Test(timeout = 4000)
    public void test31() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(291);
        LeafNode<Object> leafNode1 = new LeafNode<Object>(2, leafNode0);
        leafNode1.insert(0, (Object) null);
        leafNode1.insert(2, leafNode0);
        assertEquals(1, leafNode1.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test32() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(174);
        leafNode0.insert(174, "Leafqorde");
        leafNode0.insert(174, "Leafqorde");
        assertEquals(1, leafNode0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test33() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(210);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        Integer integer0 = new Integer(210);
        linkedList0.add(integer0);
        LinkedList<String> linkedList1 = new LinkedList<String>();
        LeafNode<String> leafNode1 = new LeafNode<String>(210, leafNode0, linkedList0, linkedList1);
        // Undeclared exception!
        try {
            leafNode1.insert(4, "=");
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test34() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(431);
        Object object0 = new Object();
        InsertionResult<Object> insertionResult0 = leafNode0.insert(1, object0);
        assertEquals(Integer.MAX_VALUE, insertionResult0.getMinGap());

        InsertionResult<Object> insertionResult1 = leafNode0.insert(431, leafNode0);
        assertEquals(430, insertionResult1.getMinGap());
    }

    @Test(timeout = 4000)
    public void test35() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(201);
        leafNode0.insert(3718, "InsertionResult");
        String string0 = leafNode0.getValue(3718);
        assertEquals("InsertionResult", string0);
    }

    @Test(timeout = 4000)
    public void test36() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(291);
        LeafNode<Object> leafNode1 = new LeafNode<Object>(1, leafNode0);
        LeafNode<Object> leafNode2 = new LeafNode<Object>(1, leafNode0);
        assertFalse(leafNode2.equals((Object) leafNode1));
    }

    @Test(timeout = 4000)
    public void test37() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(431);
        Object object0 = leafNode0.getValue(1);
        assertNull(object0);
    }

    @Test(timeout = 4000)
    public void test38() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(431);
        LeafNode<Object> leafNode1 = new LeafNode<Object>(1, leafNode0);
        Object object0 = new Object();
        leafNode1.insert(1, object0);
        // Undeclared exception!
        try {
            leafNode1.insert(431, leafNode0);
            fail("Expecting exception: IndexOutOfBoundsException");

        } catch (IndexOutOfBoundsException e) {
            //
            // Index: 0, Size: 0
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test39() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(291);
        LeafNode<Object> leafNode1 = leafNode0.getNext();
        assertNull(leafNode1);
    }

    @Test(timeout = 4000)
    public void test40() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(291);
        LeafNode<Object> leafNode1 = leafNode0.getPrev();
        assertNull(leafNode1);
    }
}
