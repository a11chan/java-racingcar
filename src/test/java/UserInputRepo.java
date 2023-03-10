public class UserInputRepo {
    private String cars;
    private int round;

    public UserInputRepo(String cars, int round) {
        this.cars = cars;
        this.round = round;
    }

    public String getCars() {
        return cars;
    }


    public int getRound() {
        return round;
    }
}
