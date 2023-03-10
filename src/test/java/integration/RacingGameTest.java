package integration;

import java.util.ArrayList;

//System.in, System.Out 테스트 방법 숙지 후 진행
public class RacingGameTest {

    private static final InputRepository inputRepo = new InputRepository();
    private static final Interpreter interpreter = new Interpreter();
    private static final CarController controller = new CarController();

    public static void main(String[] args) {
        inputRepo.saveCarNames();
        inputRepo.saveTotalRound();

        String carNames = inputRepo.getCarNames();
        int totalRound = inputRepo.getTotalRound();

        ArrayList<String> carList = interpreter.getCarList(carNames);
        while(!interpreter.isNameLengthOk(carList)) {
            inputRepo.saveCarNames();
            carNames = inputRepo.getCarNames();
            carList = interpreter.getCarList(carNames);
        }

        System.out.println();
        System.out.println("경기에 참가할 자동차입니다.");
        System.out.println(carList);
        System.out.println();
        System.out.println("경기에서 진행될 round 수입니다.");
        System.out.println(totalRound);
        System.out.println();

        ArrayList<Car> raceResult = controller.startRound(carList, totalRound);
        String winner = controller.getWinner(raceResult);
        System.out.println("최종 우승자는 " + winner + " 입니다.");
    }
}
