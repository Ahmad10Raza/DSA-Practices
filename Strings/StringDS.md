When learning about the string data structure in Java, there are several key points and questions you should understand to effectively solve Data Structures and Algorithms (DSA) problems. Here are some essential questions and concepts to consider:

### Key Questions to Understand:

1. **Basic String Operations:**

   - How do you create a string in Java?
   - How do you concatenate strings?
   - How do you compare two strings for equality?
2. **String Methods:**

   - What are the common methods provided by the `String` class (e.g., `length()`, `charAt()`, `substring()`, `indexOf()`, `toUpperCase()`, `toLowerCase()`, `trim()`)?
   - How do you split a string into an array of substrings?
   - How do you replace characters or substrings within a string?
3. **String Immutability:**

   - What does it mean that strings are immutable in Java?
   - How does immutability affect string operations, and what are the performance implications?
4. **StringBuilder and StringBuffer:**

   - What are `StringBuilder` and `StringBuffer`, and how do they differ from `String`?
   - When should you use `StringBuilder` or `StringBuffer` instead of `String`?
   - How do you use `StringBuilder` for efficient string manipulation?
5. **Character Encoding:**

   - What is Unicode, and how is it relevant to Java strings?
   - How do you handle different character encodings in Java (e.g., UTF-8, UTF-16)?
6. **String Conversion:**

   - How do you convert other data types to strings and vice versa?
   - How do you convert a string to an integer, double, or other primitive types?
7. **String Search Algorithms:**

   - How do you implement and use basic string search algorithms like Knuth-Morris-Pratt (KMP), Boyer-Moore, and Rabin-Karp?
   - What are the complexities and use cases of these algorithms?
8. **Regular Expressions:**

   - What are regular expressions, and how do you use them in Java (`Pattern` and `Matcher` classes)?
   - How do you write and test regular expressions for string matching, searching, and replacing?
9. **String Tokenization:**

   - What is string tokenization, and how do you tokenize a string using `StringTokenizer` or the `split()` method?
10. **String Pooling:**

    - What is the string pool in Java?
    - How does the `intern()` method work, and when should you use it?

### Additional Concepts:

- **Memory Management:**

  - Understanding how strings are stored in memory.
  - The implications of string concatenation in loops and how to optimize it using `StringBuilder`.
- **String Formatting:**

  - How to format strings using `String.format()` and the `Formatter` class.
- **Substrings and Subsequence Problems:**

  - How to solve common substring problems like finding the longest common substring, longest palindromic substring, and subsequence problems like the longest common subsequence.
- **Anagram and Permutation Problems:**

  - How to determine if two strings are anagrams.
  - How to generate all permutations of a string.

By thoroughly understanding these key points and concepts, you'll be well-prepared to tackle a wide range of string-related DSA problems in Java.

# 1. Basic String Operation

Let's go through the basic string operations in Java in detail:

### Creating a String

1. **Literal Initialization:**

   ```java
   String str = "Hello, World!";
   ```

   - Strings initialized using literals are stored in the string pool.
2. **Using the `new` Keyword:**

   ```java
   String str = new String("Hello, World!");
   ```

   - This creates a new `String` object in the heap.

###### Q. Difference b/w string literals and new keyword

In Java, strings can be created in two primary ways: using string literals and using the `new` keyword. These two methods have different implications in terms of memory management and performance. Here's a detailed explanation of the differences:

### Creating Strings with Literals

```java
String str1 = "Hello";
String str2 = "Hello";
```

#### Key Points:

1. **String Pool:**

   - When you create a string using a literal, the string is interned. This means it is stored in a common pool called the string pool.
   - If a string with the same content already exists in the pool, the reference to the existing string is returned instead of creating a new one.
2. **Memory Efficiency:**

   - Using string literals is more memory efficient because identical string literals share the same memory location.
   - This helps save memory when multiple strings with the same content are used.
3. **Performance:**

   - Since string literals are interned, comparisons using the `==` operator can be faster because they compare references instead of content.
   - Example:
     ```java
     String str1 = "Hello";
     String str2 = "Hello";
     boolean isSameReference = (str1 == str2); // true
     ```

### Creating Strings with the `new` Keyword

```java
String str1 = new String("Hello");
String str2 = new String("Hello");
```

#### Key Points:

1. **Heap Allocation:**

   - When you create a string using the `new` keyword, a new `String` object is created in the heap memory even if an identical string already exists in the string pool.
2. **Distinct Objects:**

   - Each call to `new String("Hello")` creates a new `String` object. Thus, `str1` and `str2` will reference different objects even if they have the same content.
   - Example:
     ```java
     String str1 = new String("Hello");
     String str2 = new String("Hello");
     boolean isSameReference = (str1 == str2); // false
     ```
