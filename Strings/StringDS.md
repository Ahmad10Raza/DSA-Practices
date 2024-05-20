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


# 4. **StringBuilder and StringBuffer:**

`StringBuilder` and `StringBuffer` in Java are classes used for creating and manipulating strings in a mutable way, which can be more efficient than using `String` when frequent modifications are required. Here's a detailed explanation of both:

### StringBuilder

`StringBuilder` is a mutable sequence of characters. It is not synchronized, meaning it is not thread-safe but provides better performance in single-threaded scenarios.

#### Key Features of StringBuilder

1. **Mutability:**

   - `StringBuilder` objects can be modified after creation. Methods like `append()`, `insert()`, `delete()`, and `reverse()` change the content of the `StringBuilder` without creating new objects.
2. **Efficiency:**

   - Modifying a `StringBuilder` is generally more efficient than modifying a `String`, as it avoids the overhead of creating new string objects.
3. **Not Thread-Safe:**

   - `StringBuilder` is not synchronized. It should be used in single-threaded contexts where thread safety is not a concern.

#### Common Methods of StringBuilder

- **`append(...)`:** Appends the specified data to the `StringBuilder`.

  ```java
  StringBuilder sb = new StringBuilder("Hello");
  sb.append(", World!");
  System.out.println(sb.toString()); // "Hello, World!"
  ```
- **`insert(int offset, ...)`:** Inserts the specified data at the given position.

  ```java
  sb.insert(5, " Java");
  System.out.println(sb.toString()); // "Hello Java, World!"
  ```
- **`delete(int start, int end)`:** Removes characters from the specified start to end index.

  ```java
  sb.delete(5, 10);
  System.out.println(sb.toString()); // "Hello, World!"
  ```
- **`reverse()`:** Reverses the sequence of characters.

  ```java
  sb.reverse();
  System.out.println(sb.toString()); // "!dlroW ,olleH"
  ```

### StringBuffer

`StringBuffer` is similar to `StringBuilder` but is synchronized, making it thread-safe for use in multi-threaded environments.

#### Key Features of StringBuffer

1. **Mutability:**

   - Like `StringBuilder`, `StringBuffer` objects can be modified after creation using methods such as `append()`, `insert()`, `delete()`, and `reverse()`.
2. **Thread Safety:**

   - `StringBuffer` is synchronized, meaning it is safe to use in multi-threaded contexts where multiple threads might access and modify the same instance.
3. **Performance:**

   - Because `StringBuffer` is synchronized, it is slightly slower than `StringBuilder` due to the overhead of ensuring thread safety.

#### Common Methods of StringBuffer

- **`append(...)`:** Appends the specified data to the `StringBuffer`.

  ```java
  StringBuffer sb = new StringBuffer("Hello");
  sb.append(", World!");
  System.out.println(sb.toString()); // "Hello, World!"
  ```
- **`insert(int offset, ...)`:** Inserts the specified data at the given position.

  ```java
  sb.insert(5, " Java");
  System.out.println(sb.toString()); // "Hello Java, World!"
  ```
- **`delete(int start, int end)`:** Removes characters from the specified start to end index.

  ```java
  sb.delete(5, 10);
  System.out.println(sb.toString()); // "Hello, World!"
  ```
- **`reverse()`:** Reverses the sequence of characters.

  ```java
  sb.reverse();
  System.out.println(sb.toString()); // "!dlroW ,olleH"
  ```

### Comparison of String, StringBuilder, and StringBuffer

1. **Immutability vs. Mutability:**

   - `String` is immutable: any operation that modifies the string creates a new `String` object.
   - `StringBuilder` and `StringBuffer` are mutable: operations modify the same object.
2. **Thread Safety:**

   - `String` and `StringBuilder` are not thread-safe.
   - `StringBuffer` is thread-safe.
3. **Performance:**

   - `StringBuilder` is faster than `StringBuffer` because it does not have the overhead of synchronization.
   - Use `StringBuilder` for single-threaded scenarios and `StringBuffer` for multi-threaded scenarios where synchronization is necessary.

### Example Code Using StringBuilder and StringBuffer

