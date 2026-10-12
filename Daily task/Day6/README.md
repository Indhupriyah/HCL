# Day 6 - Java Abstraction and Interfaces

## 1. Introduction

Abstraction is one of the four main principles of Object-Oriented Programming (OOP).

It means hiding implementation details and exposing only the essential functionality to the user.

Java supports abstraction mainly through:
1. Abstract classes
2. Interfaces

These concepts help developers define common behaviours while allowing different classes to implement them in their own ways.

## 2. Abstract Classes

An abstract class is declared using the `abstract` keyword. It cannot be instantiated directly.

It can contain:
- Abstract methods without a method body.
- Concrete methods with a method body.
- Constructors and instance fields.
- Static methods and other class members.

### Example

```java
abstract class MarketplaceItem {
    String name;
    double price;

    MarketplaceItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    abstract void displayCategory();

    void displayDetails() {
        System.out.println("Item: " + name);
        System.out.println("Price: Rs. " + price);
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

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", 250);

        book.displayDetails();
        book.displayCategory();
    }
}
```

Output:

```text
Item: Java Programming
Price: Rs. 250.0
Category: Books
```

The abstract class defines common item details, while the `Book` class provides the category implementation.

## 3. Abstract Methods

An abstract method declares what a class must do without specifying how it does it.

```java
abstract class Payment {
    abstract void processPayment(double amount);
}
```

A concrete subclass must implement the inherited abstract method unless the subclass is also abstract.

## 4. Interfaces in Java

An interface defines a contract that implementing classes agree to follow.

It is declared using the `interface` keyword. A class implements an interface using the `implements` keyword.

### Example

```java
interface Searchable {
    void search(String keyword);
}

class ItemSearch implements Searchable {
    @Override
    public void search(String keyword) {
        System.out.println("Searching for: " + keyword);
    }
}

public class Main {
    public static void main(String[] args) {
        Searchable search = new ItemSearch();
        search.search("Java Book");
    }
}
```

Output:

```text
Searching for: Java Book
```

The `search()` method is public when implemented from this interface, so its implementation must be declared `public`.

## 5. Multiple Interfaces

A Java class can implement more than one interface.

```java
interface Searchable {
    void search(String keyword);
}

interface Reportable {
    void generateReport();
}

class Marketplace implements Searchable, Reportable {
    @Override
    public void search(String keyword) {
        System.out.println("Searching: " + keyword);
    }

    @Override
    public void generateReport() {
        System.out.println("Report generated");
    }
}
```

The `Marketplace` class implements the contracts defined by both interfaces.

## 6. Abstract Class vs Interface

| Abstract Class | Interface |
|---|---|
| Declared using `abstract class` | Declared using `interface` |
| Can have instance fields | Fields are implicitly `public static final` |
| Can have constructors | Cannot have constructors |
| Can have abstract and concrete methods | Can have abstract, default, static and private methods, subject to Java rules |
| A class can extend only one class | A class can implement multiple interfaces |
| Useful for shared state and implementation | Useful for defining contracts and capabilities |

## 7. Default and Static Interface Methods

Modern Java interfaces can include default and static methods.

```java
interface Notifiable {
    void sendNotification(String message);

    default void showStatus() {
        System.out.println("Notification service ready");
    }

    static String getServiceName() {
        return "Campus Notifications";
    }
}
```

- A default method provides an implementation that implementing classes can inherit or override.
- A static interface method belongs to the interface and is called using the interface name.

Example:

```java
System.out.println(Notifiable.getServiceName());
```

Output:

```text
Campus Notifications
```

## 8. Marketplace Practice Program

Create an interface for processing payments and implement it with different payment methods.

```java
interface PaymentMethod {
    void pay(double amount);
}

class UpiPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing UPI payment of Rs. " + amount);
    }
}

class CardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing card payment of Rs. " + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentMethod payment1 = new UpiPayment();
        PaymentMethod payment2 = new CardPayment();

        payment1.pay(250);
        payment2.pay(500);
    }
}
```

Expected output:

```text
Processing UPI payment of Rs. 250.0
Processing card payment of Rs. 500.0
```

This is a learning simulation, not a real payment integration. A production marketplace must use a trusted payment provider and must not store sensitive payment credentials directly.

## 9. When Should We Use Abstraction?

Use an abstract class when related classes share state or common implementation.

Use an interface when different classes need to support the same capability, even if they are otherwise unrelated.

Examples in the marketplace:
- `PaymentMethod` defines a payment contract.
- `Searchable` defines a search capability.
- `MarketplaceItem` can be an abstract base class if all item categories share common fields and behaviour.

## 10. Day 6 Tasks

- [ ] Create an abstract class named `MarketplaceItem`.
- [ ] Add an abstract method named `displayCategory()`.
- [ ] Create `Book` and `Electronics` subclasses.
- [ ] Create a `Searchable` interface.
- [ ] Implement the interface in an item-search class.
- [ ] Create two interfaces and implement both in one class.
- [ ] Explain the differences between abstract classes and interfaces.
- [ ] Run the payment-method simulation.
- [ ] Push the Day 6 notes to GitHub.

## 11. Key Takeaways

- Abstraction hides implementation details while exposing essential behaviour.
- Abstract classes can combine shared state, implemented methods and abstract methods.
- Interfaces define contracts that classes implement.
- A class can implement multiple interfaces.
- Interface references support flexible and loosely coupled code.
- Abstraction helps organize marketplace features such as searching, payments and item categories.