3. **Memory Usage:**

   - Using the `new` keyword can lead to higher memory usage because it creates new objects even when strings with the same content exist.
4. **Performance:**

   - Creating strings with `new` can be slower due to the additional overhead of creating new objects and allocating memory on the heap.

Comparison Example

Here's an example to illustrate the differences:

```java
public class StringCreation {
    public static void main(String[] args) {
        // Using string literals
        String literalStr1 = "Hello";
        String literalStr2 = "Hello";
    
        // Using new keyword
        String newStr1 = new String("Hello");
        String newStr2 = new String("Hello");
    
        // Comparing string literals
        System.out.println("Comparing literals with ==: " + (literalStr1 == literalStr2)); // true
        System.out.println("Comparing literals with equals: " + literalStr1.equals(literalStr2)); // true
    
        // Comparing strings created with new keyword
        System.out.println("Comparing new strings with ==: " + (newStr1 == newStr2)); // false
        System.out.println("Comparing new strings with equals: " + newStr1.equals(newStr2)); // true
    
        // Comparing literal and new string
        System.out.println("Comparing literal and new with ==: " + (literalStr1 == newStr1)); // false
        System.out.println("Comparing literal and new with equals: " + literalStr1.equals(newStr1)); // true
    }
}
```

Summary

- **String Literals:**

  - Stored in the string pool.
  - Shared memory for identical strings.
  - More memory-efficient and potentially faster comparisons with `==`.
- **`new` Keyword:**

  - Creates a new `String` object in the heap.
  - Each instantiation is a distinct object.
  - Higher memory usage and slower due to object creation overhead.

Understanding these differences helps in making efficient decisions regarding string usage, especially in performance-critical applications.

### Concatenating Strings

1. **Using the `+` Operator:**

   ```java
   String str1 = "Hello";
   String str2 = "World";
   String result = str1 + ", " + str2 + "!";
   // result: "Hello, World!"
   ```
2. **Using `concat()` Method:**

   ```java
   String str1 = "Hello";
   String str2 = "World";
   String result = str1.concat(", ").concat(str2).concat("!");
   // result: "Hello, World!"
   ```

### Comparing Strings

1. **Using `equals()` Method:**

   ```java
   String str1 = "Hello";
   String str2 = "Hello";
   boolean isEqual = str1.equals(str2);
   // isEqual: true
   ```
2. **Using `==` Operator:**

   ```java
   String str1 = "Hello";
   String str2 = "Hello";
   boolean isSameReference = (str1 == str2);
   // isSameReference: true (because both refer to the same object in the string pool)
   ```
3. **Using `compareTo()` Method:**

   ```java
   String str1 = "Apple";
   String str2 = "Banana";
   int comparisonResult = str1.compareTo(str2);
   // comparisonResult: negative value (because "Apple" is lexicographically less than "Banana")
   ```

### Accessing Characters

1. **Using `charAt()`:**
   ```java
   String str = "Hello";
   char ch = str.charAt(1);
   // ch: 'e'
   ```

### Substrings

1. **Using `substring()`:**
   ```java
   String str = "Hello, World!";
   String subStr1 = str.substring(7);
   // subStr1: "World!"

   String subStr2 = str.substring(7, 12);
   // subStr2: "World"
   ```

### Length of a String

1. **Using `length()`:**
   ```java
   String str = "Hello";
   int length = str.length();
   // length: 5
   ```

### Finding Characters or Substrings

1. **Using `indexOf()`:**

   ```java
   String str = "Hello, World!";
   int index1 = str.indexOf('o');
   // index1: 4

   int index2 = str.indexOf("World");
   // index2: 7
   ```
2. **Using `lastIndexOf()`:**

   ```java
   String str = "Hello, World!";
   int lastIndex = str.lastIndexOf('o');
   // lastIndex: 8
   ```

### String Replacement

1. **Using `replace()`:**
   ```java
   String str = "Hello, World!";
   String newStr = str.replace('o', '0');
   // newStr: "Hell0, W0rld!"

   String newStr2 = str.replace("World", "Java");
   // newStr2: "Hello, Java!"
   ```

### Changing Case

1. **Using `toUpperCase()` and `toLowerCase()`:**
   ```java
   String str = "Hello, World!";
   String upperStr = str.toUpperCase();
   // upperStr: "HELLO, WORLD!"

   String lowerStr = str.toLowerCase();
   // lowerStr: "hello, world!"
   ```

### Trimming Whitespace

