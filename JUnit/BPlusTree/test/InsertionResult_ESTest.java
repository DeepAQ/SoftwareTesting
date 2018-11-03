package net.mooctest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class InsertionResult_ESTest {

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        Integer integer0 = new Integer(0);
        InsertionResult<String> insertionResult0 = new InsertionResult<String>(integer0, (Node<String>) null, (Node<String>) null);
        Integer integer1 = insertionResult0.getSplitRootKey();
        assertEquals(0, (int) integer1);
    }

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        Integer integer0 = new Integer(1905);
        LeafNode<Object> leafNode0 = new LeafNode<Object>(663);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, leafNode0, leafNode0);
        Integer integer1 = insertionResult0.getSplitRootKey();
        assertEquals(1905, (int) integer1);
    }

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        Integer integer0 = new Integer((-5227));
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(integer0, (Node<Object>) null, (Node<Object>) null);
        Integer integer1 = insertionResult0.getSplitRootKey();
        assertEquals((-5227), (int) integer1);
    }

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        Integer integer0 = new Integer(2303);
        LeafNode<Object> leafNode0 = new LeafNode<Object>(1382);
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(2);
        InsertionResult<Object> insertionResult1 = new InsertionResult<Object>(integer0, leafNode0, leafNode0, insertionResult0);
        insertionResult1.getRightNode();
        assertEquals(2, insertionResult0.getMinGap());
        assertEquals(2, insertionResult1.getMinGap());
    }

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        Integer integer0 = new Integer(2);
        LeafNode<String> leafNode0 = new LeafNode<String>(1);
        InsertionResult<String> insertionResult0 = new InsertionResult<String>(integer0, leafNode0, leafNode0);
        InternalNode<String> internalNode0 = new InternalNode<String>(2, insertionResult0);
        InsertionResult<String> insertionResult1 = internalNode0.insert(0, (String) null);
        Node<String> node0 = insertionResult1.getRightNode();
        assertEquals(2, node0.getNodeSize());
        assertEquals(Integer.MAX_VALUE, insertionResult1.getMinGap());
    }

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>(0);
        int int0 = insertionResult0.getMinGap();
        assertEquals(0, int0);
    }

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        InsertionResult<String> insertionResult0 = new InsertionResult<String>(1192);
        int int0 = insertionResult0.getMinGap();
        assertEquals(1192, int0);
    }

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>((-5227));
        insertionResult0.getLeftNode();
        assertEquals((-5227), insertionResult0.getMinGap());
    }

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        Integer integer0 = new Integer(1);
        LeafNode<String> leafNode0 = new LeafNode<String>(1);
        InternalNode<String> internalNode0 = new InternalNode<String>(1);
        InsertionResult<String> insertionResult0 = new InsertionResult<String>(integer0, leafNode0, internalNode0);
        InternalNode<String> internalNode1 = new InternalNode<String>(1, insertionResult0);
        InsertionResult<String> insertionResult1 = internalNode1.insert((-1), "/^Wk");
        insertionResult1.getLeftNode();
        assertEquals(Integer.MAX_VALUE, insertionResult1.getMinGap());
    }

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        Integer integer0 = new Integer(4473);
        InsertionResult<String> insertionResult0 = null;
        try {
            insertionResult0 = new InsertionResult<String>(integer0, (Node<String>) null, (Node<String>) null, (InsertionResult<String>) null);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
            //
            // no message in exception (getMessage() returned null)
            //
            // verifyException("net.mooctest.InsertionResult", e);
        }
    }

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>((-5227));
        insertionResult0.getRightNode();
        assertEquals((-5227), insertionResult0.getMinGap());
    }

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>((-5227));
        int int0 = insertionResult0.getMinGap();
        assertEquals((-5227), int0);
    }

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        InsertionResult<Object> insertionResult0 = new InsertionResult<Object>((-5227));
        insertionResult0.getSplitRootKey();
        assertEquals((-5227), insertionResult0.getMinGap());
    }

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        Integer integer0 = new Integer(1);
        LeafNode<String> leafNode0 = new LeafNode<String>(1);
        InternalNode<String> internalNode0 = new InternalNode<String>(1);
        InsertionResult<String> insertionResult0 = new InsertionResult<String>(integer0, leafNode0, internalNode0);
        Node<String> node0 = insertionResult0.getLeftNode();
        assertEquals(0, node0.getNodeSize());
    }
}
