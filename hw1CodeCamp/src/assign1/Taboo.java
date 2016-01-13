/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/
package assign1;

import java.util.*;

public class Taboo<T> {
	
	private HashMap<T, Set<T>> taboo_map;
	
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		taboo_map = new HashMap<T, Set<T>>();
		
		// iterate through all adjacent pairs of elements in the rules list
		for (int ii = 0; ii < rules.size()-1; ii++) {
			T curr_elem = rules.get(ii);
			T next_elem = rules.get(ii+1);
			// if neither element is null, the pair defines a rule
			if (curr_elem != null && next_elem != null) {
				// if there is already at least one rule for elements following the first one in the pair, add the new follower to the existing list
				if (taboo_map.containsKey(curr_elem)) {
					taboo_map.get(curr_elem).add(next_elem);
				} 
				// if this is the first rule about elements following curr_elem, create the set and insert it into the map
				else {
					Set<T> curr_elem_set = new HashSet<T>();
					curr_elem_set.add(next_elem);
					taboo_map.put(curr_elem, curr_elem_set);
				}
			}
		}
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		// taboo_map is a hashmap from elements to the sets of elements which cannot follow it
		// if elem is in taboo_map, lookup the noFollow set from taboo_map
		if (taboo_map.containsKey(elem)) {
			return taboo_map.get(elem);
		} 
		// if elem is not in taboo_map, then there are no rules about elements following elem, so return the empty set
		else {
			Set<T> empty = Collections.emptySet();
			return empty;
		}
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		// The index of the element of the list currently being considered for following restrictions
		int index = 0;
		
		// keep looping while the current element has a successor in the list
		while (index < list.size() - 1) {
			T first_elem = list.get(index);
			T second_elem = list.get(index + 1);

			Set<T> first_elem_set = noFollow(first_elem);
			
			// If second_elem is not allowed to follow first_elem, remove second_elem from the list
			// There is no need to adjust index in this case, since the next pair of elements to be compared will already be in the correct indices following the removal of second_elem
			if (first_elem_set.contains(second_elem)) {
				list.remove(index+1);
			}
			// If second elem is allowed to follow first_elem, increment index to compare the next pair of elements in the remaining list
			else {
				index++;
			}
		}
	}
}
