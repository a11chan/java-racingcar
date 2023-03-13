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

    //todo: 10, 3이 의미하는 바를 모를 수 있으니 final 문자로 표현 필
    public void moveCar() {
        raceCount++;
        if ((int) (Math.random() * 10) > 3) {
            position++;
        }
        printResult();
    }
}
