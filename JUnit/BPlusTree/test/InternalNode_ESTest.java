package net.mooctest;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

// import static org.evosuite.runtime.EvoAssertions.verifyException;

public class InternalNode_ESTest {

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        Integer integer0 = new Integer((-728));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        leafNode0.t = 1;
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        leafNode0.insert(2286, integer0);
        internalNode0.insert(1, leafNode0);
        internalNode0.insert((-728), (Object) null);
        assertEquals(2, internalNode0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        Integer integer0 = new Integer(3009);
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        leafNode0.t = 1;
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        Object object0 = new Object();
        internalNode0.insert(1847, insertionResult0);
        internalNode0.insert(1, object0);
        int int0 = internalNode0.order(3009);
        assertEquals(2, leafNode0.getNodeSize());
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        Integer integer0 = Integer.valueOf(3009);
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        int int0 = internalNode0.order(701);
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        Integer integer0 = new Integer((-728));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        leafNode0.insert(2, integer0);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        assertEquals(2, internalNode0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        Integer integer0 = new Integer((-728));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        InsertionResult<Object> insertionResult1 = internalNode0.insert(3009, integer0);
        internalNode0.insert(1227, insertionResult1);
        int int0 = internalNode0.order(3009);
        assertEquals(2, internalNode0.getNodeSize());
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        Integer integer0 = new Integer(3009);
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        leafNode0.t = 1;
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        internalNode0.insert(1, insertionResult0);
        internalNode0.t = 1;
        internalNode0.insert(3009, leafNode0);
        Object object0 = new Object();
        internalNode0.insert(1, object0);
        assertEquals(1, internalNode0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        Integer integer0 = new Integer((-728));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        internalNode0.insert(1, leafNode0);
        int int0 = internalNode0.getNodeSize();
        assertEquals(1, int0);
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        Integer integer0 = new Integer((-728));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        leafNode0.t = 1;
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        Object object0 = new Object();
        leafNode0.insert(3004, object0);
        internalNode0.t = 2;
        internalNode0.insert(1, leafNode0);
        int int0 = internalNode0.getNodeSize();
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        Integer integer0 = new Integer((-728));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        internalNode0.insert((-728), (Object) null);
        internalNode0.getMaxChildNode();
        assertEquals(1, internalNode0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        Integer integer0 = new Integer((-728));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        internalNode0.insert((-728), (Object) null);
        internalNode0.getChildNode(3008);
        assertEquals(1, internalNode0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        InternalNode<Integer> internalNode0 = new InternalNode<Integer>(41);
        internalNode0.keys = null;
        // Undeclared exception!
        try {
            internalNode0.order(1932);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.InternalNode", e);
        }
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        Integer integer0 = new Integer((-728));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        List<Integer> list0 = internalNode0.keys;
        LinkedList<Node<Integer>> linkedList0 = new LinkedList<Node<Integer>>();
        InternalNode<Integer> internalNode1 = new InternalNode<Integer>(3009, list0, linkedList0);
        // Undeclared exception!
        try {
            internalNode1.order((-728));
            fail("Expecting exception: IndexOutOfBoundsException");

        } catch (IndexOutOfBoundsException e) {
            //
            // Index: 0, Size: 0
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        InternalNode<Integer> internalNode0 = new InternalNode<Integer>(424);
        // Undeclared exception!
        try {
            internalNode0.order(1);
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        InternalNode<Integer> internalNode0 = new InternalNode<Integer>(3009);
        Integer integer0 = new Integer((-709));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode1 = new InternalNode<Object>(3009, insertionResult0);
        List<Integer> list0 = internalNode1.keys;
        LinkedList<Node<Node<Integer>>> linkedList0 = new LinkedList<Node<Node<Integer>>>();
        InternalNode<Node<Integer>> internalNode2 = new InternalNode<Node<Integer>>(3009, list0, linkedList0);
        // Undeclared exception!
        try {
            internalNode2.insert(2, internalNode0);
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
        Integer integer0 = new Integer(3009);
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        leafNode0.t = 1;
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        internalNode0.t = (-3209);
        // Undeclared exception!
        try {
            internalNode0.insert(3009, (Object) null);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Illegal Capacity: -3210
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        Integer integer0 = new Integer((-728));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        leafNode0.t = 1;
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        internalNode0.t = 2;
        internalNode0.insert(1, leafNode0);
        // Undeclared exception!
        try {
            internalNode0.insert((-728), (Object) null);
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        InternalNode<Node<Integer>> internalNode0 = new InternalNode<Node<Integer>>(5);
        // Undeclared exception!
        try {
            internalNode0.getMaxChildNode();
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        LeafNode<Integer> leafNode0 = new LeafNode<Integer>(3018);
        InsertionResult<Integer> insertionResult0 = new InsertionResult<Integer>((Integer) null, leafNode0, leafNode0);
        InternalNode<Integer> internalNode0 = new InternalNode<Integer>(3764, insertionResult0);
        // Undeclared exception!
        try {
            internalNode0.getChildNode(3018);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        InternalNode<Object> internalNode0 = new InternalNode<Object>(1);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        internalNode0.keys = (List<Integer>) linkedList0;
        Integer integer0 = new Integer(1);
        linkedList0.add(integer0);
        // Undeclared exception!
        try {
            internalNode0.getChildNode(0);
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
        InternalNode<Node<String>> internalNode0 = new InternalNode<Node<String>>(2);
        // Undeclared exception!
        try {
            internalNode0.getChildNode(2);
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test20() throws Throwable {
        LinkedList<Node<String>> linkedList0 = new LinkedList<Node<String>>();
        InternalNode<String> internalNode0 = null;
        try {
            internalNode0 = new InternalNode<String>(4132, (List<Integer>) null, linkedList0);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test21() throws Throwable {
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        LinkedList<Node<LeafNode<Object>>> linkedList1 = new LinkedList<Node<LeafNode<Object>>>();
        InternalNode<LeafNode<Object>> internalNode0 = null;
        try {
            internalNode0 = new InternalNode<LeafNode<Object>>((-3518), linkedList0, linkedList1);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Illegal Capacity: -3519
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test22() throws Throwable {
        InsertionResult<InternalNode<Node<Integer>>> insertionResult0 = new InsertionResult<InternalNode<Node<Integer>>>(777);
        InternalNode<InternalNode<Node<Integer>>> internalNode0 = null;
        try {
            internalNode0 = new InternalNode<InternalNode<Node<Integer>>>(494, insertionResult0);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.InternalNode", e);
        }
    }

    @Test(timeout = 4000)
    public void test23() throws Throwable {
        InsertionResult<String> insertionResult0 = new InsertionResult<String>(2);
        InternalNode<String> internalNode0 = null;
        try {
            internalNode0 = new InternalNode<String>((-3314), insertionResult0);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Illegal Capacity: -3315
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test24() throws Throwable {
        InternalNode<LeafNode<String>> internalNode0 = null;
        try {
            internalNode0 = new InternalNode<LeafNode<String>>(0);
            fail("Expecting exception: IllegalArgumentException");

        } catch (IllegalArgumentException e) {
            //
            // Illegal Capacity: -1
            //
            // verifyException("java.util.ArrayList", e);
        }
    }

    @Test(timeout = 4000)
    public void test25() throws Throwable {
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        LinkedList<Integer> linkedList0 = new LinkedList<Integer>();
        LinkedList<Node<Object>> linkedList1 = new LinkedList<Node<Object>>();
        linkedList1.add((Node<Object>) leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(2, linkedList0, linkedList1);
        assertEquals(0, internalNode0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test26() throws Throwable {
        Integer integer0 = new Integer((-728));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        int int0 = internalNode0.getNodeSize();
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test27() throws Throwable {
        Integer integer0 = new Integer((-728));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        Node<Object> node0 = internalNode0.getChildNode(3008);
        assertEquals(0, node0.getNodeSize());
    }

    @Test(timeout = 4000)
    public void test29() throws Throwable {
        InternalNode<String> internalNode0 = new InternalNode<String>(2);
        // Undeclared exception!
        try {
            internalNode0.toString();
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    @Test(timeout = 4000)
    public void test30() throws Throwable {
        Integer integer0 = new Integer(3009);
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        leafNode0.t = 1;
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        internalNode0.t = 2;
        InsertionResult<Object> insertionResult1 = internalNode0.insert(3009, (Object) null);
        assertEquals(0, internalNode0.getNodeSize());
        assertEquals(3009, (int) insertionResult1.getSplitRootKey());
    }

    @Test(timeout = 4000)
    public void test31() throws Throwable {
        InternalNode<Integer> internalNode0 = new InternalNode<Integer>(3009);
        Integer integer0 = new Integer((-728));
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode1 = new InternalNode<Object>(3009, insertionResult0);
        internalNode1.insert(1, leafNode0);
        // Undeclared exception!
        try {
            internalNode1.insert(1, internalNode0);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.InternalNode", e);
        }
    }

    @Test(timeout = 4000)
    public void test32() throws Throwable {
        Integer integer0 = new Integer(3009);
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        leafNode0.t = 1;
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        internalNode0.insert(1847, insertionResult0);
        int int0 = internalNode0.order(3009);
        assertEquals(1, internalNode0.getNodeSize());
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test33() throws Throwable {
        Integer integer0 = new Integer(3009);
        LeafNode<Object> leafNode0 = new LeafNode<Object>(3009);
        leafNode0.t = 1;
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(3009, insertionResult0);
        internalNode0.insert(1847, insertionResult0);
        internalNode0.t = 1;
        internalNode0.insert(3009, leafNode0);
        int int0 = internalNode0.order(3009);
        assertEquals(1, leafNode0.getNodeSize());
        assertEquals((-1), int0);
    }

    @Test(timeout = 4000)
    public void test34() throws Throwable {
        Integer integer0 = Integer.valueOf(838);
        LeafNode<Object> leafNode0 = new LeafNode<Object>(838);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        InternalNode<Object> internalNode0 = new InternalNode<Object>(838, insertionResult0);
        Node<Object> node0 = internalNode0.getMaxChildNode();
        assertEquals(0, node0.getNodeSize());
    }
}
