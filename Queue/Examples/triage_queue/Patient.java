package triage_queue;

import java.time.LocalDateTime;

public class Patient implements Comparable<Patient> {
    String name;
    Urgency priority;
    LocalDateTime dateTime;


    public Patient(String name, Urgency priority, LocalDateTime dateTime) {
        this.name = name;
        this.priority = priority;
        this.dateTime = dateTime;
    }

    @SuppressWarnings("unused")
    public Patient(String name, Urgency priority) {
        this(name, priority, LocalDateTime.now());
    }

    @Override
    public int compareTo(Patient o) {
        LocalDateTime hisMaximumWaiting = o.dateTime.plusMinutes(o.priority.waitTime);
        LocalDateTime myMaximumWaiting = this.dateTime.plusMinutes(this.priority.waitTime);

        int waitingComparison = myMaximumWaiting.compareTo(hisMaximumWaiting);
        if (waitingComparison != 0) return waitingComparison;

        int dateComparison = this.dateTime.compareTo(o.dateTime);
        if (dateComparison != 0) return dateComparison;

        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "triage_queue.Patient{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", dateTime=" + dateTime +
                '}';
    }
}