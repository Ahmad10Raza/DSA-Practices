/* Find the first non-repeating character from a stream of characters
 using Hashing:
The idea is to maintain a hashmap that uses constant space of at
 max 26 entries. This will keep the track of characters already 
 encountered in the string and do so in constant query time. Secondly, 
 an ArrayList or Vector can be used to keep track of the current unique
  characters from the beginning which should be added to the
   resultant string. Whenever any unique character is encountered 
   again, it’s removed from the vector, but kept in HashMap to mark
    it as encountered. If the list is empty at any point, this means
     there is no non-repeating character present in the string,
      hence ‘#’ can be added. */

      // Java implementation for the above approach
import java.util.*;

class GFG {

	static String FirstNonRepeating(String A)
	{
		// Arraylist to keep track of current unique characters
		// Hashmap to keep track of character encountered at least once
		ArrayList<Character> list = new ArrayList<>(); 
		HashMap<Character, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (char ch : A.toCharArray()) {
			if (!map.containsKey(ch)) { // any new character encountered first time
				list.add(ch);
				map.put(ch, 1);
			}
			else {
				//any repeated character encountered
				int index = list.indexOf(ch);
			
				// for any repeated character encountered more than twice the
				// index will be -1
				if (index != -1) 
					list.remove(index);
			}
			sb.append(list.isEmpty() ? '#' : list.get(0));
		}
		return sb.toString();
	}

	public static void main(String[] args)
	{
		String A = "geeksforgeeksandgeeksquizfor";
		String ans = FirstNonRepeating(A);
		System.out.print(ans);
	}
}


