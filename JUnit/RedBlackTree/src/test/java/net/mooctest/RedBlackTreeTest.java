package net.mooctest;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class RedBlackTreeTest {

    @Test
    public void test() {
        RedBlackTree tree = new RedBlackTree();
        assertNull(tree.delete(12345));
        assertFalse(tree.contains(12345));

        Random rand = new Random();
        List<Node> nodes = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            nodes.add(tree.insert(i));
            sb.append(i);
            sb.append(System.lineSeparator());
        }
        assertEquals(255, tree.root.value.intValue());
        assertEquals(1000, tree.getSize());
        assertEquals(0, tree.getMinimum());
        assertEquals(999, tree.getMaximum());

        tree.printTreePreOrder();
        tree.printTreePostOrder();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        tree.printTreeInOrder();
        assertEquals(sb.toString(), os.toString());

        Collections.shuffle(nodes);
        for (Node node : nodes) {
            assertEquals(31 + node.value.hashCode(), node.hashCode());
            assertTrue(node.equals(node));
            assertTrue(tree.contains(node.value));
            tree.delete(node.value);
        }
        assertEquals(0, tree.getSize());

        nodes.clear();
        tree = new RedBlackTree();
        for (int i = 1000; i >= 1; i--) {
            nodes.add(tree.insert(i));
        }
        assertEquals(745, tree.root.value.intValue());
        assertEquals(1000, tree.getSize());
        assertEquals(1, tree.getMinimum());
        assertEquals(1000, tree.getMaximum());

        assertTrue(new Node(0, null, null, null).isLeaf());
        assertFalse(new Node(0, null, new Node(0, null, null, null), null).isLeaf());
        assertFalse(new Node(0, null, null, new Node(0, null, null, null)).isLeaf());
        assertFalse(new Node(0, null, null, null).equals(null));
        assertFalse(new Node(0, null, null, null).equals(""));
        assertFalse(new Node(null, null, null, null).equals(new Node(233, null, null, null)));
        assertTrue(new Node(null, null, null, null).equals(new Node(null, null, null, null)));
        assertFalse(new Node(233, null, null, null).equals(new Node(234, null, null, null)));
    }

    @Test
    public void testBTree() {
        AbstractBinaryTree bTree = new MooctestHasNoBTree();
        List<Node> nodes = new ArrayList<>();
        nodes.add(bTree.insert(500));
        nodes.add(bTree.insert(250));
        nodes.add(bTree.insert(750));
        for (int i = 0; i < 500; i++) {
            nodes.add(bTree.insert(i));
            nodes.add(bTree.insert(999 - i));
        }
        bTree.rotateLeft(bTree.root);
        bTree.rotateRight(bTree.root);
        bTree.rotateLeft(bTree.root.left);
        bTree.rotateLeft(bTree.root.right);
        bTree.rotateRight(bTree.root.left);
        bTree.rotateRight(bTree.root.right);
        assertEquals(500, bTree.root.value.intValue());
        assertEquals(1003, bTree.getSize());
        assertEquals(0, bTree.getMinimum());
        assertEquals(999, bTree.getMaximum());
        assertNull(bTree.delete(12345));
        assertNull(bTree.delete(null));
        assertEquals(500, bTree.getSuccessor(500));
        assertNull(bTree.getSuccessor(bTree.search(999)));

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);
        bTree.printTree();
        assertEquals(1003, os.toString().split("\n").length);
        assertEquals(1003, os.toString().split("-----").length);
        assertEquals(502, os.toString().split("\\\\").length);
        assertEquals(502, os.toString().split("/").length);

        os.reset();
        bTree.printSubtree(new Node(null, null, null, null));
        assertEquals("<null>", os.toString().trim());

        Collections.shuffle(nodes);
        for (Node node : nodes) {
            assertTrue(bTree.contains(node.value));
            bTree.delete(node.value);
        }
        assertEquals(0, bTree.getSize());
    }

    private class MooctestHasNoBTree extends AbstractBinaryTree {
        @Override
        protected Node createNode(int value, Node parent, Node left, Node right) {
            return new Node(value, parent, left, right);
        }
    }

}
