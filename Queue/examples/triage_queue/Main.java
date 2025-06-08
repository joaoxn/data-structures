package triage_queue;

import java.time.LocalDateTime;
import java.util.PriorityQueue;

// *Example using: PriorityQueue.

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Patient> pq = new PriorityQueue<>();

        LocalDateTime now = LocalDateTime.now();

        pq.add(new Patient("João",  Urgency.URGENT,      now.minusMinutes(60))); // Arrived 60 minutes ago
        pq.add(new Patient("Igor",  Urgency.URGENT,      now.minusMinutes(45))); // Arrived 45 minutes ago
        pq.add(new Patient("José",  Urgency.VERY_URGENT, now.minusMinutes(35))); // Arrived 35 minutes ago
        pq.add(new Patient("Maria", Urgency.IMMEDIATE,   now.minusMinutes(20))); // Arrived 25 minutes ago
        pq.add(new Patient("Lucas", Urgency.IMMEDIATE,   now.minusMinutes(20))); // Arrived 25 minutes ago

        System.out.print(pq.remove().name);
        while (!pq.isEmpty()) {
            System.out.printf(", %s", pq.remove().name);
        }
    }
}
