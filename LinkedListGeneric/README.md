# Generic Custom Linked List Implementation

This project is a study implementation of a generic doubly linked list in Java. It demonstrates core data structure concepts including generics, iterators, and linked list operations.

## Features

- **Generic Implementation**: The `CustomLinkedList` class can store any type of element using Java generics.
- **Doubly Linked Structure**: Each node maintains references to both next and previous nodes.
- **Iterator Support**: Implements the `Iterable` interface, allowing use in enhanced for loops.
- **Common Operations**:
  - Add elements to the end of the list (`add`)
  - Add elements to the beginning of the list (`addFirst`)
  - Get elements by index (`get`)
  - Remove elements by index (`remove`)
  - Get first and last elements (`getFirst`, `getLast`)
  - Get the size of the list (`getLength`)

## Project Structure

```
src/
└── main/
    └── java/
        └── org/
            └── javacourse/
                ├── CustomLinkedList.java    # Main linked list implementation
                └── Main.java               # Example usage
```

## Usage Example

```java
CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
customLinkedList.add("ABC");
customLinkedList.add("DEF");
customLinkedList.add("GHI");
customLinkedList.addFirst("aaaa");

System.out.println(customLinkedList.get(3));        // Output: GHI
System.out.println(customLinkedList.getLength());   // Output: 4
System.out.println(customLinkedList.getFirst());    // Output: aaaa
System.out.println(customLinkedList.getLast());     // Output: GHI

customLinkedList.remove(2);                         // Remove element at index 2
System.out.println(customLinkedList.getLength());   // Output: 3

// Iterate through the list
for (String str : customLinkedList) {
    System.out.println(str);
}
```

## Class Details

### CustomLinkedList&lt;Element&gt;
- **Generic Type**: `Element` - can be any object type
- **Internal Structure**: Uses a private static `Node` class with data, next, and prev references
- **Fields**:
  - `head`: Reference to the first node
  - `tail`: Reference to the last node
  - `size`: Current number of elements in the list

### Node&lt;Element&gt;
- **Private static inner class** representing each element in the list
- Contains data, next node reference, and previous node reference

## Building and Running

This project uses Maven for dependency management.

To run the example:
```bash
mvn compile
mvn exec:java -Dexec.mainClass="org.javacourse.Main"
```

Alternatively, you can run directly from an IDE that supports Java and Maven.

## Learning Objectives

This implementation was created as part of a Udemy Java course to understand:
- Generic programming in Java
- Data structure implementation from scratch
- Doubly linked list operations
- Iterator pattern implementation
- Memory management in Java collections