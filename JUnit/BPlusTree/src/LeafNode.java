import java.util.ArrayList;
import java.util.List;

/*
 * Represents an internal node in the B+Tree
 * @author	Lidan Hifi
 */
class LeafNode<Value> extends Node<Value> {
	// values vector (each index in the keys vector is matching another index in the values vector)
	private List<Value> values;
	// pointers to the next leaf and the previous leaf
	private LeafNode<Value> next;
	private LeafNode<Value> prev;
	
	/*
	 * creates new leaf node
	 * @param totalKeys tree param
	 */
	public LeafNode(int totalKeys) {
		super(totalKeys);
		values = new ArrayList<Value>(t - 1);
	}
	
	/*
	 * creates new leaf node split from a previous leaf node
	 * @param totalKeys tree param
	 * @param prev previous leaf
	 */
	public LeafNode(int totalKeys, LeafNode<Value> prev) {
		this(totalKeys);
		this.prev = prev;
		this.next = prev.next;
		if (this.next != null)
			this.next.prev = this;
		
		prev.next = this;
	}
	
	/*
	 * creates new leaf node split from a previous leaf node, with a given keys and values
	 * @param totalKeys tree param
	 * @param prev previous leaf
	 * @param keys keys list
	 * @param values values list
	 */
	public LeafNode(int totalKeys, LeafNode<Value> prev, List<Integer> keys, List<Value> values) {
		this(totalKeys, prev);
		this.keys.addAll(keys);
		this.values.addAll(values);
	}
	
	/*
	 * (non-Javadoc)
	 * @see data.Node#order(int)
	 */
	public int order(int key) {
		return keys.indexOf(key);
	}
	
	/*
	 * get the value that matches a given key
	 * @param key key for searching
	 * @return value if the key was found, null if not
	 */
	public Value getValue(int key) {
		// find the index of the given key
		int index = order(key);
		
		// if the index was found, return the matched value
		if (index != -1)
			return values.get(index);
		else
			return null;
	}
	
	/*
	 * insert key,value to a non-full leaf node
	 * @param key key
	 * @param value value
	 */
	private InsertionResult<Value> insertNonFull(int key, Value value) {
		return insertNonFull(key, value, findLessThanOrEqualToKey(key));
	}
	
	/*
	 * insert key,value to a non-full leaf node
	 * @param key key
	 * @param value value
	 */
	private InsertionResult<Value> insertNonFull(int key, Value value, int index) {
		if (keys.isEmpty() || (index == keys.size() - 1 && keys.get(index).compareTo(key) < 0)) {
			// keys list is empty or insert as right most
			keys.add(key);
			values.add(value);
		} else {
			// insert in the middle of the list
			keys.add(index, key);
			values.add(index, value);
		}
		
		// return insertion result that contains the minimum gap between the given key and his siblings
		return new InsertionResult<Value>(calculateGap(index));
	}
	
	/*
	 * (non-Javadoc)
	 * @see data.Node#insert(int, java.lang.Object)
	 */
	public InsertionResult<Value> insert(int key, Value value) {
		// find the index for insertion
		int indexForInsertion = findLessThanOrEqualToKey(key);
		InsertionResult<Value> resultFromNonFullInsertion = null;
		
		if (indexForInsertion != -1 && indexForInsertion < keys.size() && keys.get(indexForInsertion).equals(key)) {
			// duplicate value, simply overwrite the old one
			values.set(indexForInsertion, value);
		} else if (keys.size() < t - 1) {
			// if node is not full- insert non full and return insertion result that contains the minimum gap
			resultFromNonFullInsertion = insertNonFull(key, value, indexForInsertion);
		} else {
			// if the leaf is full- SPLIT the keys and the values
			LeafNode<Value> nextSibling;
			int mid = 0;
			if (t % 2 == 0) {
				mid = keys.size() / 2;
			} else {
				mid = (keys.size() + 1) / 2;
			}
			
			// move keys & values to the next node, and make insertion- based on the original index and the mid
			if (indexForInsertion <= mid) {
				// insert the new key to the current leaf
				nextSibling = new LeafNode<Value>(t, this, this.keys.subList(mid, this.keys.size()), this.values.subList(mid, this.values.size()));
				this.keys = new ArrayList<Integer>(this.keys.subList(0, mid));
				this.values = new ArrayList<Value>(this.values.subList(0, mid));
				
				resultFromNonFullInsertion = insertNonFull(key, value);
			} else {
				// insert the new key to the new sibling
				nextSibling = new LeafNode<Value>(t, this, this.keys.subList(mid + 1, this.keys.size()), this.values.subList(mid + 1, this.values.size()));
				this.keys = new ArrayList<Integer>(this.keys.subList(0, mid + 1));
				this.values = new ArrayList<Value>(this.values.subList(0, mid + 1));
				
				resultFromNonFullInsertion = nextSibling.insertNonFull(key, value);
			}
			
			// return new insertion result, contains the minimum gap and the split (right, left and new root)
			return new InsertionResult<Value>(this.keys.get(this.keys.size() - 1), this, nextSibling, resultFromNonFullInsertion);
		}
		
		return resultFromNonFullInsertion;
	}
	
	/*
	 * calculates the gap between the key in the given index, and his siblings
	 * @param index index of the inserted key
	 * @return the minimum gap between the right gap and the left gap
	 */
	protected int calculateGap(int index) {
		// initialize the init gaps to infinity
		int leftGap = Integer.MAX_VALUE, rightGap = Integer.MAX_VALUE;
		
		if (index >= 0) {
			// rightGap
			Integer nextKey = null;
			if (index + 1 < keys.size()) // inside the node
				nextKey = keys.get(index + 1);
			else if (next != null) // calculate with the first element of the next node
				nextKey = next.keys.get(0);
			
			if (nextKey != null)
				rightGap = Math.abs( (Integer)keys.get(index) - (Integer)nextKey );
			
			// leftGap
			Integer prevKey = null;
			if (index - 1 >= 0)
				prevKey = keys.get(index - 1); // inside the node
			else if (prev != null)
				prevKey = prev.keys.get(prev.keys.size() - 1); // calculate with the last element of the previous node
			
			if (prevKey != null)
				leftGap = Math.abs( (Integer)keys.get(index) - (Integer)prevKey );
		}
		
		return Math.min(rightGap, leftGap);
	}
	
	/*
	 * get the next leaf
	 * @return next leaf
	 */
	public LeafNode<Value> getNext() {
		return this.next;
	}
	
	/*
	 * get the previous leaf
	 * @return previous leaf
	 */
	public LeafNode<Value> getPrev() {
		return this.prev;
	}
	
	/*
	 * get string representation of the keys in descending order- from the last key to the first
	 * @return string representation of the leaf's keys in descending order
	 */
	public String reverseToString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = this.keys.size() - 1; i >= 0; i--) {
			sb.append(this.keys.get(i) + ",");
		}

		return sb.toString().substring(0, sb.toString().length());
	}
	
	/*
	 * get string representation of the keys in ascending order- from the first key to the last
	 * @return string representation of the leaf's keys in ascending order
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < this.keys.size() - 1; i++) {
			sb.append(this.keys.get(i) + ",");
		}
		sb.append(this.keys.get(this.keys.size() - 1));

		return sb.toString();
	}
}
