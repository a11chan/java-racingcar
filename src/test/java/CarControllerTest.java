
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;


import static org.assertj.core.api.Assertions.assertThat;

public class CarControllerTest {

    @DisplayName("자동차 5대 생성 검증")
    @Test
    public void makeCarContainer() {
        String carNames = "  1 2 a 4 5  ,  12   34,1 2 3,1 2,   1";
        ArrayList<Car> carContainer = getCarContainer(carNames);
        assertThat((long) carContainer.size()).isEqualTo(5);
        carContainer.forEach(car -> System.out.println(car.getName()));
    }

    @DisplayName("100라운드 진행 시 자동차 1대 위치 계산")
    @Test
    public void moveCar() {
        String carNames = "가나다";
        int roundCount = 100;

        ArrayList<Car> carContainer = startRound(carNames, roundCount);

        assertThat(carContainer.get(0).getPosition() >= 0).isTrue();
        System.out.println("carContainer.get(0).getPosition() = " + carContainer.get(0).getPosition());
    }

    @DisplayName("100라운드 진행 시 자동차 5대 위치 계산")
    @Test
    public void moveCar2() {
        String carNames = "가,가나,가나다,가나다라,가나다라마";
        int roundCount = 100;

        ArrayList<Car> carContainer = startRound(carNames, roundCount);

        int allCarPositionTotal = carContainer.stream()
            .mapToInt(Car::getPosition)
            .sum();
        assertThat(allCarPositionTotal).isNotEqualTo(0);
        System.out.println("allCarPositionTotal = " + allCarPositionTotal);
        carContainer.forEach(car -> System.out.println(car.getName()));
    }


    @DisplayName("50라운드 진행 시 자동차 5대 위치 출력")
    @Test
    public void moveCar3() {
        String carNames = "가,가나,가나다,가나다라,가나다라마";
        int roundCount = 50;

        ArrayList<Car> carContainer = startRound(carNames, roundCount);
        carContainer.forEach(Car::printResult);
        System.out.println("10라운드 진행 시 자동차 5대 위치 출력 테스트 -- 끝");
    }


    @DisplayName("50라운드 진행 시 자동차 5대 승자 출력")
    @Test
    public void moveCar4() {
        String carNames = "가,가나,가나다,가나다라,가나다라마";
        int roundCount = 50;

        ArrayList<Car> carContainer = startRound(carNames, roundCount);
        carContainer.forEach(Car::printResult);
        System.out.println("10라운드 진행 시 자동차 5대 위치 출력 테스트 -- 끝");
    }

    private static ArrayList<Car> startRound(String carNames, int roundCount) {
        ArrayList<Car> carContainer = getCarContainer(carNames);
        for (int round = 0; round < roundCount; round++) {
            carContainer.forEach(Car::moveCar);
        }
        return carContainer;
    }

    private static ArrayList<Car> getCarContainer(String carNames) {
        Interpreter interpreter = new Interpreter();
        return interpreter.getCarList(carNames).stream()
            .map(Car::new)
            .collect(Collectors.toCollection(ArrayList::new));
    }
}
