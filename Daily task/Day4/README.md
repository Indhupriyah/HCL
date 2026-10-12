# Day 4 - Java Methods and Object-Oriented Programming Basics

## 1. Introduction

Java is an object-oriented programming language. Object-Oriented Programming (OOP) organizes code using classes and objects.

OOP helps developers create reusable, organized, and maintainable applications.

The four main principles of OOP are:

1. Encapsulation
2. Inheritance
3. Polymorphism
4. Abstraction

This day introduces methods, classes, objects, constructors, and encapsulation.

## 2. Methods in Java

A method is a block of code that performs a particular task. Methods help reduce code duplication and improve readability.

### 2.1 Method Syntax

```java
returnType methodName(parameters) {
    // Statements
    return value;
}
```

- `returnType` specifies the type of value returned.
- `methodName` identifies the method.
- `parameters` are inputs received by the method.
- `return` sends a result back to the caller when required.

### 2.2 Method Without Parameters

```java
public class Main {
    static void displayMessage() {
        System.out.println("Welcome to the marketplace");
    }

    public static void main(String[] args) {
        displayMessage();
    }
}
```

Output:

```text
Welcome to the marketplace
```

The `displayMessage()` method does not accept parameters or return a value.

### 2.3 Method With Parameters

```java
public class Main {
    static void displayItem(String itemName, double price) {
        System.out.println("Item: " + itemName);
        System.out.println("Price: Rs. " + price);
    }

    public static void main(String[] args) {
        displayItem("Java Book", 250.0);
    }
}
```

Output:

```text
Item: Java Book
Price: Rs. 250.0
```

Here, `itemName` and `price` are parameters passed to the method.

### 2.4 Method With a Return Value

```java
public class Main {
    static double calculateDiscount(double price, double discount) {
        return price - discount;
    }

    public static void main(String[] args) {
        double finalPrice = calculateDiscount(500, 50);
        System.out.println("Final price: Rs. " + finalPrice);
    }
}
```

Output:

```text
Final price: Rs. 450.0
```

The method returns the calculated price as a `double`.

### 2.5 Method Overloading

Method overloading means defining multiple methods with the same name but different parameter lists.

```java
public class Main {
    static int add(int a, int b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println(add(10, 20));
        System.out.println(add(10, 20, 30));
    }
}
```

Output:

```text
30
60
```

Java chooses the appropriate overloaded method based on the arguments. Changing only the return type does not create a valid overload.

## 3. Classes and Objects

### 3.1 What Is a Class?

A class is a blueprint that defines the data and behaviour of objects.

Example:

```java
class Item {
    String name;
    double price;

    void display() {
        System.out.println(name + " - Rs. " + price);
    }
}
```

The `Item` class defines two fields and one method.

### 3.2 What Is an Object?

An object is an instance of a class.

```java
public class Main {
    public static void main(String[] args) {
        Item item1 = new Item();

        item1.name = "Calculator";
        item1.price = 400;

        item1.display();
    }
}
```

Output:

```text
Calculator - Rs. 400.0
```

The `new` keyword creates an object, and `item1` refers to that object.

## 4. Constructors in Java

A constructor initializes an object when it is created.

A constructor has the same name as its class and does not declare a return type.

### Example

```java
class Item {
    String name;
    double price;

    Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void display() {
        System.out.println(name + " - Rs. " + price);
    }
}

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("Backpack", 600);
        item1.display();
    }
}
```

Output:

```text
Backpack - Rs. 600.0
```

### Understanding the `this` Keyword

The `this` keyword refers to the current object.

In the constructor:

```java
this.name = name;
```

- `this.name` refers to the object's field.
- `name` refers to the constructor parameter.

## 5. Encapsulation

Encapsulation means keeping an object's data protected and controlling access through methods.

It is commonly implemented using private fields and public getter and setter methods.

### Example

```java
class Item {
    private String name;
    private double price;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        if (price > 0) {
            this.price = price;
        } else {
            System.out.println("Price must be greater than zero");
        }
    }

    public double getPrice() {
        return price;
    }
}

public class Main {
    public static void main(String[] args) {
        Item item = new Item();

        item.setName("Java Book");
        item.setPrice(250);

        System.out.println(item.getName());
        System.out.println(item.getPrice());
    }
}
```

Output:

```text
Java Book
250.0
```

The price setter checks that the price is positive before assigning it.

In a production application, additional validation and error handling would be required.

## 6. Static and Instance Members

### Static Members

Static members belong to the class and can be accessed without creating an instance.

```java
class Marketplace {
    static String platformName = "Campus Marketplace";
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Marketplace.platformName);
    }
}
```

Output:

```text
Campus Marketplace
```

### Instance Members

Instance fields and methods belong to individual objects. Different objects can store different values.

```java
class Student {
    String name;
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();

        s1.name = "Priya";
        s2.name = "Arun";

        System.out.println(s1.name);
        System.out.println(s2.name);
    }
}
```

Output:

```text
Priya
Arun
```

## 7. Marketplace Practice Program

Create a class that represents an item listed for sale.

```java
class MarketplaceItem {
    private String itemName;
    private String category;
    private double price;
    private boolean available;

    public MarketplaceItem(
            String itemName,
            String category,
            double price) {

        this.itemName = itemName;
        this.category = category;
        this.available = true;

        if (price > 0) {
            this.price = price;
        } else {
            throw new IllegalArgumentException(
                "Price must be greater than zero"
            );
        }
    }

    public void displayItem() {
        System.out.println("Item: " + itemName);
        System.out.println("Category: " + category);
        System.out.println("Price: Rs. " + price);
        System.out.println("Available: " + available);
    }

    public void markAsSold() {
        available = false;
    }

    public static void main(String[] args) {
        MarketplaceItem item = new MarketplaceItem(
            "Engineering Mathematics Book",
            "Books",
            180
        );

        item.displayItem();

        item.markAsSold();

        System.out.println("After sale:");
        item.displayItem();
    }
}
```

Expected output:

```text
Item: Engineering Mathematics Book
Category: Books
Price: Rs. 180.0
Available: true
After sale:
Item: Engineering Mathematics Book
Category: Books
Price: Rs. 180.0
Available: false
```

This program demonstrates classes, objects, constructors, encapsulation, methods, and state changes.

## 8. Day 4 Tasks

- [ ] Write a method that adds two numbers.
- [ ] Write a method that returns the square of a number.
- [ ] Create a class named `Student` with name and department fields.
- [ ] Create two objects of the `Student` class.
- [ ] Write a constructor that initializes an item's name and price.
- [ ] Explain the purpose of the `this` keyword.
- [ ] Implement private fields with getter and setter methods.
- [ ] Add validation to prevent zero or negative item prices.
- [ ] Create a method to mark an item as sold.
- [ ] Push the Day 4 learning notes to GitHub.

## 9. Key Takeaways

- Methods organize reusable operations.
- Parameters provide inputs, and return values provide results.
- Classes define object structure, while objects are instances of classes.
- Constructors initialize new objects.
- The `this` keyword refers to the current object.
- Encapsulation protects fields and controls how they are modified.
- Static members belong to the class, while instance members belong to individual objects.
- These concepts form the foundation for building marketplace entities and business logic in Java.
