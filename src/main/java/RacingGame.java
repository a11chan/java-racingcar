import java.util.ArrayList;

public class RacingGame {

    public static void main(String[] args) {
        InputConsole inputRepository = new InputConsole();
        inputRepository.saveCarNames();
        inputRepository.saveTotalRound();

        String carNames = inputRepository.getCarNames();
        int totalRound = inputRepository.getTotalRound();

        Interpreter interpreter = new Interpreter();
        ArrayList<String> carList = interpreter.getCarList(carNames);
        while(!interpreter.isNameLengthOk(carList)) {
            inputRepository.saveCarNames();
            carNames = inputRepository.getCarNames();
            carList = interpreter.getCarList(carNames);
        }

        System.out.println();
        System.out.println("경기에 참가할 자동차입니다.");
        System.out.println(carList);
        System.out.println();
        System.out.println("경기에서 진행될 round 수입니다.");
        System.out.println(totalRound);
        System.out.println();

        CarController controller = new CarController();
        ArrayList<Car> raceResult = controller.startRound(carList, totalRound);
        String winner = controller.getWinner(raceResult);
        System.out.println("최종 우승자는 " + winner + "입니다.");
    }
}
