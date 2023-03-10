public class Car {

    private final String name;
    private int position;

    public void printResult() {
        System.out.println(name + " : " + "-".repeat(position) + " " + position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void moveCar() {
        if ((int) (Math.random() * 10) > 3) {
            position++;
        }
    }
}
