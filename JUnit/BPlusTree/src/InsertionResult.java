/*
 * Represents a result of insertion operation.
 * always contains minGap- the minimum gap between the inserted key and his siblings.
 * may contains pointers to left & right nodes, if the node was split as a result of the insertion.
 * @author Lidan Hifi
 */
class InsertionResult<Value> {
	// new root after split
	private Integer splitRootKey;
	// pointers to the old node (left) and the new node (right)
	private Node<Value> left, right;
	// holds the minimum gap between the inserted key and his siblings
	private int minGap;
	
	/*
	 * creates new insertion result, after split
	 */
	public InsertionResult(Integer key, Node<Value> left, Node<Value> right) {
		splitRootKey = key;
		this.left = left;
		this.right = right;
	}
	
	/*
	 * creates new insertion result, with the minGap from the regular insertion (to a non-full node)
	 */
	public InsertionResult(Integer key, Node<Value> left, Node<Value> right, InsertionResult<Value> resultFromNonFullNode) {
		this(key, left, right);
		
		this.minGap = resultFromNonFullNode.getMinGap();
	}
	
	/*
	 * creates new insertion result, as a result from non-full node insertion (holds only the min gap)
	 */
	public InsertionResult(int minGap) {
		this(null, null, null);
		this.minGap = minGap;
	}
	
	public Node<Value> getLeftNode() { return left; }
	public Node<Value> getRightNode() { return right; }
	public Integer getSplitRootKey() { return splitRootKey; }
	public int getMinGap() { return minGap; }
}
