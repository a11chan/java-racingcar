import java.util.ArrayList;
import java.util.stream.Collectors;

class CarController {

    public ArrayList<Car> startRound(String carNames, int roundCount) {
        ArrayList<Car> carContainer = getCarContainer(carNames);
        for (int round = 0; round < roundCount; round++) {
            carContainer.forEach(Car::moveCar);
            System.out.println();
        }
        return carContainer;
    }

    public ArrayList<Car> getCarContainer(String carNames) {
        Interpreter interpreter = new Interpreter();
        return interpreter.getCarList(carNames).stream()
            .map(Car::new)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public String getWinner(ArrayList<Car> carContainer) {
        int max = carContainer.stream().mapToInt(Car::getPosition).max().getAsInt();
        return carContainer.stream()
            .filter(car -> car.getPosition() == max)
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }
}