1. **Using `trim()`:**
   ```java
   String str = "   Hello, World!   ";
   String trimmedStr = str.trim();
   // trimmedStr: "Hello, World!"
   ```

### Splitting Strings

1. **Using `split()`:**
   ```java
   String str = "apple,banana,cherry";
   String[] fruits = str.split(",");
   // fruits: ["apple", "banana", "cherry"]
   ```

### Example Code

Here's an example demonstrating some of these basic string operations:

```java
public class StringOperations {
    public static void main(String[] args) {
        // Creating a string
        String str1 = "Hello";
        String str2 = "World";
    
        // Concatenation
        String greeting = str1 + ", " + str2 + "!";
        System.out.println(greeting); // Output: Hello, World!
    
        // Length
        int length = greeting.length();
        System.out.println("Length: " + length); // Output: Length: 13
    
        // Character at index
        char ch = greeting.charAt(7);
        System.out.println("Character at index 7: " + ch); // Output: Character at index 7: W
    
        // Substring
        String subStr = greeting.substring(7, 12);
        System.out.println("Substring: " + subStr); // Output: Substring: World
    
        // Index of
        int index = greeting.indexOf('o');
        System.out.println("Index of 'o': " + index); // Output: Index of 'o': 4
    
        // Replace
        String replaced = greeting.replace("World", "Java");
        System.out.println("Replaced String: " + replaced); // Output: Replaced String: Hello, Java!
    
        // Case conversion
        String upper = greeting.toUpperCase();
        System.out.println("Uppercase: " + upper); // Output: Uppercase: HELLO, WORLD!
    
        String lower = greeting.toLowerCase();
        System.out.println("Lowercase: " + lower); // Output: Lowercase: hello, world!
    
        // Trim
        String str3 = "   Hello, Java!   ";
        String trimmed = str3.trim();
        System.out.println("Trimmed: '" + trimmed + "'"); // Output: Trimmed: 'Hello, Java!'
    
        // Split
        String fruits = "apple,banana,cherry";
        String[] fruitArray = fruits.split(",");
        for (String fruit : fruitArray) {
            System.out.println(fruit);
        }
        // Output:
        // apple
        // banana
        // cherry
    }
}
```

These are the fundamental operations you need to know when working with strings in Java. Understanding these will help you manipulate and work with string data effectively.

# 2. String Methods:

Here's a comprehensive explanation of the commonly used methods in the `String` class in Java. The `String` class in Java provides a rich set of methods for manipulating and inspecting strings. Here's an overview of these methods:

### Basic Methods

1. **`length()`**

   - Returns the length of the string.

   ```java
   String str = "Hello";
   int len = str.length(); // 5
   ```
2. **`charAt(int index)`**

   - Returns the character at the specified index.

   ```java
   char ch = str.charAt(1); // 'e'
   ```

### Substring Methods

3. **`substring(int beginIndex)`**

   - Returns a substring starting from the specified index to the end.

   ```java
   String substr = str.substring(2); // "llo"
   ```
4. **`substring(int beginIndex, int endIndex)`**

   - Returns a substring starting from `beginIndex` to `endIndex` - 1.

   ```java
   String substr = str.substring(1, 4); // "ell"
   ```

### Search Methods

5. **`indexOf(int ch)`**

   - Returns the index of the first occurrence of the specified character.

   ```java
   int index = str.indexOf('l'); // 2
   ```
6. **`indexOf(String str)`**

   - Returns the index of the first occurrence of the specified substring.

   ```java
   int index = str.indexOf("lo"); // 3
   ```
7. **`lastIndexOf(int ch)`**

   - Returns the index of the last occurrence of the specified character.

   ```java
   int lastIndex = str.lastIndexOf('l'); // 3
   ```
8. **`lastIndexOf(String str)`**

   - Returns the index of the last occurrence of the specified substring.

   ```java
   int lastIndex = str.lastIndexOf("l"); // 3
   ```

### Comparison Methods

9. **`equals(Object anObject)`**

   - Compares this string to the specified object.

   ```java
   boolean isEqual = str.equals("Hello"); // true
   ```
10. **`equalsIgnoreCase(String anotherString)`**

    - Compares this string to another string, ignoring case considerations.

    ```java
    boolean isEqualIgnoreCase = str.equalsIgnoreCase("hello"); // true
    ```
11. **`compareTo(String anotherString)`**

    - Compares two strings lexicographically.

    ```java
    int result = str.compareTo("World"); // Negative value because "Hello" is less than "World"
    ```
12. **`compareToIgnoreCase(String str)`**

    - Compares two strings lexicographically, ignoring case differences.

    ```java
    int result = str.compareToIgnoreCase("world"); // Negative value because "Hello" is less than "world" lexicographically
    ```

