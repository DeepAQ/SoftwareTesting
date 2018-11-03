import java.util.ArrayList;
import java.util.List;
/*
 * Represents an internal node in the B+Tree
 * @author	Lidan Hifi
 */
class InternalNode<Value> extends Node<Value> {
	// children vector- pointers to the node's children nodes
	private List<Node<Value>> children;
	// how many leaves is stored in the subtree rooted in this node
	private int totalWeight = 0;
	
	/*
	 * creates new internal node
	 * @param totalKeys treeParam
	 */
	public InternalNode(int totalKeys) {
		super(totalKeys);
		children = new ArrayList<Node<Value>>(t);
	}
	
	/*
	 * creates new internal node, with the given keys list and the given children pointers list
	 * @param totalKeys tree param
	 * @param keys list of integer keys
	 * @param children list of children nodes
	 */
	public InternalNode(int totalKeys, List<Integer> keys, List<Node<Value>> children) {
		this(totalKeys);
		this.keys.addAll(keys);
		this.children.addAll(children);
		
		for (Node<Value> child : children)
			this.totalWeight += child.getNodeSize();
	}
	
	/*
	 * creates new internal node based on a given split
	 * @param totalKeys
	 * @param split insertion result that returned after splitting a child node
	 */
	public InternalNode(int totalKeys, InsertionResult<Value> split) {
		this(totalKeys);
		
		// add the left, right children nodes from the split to the new node
		children.add(split.getLeftNode());
		children.add(split.getRightNode());
		
		// add the new root to the new node
		keys.add(split.getSplitRootKey());
		
		// calculate the total weight of the new node
		totalWeight = split.getLeftNode().getNodeSize() + split.getRightNode().getNodeSize();
	}
	
	/*
	 * (non-Javadoc)
	 * @see data.Node#getNodeSize()
	 */
	public int getNodeSize() {
		return totalWeight;
	}
	
	/*
	 * (non-Javadoc)
	 * @see data.Node#order(int)
	 */
	public int order(int key) {
		int orderIndex = 0;
		int childOrderIndex = 0;
		
		// right most- check if the key is larger than any other key in this node
		if (keys.get(keys.size() - 1).compareTo(key) < 0) {
			// calculate the total weight of all the children until the last child node
			// continue calculate the order recursively
			orderIndex = this.totalWeight - children.get(children.size() - 1).getNodeSize();
			childOrderIndex = children.get(children.size() - 1).order(key);
			if (childOrderIndex != -1)
				orderIndex += childOrderIndex;
			else
				return -1;
		} else {
			int i = 0;
			// in the middle of the list- calculate the total weight of all the children while the current key is smaller than the current key
			// continue calculate the order recursively
			Integer currentKey = keys.get(i);
			while (i < keys.size() && currentKey.compareTo(key) < 0) {
				childOrderIndex = children.get(i).getNodeSize();
				if (childOrderIndex == -1)
					return -1;
				else
					orderIndex += childOrderIndex;
				
				if (i < keys.size() - 1)
					currentKey = keys.get(++i);
				else
					i++;
			}
			
			orderIndex += children.get(i).order(key);
		}
		
		return orderIndex;
	}
	
