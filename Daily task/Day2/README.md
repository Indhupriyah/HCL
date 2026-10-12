# Day 2 - Java Language Fundamentals and Git Fundamentals

## 1. Java Language Fundamentals

Java is a high-level, object-oriented programming language. It is platform-independent because Java source code is compiled into bytecode, which can run on a compatible Java Virtual Machine (JVM).

### 1.1 Java Program Structure

Every basic Java program contains a class and a `main()` method, which acts as the entry point for program execution.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

**Explanation:**
- `public` - Makes the class or method accessible.
- `class` - Defines a class.
- `static` - Allows the method to be called without creating an object.
- `void` - Indicates that the method does not return a value.
- `main()` - Entry point of the Java application.
- `System.out.println()` - Prints output to the console.

### 1.2 Variables in Java

A variable is a named storage location used to hold data.

**Syntax:**

```java
dataType variableName = value;
```

**Example:**

```java
int price = 500;
String itemName = "Java Programming Book";
boolean available = true;

System.out.println(itemName);
System.out.println(price);
System.out.println(available);
```

**Output:**

```text
Java Programming Book
500
true
```

### 1.3 Data Types in Java

Java data types are divided into primitive and non-primitive types.

**Primitive data types:**

| Data Type | Example | Purpose |
|---|---|---|
| `byte` | `byte age = 20;` | Small integer |
| `short` | `short count = 100;` | Short integer |
| `int` | `int price = 500;` | Whole numbers |
| `long` | `long id = 123456L;` | Large whole numbers |
| `float` | `float rating = 4.5f;` | Decimal numbers |
| `double` | `double amount = 499.99;` | More precise decimal values |
| `char` | `char grade = 'A';` | Single character |
| `boolean` | `boolean sold = false;` | True or false |

**Non-primitive data types:** Strings, arrays, classes, interfaces and other reference types.

Example:

```java
String sellerName = "Priya";
int[] prices = {100, 200, 300};
```

### 1.4 Operators in Java

Operators perform operations on values and variables.

**Arithmetic operators:** `+`, `-`, `*`, `/`, `%`

```java
int price = 500;
int discount = 50;

System.out.println(price - discount);
```

Output:

```text
450
```

**Relational operators:** `==`, `!=`, `>`, `<`, `>=`, `<=`

```java
int price = 500;
System.out.println(price <= 500);
```

Output:

```text
true
```

**Logical operators:** `&&`, `||`, `!`

```java
boolean available = true;
boolean approved = true;

System.out.println(available && approved);
```

Output:

```text
true
```

### 1.5 Type Conversion

Type conversion changes a value from one data type to another.

**Widening conversion:** Generally automatic when converting a smaller numeric type into a compatible larger type.

```java
int number = 100;
double value = number;

System.out.println(value);
```

Output:

```text
100.0
```

**Narrowing conversion:** Requires explicit casting when converting to a type with a smaller range or precision.

```java
double price = 499.99;
int roundedDown = (int) price;

System.out.println(roundedDown);
```

Output:

```text
499
```

### 1.6 Strings in Java

A `String` represents a sequence of characters.

```java
String item = "Engineering Mathematics Book";

System.out.println(item.length());
System.out.println(item.toUpperCase());
System.out.println(item.contains("Book"));
```

Output:

```text
29
ENGINEERING MATHEMATICS BOOK
true
```

### 1.7 Taking User Input

The `Scanner` class can read input from the keyboard.

```java
import java.util.Scanner;

public class MarketplaceInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();

        System.out.print("Enter item price: ");
        double price = scanner.nextDouble();

        System.out.println("Item: " + itemName);
        System.out.println("Price: Rs. " + price);

        scanner.close();
    }
}
```

This program accepts an item name and price and displays them.

### 1.8 Constants

A constant is a value that cannot be reassigned after initialization. The `final` keyword is used to declare constants.

```java
final double PLATFORM_FEE_RATE = 0.02;
```

This represents a platform fee rate of 2%, if that rate is adopted in the marketplace's business rules.

## 2. Git Fundamentals

Git is a distributed version control system used to track changes in source code and collaborate with other developers.

