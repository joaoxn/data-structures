public enum Urgency {
    IMMEDIATE   (0),
    VERY_URGENT (10, "VERY URGENT"),
    URGENT      (30),
    LESS_URGENT (60, "LESS URGENT"),
    NON_URGENT  (120, "NON URGENT");

    public final int waitTime;
    public final String name;

    Urgency(int waitTime, String name) {
        this.waitTime = waitTime;
        this.name = name;
    }

    Urgency(int waitTime) {
        this.waitTime = waitTime;
        this.name = this.name();
    }
}
