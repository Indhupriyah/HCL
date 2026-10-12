# Day 5 - Java Inheritance and Polymorphism

## 1. Introduction

Inheritance and polymorphism are two important principles of Object-Oriented Programming (OOP).

- **Inheritance** allows one class to acquire accessible fields and methods from another class.
- **Polymorphism** allows the same method name or interface to represent different behaviours.

These concepts help reduce code duplication and make applications easier to extend.

## 2. Inheritance in Java

Inheritance allows a child class to extend a parent class using the `extends` keyword.

### Example

```java
class User {
    String name;

    void displayName() {
        System.out.println("Name: " + name);
    }
}

class Student extends User {
    String department;

    void displayDepartment() {
        System.out.println("Department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student();

        student.name = "Priya";
        student.department = "Information Science";

        student.displayName();
        student.displayDepartment();
    }
}
```

Output:

```text
Name: Priya
Department: Information Science
```

The `Student` class inherits the accessible `name` field and `displayName()` method from `User`.

### Benefits of Inheritance

- Reuses common functionality.
- Reduces duplicated code.
- Supports extending existing classes.
- Helps organize related classes.

## 3. Types of Inheritance

### 3.1 Single Inheritance

One child class extends one parent class.

```java
class User {
}

class Student extends User {
}
```

### 3.2 Multilevel Inheritance

A class inherits from a class that already inherits from another class.

```java
class User {
}

class Student extends User {
}

class Seller extends Student {
}
```

### 3.3 Hierarchical Inheritance

Multiple child classes inherit from the same parent class.

```java
class User {
}

class Student extends User {
}

class Admin extends User {
}
```

**Note:** Java does not support multiple inheritance of classes. A class cannot extend two classes simultaneously. Multiple inheritance of type can be achieved using interfaces.

## 4. The super Keyword

The `super` keyword refers to the immediate parent class.

It can be used to:
- Access a parent class field.
- Call a parent class method.
- Call a parent class constructor.

### Example

```java
class User {
    String name;

    User(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("User: " + name);
    }
}

class Student extends User {
    String department;

    Student(String name, String department) {
        super(name);
        this.department = department;
    }

    void displayDetails() {
        super.display();
        System.out.println("Department: " + department);
    }
}

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Priya", "ISE");
        student.displayDetails();
    }
}
```

Output:

```text
User: Priya
Department: ISE
```

The call `super(name)` invokes the parent constructor.

## 5. Method Overriding

Method overriding occurs when a child class provides its own implementation of an inherited instance method.

### Example

```java
class User {
    void displayRole() {
        System.out.println("General user");
    }
}

class Seller extends User {
    @Override
    void displayRole() {
        System.out.println("Marketplace seller");
    }
}

public class Main {
    public static void main(String[] args) {
        Seller seller = new Seller();
        seller.displayRole();
    }
}
```

Output:

```text
Marketplace seller
```

The `@Override` annotation helps the compiler verify that the method correctly overrides an inherited method.

## 6. Polymorphism in Java

Polymorphism means one interface or method name can represent different behaviours.

The two commonly studied forms are:
1. Compile-time polymorphism through method overloading.
2. Runtime polymorphism through method overriding and dynamic method dispatch.

### 6.1 Compile-Time Polymorphism

Example of method overloading:

```java
class PriceCalculator {
    double calculate(double price) {
        return price;
    }

    double calculate(double price, double discount) {
        return price - discount;
    }
}

public class Main {
    public static void main(String[] args) {
        PriceCalculator calculator = new PriceCalculator();

        System.out.println(calculator.calculate(500));
        System.out.println(calculator.calculate(500, 50));
    }
}
```

Output:

```text
500.0
450.0
```

The compiler selects the appropriate method based on the arguments.

### 6.2 Runtime Polymorphism

A parent-class reference can refer to a child-class object. When an overridden instance method is called, Java selects the implementation based on the actual object at runtime.

```java
class User {
    void displayRole() {
        System.out.println("General user");
    }
}

class Buyer extends User {
    @Override
    void displayRole() {
        System.out.println("Marketplace buyer");
    }
}

class Seller extends User {
    @Override
    void displayRole() {
        System.out.println("Marketplace seller");
    }
}

public class Main {
    public static void main(String[] args) {
        User user1 = new Buyer();
        User user2 = new Seller();

        user1.displayRole();
        user2.displayRole();
    }
}
```

Output:

```text
Marketplace buyer
Marketplace seller
```

Although both variables have the reference type `User`, the overridden methods execute according to the actual objects.

## 7. The final Keyword

The `final` keyword restricts modification or extension in different contexts.

- **Final variable:** Cannot be reassigned after initialization.
- **Final method:** Cannot be overridden in a subclass.
- **Final class:** Cannot be extended.

### Example

```java
final class PaymentRules {
    static final double MAX_DISCOUNT = 100.0;
}
```

The class cannot be subclassed, and `MAX_DISCOUNT` cannot be reassigned.

## 8. Marketplace Practice Program

Build a simple example with a common item class and different item categories.

```java
class MarketplaceItem {
    String name;
    double price;

    MarketplaceItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    void displayCategory() {
        System.out.println("General item");
    }

    void displayDetails() {
        System.out.println("Item: " + name);
        System.out.println("Price: Rs. " + price);
        displayCategory();
    }
}

class Book extends MarketplaceItem {
    Book(String name, double price) {
        super(name, price);
    }

    @Override
    void displayCategory() {
        System.out.println("Category: Books");
    }
}

class Electronics extends MarketplaceItem {
    Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    void displayCategory() {
        System.out.println("Category: Electronics");
    }
}

public class Main {
    public static void main(String[] args) {
        MarketplaceItem item1 = new Book("Java Book", 250);
        MarketplaceItem item2 = new Electronics("Calculator", 400);

        item1.displayDetails();
        System.out.println();

        item2.displayDetails();
    }
}
```

Expected output:

```text
Item: Java Book
Price: Rs. 250.0
Category: Books

Item: Calculator
Price: Rs. 400.0
Category: Electronics
```

This demonstrates inheritance, constructors, method overriding, and runtime polymorphism.

## 9. Day 5 Tasks

- [ ] Create a parent class named `User`.
- [ ] Create `Buyer` and `Seller` classes that extend `User`.
- [ ] Use `super()` to initialize parent-class fields.
- [ ] Override a method in a child class.
- [ ] Demonstrate method overloading with a price calculator.
- [ ] Demonstrate runtime polymorphism using a parent reference.
- [ ] Explain why Java does not support multiple inheritance of classes.
- [ ] Implement the marketplace item example.
- [ ] Push the Day 5 notes to GitHub.

## 10. Key Takeaways

- Inheritance supports code reuse through parent and child classes.
- The `extends` keyword establishes class inheritance.
- The `super` keyword accesses parent-class constructors and members.
- Method overriding provides specialized behaviour in child classes.
- Method overloading uses different parameter lists.
- Runtime polymorphism selects an overridden instance method based on the actual object.
- These concepts help organize marketplace users, products, and their behaviours.
