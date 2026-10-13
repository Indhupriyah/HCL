# Day 7 - Java Collections Framework — Part 1

## 1. Introduction

The Java Collections Framework provides classes and interfaces for storing, organizing, accessing, and manipulating groups of objects.

In the Student Second-Hand Marketplace, collections can be used to:
- Store product listings.
- Prevent duplicate categories or IDs.
- Maintain a queue of students waiting for an item.
- Prioritize requests.
- Search, update, and remove listings.

The main collection interfaces covered today are `List`, `Set`, and `Queue`.

## 2. List Interface

A `List` stores an ordered sequence of elements. It allows duplicate values and provides index-based access.

Common implementations:
- `ArrayList`
- `LinkedList`

### 2.1 ArrayList

`ArrayList` is a resizable array. It is useful when elements need frequent access by index and when items are commonly added to or removed from the end.

Example:

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();

        items.add("Java Book");
        items.add("Calculator");
        items.add("Backpack");
        items.add("Java Book");

        System.out.println(items);
        System.out.println(items.get(1));
        System.out.println(items.size());
    }
}
```

Output:

```text
[Java Book, Calculator, Backpack, Java Book]
Calculator
4
```

Important methods:
- `add(element)` — adds an element.
- `get(index)` — retrieves an element.
- `set(index, element)` — replaces an element.
- `remove(index)` — removes an element at an index.
- `contains(element)` — checks whether an element exists.
- `size()` — returns the number of elements.

### 2.2 LinkedList

`LinkedList` is implemented as a doubly linked list. It implements both `List` and `Deque`.

It can be useful when performing frequent insertions and removals at the beginning or end of a sequence.

```java
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> items = new LinkedList<>();

        items.add("Book");
        items.add("Bag");
        items.add("Calculator");

        items.add(1, "Headphones");
        System.out.println(items);

        items.remove(0);
        System.out.println(items);
    }
}
```

Output:

```text
[Book, Headphones, Bag, Calculator]
[Headphones, Bag, Calculator]
```

### 2.3 ArrayList vs LinkedList

| Feature | ArrayList | LinkedList |
|---|---|---|
| Internal structure | Resizable array | Doubly linked list |
| Access by index | Usually fast, O(1) | O(n) |
| Add at the end | Amortized O(1) | O(1) |
| Add/remove at the beginning | O(n) due to shifting | O(1) |
| Memory usage | Generally lower | Higher due to node links |
| Best use | Frequent reads and indexed access | Frequent operations at the ends |

Note: Inserting or removing in the middle of an `ArrayList` generally requires shifting elements. In a `LinkedList`, finding the middle position is still O(n), even though relinking the nodes once the position is reached is O(1).

For a marketplace product catalogue, `ArrayList` is usually the better starting choice.

## 3. Set Interface

A `Set` stores unique elements. It does not allow duplicates according to its equality rules.

Common implementations:
- `HashSet`
- `LinkedHashSet`
- `TreeSet`

### 3.1 HashSet

`HashSet` stores unique elements and does not guarantee iteration order.

```java
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> categories = new HashSet<>();

        categories.add("Books");
        categories.add("Electronics");
        categories.add("Hostel Essentials");
        categories.add("Books");

        System.out.println(categories);
        System.out.println(categories.size());
    }
}
```

The set contains three unique categories. Their printed order is not guaranteed.

### 3.2 LinkedHashSet

`LinkedHashSet` preserves insertion order while preventing duplicates.

```java
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> categories = new LinkedHashSet<>();

        categories.add("Books");
        categories.add("Electronics");
        categories.add("Bags");
        categories.add("Books");

        System.out.println(categories);
    }
}
```

Output:

```text
[Books, Electronics, Bags]
```

### 3.3 TreeSet

`TreeSet` stores unique elements in sorted order according to their natural ordering or a supplied comparator.

```java
import java.util.TreeSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> categories = new TreeSet<>();

        categories.add("Electronics");
        categories.add("Books");
        categories.add("Bags");

        System.out.println(categories);
    }
}
```

Output:

```text
[Bags, Books, Electronics]
```

### 3.4 Set Comparison

| Implementation | Duplicates | Iteration order |
|---|---|---|
| `HashSet` | Not allowed | No guaranteed order |
| `LinkedHashSet` | Not allowed | Insertion order |
| `TreeSet` | Not allowed | Sorted order |

## 4. Queue Interface

A `Queue` stores elements for processing. Many queues use First-In, First-Out (FIFO) ordering.

Common implementations:
- `ArrayDeque`
- `LinkedList`
- `PriorityQueue`

### 4.1 Queue Methods

| Method | Behaviour |
|---|---|
| `offer(element)` | Adds an element when possible |
| `poll()` | Removes and returns the head, or returns `null` if empty |
| `peek()` | Returns the head without removing it, or returns `null` if empty |
| `remove()` | Removes the head; throws an exception if empty |
| `element()` | Returns the head; throws an exception if empty |

### 4.2 FIFO Queue Using ArrayDeque

```java
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> waitlist = new ArrayDeque<>();

        waitlist.offer("Priya");
        waitlist.offer("Arun");
        waitlist.offer("Kavin");

        System.out.println(waitlist.peek());
        System.out.println(waitlist.poll());
        System.out.println(waitlist);
    }
}
```

Output:

```text
Priya
Priya
[Arun, Kavin]
```

Priya is processed first because she joined the queue first.

`ArrayDeque` is generally a good choice for a normal in-memory FIFO queue.

### 4.3 PriorityQueue

`PriorityQueue` processes elements according to their priority ordering, not insertion order.

By default, elements use natural ordering. A comparator can define a different priority.

```java
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> requests = new PriorityQueue<>();

        requests.offer(30);
        requests.offer(10);
        requests.offer(20);

        while (!requests.isEmpty()) {
            System.out.println(requests.poll());
        }
    }
}
```

Output:

```text
10
20
30
```

The smallest number is processed first.

For marketplace requests, we could define priority rules such as faculty requests before student requests. A custom comparator would be required to implement such a policy.

## 5. Iterating Through Collections

Iteration means accessing collection elements one by one.

### 5.1 Enhanced for Loop

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();

        items.add("Book");
        items.add("Bag");
        items.add("Calculator");

        for (String item : items) {
            System.out.println(item);
        }
    }
}
```