### Case Conversion Methods

13. **`toLowerCase()`**

    - Converts all characters in this string to lowercase.

    ```java
    String lower = str.toLowerCase(); // "hello"
    ```
14. **`toUpperCase()`**

    - Converts all characters in this string to uppercase.

    ```java
    String upper = str.toUpperCase(); // "HELLO"
    ```

### Whitespace Removal Methods

15. **`trim()`**

    - Removes leading and trailing whitespace from this string.

    ```java
    String trimmed = "  Hello  ".trim(); // "Hello"
    ```

### Replace Methods

16. **`replace(char oldChar, char newChar)`**

    - Replaces all occurrences of the specified character with a new character.

    ```java
    String replaced = str.replace('l', 'p'); // "Heppo"
    ```
17. **`replace(CharSequence target, CharSequence replacement)`**

    - Replaces each substring that matches the target sequence with the replacement sequence.

    ```java
    String replaced = str.replace("ll", "yy"); // "Heyyo"
    ```

### Regular Expression Methods

18. **`matches(String regex)`**

    - Tells whether or not this string matches the given regular expression.

    ```java
    boolean isMatch = str.matches("[A-Za-z]+"); // true
    ```
19. **`replaceAll(String regex, String replacement)`**

    - Replaces each substring that matches the given regular expression with the given replacement.

    ```java
    String replaced = "abc123".replaceAll("\\d", "*"); // "abc***"
    ```
20. **`replaceFirst(String regex, String replacement)`**

    - Replaces the first substring that matches the given regular expression with the given replacement.

    ```java
    String replaced = "abc123".replaceFirst("\\d", "*"); // "abc*23"
    ```

### Split and Join Methods

21. **`split(String regex)`**

    - Splits this string around matches of the given regular expression.

    ```java
    String[] parts = "apple,banana,cherry".split(","); // ["apple", "banana", "cherry"]
    ```
22. **`split(String regex, int limit)`**

    - Splits this string around matches of the given regular expression, with a limit on the number of splits.

    ```java
    String[] parts = "apple,banana,cherry".split(",", 2); // ["apple", "banana,cherry"]
    ```
23. **`join(CharSequence delimiter, CharSequence... elements)`**

    - Returns a new string composed of elements joined together with a specified delimiter.

    ```java
    String joined = String.join(", ", "apple", "banana", "cherry"); // "apple, banana, cherry"
    ```

### Conversion Methods

24. **`toCharArray()`**

    - Converts this string to a new character array.

    ```java
    char[] chars = str.toCharArray(); // ['H', 'e', 'l', 'l', 'o']
    ```
25. **`getBytes()`**

    - Encodes this string into a sequence of bytes using the platform's default charset.

    ```java
    byte[] bytes = str.getBytes();
    ```

### Utility Methods

26. **`contains(CharSequence s)`**

    - Returns `true` if this string contains the specified sequence of char values.

    ```java
    boolean contains = str.contains("ll"); // true
    ```
27. **`startsWith(String prefix)`**

    - Tests if this string starts with the specified prefix.

    ```java
    boolean starts = str.startsWith("He"); // true
    ```
28. **`endsWith(String suffix)`**

    - Tests if this string ends with the specified suffix.

    ```java
    boolean ends = str.endsWith("lo"); // true
    ```
29. **`isEmpty()`**

    - Returns `true` if, and only if, `length()` is `0`.

    ```java
    boolean isEmpty = str.isEmpty(); // false
    ```

### Interning Methods

30. **`intern()`**

    - Returns a canonical representation for the string object. It ensures that all identical strings share the same memory reference.

    ```java
    String interned = str.intern();
    ```

### Example Usage of String Methods

Here's a Java program that demonstrates many of these string methods:

