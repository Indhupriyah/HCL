# Day 3 - Java Control Flow and Arrays

## 1. Introduction

Control flow statements determine the order in which a Java program executes. Arrays allow us to store multiple values of the same data type in a single variable.

These concepts are useful for implementing marketplace features such as checking item prices, displaying available products, and calculating total prices.

## 2. Conditional Statements

### 2.1 if Statement

The `if` statement executes a block of code when a condition is true.

```java
int price = 500;

if (price > 0) {
    System.out.println("Valid price");
}
```

Output:

```text
Valid price
```

### 2.2 if-else Statement

The `if-else` statement chooses between two blocks of code.

```java
double price = 0;

if (price > 0) {
    System.out.println("Item is available for sale");
} else {
    System.out.println("Invalid price");
}
```

Output:

```text
Invalid price
```

### 2.3 else-if Ladder

An `else-if` ladder checks multiple conditions in sequence.

```java
int price = 400;

if (price < 100) {
    System.out.println("Budget item");
} else if (price <= 500) {
    System.out.println("Affordable item");
} else {
    System.out.println("Premium item");
}
```

Output:

```text
Affordable item
```

### 2.4 switch Statement

A `switch` statement selects a block based on a value.

```java
int category = 2;

switch (category) {
    case 1:
        System.out.println("Books");
        break;
    case 2:
        System.out.println("Electronics");
        break;
    case 3:
        System.out.println("Hostel Essentials");
        break;
    default:
        System.out.println("Unknown category");
}
```

Output:

```text
Electronics
```

The `break` statement prevents execution from continuing into subsequent cases in this traditional switch syntax.

## 3. Loops in Java

Loops execute a block of code repeatedly.

### 3.1 for Loop

Use a `for` loop when the number of iterations is known or controlled by a counter.

```java
for (int i = 1; i <= 5; i++) {
    System.out.println(i);
}
```

Output:

```text
1
2
3
4
5
```

### 3.2 while Loop

A `while` loop continues as long as its condition remains true.

```java
int i = 1;

while (i <= 3) {
    System.out.println(i);
    i++;
}
```

Output:

```text
1
2
3
```

### 3.3 do-while Loop

A `do-while` loop executes its body at least once before checking the condition.

```java
int i = 1;

do {
    System.out.println(i);
    i++;
} while (i <= 3);
```

Output:

```text
1
2
3
```

### 3.4 Enhanced for Loop

The enhanced `for` loop iterates over elements in an array or collection.

```java
String[] items = {"Books", "Bags", "Calculators"};

for (String item : items) {
    System.out.println(item);
}
```

Output:

```text
Books
Bags
Calculators
```

## 4. Arrays in Java

An array stores a fixed number of elements of the same type.

### 4.1 Array Declaration

```java
int[] prices = {100, 200, 300, 400};
```

Here, `prices` contains four integer values.

### 4.2 Accessing Array Elements

Array indexing begins at zero.

```java
int[] prices = {100, 200, 300};

System.out.println(prices[0]);
System.out.println(prices[2]);
```

Output:

```text
100
300
```

Accessing an invalid index causes an `ArrayIndexOutOfBoundsException`.

### 4.3 Array Length

The `length` property returns the number of elements in an array.

```java
String[] items = {"Book", "Bag", "Calculator"};

System.out.println(items.length);
```

Output:

```text
3
```

### 4.4 Traversing an Array

```java
int[] prices = {100, 250, 400};

for (int i = 0; i < prices.length; i++) {
    System.out.println(prices[i]);
}
```

### 4.5 Finding the Sum and Average

```java
int[] prices = {100, 200, 300, 400};
int sum = 0;

for (int price : prices) {
    sum += price;
}

double average = (double) sum / prices.length;

System.out.println("Total: " + sum);
System.out.println("Average: " + average);
```

Output:

```text
Total: 1000
Average: 250.0
```

### 4.6 Finding the Highest Price

```java
int[] prices = {250, 150, 700, 400};
int highest = prices[0];

for (int price : prices) {
    if (price > highest) {
        highest = price;
    }
}

System.out.println("Highest price: " + highest);
```

Output:

```text
Highest price: 700
```

This example assumes the array contains at least one element.

## 5. Two-Dimensional Arrays

A two-dimensional array stores data in rows and columns.

```java
int[][] prices = {
    {100, 200},
    {300, 400}
};

System.out.println(prices[0][1]);
System.out.println(prices[1][0]);
```

Output:

```text
200
300
```

The first index selects a row, and the second index selects an element within that row.

## 6. break and continue

### break

The `break` statement exits a loop immediately.

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        break;
    }
    System.out.println(i);
}
```

Output:

```text
1
2
```

### continue

The `continue` statement skips the current iteration and proceeds to the next one.

```java
for (int i = 1; i <= 5; i++) {
    if (i == 3) {
        continue;
    }
    System.out.println(i);
}
```

Output:

```text
1
2
4
5
```

## 7. Marketplace Practice Program

Create a Java program to display available items, their prices, and the total value of the listed items.

```java
public class MarketplaceItems {
    public static void main(String[] args) {
        String[] items = {
            "Java Book",
            "Calculator",
            "Backpack",
            "Headphones"
        };

        int[] prices = {250, 400, 600, 800};
        int total = 0;

        System.out.println("Available Marketplace Items:");

        for (int i = 0; i < items.length; i++) {
            System.out.println(
                items[i] + " - Rs. " + prices[i]
            );

            total += prices[i];
        }

        System.out.println("Total listing value: Rs. " + total);
    }
}
```

Expected output:

```text
Available Marketplace Items:
Java Book - Rs. 250
Calculator - Rs. 400
Backpack - Rs. 600
Headphones - Rs. 800
Total listing value: Rs. 2050
```

This program uses arrays, loops, variables, and string concatenation.

## 8. Day 3 Tasks

- [ ] Write a program to check whether a number is positive, negative, or zero.
- [ ] Write a program to check whether a number is even or odd.
- [ ] Print numbers from 1 to 100 using a loop.
- [ ] Find the sum of the first 10 natural numbers.
- [ ] Find the largest element in an integer array.
- [ ] Calculate the average of array elements.
- [ ] Display marketplace items and prices using arrays.
- [ ] Explain the differences between `for`, `while`, and `do-while`.
- [ ] Push the Day 3 notes to GitHub.

## 9. Key Takeaways

- Conditional statements execute code based on conditions.
- Loops repeat instructions while their conditions allow.
- Arrays store a fixed number of elements of the same type.
- Array indexes start at zero.
- The `break` statement exits a loop, while `continue` skips an iteration.
- Arrays and loops can be combined to process marketplace listings efficiently.
