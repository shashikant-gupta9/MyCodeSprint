import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        // Create a priority queue
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Add elements to the priority queue
        priorityQueue.add(10);
        priorityQueue.add(20);
        priorityQueue.add(5);
        priorityQueue.add(15);

        // Display elements of the priority queue
        System.out.println("Priority Queue: " + priorityQueue);

        // Remove elements from the priority queue
        while (!priorityQueue.isEmpty()) {
            System.out.println("Removed: " + priorityQueue.poll());
        }
    }
}
