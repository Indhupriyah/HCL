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