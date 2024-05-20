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