### 5.2 Iterator

An `Iterator` traverses a collection and can safely remove the current element using its `remove()` method.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> prices =
                new ArrayList<>(List.of(100, 250, 500, 50));

        Iterator<Integer> iterator = prices.iterator();

        while (iterator.hasNext()) {
            int price = iterator.next();

            if (price < 100) {
                iterator.remove();
            }
        }

        System.out.println(prices);
    }
}
```

Output:

```text
[100, 250, 500]
```

Calling `iterator.remove()` removes the current element safely during iterator traversal.

### 5.3 ListIterator

`ListIterator` is available for lists. It supports forward and backward traversal, and it can add, replace, or remove elements during iteration.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        List<String> items =
                new ArrayList<>(List.of("Book", "Bag"));

        ListIterator<String> iterator = items.listIterator();

        while (iterator.hasNext()) {
            String item = iterator.next();

            if (item.equals("Book")) {
                iterator.set("Java Book");
            }
        }

        System.out.println(items);
    }
}
```

Output:

```text
[Java Book, Bag]
```

### 5.4 ConcurrentModificationException

Structural modifications to a collection while using an enhanced `for` loop or an iterator can cause a `ConcurrentModificationException` when the iterator detects the unexpected modification.

Incorrect example:

```java
for (String item : items) {
    if (item.equals("Book")) {
        items.remove(item);
    }
}
```

Safer alternatives include:
- `Iterator.remove()`
- `ListIterator` modification methods
- `removeIf()` for supported collections

Example:

```java
items.removeIf(item -> item.equals("Book"));
```

## 6. Choosing the Right Collection

| Requirement | Recommended collection |
|---|---|
| Store product listings in order | `ArrayList` |
| Store unique category names | `LinkedHashSet` |
| Maintain a normal waiting list | `ArrayDeque` |
| Process requests by priority | `PriorityQueue` |
| Display unique categories alphabetically | `TreeSet` |

The best choice depends on the operations required, ordering rules, and performance needs.

## 7. Practical Lab: Library Waitlist

### Objective

Build a small program that demonstrates:
- `ArrayList` for a catalogue.
- `LinkedHashSet` for duplicate-free categories.
- `ArrayDeque` for a FIFO waiting list.
- `PriorityQueue` for priority-based requests.
- `Iterator.remove()` for removing overdue entries.