	/*
	 * (non-Javadoc)
	 * @see data.Node#insert(int, java.lang.Object)
	 */
	public InsertionResult<Value> insert(int key, Value value) {
		// insert key,value recursively (until reaches a leaf) and calculate the new node's weight after the insertion
		// may be not changed, if the key is already exists (in this case we update the value only, but the weight does not change)
		Node<Value> child = getChildNode(key);
		totalWeight -= child.getNodeSize();
		InsertionResult<Value> split = child.insert(key, value);
		totalWeight += child.getNodeSize();
		
		// if the child node was split as a result of the insertion
		if (split != null && split.getSplitRootKey() != null) {
			int indexForInsertion = findLessThanOrEqualToKey(split.getSplitRootKey());
			
			if (keys.size() < t - 1) {
				// if this node is not full- insert the new root key to this node
				insertNonFull(split, indexForInsertion);
			} else {
				// if this node is full- SPLIT the keys and the children
				InternalNode<Value> nextSibling;
				
				int mid = 0;
				if (t % 2 == 0) {
					mid = keys.size() / 2;
				} else {
					mid = (keys.size() + 1) / 2;
				}
								
				// move keys & children to the next node, and make insertion- based on the original index and the mid
				if (indexForInsertion <= mid) {
					// insert the new root key to the current node
					nextSibling = new InternalNode<Value>(t, this.keys.subList(mid, this.keys.size()), this.children.subList(mid, this.children.size()));
					this.keys = new ArrayList<Integer>(this.keys.subList(0, mid));
					this.children = new ArrayList<Node<Value>>(this.children.subList(0, mid));
					totalWeight -= nextSibling.getNodeSize();
					
					insertNonFull(split);
				} else {
					// insert the new root key to the new sibling
					nextSibling = new InternalNode<Value>(t, this.keys.subList(mid + 1, this.keys.size()), this.children.subList(mid + 1, this.children.size()));
					this.keys = new ArrayList<Integer>(this.keys.subList(0, mid + 1));
					this.children = new ArrayList<Node<Value>>(this.children.subList(0, mid + 1));
					totalWeight -= nextSibling.getNodeSize();
					
					nextSibling.insertNonFull(split);
				}
				
				// remove the new root from the key's list
				Integer newRoot = this.keys.get(this.keys.size() - 1);
				this.keys.remove(this.keys.size() - 1);
				
				// the node was split, so return a new insertion result that holds the split
				return new InsertionResult<Value>(newRoot, this, nextSibling, split);
			}
		}
		
		return new InsertionResult<Value>(split.getMinGap());
	}
	
	/*
	 * insert the new root (as a result of split) to a non-full internal node
	 * @param split split that contains pointers to the right & left nodes (as a result of the split), and the new root
	 */
	private void insertNonFull(InsertionResult<Value> split) {
		insertNonFull(split, findLessThanOrEqualToKey(split.getSplitRootKey()));
	}
	
	/*
	 * insert the new root (as a result of split) to a non-full internal node
	 * @param split split that contains pointers to the right & left nodes (as a result of the split), and the new root
	 * @param index index for insertion
	 */
	private void insertNonFull(InsertionResult<Value> split, int index) {
		if (keys.isEmpty() || index == keys.size()) { // empty or right most
			keys.add(split.getSplitRootKey());
			
			if (children.isEmpty()) { // empty
				addChild(split.getLeftNode());
			} else { // right most
				setChild(children.size() - 1, split.getLeftNode());
			}
			
			addChild(split.getRightNode());
		} else {
			//in the middle of the list
			keys.add(index, split.getSplitRootKey());
			
			setChild(index, split.getLeftNode());
			
			if (index == 0) { // beginning of list
				addChild(index + 1, split.getRightNode());
			} else { // middle of list
				addChild(index + 1, split.getRightNode());
			}
			
		}
	}
	
	/*
	 * add a child node in a specific index (in the middle of a children list), and update the node's weight based on the new node's weight
	 * @param index index in the children list
	 * @param node new node for insertion
	 */
	private void addChild(int index, Node<Value> node) {
		children.add(index, node);
		totalWeight += node.getNodeSize();
	}
	
	/*
	 * add new child node, and update the node's weight based on the new node's weight
	 * @param index index in the children list
	 * @param node new node for insertion 
	 */
	private void addChild(Node<Value> node) {
		children.add(node);
		totalWeight += node.getNodeSize();
	}
	
	/*
	 * replace already-exists-child-node with an other node, and update the node's weight based on the new node's weight
	 * @param index index in the children list
	 * @param node new node for replace 
	 */
	private void setChild(int index, Node<Value> node) {
		totalWeight -= children.get(index).getNodeSize();
		children.set(index, node);
		totalWeight += node.getNodeSize();
	}
	
	/*
	 * get the child node that matches to the given key
	 * @param key key
	 * @return child node that matches to the given key
	 */
	public Node<Value> getChildNode(int key) {
		return children.get(findLessThanOrEqualToKey(key));
	}
	
	/*
	 * get the right most child node
	 * @return pointer to the right most child node
	 */
	public Node<Value> getMaxChildNode() {
		return children.get(children.size() - 1);
	} 
	
	/*
	 * get string representation of the keys stored under this node in ascending order- from the first key to the last.
	 * the root of each leaf is represented by "#".
	 * @return string representation of the node's keys in ascending order
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < this.children.size() - 1; i++) {
			sb.append(this.children.get(i).toString() + "#");
		}
		sb.append(this.children.get(this.children.size() - 1).toString());
		
		return sb.toString();
	}
}
