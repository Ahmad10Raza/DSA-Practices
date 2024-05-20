public class StringDS {
    private char[] chars;
    
    public StringDS(String str) {
        chars = str.toCharArray();
    }
    
    public int length() {
        return chars.length;
    }
    
    public char charAt(int index) {
        if (index < 0 || index >= chars.length) {
            throw new IndexOutOfBoundsException();
        }
        return chars[index];
    }
    
    public StringDS substring(int beginIndex, int endIndex) {
        if (beginIndex < 0 || endIndex > chars.length || beginIndex > endIndex) {
            throw new IndexOutOfBoundsException();
        }
        char[] subChars = new char[endIndex - beginIndex];
        System.arraycopy(chars, beginIndex, subChars, 0, endIndex - beginIndex);
        return new StringDS(new String(subChars));
    }
    
    public boolean equals(StringDS other) {
        if (other == null || chars.length != other.length()) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != other.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    public String toString() {
        return new String(chars);
    }


    // Function to reverse a string

    // A string is given as input, we need to reverse the string
    // and return the reversed string

    // Example:
    // Input: "hello"
    // Output: "olleh"

    // Approach1: Using StringBuilder

    public String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }

    // Approach2: Using StringBuffer

    public String reverseString2(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }

    // Approach3: Using char array
    // Time complexity: O(n)
    // Space complexity: O(n)

    // We will convert the string to char array
    // Then we will swap the characters from start and end  
    // till we reach the middle of the array

    public String reverseString3(String str) {
        char[] chars = str.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return new String(chars);
    }

    // Approach4: Using Recursion
    // Time complexity: O(n)
    // Space complexity: O(n)

    // We will use recursion to reverse the string
    // We will keep the first character as it is and reverse the rest of the string
    // Then we will append the first character at the end of the reversed string

    public String reverseString4(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return reverseString4(str.substring(1)) + str.charAt(0);
    }

    // Approach5: Using Iterative
    // Time complexity: O(n)
    // Space complexity: O(n)

    //  Iterate the string from end to start and append the characters to a new string

    public  String reverseIteratively(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }
    


    // Driver program to test above function
    public static void main(String []args) {
        
        StringDS str = new StringDS("hello");
        System.out.println(str.reverseString("hello"));
        System.out.println(str.reverseString2("hello"));
        System.out.println(str.reverseString3("hello"));
        System.out.println(str.reverseString4("hello"));
        System.out.println(str.reverseIteratively("hello"));
        

        
    }
}
