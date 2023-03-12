
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.assertj.core.api.Assertions.assertThat;

public class CarControllerTest {

    private CarController controller;

    @BeforeEach
    void setUp() {
        controller = new CarController();
    }

    @DisplayName("자동차 5대 생성 검증")
    @Test
    public void makeCarContainer() {
        String carNames = "  1 2 a 4 5  ,  12   34,1 2 3,1 2,   1";
        ArrayList<Car> carContainer = controller.getCarContainer(carNames);
        assertThat((long) carContainer.size()).isEqualTo(5);
    }

    @DisplayName("1라운드 진행 시 자동차 1대 위치 계산")
    @Test
    public void moveCar() {
        String carNames = "아스라다";
        int roundCount = 1;

        ArrayList<Car> carContainer = controller.startRound(carNames, roundCount);

        assertThat(carContainer.get(0).getPosition() >= 0).isTrue();
        System.out.println("carContainer.get(0).getPosition() = " + carContainer.get(0).getPosition());
    }

    @DisplayName("1라운드 진행 시 자동차 5대 위치 계산")
    @Test
    public void moveCar2() {
        String carNames = "아스라다,엑스페리온,오거";
        int roundCount = 1;

        ArrayList<Car> carContainer = controller.startRound(carNames, roundCount);

        int allCarPositionTotal = carContainer.stream()
            .mapToInt(Car::getPosition)
            .sum();
        assertThat(allCarPositionTotal).isNotEqualTo(0);
        System.out.println("allCarPositionTotal = " + allCarPositionTotal);
    }


    @DisplayName("3라운드 진행 시 자동차 3대의 경기횟수는 각 3이다")
    @Test
    public void moveCar3() {
        String carNames = "아스라다,엑스페리온,오거";
        int roundCount = 3;

        int sum = controller.startRound(carNames, roundCount).stream()
            .mapToInt(Car::getRaceCount).sum();

        assertThat(sum / roundCount).isEqualTo(3);
    }


    @DisplayName("5라운드 진행 시 자동차 3대 승자 출력 & notBlack")
    @Test
    public void moveCar4() {
        String carNames = "아스라다,엑스페리온,오거";
        int roundCount = 5;

        ArrayList<Car> carContainer = controller.startRound(carNames, roundCount);

        String winner = controller.getWinner(carContainer);

        assertThat(winner).isNotBlank();
        System.out.println("최종 우승자는 " + winner + " 입니다.");
    }


    @DisplayName("5라운드 진행 시 자동차 3대 승자 출력 & notEmpty")
    @Test
    public void moveCar5() {
        String carNames = "아스라다,엑스페리온,오거";
        int roundCount = 5;

        ArrayList<Car> carContainer = controller.startRound(carNames, roundCount);

        String winner = controller.getWinner(carContainer);

        assertThat(winner).isNotEmpty();
        System.out.println("최종 우승자는 " + winner + " 입니다.");
    }

}