```java
public class StringBuilderAndStringBufferExample {
    public static void main(String[] args) {
        //

```java
        // Using StringBuilder in a single-threaded context
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(", World!");
        System.out.println("StringBuilder: " + sb.toString()); // "Hello, World!"

        sb.insert(5, " Java");
        System.out.println("After insert: " + sb.toString()); // "Hello Java, World!"

        sb.delete(5, 10);
        System.out.println("After delete: " + sb.toString()); // "Hello, World!"

        sb.reverse();
        System.out.println("After reverse: " + sb.toString()); // "!dlroW ,olleH"

        // Using StringBuffer in a multi-threaded context
        StringBuffer sbf = new StringBuffer("Hello");
        sbf.append(", World!");
        System.out.println("StringBuffer: " + sbf.toString()); // "Hello, World!"

        sbf.insert(5, " Java");
        System.out.println("After insert: " + sbf.toString()); // "Hello Java, World!"

        sbf.delete(5, 10);
        System.out.println("After delete: " + sbf.toString()); // "Hello, World!"

        sbf.reverse();
        System.out.println("After reverse: " + sbf.toString()); // "!dlroW ,olleH"

        // Demonstrating performance difference (in a simplified way)
        long startTime, endTime;

        // StringBuilder performance test
        startTime = System.nanoTime();
        StringBuilder sbTest = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            sbTest.append("test");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuilder time: " + (endTime - startTime) + " ns");

        // StringBuffer performance test
        startTime = System.nanoTime();
        StringBuffer sbfTest = new StringBuffer();
        for (int i = 0; i < 100000; i++) {
            sbfTest.append("test");
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer time: " + (endTime - startTime) + " ns");
    }
}
```

### Summary

- **StringBuilder** is used for creating and manipulating mutable strings in a single-threaded environment, offering better performance due to the lack of synchronization.
- **StringBuffer** is used for creating and manipulating mutable strings in a multi-threaded environment, ensuring thread safety through synchronization at the cost of performance.
- Both classes provide methods such as `append()`, `insert()`, `delete()`, and `reverse()` to modify the string content efficiently without creating new objects.
- Use `StringBuilder` when you are sure that the string manipulation is done in a single-threaded context.
- Use `StringBuffer` when you need to handle string manipulation in a multi-threaded context to ensure thread safety.


# 5. Character Encoding

Character encoding is a critical concept in computing and data communication, ensuring that textual data is correctly represented and interpreted. In Java, understanding character encoding is especially important when dealing with strings, file I/O, and network communication.

### What is Character Encoding?

Character encoding is a system that maps characters (such as letters, digits, and symbols) to specific binary values that computers can store and manipulate. Common character encodings include ASCII, ISO-8859-1, UTF-8, and UTF-16.

### Common Character Encodings

1. **ASCII (American Standard Code for Information Interchange):**

   - Uses 7 bits to represent characters.
   - Can encode 128 characters, including control characters, digits, letters, and punctuation marks.
   - Limited to English and lacks support for many international characters.
2. **ISO-8859-1 (Latin-1):**

   - An 8-bit extension of ASCII.
   - Can encode 256 characters, supporting many Western European languages.
3. **UTF-8 (Unicode Transformation Format - 8-bit):**

   - A variable-length encoding that uses 1 to 4 bytes per character.
   - Compatible with ASCII for the first 128 characters.
   - Can represent every character in the Unicode character set, making it suitable for international text.
4. **UTF-16 (Unicode Transformation Format - 16-bit):**

   - Uses 2 bytes (16 bits) for most common characters.
   - Uses 4 bytes for characters outside the Basic Multilingual Plane (BMP).
   - Also capable of representing every character in the Unicode character set.

### Character Encoding in Java

In Java, strings are sequences of characters represented internally as UTF-16. Understanding character encoding is crucial when converting between byte arrays and strings, reading from or writing to files, and handling network data.

#### Key Classes and Methods

1. **String Class:**

   - The `String` class in Java uses UTF-16 encoding internally.
   - Methods like `getBytes()` and constructors that take a byte array allow specifying encodings.
2. **Charset Class:**

   - The `java.nio.charset.Charset` class provides methods for encoding and decoding between byte arrays and strings.
   - Use `Charset.forName(String charsetName)` to get a `Charset` instance.
3. **Encoding and Decoding:**

   - Encoding: Converting a `String` to a byte array using a specific charset.
   - Decoding: Converting a byte array to a `String` using a specific charset.

#### Example Usage

```java
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.UnsupportedEncodingException;

