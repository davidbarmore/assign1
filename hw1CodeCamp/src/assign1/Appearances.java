package assign1;

import java.util.*;

public class Appearances {

	/**
	 * Returns the number of elements that appear the same number of times in
	 * both collections. Static method. (see handout).
	 * 
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {

		Set<T> unique_a = new HashSet<T>();
		Set<T> unique_b = new HashSet<T>();

		// Create maps from elements in each collection to the count
		// of each element in that collection
		// Also create a set of the unique elements in each collection
		HashMap<T, Integer> amap = createCountHashmap(a, unique_a);
		HashMap<T, Integer> bmap = createCountHashmap(b, unique_b);

		// Counter for the number of elements with the same (non-zero) count in
		// both collections
		int same_count = 0;

		// Change unique_a to be the set of all unique elements in both a and b,
		// i.e. the intersection of the unique elements of the two collections
		unique_a.retainAll(unique_b);

		// Iterate through the set of unique elements in both sets
		for (T elem : unique_a) {
			// If the counts are the same, increment the count of the number of
			// elements with the same count in both sets
			if (amap.get(elem) == bmap.get(elem)) {
				same_count++;
			}
		}

		return same_count;
	}

	// Create a hashmap from the hash codes of the elements of a generic
	// collection col to the count of that element within col
	// @param col: Collection<T>, type T must implement hashCode()
	// @param unique_elems: a set of unique elements of col, initially empty
	// when passed in
	// @return hm: HashMap from elements in col to counts of elements in col
	private static <T> HashMap<T, Integer> createCountHashmap(
			Collection<T> col, Set<T> unique_elems) {
		HashMap<T, Integer> hm = new HashMap<T, Integer>();
		for (T elem : col) {
			// Update the set of unique elements, based on current elem
			unique_elems.add(elem);
			// Update the map of elements to counts of elements, based on
			// current elem
			if (hm.containsKey(elem)) {
				hm.put(elem, hm.get(elem) + 1);
			} else {
				hm.put(elem, 1);
			}
		}
		return hm;
	}

}
