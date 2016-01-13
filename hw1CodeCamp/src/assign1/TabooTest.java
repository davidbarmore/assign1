// TabooTest.java
// Taboo class tests -- nothing provided.
package assign1;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class TabooTest {

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
	public void testNoFollow1() {
		List<String> a = stringToList("abbccc");
		Taboo<String> taboo = new Taboo<String>(a);
		
		Set<String> nofollow_a = new HashSet<String>();
		nofollow_a.add("b");
		Set<String> nofollow_b = new HashSet<String>();
		nofollow_b.add("b");
		nofollow_b.add("c");
		Set<String> nofollow_c = new HashSet<String>();
		nofollow_c.add("c");
		
		assertEquals(nofollow_a, taboo.noFollow("a"));
		assertEquals(nofollow_b, taboo.noFollow("b"));
		assertEquals(nofollow_c, taboo.noFollow("c"));
	}
	
	@Test
	public void testNoFollow2() {
		List<String> a = stringToList("ababac");
		a.add(null);
		a.add(null);
		a.addAll(stringToList("adefb"));
		a.add(null);
		
		Taboo<String> taboo = new Taboo<String>(a);
		
		Set<String> nofollow_a = new HashSet<String>();
		nofollow_a.add("b");
		nofollow_a.add("c");
		nofollow_a.add("d");
		Set<String> nofollow_b = new HashSet<String>();
		nofollow_b.add("a");
		Set<String> nofollow_c = Collections.emptySet();
		Set<String> nofollow_d = new HashSet<String>();
		nofollow_d.add("e");
		
		assertEquals(nofollow_a, taboo.noFollow("a"));
		assertEquals(nofollow_b, taboo.noFollow("b"));
		assertEquals(nofollow_c, taboo.noFollow("c"));
		assertEquals(nofollow_d, taboo.noFollow("d"));
		assertEquals(nofollow_c, taboo.noFollow("z"));
	}
	
	@Test
	public void testNoFollow3() {
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5, null, 3, 2, 1, 4, 3, 1, null, 1, 4, 2, 2);
		
		Taboo<Integer> taboo = new Taboo<Integer>(a);
		
		Set<Integer> nofollow_1 = new HashSet<Integer>();
		nofollow_1.addAll(Arrays.asList(2, 4));
		Set<Integer> nofollow_2 = new HashSet<Integer>();
		nofollow_2.addAll(Arrays.asList(3,2,1));
		Set<Integer> nofollow_3 = new HashSet<Integer>();
		nofollow_3.addAll(Arrays.asList(1,5,2));
		Set<Integer> nofollow_4 = new HashSet<Integer>();
		nofollow_4.addAll(Arrays.asList(3,2));
		Set<Integer> nofollow_5 = Collections.emptySet();

		assertEquals(nofollow_1, taboo.noFollow(1));
		assertEquals(nofollow_2, taboo.noFollow(2));
		assertEquals(nofollow_3, taboo.noFollow(3));
		assertEquals(nofollow_4, taboo.noFollow(4));
		assertEquals(nofollow_5, taboo.noFollow(5));
		assertEquals(nofollow_5, taboo.noFollow(20));
		
	}
	
	@Test
	public void testNoFollow4() {
		List<String> a = stringToList("");
		Taboo<String> taboo = new Taboo<String>(a);
		
		Set<String> empty = Collections.emptySet();
		
		assertEquals(empty, taboo.noFollow("x"));

	}
	
	@Test
	public void testReduce1() {
		List<String> a = stringToList("ababac");
		a.add(null);
		a.add(null);
		a.addAll(stringToList("adefb"));
		a.add(null);
		
		Taboo<String> taboo = new Taboo<String>(a);
		
		List<String> b1 = stringToList("");
		taboo.reduce(b1);
		List<String> b1reduce = stringToList("");
		List<String> b2 = stringToList("ghklmnopqr1x$%s3");
		taboo.reduce(b2);
		List<String> b2reduce = stringToList("ghklmnopqr1x$%s3");
		List<String> b3 = stringToList("ababacadefb");
		taboo.reduce(b3);
		List<String> b3reduce = stringToList("aaaaeb");
		List<String> b4 = stringToList("abbbbaaacccddeefb");
		taboo.reduce(b4);
		List<String> b4reduce = stringToList("aaaaeeb");
		
		assertEquals(b1reduce, b1);
		assertEquals(b2reduce, b2);
		assertEquals(b3reduce, b3);
		assertEquals(b4reduce, b4);
		
	}
	
	@Test
	public void testReduce2() {
		List<Integer> a = Arrays.asList(1, 2, 3, 1, 2, 3, 5, null, 3, 2, 1, 4, 3, 1, null, 1, 4, 2, 2);
		
		Taboo<Integer> taboo = new Taboo<Integer>(a);
		

		List<Integer> b1 = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,4,3,2,1));
		taboo.reduce(b1);
		List<Integer> b1reduce = Arrays.asList(1,3,4,5,4,1);
		List<Integer> b2 =  new LinkedList<Integer>(Arrays.asList(1, 2, 3, 1, 2, 3, 5, 3, 2, 1, 4, 3, 1, 1, 4, 2, 2));
		taboo.reduce(b2);
		List<Integer> b2reduce = Arrays.asList(1, 3, 3, 3, 4, 1, 1);
		List<Integer> b3 =  new LinkedList<Integer>(Arrays.asList(2, 2, 2, 2, 2, 2, 2));
		taboo.reduce(b3);
		List<Integer> b3reduce = Arrays.asList(2);
		
		assertEquals(b1reduce, b1);
		assertEquals(b2reduce, b2);
		assertEquals(b3reduce, b3);
	}

}