GitHub is a platform for hosting Git repositories online.

### 2.1 Important Git Commands

| Command | Purpose |
|---|---|
| `git init` | Initializes a Git repository |
| `git clone URL` | Copies a remote repository locally |
| `git status` | Shows the current working-tree status |
| `git add FILE` | Stages a file for the next commit |
| `git add .` | Stages changes in the current directory |
| `git commit -m "message"` | Records staged changes |
| `git log --oneline` | Displays a compact commit history |
| `git branch` | Lists local branches |
| `git switch -c branch-name` | Creates and switches to a branch |
| `git pull origin main` | Fetches and integrates changes from `main` |
| `git push origin main` | Pushes local commits to the remote `main` branch |

### 2.2 Understanding the Git Workflow

The basic Git workflow contains three main areas:

1. **Working directory:** Where files are created and modified.
2. **Staging area:** Where selected changes are prepared for a commit.
3. **Repository:** Where commits are stored.

Typical workflow:

```text
Create or modify files
          |
          v
       git add
          |
          v
      git commit
          |
          v
       git push
          |
          v
     GitHub remote
```

### 2.3 Creating a Branch

Branches allow developers to work on features independently.

```bash
git switch -c feature/item-listing
```

Check the current branch:

```bash
git branch
```

### 2.4 Saving and Pushing Changes

```bash
git status
git add .
git commit -m "Add item listing feature"
git push -u origin feature/item-listing
```

The final command pushes the feature branch to GitHub and sets its upstream branch.

**Note:** Run these commands from the appropriate repository. Before staging everything with `git add .`, check `git status` to avoid including unrelated files.

### 2.5 Why Commit Messages Matter

Good commit messages explain what changed.

Examples:

- `Add item listing validation`
- `Update Java fundamentals notes`
- `Fix item price input handling`

Avoid vague messages such as `update`, `changes`, or `done`.

## 3. Application to the Student Second-Hand Marketplace

The marketplace allows students to buy and sell used books, gadgets and hostel items within their campus.

### Business Rules

1. Every item listing should have an item name, category, price and seller.
2. The listing price must be greater than zero.
3. A listing should have an availability status.
4. Sold items should no longer be displayed as available.
5. Item names and other required text fields must not be blank.

### Java Practice Program

Create a file named `MarketplaceItem.java`.

```java
public class MarketplaceItem {
    String itemName;
    String category;
    double price;
    boolean available;

    public MarketplaceItem(
            String itemName,
            String category,
            double price) {

        this.itemName = itemName;
        this.category = category;
        this.price = price;
        this.available = true;
    }

    public void displayItem() {
        System.out.println("Item: " + itemName);
        System.out.println("Category: " + category);
        System.out.println("Price: Rs. " + price);
        System.out.println("Available: " + available);
    }

    public static void main(String[] args) {
        MarketplaceItem item = new MarketplaceItem(
                "Java Programming Book",
                "Books",
                250.0
        );

        item.displayItem();
    }
}
```

**Expected output:**

```text
Item: Java Programming Book
Category: Books
Price: Rs. 250.0
Available: true
```

This is a basic learning example. The fields are package-private and the price is not yet validated; proper encapsulation and validation will be introduced as the project develops.

## 4. Day 2 Tasks

- [ ] Explain primitive and non-primitive data types.
- [ ] Write a Java program using variables and operators.
- [ ] Write a program that accepts an item name and price.
- [ ] Explain widening and narrowing type conversion.
- [ ] Create and display a `MarketplaceItem` object.
- [ ] Practise `git status`, `git add`, `git commit` and `git push`.
- [ ] Create a feature branch and inspect the branch list.
- [ ] Push the Day 2 learning notes to the HCL GitHub repository.

## 5. Key Takeaways

- Java variables store data, and data types define what values they can hold.
- Operators perform calculations and comparisons.
- Strings support text operations, while `Scanner` reads console input.
- Classes define the structure and behaviour of objects.
- Git tracks changes through staging and commits.
- Branches help developers work on separate features.
- The Student Second-Hand Marketplace applies these concepts to item listings and price handling.
