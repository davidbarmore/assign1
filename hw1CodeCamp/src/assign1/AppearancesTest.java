package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.*;

public class AppearancesTest {
	// utility -- converts a string to a list with one
	// elem for each char.
	private List<String> stringToList(String s) {
		List<String> list = new ArrayList<String>();
		for (int i=0; i<s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			// note: String.valueOf() converts lots of things to string form
		}
		return list;
	}
	
	@Test
	public void testSameCount1() {
		List<String> a = stringToList("abbccc");
		List<String> b = stringToList("cccbba");
		assertEquals(3, Appearances.sameCount(a, a));
		assertEquals(3, Appearances.sameCount(a, b));
		assertEquals(3, Appearances.sameCount(b, a));
	}
	
	@Test
	public void testSameCount2() {
		// basic List<Integer> cases
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		assertEquals(4, Appearances.sameCount(a, a));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 9, 9, 1)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1)));
		assertEquals(1, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1, 2)));
		assertEquals(2, Appearances.sameCount(a, Arrays.asList(1, 3, 3, 1, 1, 5)));
	}
	
	@Test
	public void testSameCount3() {
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5);
		
		assertEquals(0, Appearances.sameCount(a, Arrays.asList(0, 4, -1, 15)));
		List<Integer> empty = Collections.emptyList();
		assertEquals(0, Appearances.sameCount(a, empty));
		assertEquals(0, Appearances.sameCount(empty, a));
		assertEquals(0, Appearances.sameCount(empty, empty));
	}
	
	@Test
	public void testSameCount4() {
		List<String> a = stringToList("This is a tEst");
		List<String> b = stringToList("tteSss ");
		List<String> c = stringToList("TEsss   ");
		assertEquals(1, Appearances.sameCount(a, b));
		assertEquals(1, Appearances.sameCount(b, a));
		
		assertEquals(4, Appearances.sameCount(a, c));
		assertEquals(4, Appearances.sameCount(c, a));
		
		assertEquals(0, Appearances.sameCount(b, c));
		assertEquals(0, Appearances.sameCount(c, b));
	}
}
