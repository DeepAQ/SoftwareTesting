package net.mooctest;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

// import static org.evosuite.runtime.EvoAssertions.verifyException;

public class Node_ESTest {

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        LeafNode<Integer> leafNode0 = new LeafNode<Integer>(3925);
        Integer integer0 = new Integer(435);
        leafNode0.insert(3925, integer0);
        leafNode0.insert(435, integer0);
        leafNode0.insert(2467, integer0);
        leafNode0.insert(1173, integer0);
        leafNode0.insert(3925, integer0);
        assertEquals(4, leafNode0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(4028);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        leafNode0.keys = (List<Integer>) linkedList0;
        leafNode0.insert(4028, (Object) null);
        leafNode0.insert(2, (Object) null);
        Integer integer0 = new Integer(4028);
        linkedList0.add(integer0);
        int int0 = leafNode0.findLessThanOrEqualToKey(4028);
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(22);
        leafNode0.insert(814, "");
        int int0 = leafNode0.order(814);
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        LeafNode<Integer> leafNode0 = new LeafNode<Integer>(3893);
        Integer integer0 = new Integer(3893);
        leafNode0.insert(3893, integer0);
        leafNode0.insert((-1391), integer0);
        int int0 = leafNode0.order(3893);
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        LeafNode<String> leafNode0 = new LeafNode<String>(58);
        int int0 = leafNode0.order(58);
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        LeafNode<Integer> leafNode0 = new LeafNode<Integer>(3893);
        Integer integer0 = new Integer(541);
        leafNode0.insert((-1391), integer0);
        leafNode0.insert((-1391), integer0);
        assertEquals(1, leafNode0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        LeafNode<Integer> leafNode0 = new LeafNode<Integer>(3932);
        Integer integer0 = new Integer((-4332));
        leafNode0.insert(3932, integer0);
        int int0 = leafNode0.getNodeSize();
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(4028);
        leafNode0.insert(4028, (Object) null);
        int int0 = leafNode0.findLessThanOrEqualToKey(4028);
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        InternalNode<Node<Object>> internalNode0 = new InternalNode<Node<Object>>(54);
        int int0 = internalNode0.findLessThanOrEqualToKey(0);
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        LeafNode<Integer> leafNode0 = new LeafNode<Integer>(3949);
        leafNode0.keys = null;
        // Undeclared exception!
        try {
            leafNode0.order((-1342));
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.LeafNode", e);
        }
    }

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        InternalNode<Integer> internalNode0 = new InternalNode<Integer>(1686);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        internalNode0.keys = (List<Integer>) linkedList0;
        // Undeclared exception!
        try {
            internalNode0.order(132);
            fail("Expecting exception: IndexOutOfBoundsException");

        } catch (IndexOutOfBoundsException e) {
            //
            // Index: -1, Size: 0
            //
            // verifyException("java.util.LinkedList", e);
        }
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        InternalNode<String> internalNode0 = new InternalNode<String>(184);
        // Undeclared exception!
        try {
            internalNode0.order(184);
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(37);
        Object object0 = new Object();
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        leafNode0.keys = (List<Integer>) linkedList0;
        linkedList0.add((Integer) null);
        // Undeclared exception!
        try {
            leafNode0.insert(37, object0);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.Node", e);
        }
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(4028);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        leafNode0.keys = (List<Integer>) linkedList0;
        Integer integer0 = new Integer((-229));
        linkedList0.add(integer0);
        // Undeclared exception!
        try {
            leafNode0.insert(2, (Object) null);
            fail("Expecting exception: IndexOutOfBoundsException");

        } catch (IndexOutOfBoundsException e) {
            //
            // Index: 1, Size: 0
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        LeafNode<Integer> leafNode0 = new LeafNode<Integer>(3893);
        Integer integer0 = new Integer(541);
        leafNode0.t = (-1);
        // Undeclared exception!
        try {
            leafNode0.insert((-1391), integer0);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Illegal Capacity: -2
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        InternalNode<Object> internalNode0 = new InternalNode<Object>(2804);
        Object object0 = new Object();
        // Undeclared exception!
        try {
            internalNode0.insert(1013, object0);
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(4037);
        leafNode0.keys = null;
        // Undeclared exception!
        try {
            leafNode0.getNodeSize();
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.Node", e);
        }
    }

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(4069);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        leafNode0.keys = (List<Integer>) linkedList0;
        linkedList0.add((Integer) null);
        // Undeclared exception!
        try {
            leafNode0.findLessThanOrEqualToKey(4069);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.Node", e);
        }
    }

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        LeafNode<Integer> leafNode0 = new LeafNode<Integer>(3932);
        int int0 = leafNode0.getNodeSize();
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        LeafNode<Integer> leafNode0 = new LeafNode<Integer>(3893);
        Integer integer0 = new Integer(828);
        leafNode0.insert((-3374), integer0);
        leafNode0.insert(3893, integer0);
        InsertionResult<Integer> insertionResult0 = leafNode0.insert((-1391), integer0);
        assertEquals(1983, insertionResult0.getMinGap());

        InsertionResult<Integer> insertionResult1 = leafNode0.insert(1173, integer0);
        assertEquals(2564, insertionResult1.getMinGap());
    }
}
