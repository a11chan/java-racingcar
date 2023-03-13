import java.util.ArrayList;
import java.util.stream.Collectors;

public class CarController {
    // todo: List가 나은지 ArrayList가 나은지 알아볼 것
    public ArrayList<Car> startRound(ArrayList<String> carList, int totalRound) {
        ArrayList<Car> carContainer = getCarContainer(carList);
        for (int round = 0; round < totalRound; round++) {
            carContainer.forEach(Car::moveCar);
            System.out.println();
        }
        return carContainer;
    }

    public ArrayList<Car> getCarContainer(ArrayList<String> carList) {
        return carList.stream()
            .map(Car::new)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    //todo: controller에 있는 게 자연스러운지 확인
    public String getWinner(ArrayList<Car> carContainer) {
        int max = carContainer.stream().mapToInt(Car::getPosition).max().getAsInt();
        return carContainer.stream()
            .filter(car -> car.getPosition() == max)
            .map(Car::getName)
            .collect(Collectors.joining(", "));
    }
}
