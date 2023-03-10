public class InputRepository {
    private final String name;
    private final int round;

    public InputRepository(String name, int round) {
        this.name = name;
        this.round = round;
    }

    public int getRound() {
        return round;
    }
}
