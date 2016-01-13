// StringCodeTest
// Some test code is provided for the early HW1 problems,
// and much is left for you to add.

package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class StringCodeTest {
	//
	// blowup
	//
	@Test
	public void testBlowup1() {
		// basic cases
		assertEquals("abc", StringCode.blowup("abc"));
		assertEquals("xxaaaabb", StringCode.blowup("xx3abb"));
		assertEquals("xxxZZZZ", StringCode.blowup("2x3Z"));
	}
	
	@Test
	public void testBlowup2() {
		// things with digits
		
		// digit at end
		assertEquals("axxx", StringCode.blowup("a2x3"));
		
		// digits next to each other
		assertEquals("a33111", StringCode.blowup("a231"));
		
		// try a 0
		assertEquals("aabb", StringCode.blowup("aa0bb"));
	}
	
	@Test
	public void testBlowup3() {
		// weird chars, empty string
		assertEquals("AB&&,- ab", StringCode.blowup("AB&&,- ab"));
		assertEquals("", StringCode.blowup(""));
		
		// string with only digits
		assertEquals("", StringCode.blowup("2"));
		assertEquals("33", StringCode.blowup("23"));
		assertEquals("233444555566666", StringCode.blowup("0123456"));
	}

	
	
	//
	// maxRun
	//
	@Test
	public void testRun1() {
		assertEquals(2, StringCode.maxRun("hoopla"));
		assertEquals(3, StringCode.maxRun("hoopllla"));
	}
	
	@Test
	public void testRun2() {
		assertEquals(3, StringCode.maxRun("abbcccddbbbxx"));
		assertEquals(0, StringCode.maxRun(""));
		assertEquals(3, StringCode.maxRun("hhhooppoo"));
		assertEquals(1, StringCode.maxRun("a")); //only one character
		assertEquals(4, StringCode.maxRun("aaaa")); //only one run
		assertEquals(3, StringCode.maxRun("abbb")); //longest run at end of string
	}
	
	@Test
	public void testRun3() {
		// "evolve" technique -- make a series of test cases
		// where each is change from the one above.
		assertEquals(1, StringCode.maxRun("123"));
		assertEquals(2, StringCode.maxRun("1223"));
		assertEquals(2, StringCode.maxRun("112233"));
		assertEquals(3, StringCode.maxRun("1112233"));
	}

	
	// stringIntersect
	
	@Test
	public void testIntersect1() {
		// basic cases
		assertFalse(StringCode.stringIntersect("aaa", "bbb", 1));
		assertTrue(StringCode.stringIntersect("baaab", "caaac", 3));
		assertTrue(StringCode.stringIntersect("abcba", "dcdedcd", 1));
	}
	
	@Test
	public void testIntersect2() {
		// intersection exists, but is too short
		assertFalse(StringCode.stringIntersect("abc", "cde", 2));
		assertFalse(StringCode.stringIntersect("abcba", "bcde", 3));
		
		// intersection is longer than necessary (still true)
		assertTrue(StringCode.stringIntersect("abbbbba", "abbbba", 3));
		
		// intersection includes entire string
		assertTrue(StringCode.stringIntersect("aaa", "caaac", 3));
		assertTrue(StringCode.stringIntersect("baaab", "baaab", 5));
	}
	
	@Test
	public void testIntersect3() {
		// len is shorter than one of the strings
		assertFalse(StringCode.stringIntersect("abc", "cdecde", 4));
		
		// one string is empty
		assertFalse(StringCode.stringIntersect("", "cdecde", 1));
		
		// weird characters
		assertTrue(StringCode.stringIntersect("1b. 3cz,)", "b. 3bazcc0[", 4));
		assertFalse(StringCode.stringIntersect("1b. 3cz,)", "bc", 2));
		assertFalse(StringCode.stringIntersect("1b. 3cz,)", "b.3c", 3));
	}
	
}
