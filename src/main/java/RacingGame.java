import java.util.ArrayList;

public class RacingGame {
    public static void main(String[] args) {
        InputRepository inputRepo = new InputRepository();
        inputRepo.saveCarNames();
        inputRepo.saveTotalCount();

        String carNames = inputRepo.getCarNames();
        int totalCount = inputRepo.getTotalCount();

        Interpreter interpreter = new Interpreter();
        ArrayList<String> carList = interpreter.getCarList(carNames);
        while(!interpreter.isNameLengthOk(carList)) {
            inputRepo.saveCarNames();
            carNames = inputRepo.getCarNames();
            carList = interpreter.getCarList(carNames);
        }

        System.out.println("경기에 참가할 자동차입니다.");
        System.out.println(carList);
        System.out.println();
        System.out.println("경기에서 진행될 round 수입니다.");
        System.out.println(totalCount);
        System.out.println();
    }
}
