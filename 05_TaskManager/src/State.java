public enum State {
    OPEN(1, "Open"),
    IN_PROGRESS(2, "In Progress"),
    DONE(-2, "Done");

    private final int value;
    private final String displayValue;

    private State(int stateCode, String displayValue) {
        this.value = stateCode;
        this.displayValue = displayValue;
    }
}
