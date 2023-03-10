package integration;

public class Car {

    private final String name;
    private int position;
    private int raceCount;

    public void printResult() {
        System.out.println(name + " : " + "-".repeat(position));

    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public int getRaceCount() {
        return raceCount;
    }

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveCar() {
        raceCount++;
        if ((int) (Math.random() * 10) > 3) {
            position++;
        }
        printResult();
    }
}
