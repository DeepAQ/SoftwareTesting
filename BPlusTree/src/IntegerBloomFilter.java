import java.util.BitSet;

/*
 * Integer bloom filter- used for test whether an integer element is a member of a set or not.
 * @author Lidan Hifi
 */
public class IntegerBloomFilter {
	// filter set
	private BitSet bitset;
	// filter set size
	private final int bitSetSize;
	// bits per element that is stored in the structure
	private final int bitsPerElement;
	// expected elements to be added
	private final int expectedNumberOfElements;
	// total items actually added
	private int totalElements;
	// hash functions count
	private final int k; 
	// hash params
	private final int hashParam1, hashParam2; 

	/**
	 * Constructs an empty Bloom filter. The total length of the Bloom filter will be
	 * c*n.
	 *
	 * @param bitsPerElement is the number of bits used per element.
	 * @param expectedNumberOfElements is the expected number of elements the filter will contain.
	 * @param totalHashFunctions is the number of hash functions used.
	 */
	public IntegerBloomFilter(int bitsPerElement, int expectedNumberOfElements, int totalHashFunctions) {
		this.expectedNumberOfElements = expectedNumberOfElements;
		this.k = totalHashFunctions;
		this.bitsPerElement = bitsPerElement;
		this.bitSetSize = bitsPerElement * expectedNumberOfElements;
		totalElements = 0;
		this.bitset = new BitSet(bitSetSize);
		this.hashParam1 = (int)(Math.random() * 100);
		this.hashParam2 = (int)(Math.random() * 100);
	}
	
	/*
	 * constructs a new Bloom Filter for a given false positive probability and expected number of elements
	 * it is based on the formula -ln(p)/(ln2)^2 that represents how many bits we need per element,
	 * and the formula -ln(p)/ln2 that represents how many hash functions we need.
	 * @param falsePositiveProbability probability for false positive
	 * @param expectedNumberOfElements is the expected number of elements the filter will contain.
	 */
	public IntegerBloomFilter(double falsePositiveProbability, int expectedNumberOfElements) {
		this((int)Math.ceil(-(Math.log(falsePositiveProbability) / (Math.log(2) * Math.log(2)))), expectedNumberOfElements, (int)Math.ceil(-(Math.log(falsePositiveProbability)) / Math.log(2)));
	}

	/*
	 * get the expected false positive probability, based on the expected number of elements that configured on initialization.
	 * this probability is constant during the filter's life.
	 * @return the expected false positive probability
	 */
	public double getExpectedFalsePositiveProbability() {
		return getFalsePositiveProbability(expectedNumberOfElements);
	}

	/*
	 * get the expected false positive probability, based on the given number of elements
	 * @return the expected false positive probability for the given number of elements
	 */
	public double getFalsePositiveProbability(double elementsNumber) {
		return Math.pow(1 - Math.exp(-k * (double)elementsNumber / (double)bitSetSize), k);
	}

	/*
	 * get the current false positive probability, based on the total number of elements that actually added to the filter
	 * this probability is variable during the filter's life, and increases each time an element is added
	 * @return the current false positive probability
	 */
	public double getCurrentFalsePositiveProbability() {
		return getFalsePositiveProbability(totalElements);
	}

	/*
	 * clear the filter
	 */
	public void clear() {
		bitset.clear();
		totalElements = 0;
	}

	/*
	 * calculates the hash functions (it generates the function based on the hash params that configured randomly in the filter initialization 
	 * @param data the given key for calculation
	 * @param hashes how many hash functions is needed to be calculated
	 * @return integer array that contains the results of the functions. need to operate mod function on each result, based on the filter set size.
	 */
	private int[] createHashes(int data, int hashes) {
		int[] hashValues = new int[hashes];
		
		for (int i = 0; i < hashes; i++) {
			hashValues[i] = ((i + hashParam1) * data + hashParam2) % 701;
		}
		
		return hashValues;
	}

	/*
	 * add an element to the filter
	 * @param element the given element for insertion
	 */
	public void add(int element) {
		int[] hashes = createHashes(element, k);

		for (int hash : hashes)
			bitset.set(Math.abs(hash % bitSetSize), true);
		
		totalElements++;
	}
	
	/*
	 * test whether the given element is in the set or not
	 * @param element the given element for query
	 * @return true if the given element may be in the set (or maybe false positive), false if not (and it is 100% not).
	 */
	public boolean contains(int element) {
		int[] hashes = createHashes(element, k);
		
		for (int hash : hashes) {
			if (!bitset.get(Math.abs(hash % bitSetSize)))
				return false;
		}
		
		return true;
	}
	
	/*
	 * get how many bits in the filter represents an element in the set
	 * @return bits per element
	 */
	public int getBitsPerElement() {
		return bitsPerElement;
	}
	
	/*
	 * get the filter set size
	 * @return the filter set size
	 */
	public int getFilterSize() {
		return bitSetSize;
	}
	
	/*
	 * get the total hash functions of the filter
	 * @return the total hash function of the filter
	 */
	public int getTotalHashFunctions() {
		return k;
	}
}