```java

public class StringMethodsExample {
    public static void main(String[] args) {
        String str = " Hello, World! ";

        // Basic methods
        System.out.println("Length: " + str.length());
        System.out.println("Character at index 1: " + str.charAt(1));

        // Substring methods
        System.out.println("Substring from index 2: " + str.substring(2));
        System.out.println("Substring from index 2 to 5: " + str.substring(2, 5));

        // Search methods
        System.out.println("Index of 'l': " + str.indexOf('l'));
        System.out.println("Last index of 'l': " + str.lastIndexOf('l'));

        // Comparison methods
        System.out.println("Equals ' Hello, World! ': " + str.equals(" Hello, World! "));
        System.out.println("Equals ignoring case ' hello, world! ': " + str.equalsIgnoreCase(" hello, world! "));
        System.out.println("Compare to ' Hello, Java! ': " + str.compareTo(" Hello, Java! "));

        // Case conversion methods
        System.out.println("To lowercase: " + str.toLowerCase());
        System.out.println("To uppercase: " + str.toUpperCase());

        // Whitespace removal
        System.out.println("Trim: '" + str.trim() + "'");

        // Replace methods
        System.out.println("Replace 'l' with 'p': " + str.replace('l', 'p'));
        System.out.println("Replace 'World' with 'Java': " + str.replace("World", "Java"));

        // Regular expression methods
        System.out.println("Matches '[A-Za-z ,!]+': " + str.matches("[A-Za-z ,!]+"));
        System.out.println("Replace all digits with '*': " + "abc123".replaceAll("\\d", "*"));

        // Split and join methods
        String[] fruits = "apple,banana,cherry".split(",");
        System.out.println("Split: " + String.join(", ", fruits));
        System.out.println("Join: " + String.join(", ", "apple", "banana", "cherry"));
}
}
```



# 3. String Immutability









































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































































String Immutability in Java

In Java, strings are immutable, which means once a `String` object is created, its content cannot be changed. Any modification to a string results in the creation of a new `String` object. This immutability has several important implications for memory management, performance, and thread safety.

#### Key Characteristics of String Immutability

1. **Creation of New Objects:**

   - When you perform operations that modify a string, such as concatenation or replacement, a new `String` object is created instead of altering the existing one.

   ```java
   String str1 = "Hello";
   String str2 = str1.concat(", World!");
   // str1 remains "Hello"
   // str2 is a new String "Hello, World!"
   ```
2. **String Pooling:**

   - The string pool (also known as the intern pool) is a special memory region where the JVM stores string literals. When a string literal is created, the JVM checks the pool first. If the string already exists in the pool, a reference to the existing string is returned. If not, the string is added to the pool.

   ```java
   String str1 = "Hello";
   String str2 = "Hello";
   boolean sameReference = (str1 == str2); // true, both refer to the same object in the pool
   ```
3. **Thread Safety:**

   - Since strings are immutable, they are inherently thread-safe. Multiple threads can access and read the same string instance without requiring synchronization.

   ```java
   // No risk of data inconsistency or race conditions when sharing immutable strings between threads
   ```
4. **Security:**

   - String immutability enhances security by preventing unintended changes to strings that are used in security-sensitive operations, such as passwords, file paths, and network connections.

   ```java
   // Ensures that critical strings like passwords cannot be altered once created
   ```

#### Implications of Immutability

1. **Memory Efficiency:**

   - While immutability can lead to the creation of many string objects, string pooling mitigates this by reusing common strings. However, excessive creation of new strings, especially in loops, can lead to increased memory usage and performance overhead.

   ```java
   String str = "";
   for (int i = 0; i < 1000; i++) {
       str += i; // Inefficient, creates new String object in each iteration
   }
   ```
2. **Performance Optimization with `StringBuilder` and `StringBuffer`:**

   - For scenarios where frequent modifications to a string are necessary, using `StringBuilder` (or `StringBuffer` for thread-safe operations) is recommended. These classes provide mutable sequences of characters, allowing in-place modifications without creating new objects.

   ```java
   StringBuilder sb = new StringBuilder();
   for (int i = 0; i < 1000; i++) {
       sb.append(i); // Efficient, modifies the same StringBuilder object
   }
   String result = sb.toString(); // Converts the final result back to an immutable String
   ```

#### Example of String Immutability

```java
public class StringImmutabilityExample {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = str1;

        // str1 and str2 point to the same object
        System.out.println(str1 == str2); // true

        // Concatenate a new string to str1
        str1 = str1.concat(", World!");

        // str1 now refers to a new object, str2 still refers to the original
        System.out.println(str1); // "Hello, World!"
        System.out.println(str2); // "Hello"
        System.out.println(str1 == str2); // false

        // Efficient string modification using StringBuilder
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(", World!");
        String result = sb.toString();
        System.out.println(result); // "Hello, World!"
    }
}
```

### Summary

- **Immutability** means that once a `String` object is created, its content cannot be changed.
- **String Pooling** allows the reuse of common strings, reducing memory footprint.
- **Thread Safety** and **Security** are enhanced due to the unchangeable nature of strings.
- **Performance Optimization** can be achieved using `StringBuilder` or `StringBuffer` for mutable string operations, reducing the overhead of creating new string objects during modifications.

Understanding and leveraging string immutability is crucial for writing efficient and robust Java applications, especially when dealing with frequent or complex string manipulations.
