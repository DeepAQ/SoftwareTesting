import java.util.ArrayList;
import java.util.List;

/*
 * Represents a node in the B+Tree
 * @author	Lidan Hifi
 */
abstract class Node<Value> {
	protected int t; // tree param
	protected List<Integer> keys;
	
	/*
	 * creates new node, and initialize the keys vector to (t-1) initial capacity
	 * @param totalKeys tree param
	 */
	Node(int totalKeys) {
		t = totalKeys;
		keys = new ArrayList<Integer>(t - 1);
	}
	
	/*
	 * Insert a key & value to the node.
	 * @param key key for insertion
	 * @param value object for insertion (can be integer or string for example, or any class that inherit from Object)
	 * @return insertion result - an object that contains the minimum gap between the inserted key and his siblings keys,
	 * and if the node was split in two parts- contains the new root and pointers to the right node (new one) and left node (old one) 
	 */
	public abstract InsertionResult<Value> insert(int key, Value value);
	
	/*
	 * get the index of the given key in the tree rooted at this node
	 * @param key the given key for searching
	 * @return the index of the given key in the tree rooted at this node (or in the keys vector if it is leaf)
	 */
	public abstract int order(int key);
	
	/*
	 * get the node size- how many keys are stored in
	 * @return the keys vector size
	 */
	public int getNodeSize() {
		return keys.size();
	}
	
	/*
	 * get the index of the key that equals to the given key, or the last key that less than the given key
	 * used in variant of binary search to find the index
	 * @param key the given key for searching
	 * @result index of the key that less than or equal to the given key
	 */
	protected int findLessThanOrEqualToKey(int key) {
		// check the right most key 
		// in this case, when the given key is bigger than any other key,
		// the algorithm complexity will be O(1)
		if (keys.size() > 0 && keys.get(keys.size() - 1).compareTo(key) < 0)
			return keys.size();
		// check the left most key 
		// in this case, when the given key is smaller than any other key,
		// the algorithm complexity will be O(1)
		else if (keys.size() > 0 && keys.get(0).compareTo(key) >= 0)
			return 0;
		else {
			// find the index by a kind-of binary search
			int from = 0;
			int to = keys.size() - 1;
			
			while (from <= to) {
				int mid = (from + to) / 2;
				
				if (mid < keys.size() - 1 && keys.get(mid).compareTo(key) < 0 && keys.get(mid + 1).compareTo(key) > 0)
					return mid + 1;
				else if (keys.get(mid).compareTo(key) > 0)
					to = mid - 1;
				else if (keys.get(mid).compareTo(key) < 0)
					from = mid + 1;
				else
					return mid;
			}
		}
		
		return -1;
	}
}
