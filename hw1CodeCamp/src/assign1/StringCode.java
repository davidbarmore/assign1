package assign1;

import java.util.HashSet;
import java.util.Set;

// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adjacent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int original_string_length = str.length();
		// if the input string has length 0 or 1, the max run is equal to the length of the string
		if (original_string_length < 2) return original_string_length;
		
		// if the function has not returned yet, str must have at least two characters
		int ii, current_run_length = 1, max_run_length = 1;
		char curr_char, next_char;
		
		// iterate through all adjacent pairs of characters
		for (ii = 0; ii < original_string_length-1; ii++) {
			curr_char = str.charAt(ii);
			next_char = str.charAt(ii+1);
			// if the two characters are the same, increment the counter for the current run
			if (curr_char == next_char) {
				current_run_length++;
			} 
			// if the characters are different, a run has just ended
			else {
				// if it was longer than any previous runs, update the max_run_length
				if (current_run_length > max_run_length) {
					max_run_length = current_run_length;
				}
				// reset the current_run_length to 1, for the new run
				current_run_length = 1;
			}
		}
		// perform one final check, in case the last run in the string happens to be the longest run
		// the final run is not checked in the loop above, since there is no different character at the end to signify the end of the run
		if (current_run_length > max_run_length) {
			max_run_length = current_run_length;
		}
		
		return max_run_length; 
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		int original_string_length = str.length();
		String return_string = "";
		char ch, next_ch;
		int num_reps;
		
		// Iterate through all the characters in the string, except the last one
		for (int ii = 0; ii < original_string_length - 1; ii++) {
			ch = str.charAt(ii);
			
			// If the current character is a digit, append that many copies of the next character at the end of the return string
			if (Character.isDigit(ch)) {
				next_ch = str.charAt(ii+1);
				num_reps = ch - 48; //subtract 48 to convert from the ascii value of the character to its numerical value
				for (int jj = 0; jj < num_reps; jj++) {
					return_string += next_ch;
				}
			} 
			// Otherwise, just append the current non-digit character
			else {
				return_string += ch;
			}
		}
		
		// If the string is non-empty, check the last character
		if (original_string_length > 0) {
			ch = str.charAt(original_string_length - 1);
			// Ignore it if it is a digit, otherwise append the final non-digit character to the return string
			if (!Character.isDigit(ch)) return_string += ch;
		}
		
		return return_string; 
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		int length_a = a.length(), length_b = b.length();
		
		
		// if len is less than the length of either string, then there cannot be an intersection of length len
//		if (length_a < len || length_b < len) return false;
		
		// if stringIntersect hasn't returned yet, then len is no longer than either of the input strings
		
		// create a hashset to store all the substrings of length len in a
		HashSet<String> hs = new HashSet<>();
		// store all the substrings in a of length len
		for (int ii = 0; ii <= length_a-len; ii++) {
			hs.add(a.substring(ii, ii+len));
		}
		// check each substring in b of length len, to see if it is in the hashset of substrings in a of length len
		for (int jj = 0; jj <= length_b-len; jj++) {
			if (hs.contains(b.substring(jj, jj+len))) return true;
		}
		
		// if stringIntersect has not returned yet, there must not be any intersection of length len, so return false
		return false; 
	}
}


