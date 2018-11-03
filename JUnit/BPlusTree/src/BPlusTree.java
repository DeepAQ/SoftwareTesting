/**
 * B+ Tree
 * @author Lidan Hifi
 */
public class BPlusTree<Value> {
	// tree param
	private int t;
	// pointer to the root node.  can be leaf or internal node.
	private Node<Value> root;
	// pointer to the first leaf in the tree, for kind-of InOrder scan.
	private LeafNode<Value> first;
	// the minimum gap between two elements in the tree.
	private int minGap;
	// pointer to a bloom filter object, for O(1) unsuccessful search.
	private IntegerBloomFilter filter = null;
	
	/*
	 * Create new B+Tree
	 * initialize a new root as an empty leaf
	 * @param treeParam t that represents how many child nodes can an internal node have
	 */
	public BPlusTree(int treeParam) {
		t = treeParam;
		minGap = Integer.MAX_VALUE;
		root = new LeafNode<Value>(treeParam);
		first = (LeafNode<Value>)root;
	}
	
	/*
	 * Create new B+Tree
	 * @param treeParam t that represents how many child nodes can an internal node have
	 * @param expectedNumberOfElements expected number of elements that will be stored in the tree. used for initialize the bloom filter, for O(1) unsucessful search.
	 */
	public BPlusTree(int treeParam, int expectedNumberOfElements) {
		this(treeParam);
		// initialize the bloom filter, with a false-positive probability of 0.000001
		filter = new IntegerBloomFilter(0.000001, expectedNumberOfElements);
	}
	
	/*
	 * find the leaf that might store the given key
	 * @param key the key that the search algorithm looking for
	 * @return the leaf that might store the given key
	 */
	private LeafNode<Value> findLeaf(int key) {
		Node<Value> current = root;
		
		while (!(current instanceof LeafNode)) {
			current = ((InternalNode<Value>)current).getChildNode(key);
		}
		
		return (LeafNode<Value>)current;
	}
	
	/*
	 * get the value for a given key, that is stored in the tree
	 * @param key the value's key that was stored in the tree
	 * @return Value if the search succeed, null if the key does not exist in the tree.
	 */
	public Value search(int key) {
		boolean continueToSearch = true;
		
		if (filter != null) // check if bloom filter was initialized
			continueToSearch = filter.contains(key); // find the given key in the filter
		
		if (continueToSearch) // if the bloom filter return true (it might happen when the key really exists, or either false positive)
			return findLeaf(key).getValue(key);
		else {
			System.out.println("Filter stopped the search.");
			System.out.println("Current False Positive Probability: " + filter.getCurrentFalsePositiveProbability());
		}
		
		return null;
	}
	
	/*
	 * Insert key,value to the tree.
	 * @param key key for insertion
	 * @param value value for insertion
	 */
	public void insert(int key, Value value) {
		// insert the data recursively, starting in the root
		InsertionResult<Value> result = root.insert(key, value);
		
		// the tree was split, create a new root that points to the split nodes
		if (result != null && result.getSplitRootKey() != null) 
			root = new InternalNode<Value>(t, result);
		
		// update the min gap if the return min gap is smaller than the current one
		if (result != null && result.getMinGap() < minGap)
			minGap = result.getMinGap();
		
		// if the bloom filter was initialized, add the given key to the filter for future search
		if (filter != null)
			filter.add(key);
	}
	
	/*
	 * get string representation of the keys in descending order- from the last key to the first
	 * @return string representation of the tree's keys in descending order
	 */
	public String reverseInOrder() {
		Node<Value> current = root;
		
		// find the right-most leaf
		while (!(current instanceof LeafNode)) {
			current = ((InternalNode<Value>)current).getMaxChildNode();
		}
		
		LeafNode<Value> leaf = (LeafNode<Value>)current;
		StringBuilder sb = new StringBuilder();
		
		// append to the result string the reversed elements in each leaf
		while (leaf != null) {
			sb.append(leaf.reverseToString());
			leaf = leaf.getPrev();
		}
		
		return sb.toString();
	}
	
	/*
	 * get the tree size- how many keys are stored
	 */
	public int getSize() {
		return root.getNodeSize();
	}
	
	/*
	 * get the minimum gap between any two keys in the tree
	 * @return minimum gap value
	 */
	public int getMinGap() {
		return minGap;
	}
	
	/*
	 * get the index of the given key in the tree
	 * @return index of the given key if the key exists, -1 if the key does not exists
	 */
	public int order(int key) {
		int orderIndex = root.order(key);
		if (orderIndex != -1) // zero based
			return orderIndex + 1;
		
		return -1;
	}
	
	/*
	 * get string representation of the keys in ascending order- from the first key to the last
	 * @return string representation of the tree's keys in ascending order
	 */
	public String inOrder() {
		StringBuilder sb = new StringBuilder();
		LeafNode<Value> current = first;
		
		// append the string representation of each leaf to the result string
		while (current != null) {
			sb.append(current);
			current = current.getNext();
		}
		
		return sb.toString();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (root.getNodeSize() != 0)
				return root.toString();
		
		return "";
	}
}
