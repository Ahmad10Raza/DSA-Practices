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

    


    // Driver program to test above function
    public static void main(String []args) {
        


        
    }
}