public class EncodingExample {
    public static void main(String[] args) {
        String original = "Hello, 世界"; // "Hello, World" in Chinese

        // Encode to byte array using UTF-8
        byte[] utf8Bytes = original.getBytes(StandardCharsets.UTF_8);
      
        // Decode back to String using UTF-8
        String decodedUtf8 = new String(utf8Bytes, StandardCharsets.UTF_8);
      
        System.out.println("Original: " + original);         // Hello, 世界
        System.out.println("Decoded UTF-8: " + decodedUtf8); // Hello, 世界

        // Encode to byte array using ISO-8859-1 (will cause data loss)
        try {
            byte[] iso88591Bytes = original.getBytes("ISO-8859-1");
          
            // Decode back to String using ISO-8859-1
            String decodedIso88591 = new String(iso88591Bytes, "ISO-8859-1");
          
            System.out.println("Decoded ISO-8859-1: " + decodedIso88591); // Data loss, incorrect characters
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
```

### Handling Character Encoding in File I/O and Networking

#### File I/O

When reading from or writing to files, you can specify the character encoding to ensure proper data interpretation.

```java
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public class FileEncodingExample {
    public static void main(String[] args) {
        String filePath = "example.txt";
        String content = "Hello, 世界";

        // Write to file using UTF-8 encoding
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, StandardCharsets.UTF_8))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read from file using UTF-8 encoding
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath, StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### Networking

When sending and receiving data over a network, specifying the correct character encoding ensures that the data is correctly interpreted on both ends.

```java
import java.io.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class NetworkEncodingExample {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            Socket clientSocket = new Socket("localhost", 8080);

            // Server side
            new Thread(() -> {
                try {
                    Socket socket = serverSocket.accept();
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                    String received = in.readLine();
                    System.out.println("Server received: " + received);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            // Client side
            PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream(), StandardCharsets.UTF_8), true);
            out.println("Hello, 世界");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### Summary

- **Character encoding** maps characters to specific binary values that computers can store and manipulate.
- **Common encodings** include ASCII, ISO-8859-1, UTF-8, and UTF-16.
- **Java strings** use UTF-16 internally, but you can encode and decode using various charsets.
- Use the `String`, `Charset`, and I/O classes to handle encoding correctly in Java.
- Properly managing character encoding ensures that text data is correctly represented and interpreted across different systems and applications.


# 6. String Conversion:

### String Conversion in Java

Converting between strings and other data types is a common task in Java. Here’s how you can convert various data types to strings and vice versa:

### Converting Other Data Types to Strings

1. **Using `String.valueOf()`:**

   - Converts different data types to their string representation.

   ```java
   int num = 10;
   String str = String.valueOf(num); // "10"
   ```
2. **Using `toString()` Method:**

   - Most Java objects have a `toString()` method that provides a string representation.

   ```java
   double d = 3.14;
   String str = Double.toString(d); // "3.14"
   ```
3. **Using `String.format()`:**

   - Formats a string using specified format specifiers.

   ```java
   int num = 10;
   String str = String.format("%d", num); // "10"
   ```
4. **Using `+` Operator:**

   - Concatenates the value with an empty string, implicitly calling `toString()`.

   ```java
   boolean bool = true;
   String str = bool + ""; // "true"
   ```

### Converting Strings to Other Data Types

1. **Using `Integer.parseInt()` and `Integer.valueOf()`:**

   - Converts a string to an integer.

   ```java
   String str = "123";
   int num = Integer.parseInt(str); // 123
   int num = Integer.valueOf(str); // 123
   ```
2. **Using `Double.parseDouble()` and `Double.valueOf()`:**

   - Converts a string to a double.

   ```java
   String str = "3.14";
   double d = Double.parseDouble(str); // 3.14
   double d = Double.valueOf(str); // 3.14
   ```
3. **Using `Boolean.parseBoolean()` and `Boolean.valueOf()`:**

   - Converts a string to a boolean.

   ```java
   String str = "true";
   boolean bool = Boolean.parseBoolean(str); // true
   boolean bool = Boolean.valueOf(str); // true
   ```
4. **Using `Long.parseLong()` and `Long.valueOf()`:**

   - Converts a string to a long.

   ```java
   String str = "123456789";
   long l = Long.parseLong(str); // 123456789L
   long l = Long.valueOf(str); // 123456789L
   ```
5. **Using `Float.parseFloat()` and `Float.valueOf()`:**

   - Converts a string to a float.

   ```java
   String str = "3.14";
   float f = Float.parseFloat(str); // 3.14f
   float f = Float.valueOf(str); // 3.14f
   ```
6. **Using `Byte.parseByte()` and `Byte.valueOf()`:**

   - Converts a string to a byte.

   ```java
   String str = "10";
   byte b = Byte.parseByte(str); // 10
   byte b = Byte.valueOf(str); // 10
   ```
7. **Using `Short.parseShort()` and `Short.valueOf()`:**

   - Converts a string to a short.

   ```java
   String str = "10";
   short s = Short.parseShort(str); // 10
   short s = Short.valueOf(str); // 10
   ```

### Example Code for String Conversion

```java
public class StringConversionExample {
    public static void main(String[] args) {
        // Converting other data types to String
        int num = 10;
        double d = 3.14;
        boolean bool = true;
      
        String strNum = String.valueOf(num);
        String strDouble = Double.toString(d);
        String strBool = Boolean.toString(bool);
      
        System.out.println("String representations:");
        System.out.println("Integer: " + strNum);
        System.out.println("Double: " + strDouble);
        System.out.println("Boolean: " + strBool);

        // Converting String to other data types
        String str = "123";
        int parsedNum = Integer.parseInt(str);
        double parsedDouble = Double.parseDouble("3.14");
        boolean parsedBool = Boolean.parseBoolean("true");

        System.out.println("Parsed values:");
        System.out.println("Integer: " + parsedNum);
        System.out.println("Double: " + parsedDouble);
        System.out.println("Boolean: " + parsedBool);

        // Using try-catch to handle NumberFormatException
        try {
            String invalidStr = "abc";
            int invalidNum = Integer.parseInt(invalidStr); // This will throw NumberFormatException
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format: " + e.getMessage());
        }
    }
}
```

### Handling Exceptions

When converting strings to numeric types, it is crucial to handle `NumberFormatException` for invalid inputs.

```java
try {
    String invalidStr = "abc";
    int invalidNum = Integer.parseInt(invalidStr); // This will throw NumberFormatException
} catch (NumberFormatException e) {
    System.out.println("Invalid number format: " + e.getMessage());
}
```

### Summary

- **Converting to Strings:** Use `String.valueOf()`, `toString()`, `String.format()`, or concatenation with `+`.
- **Converting from Strings:** Use `parseXXX()` or `valueOf()` methods for each primitive type and handle possible exceptions for invalid input formats.


# 7. String Search Algorithms:

### String Search Algorithms in Java

String search algorithms are used to find a substring (pattern) within another string (text). Here we will cover three popular string search algorithms: Knuth-Morris-Pratt (KMP), Boyer-Moore, and Rabin-Karp.

### 1. Knuth-Morris-Pratt (KMP) Algorithm

The KMP algorithm preprocesses the pattern to create a partial match table (also known as the "longest prefix suffix" table), which is used to skip unnecessary comparisons during the search phase.

#### KMP Algorithm Steps

1. **Preprocess the Pattern:**
   - Create the partial match table for the pattern.
2. **Search the Text:**
   - Use the partial match table to skip characters in the text.

#### Complexity

- **Preprocessing Time:** O(m), where m is the length of the pattern.
- **Search Time:** O(n), where n is the length of the text.
- **Overall Time Complexity:** O(n + m).

#### Implementation

```java
public class KMPAlgorithm {
    public static int[] computeLPSArray(String pattern) {
        int length = 0;  // length of the previous longest prefix suffix
        int i = 1;
        int[] lps = new int[pattern.length()];
        lps[0] = 0; // lps[0] is always 0

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void KMPsearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] lps = computeLPSArray(pattern);

        int i = 0; // index for text
        int j = 0; // index for pattern
        while (i < n) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == m) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < n && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        KMPsearch(text, pattern);
    }
}
```

### 2. Boyer-Moore Algorithm

The Boyer-Moore algorithm uses two heuristics to improve search efficiency: the bad character rule and the good suffix rule.

#### Boyer-Moore Algorithm Steps

1. **Preprocess the Pattern:**
   - Create the bad character table and the good suffix table.
2. **Search the Text:**
   - Use the tables to skip sections of the text.

#### Complexity

- **Preprocessing Time:** O(m + k), where m is the length of the pattern and k is the size of the alphabet.
- **Search Time:** O(n), where n is the length of the text in the best case.
- **Overall Time Complexity:** O(n + m).

#### Implementation

```java
public class BoyerMooreAlgorithm {
    public static void preprocessBadChar(String pattern, int[] badChar) {
        int m = pattern.length();
        for (int i = 0; i < 256; i++) {
            badChar[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            badChar[(int) pattern.charAt(i)] = i;
        }
    }

    public static void BoyerMooreSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int[] badChar = new int[256];

        preprocessBadChar(pattern, badChar);

        int s = 0; // s is the shift of the pattern with respect to text
        while (s <= (n - m)) {
            int j = m - 1;

            while (j >= 0 && pattern.charAt(j) == text.charAt(s + j)) {
                j--;
            }

            if (j < 0) {
                System.out.println("Found pattern at index " + s);
                s += (s + m < n) ? m - badChar[text.charAt(s + m)] : 1;
            } else {
                s += Math.max(1, j - badChar[text.charAt(s + j)]);
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABAAABCD";
        String pattern = "ABC";
        BoyerMooreSearch(text, pattern);
    }
}
```

### 3. Rabin-Karp Algorithm

The Rabin-Karp algorithm uses hashing to find patterns in the text. It computes a hash for the pattern and checks the hash of substrings of the text.

#### Rabin-Karp Algorithm Steps

1. **Compute the Hash:**
   - Compute the hash of the pattern and the initial hash of the text substring.
2. **Slide the Pattern:**
   - Slide the pattern over the text and recompute the hash for the next substring.
   - Compare the hashes, and if they match, check the actual substrings.

#### Complexity

- **Average and Best Case Time Complexity:** O(n + m).
- **Worst Case Time Complexity:** O(n * m) due to hash collisions.

#### Implementation

```java
public class RabinKarpAlgorithm {
    public static final int d = 256; // Number of characters in the input alphabet
    public static final int q = 101; // A prime number

    public static void RabinKarpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int p = 0; // hash value for pattern
        int t = 0; // hash value for text
        int h = 1;

        // The value of h would be "pow(d, m-1) % q"
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Calculate the hash value of pattern and first window of text
        for (int i = 0; i < m; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (int i = 0; i <= n - m; i++) {
            // Check the hash values of current window of text and pattern
            if (p == t) {
                // Check for characters one by one
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    System.out.println("Found pattern at index " + i);
                }
            }

            // Calculate hash value for next window of text
            if (i < n - m) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "GEEKS FOR GEEKS";
        String pattern = "GEEK";
        RabinKarpSearch(text, pattern);
    }
}
```

### Summary

- **KMP Algorithm:**

  - **Complexity:** O(n + m).
  - **Use Cases:** Efficient for patterns with repeating sub-patterns.
- **Boyer-Moore Algorithm:**

  - **Complexity:** O(n) in the best case.
  - **Use Cases:** Efficient for longer patterns and a larger alphabet.
- **Rabin-Karp Algorithm:**

  - **Complexity:** O(n + m) on average, O(n * m) in the worst case.
  - **Use Cases:** Suitable for multiple pattern searches and simple hash implementations.

These algorithms are essential tools for string searching tasks, each with its strengths and best use cases. Choose the algorithm based on the specific requirements of your problem, such as the pattern length, text length, and the need for handling large alphabets.


# 8. Regular Expressions:

### Regular Expressions in Java

Regular expressions (regex) are sequences of characters that form a search pattern, often used for string matching, searching, and replacing operations. In Java, regular expressions are supported by the `Pattern` and `Matcher` classes in the `java.util.regex` package.

### What are Regular Expressions?

Regular expressions are patterns that describe sets of strings. They are used to:

- Match strings
- Search within strings
- Replace parts of strings
- Split strings

### Using Regular Expressions in Java

To use regular expressions in Java, you need to work with the `Pattern` and `Matcher` classes.

#### `Pattern` Class

- Compiles a regular expression into a pattern.
- Provides no public constructors; you use the `compile()` method.

#### `Matcher` Class

- An engine that performs match operations on a character sequence by interpreting a `Pattern`.
- You get a `Matcher` object by calling the `matcher()` method on a `Pattern` object.

### Basic Operations

#### 1. Compiling a Regular Expression

```java
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexExample {
    public static void main(String[] args) {
        // Compile a regular expression
        Pattern pattern = Pattern.compile("a*b");
      
        // Create a matcher for a given input string
        Matcher matcher = pattern.matcher("aaaaab");
      
        // Check if the pattern matches the input string
        boolean matchFound = matcher.matches();
        System.out.println("Match found: " + matchFound);
    }
}
```

#### 2. Searching with Regular Expressions

```java
public class RegexSearchExample {
    public static void main(String[] args) {
        String text = "This is a sample text.";
        Pattern pattern = Pattern.compile("\\bsample\\b");
        Matcher matcher = pattern.matcher(text);
      
        if (matcher.find()) {
            System.out.println("Found at: " + matcher.start() + " to " + matcher.end());
        } else {
            System.out.println("No match found.");
        }
    }
}
```

#### 3. Replacing with Regular Expressions

```java
public class RegexReplaceExample {
    public static void main(String[] args) {
        String text = "This is a sample text.";
        Pattern pattern = Pattern.compile("\\bsample\\b");
        Matcher matcher = pattern.matcher(text);
      
        String replacedText = matcher.replaceAll("example");
        System.out.println("Replaced text: " + replacedText);
    }
}
```

### Writing Regular Expressions

Regular expressions consist of literals and metacharacters. Here are some basic components:

- **Literals:** Characters like `a`, `b`, `1`, `2`.
- **Metacharacters:** Special characters like `.` (any character), `*` (zero or more), `+` (one or more), `?` (zero or one), `\d` (digit), `\w` (word character), etc.

#### Examples of Regular Expressions

- `a*b`: Matches any number of `a` followed by `b`.
- `\d{3}`: Matches exactly three digits.
- `[A-Z]`: Matches any uppercase letter.
- `\bword\b`: Matches the word "word" as a whole word.

### Testing Regular Expressions

To test regular expressions, you can use online tools like [regex101](https://regex101.com/) or write test cases in Java.

#### Example: Matching Email Addresses

```java
public class EmailValidator {
    public static void main(String[] args) {
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailPattern);
      
        String email1 = "example@test.com";
        String email2 = "invalid-email";
      
        Matcher matcher1 = pattern.matcher(email1);
        Matcher matcher2 = pattern.matcher(email2);
      
        System.out.println(email1 + ": " + matcher1.matches());
        System.out.println(email2 + ": " + matcher2.matches());
    }
}
```

### Summary

- **Regular Expressions:** Patterns for matching, searching, and replacing strings.
- **Pattern Class:** Compiles the regex pattern.
- **Matcher Class:** Applies the pattern to strings for matching, searching, and replacing.
- **Common Operations:** Matching (`matches()`), searching (`find()`), and replacing (`replaceAll()`).

By mastering these concepts, you can effectively use regular expressions for a variety of text-processing tasks in Java.


# 9. String Tokenization:

### String Tokenization in Java

String tokenization is the process of splitting a string into a sequence of tokens, typically based on a set of delimiters. In Java, tokenization can be done using several methods, including the `String.split()` method and the `StringTokenizer` class.

### Methods of Tokenization

1. **Using `String.split()` Method**
2. **Using `StringTokenizer` Class**

### 1. Using `String.split()` Method

The `String.split()` method is a convenient way to split a string into an array of substrings based on a regular expression delimiter.

#### Example

```java
public class SplitExample {
    public static void main(String[] args) {
        String text = "Java,Python,C++,JavaScript";
        String delimiter = ",";
        String[] tokens = text.split(delimiter);
      
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
```

#### Output

```
Java
Python
C++
JavaScript
```

#### Details

- **Syntax:** `String[] split(String regex)`
- **Parameters:**
  - `regex`: The regular expression used to match the delimiters.
- **Returns:** An array of strings computed by splitting the input string around matches of the given regular expression.

### 2. Using `StringTokenizer` Class

The `StringTokenizer` class is a legacy class that provides methods for splitting a string into tokens. It is retained for compatibility with older code.

#### Example

```java
import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args) {
        String text = "Java|Python|C++|JavaScript";
        String delimiter = "|";
        StringTokenizer tokenizer = new StringTokenizer(text, delimiter);
      
        while (tokenizer.hasMoreTokens()) {
            System.out.println(tokenizer.nextToken());
        }
    }
}
```

#### Output

```
Java
Python
C++
JavaScript
```

#### Details

- **Constructor:** `StringTokenizer(String str, String delim)`
- **Methods:**
  - `boolean hasMoreTokens()`: Checks if there are more tokens.
  - `String nextToken()`: Returns the next token from the string.

### Comparing `String.split()` and `StringTokenizer`

- **Flexibility:** `String.split()` is more flexible since it accepts regular expressions for delimiters.
- **Usage:** `StringTokenizer` is simpler and faster for basic tokenization but lacks the flexibility of `String.split()`.
- **Thread Safety:** `StringTokenizer` is not thread-safe. For thread-safe tokenization, use `String.split()` or other modern methods.

### Advanced Tokenization with Regular Expressions

Using regular expressions with `String.split()` allows for more advanced tokenization scenarios.

#### Example: Splitting by Multiple Delimiters

```java
public class AdvancedSplitExample {
    public static void main(String[] args) {
        String text = "Java;Python|C++:JavaScript";
        String delimiters = "[;|:]";
        String[] tokens = text.split(delimiters);
      
        for (String token : tokens) {
            System.out.println(token);
        }
    }
}
```

#### Output

```
Java
Python
C++
JavaScript
```

### Summary

- **String Tokenization:** The process of splitting a string into tokens based on delimiters.
- **`String.split()` Method:** Flexible, uses regular expressions, and returns an array of tokens.
- **`StringTokenizer` Class:** Simple and fast for basic tokenization, but less flexible and a legacy class.
- **Advanced Tokenization:** Can be achieved using regular expressions with the `String.split()` method.

By understanding and using these methods, you can effectively tokenize strings in Java for various applications.


# 10. String Pooling:

### String Pooling in Java

String pooling is a memory optimization technique in Java where all string literals are stored in a special memory area called the "string pool." This technique helps to save memory and improve performance by reusing instances of strings instead of creating new ones each time.

### How String Pooling Works

- **String Pool:** A special area in the Java heap memory where string literals are stored.
- **String Interning:** The process of storing only one copy of each distinct string value, which must be immutable.

### Creating Strings in Java

Strings can be created in two main ways:

1. **Using String Literals:**

   - When a string is created using double quotes (e.g., `"hello"`), it is automatically added to the string pool.
   - If the string already exists in the pool, the reference to the existing string is returned.

   ```java
   String str1 = "hello";
   String str2 = "hello";
   System.out.println(str1 == str2); // true
   ```
2. **Using the `new` Keyword:**

   - When a string is created using the `new` keyword (e.g., `new String("hello")`), it creates a new string object in the heap, not in the string pool.

   ```java
   String str1 = new String("hello");
   String str2 = new String("hello");
   System.out.println(str1 == str2); // false
   ```

### String Interning

- **intern() Method:** The `intern()` method can be used to add a string to the pool explicitly or get the reference to the pooled instance if it already exists.

#### Example

```java
public class StringPoolingExample {
    public static void main(String[] args) {
        String str1 = new String("hello");
        String str2 = "hello";

        // str1 and str2 are different objects
        System.out.println(str1 == str2); // false

        // Interning str1
        str1 = str1.intern();

        // Now str1 and str2 refer to the same object in the pool
        System.out.println(str1 == str2); // true
    }
}
```

### Benefits of String Pooling

1. **Memory Efficiency:**

   - String pooling reduces memory consumption by storing only one copy of each distinct string value.
2. **Performance Improvement:**

   - Comparing strings using `==` (reference comparison) is faster than using `equals()` (content comparison), and string pooling allows for such optimizations in certain scenarios.

### Considerations

- **Immutability:** Strings in Java are immutable, which makes string pooling feasible and safe. If strings were mutable, sharing them would lead to unpredictable behavior.
- **Garbage Collection:** Strings in the pool are eligible for garbage collection if no references to them remain.
- **Large Applications:** In applications that use a large number of unique strings dynamically, excessive use of the string pool might lead to increased memory usage and potential performance overhead.

### Summary

- **String Pooling:** A technique to store and reuse instances of strings in a special memory area.
- **String Literals:** Automatically pooled.
- **new Keyword:** Creates a new object on the heap, not in the pool.
- **intern() Method:** Used to manually add a string to the pool or retrieve the pooled instance.
- **Benefits:** Memory efficiency and performance improvement.
- **Considerations:** Strings must be immutable, and excessive dynamic strings might affect performance.

String pooling is a powerful feature in Java that can significantly optimize memory usage and improve performance when used appropriately.