### Program

Save the following as `LibraryWaitlist.java`.

```java
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class LibraryWaitlist {

    public static void main(String[] args) {

        // 1. Catalogue using ArrayList
        List<String> catalogue = new ArrayList<>();
        catalogue.add("Java Book");
        catalogue.add("DBMS Book");
        catalogue.add("Computer Networks Book");

        System.out.println("Catalogue: " + catalogue);

        // 2. Unique categories using LinkedHashSet
        Set<String> categories = new LinkedHashSet<>();
        categories.add("Books");
        categories.add("Electronics");
        categories.add("Books");

        System.out.println("Categories: " + categories);

        // 3. FIFO waiting list using ArrayDeque
        Queue<String> waitlist = new ArrayDeque<>();
        waitlist.offer("Priya");
        waitlist.offer("Arun");
        waitlist.offer("Kavin");

        System.out.println("Next student: " + waitlist.poll());
        System.out.println("Remaining waitlist: " + waitlist);

        // 4. Priority requests: lower number = higher priority
        Queue<Integer> priorityRequests = new PriorityQueue<>();
        priorityRequests.offer(3);
        priorityRequests.offer(1);
        priorityRequests.offer(2);

        System.out.println("Priority processing order:");

        while (!priorityRequests.isEmpty()) {
            System.out.println(priorityRequests.poll());
        }

        // 5. Remove overdue items safely using Iterator
        List<String> borrowedItems = new ArrayList<>();
        borrowedItems.add("Java Book");
        borrowedItems.add("DBMS Book");
        borrowedItems.add("Old Notes");

        Iterator<String> iterator = borrowedItems.iterator();

        while (iterator.hasNext()) {
            String item = iterator.next();

            if (item.equals("Old Notes")) {
                iterator.remove();
            }
        }

        System.out.println("After overdue removal: " + borrowedItems);
    }
}
```

### Expected output

```text
Catalogue: [Java Book, DBMS Book, Computer Networks Book]
Categories: [Books, Electronics]
Next student: Priya
Remaining waitlist: [Arun, Kavin]
Priority processing order:
1
2
3
After overdue removal: [Java Book, DBMS Book]
```

### Performance comparison

For the lab, compare `ArrayList` and `LinkedList` using the same workload:
1. Append a large number of elements.
2. Insert elements at the beginning.
3. Retrieve elements using `get(i)`.
4. Record elapsed time for each operation.

Run multiple trials and use the same input size. Explain why indexed access is generally faster in `ArrayList` and why `LinkedList` is not automatically faster for arbitrary insertions.

## 8. Applying Collections to the Student Second-Hand Marketplace

Use these collection choices as a starting point for your project:

- `List<MarketplaceItem>` — store item listings.
- `Set<String>` — store unique category names.
- `Queue<String>` — maintain a FIFO waitlist for a reserved item.
- `PriorityQueue<Request>` — process requests using an explicitly defined priority rule.

For now, these collections store data in memory. They do not persist data after the program terminates. Later, the project will move to repository and database-based storage.

## 9. Day 7 Tasks

- [ ] Explain the difference between `List`, `Set`, and `Queue`.
- [ ] Demonstrate `ArrayList` and `LinkedList`.
- [ ] Compare `HashSet`, `LinkedHashSet`, and `TreeSet`.
- [ ] Implement a FIFO queue using `ArrayDeque`.
- [ ] Implement a priority queue using `PriorityQueue`.
- [ ] Remove elements safely using `Iterator.remove()`.
- [ ] Complete the Library Waitlist program.
- [ ] Compare `ArrayList` and `LinkedList` performance.
- [ ] Use collections to store marketplace items and categories.
- [ ] Push the Day 7 learning notes and practical code to GitHub.

## 10. Key Takeaways

- `List` maintains an ordered sequence and allows duplicates.
- `Set` stores unique elements.
- `Queue` supports processing elements according to a defined ordering.
- `ArrayList` is usually a good default for product listings.
- `LinkedHashSet` preserves insertion order while preventing duplicates.
- `ArrayDeque` is useful for FIFO queues.
- `PriorityQueue` processes elements by priority.
- Iterators allow safe removal during traversal.
- Choosing the right collection improves clarity and performance.
