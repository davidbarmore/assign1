// Test cases for CharGrid -- a few basic tests are provided.
package assign1;

import static org.junit.Assert.*;
import org.junit.Test;

public class CharGridTest {
	
	@Test
	public void testCharArea1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.charArea('a'));
		assertEquals(1, cg.charArea('z'));
	}
	
	
	@Test
	public void testCharArea2() {
		char[][] grid = new char[][] {
				{'c', 'a', ' '},
				{'b', ' ', 'b'},
				{' ', ' ', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(1, cg.charArea('c'));
		assertEquals(9, cg.charArea(' '));
	}
	
	@Test
	public void testCharArea3() {
		char[][] grid = new char[][] {
				{'.', 'a', ','},
				{'b', 'a', 'b'},
				{'+', ',', 'a'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(6, cg.charArea('a'));
		assertEquals(3, cg.charArea('b'));
		assertEquals(0, cg.charArea('c'));
		assertEquals(6, cg.charArea(','));
		assertEquals(1, cg.charArea('+'));
	}
	
	public void testCharArea4() {
		char[][] grid = new char[][] {
				{'.', 'a', ',', 'd', 'b', 'j'},
				{'b', 'a', 'b', ',', 'b', '+'},
				{'+', ',', 'a', 'b', '+', '.'}
			};
		
		CharGrid cg = new CharGrid(grid);
		
		assertEquals(18, cg.charArea('.'));
		assertEquals(1, cg.charArea('j'));
		assertEquals(15, cg.charArea('b'));
		assertEquals(9, cg.charArea(','));
		assertEquals(12, cg.charArea('+'));
		assertEquals(1, cg.charArea('d'));
	}
	
	@Test
	public void testCountPlus1() {
		char[][] grid = new char[][] {
				{'a', 'y', ' '},
				{'x', 'a', 'z'},
			};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(0, cg.countPlus());
	}
	
	@Test
	public void testCountPlus2() {
		char[][] grid = new char[][] {
			{'.', 'a', ','},
			{'a', 'a', 'a'},
			{'+', 'a', 'a'}
		};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testCountPlus3() {
		char[][] grid = new char[][] {
			{'.', 'a', ',', 'd', 'b', 'j'},
			{'b', 'a', 'b', ',', 'b', '+'},
			{'a', 'a', 'a', 'a', '+', '+'},
			{'b', 'a', 'a', ',', 'b', '+'},
			{'b', 'a', ',', ',', ',', '+'},
			{'b', 'a', 'b', ',', 'b', '+'},
			{'+', ',', 'a', 'b', '+', '.'}
		};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testCountPlus4() {
		char[][] grid = new char[][] {
			{'.', 'a', ',', 'd', 'b', 'j'},
			{'b', 'a', 'a', 'b', 'b', 'b'},
			{'a', 'a', 'a', 'a', 'b', '+'},
			{'b', 'a', 'a', ',', '+', '+'},
			{'b', 'a', ',', 'a', ',', '+'},
			{'b', 'a', 'b', ',', 'b', '+'},
			{'+', ',', 'a', 'b', '+', '.'}
		};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testCountPlus5() {
		char[][] grid = new char[][] {
			{'a', 'a', 'a', 'a', 'a', 'j'},
			{'a', 'a', 'a', 'a', 'a', 'b'},
			{'a', 'a', 'a', 'a', 'a', '+'},
			{'a', 'a', 'a', 'a', 'a', '+'},
			{'a', 'a', 'a', 'a', 'a', '+'},
			{'b', 'b', 'b', ',', 'b', '+'},
			{'+', ',', 'a', 'b', '+', '.'}
		};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(1, cg.countPlus());
	}
	
	@Test
	public void testCountPlus6() {
		char[][] grid = new char[][] {
			{'a', 'b', 'a', 'a', 'a', 'j'},
			{'a', 'a', 'a', 'a', 'b', 'b'},
			{'a', 'a', 'a', 'b', 'b', 'b'},
			{'a', 'a', 'a', 'c', 'b', '+'},
			{'a', 'b', 'c', 'c', 'c', '+'},
			{'b', 'b', 'b', 'c', 'b', '+'},
			{'+', 'b', 'a', 'b', '+', '.'}
		};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(4, cg.countPlus());
	}
	
	@Test
	public void testCountPlus7() {
		char[][] grid = new char[][] {
			{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'},
			{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'a'},
			{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'a'},
			{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'a'},
			{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'a'},
			{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'a'},
			{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'a'},
			{'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'a', 'a'},
			{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'}
		};
		
		
		CharGrid cg = new CharGrid(grid);
				
		assertEquals(1, cg.countPlus());
	}
}
