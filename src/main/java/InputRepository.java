import java.util.Scanner;

public class InputRepository {
    private String carNames;
    private int roundCount;

    public void saveCarNames() {
        printWelcomeMssage();
        Scanner inputScanner = new Scanner(System.in);
        String carNames = inputScanner.nextLine();
        while (carNames.isEmpty()) {
            printReInputMsg();
            carNames = inputScanner.nextLine();
            if (isNotEmpty(carNames)) break;
        }
        while (carNames.isBlank()) {
            printReInputMsg();
            carNames = inputScanner.nextLine();
            if (isNotBlank(carNames)) break;
        }
        this.carNames = carNames;
    }

    public String getCarNames() {
        return carNames;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void saveRoundCount() {
        System.out.println("경기할 횟수를 입력해주세요.");
        System.out.println("(1 이상의 정수)");
        Scanner inputScanner = new Scanner(System.in);

        if (inputScanner.hasNextInt()) {
            roundCount = inputScanner.nextInt();
        } else {
            System.out.println("[ERROR] 1이상의 정수로 입력해주세요.");
            saveRoundCount();
        }
        while (roundCount <= 0) {
            System.out.println("[ERROR] 1이상의 정수로 입력해주세요.");
            System.out.print(">>>");
            roundCount = inputScanner.nextInt();
            if (1 <= roundCount) break;
        }
    }


    private static boolean isNotBlank(String carNames) {
        if (!carNames.isBlank()) {
            System.out.println("carNames = " + carNames);
            return true;
        }
        return false;
    }

    private static boolean isNotEmpty(String carNames) {
        if (!carNames.isEmpty()) {
            System.out.println("carNames = " + carNames);
            return true;
        }
        return false;
    }

    private static void printReInputMsg() {
        System.out.println("[ERROR] 다시 입력해주세요.");
        System.out.print(">>>");
    }

    private static void printWelcomeMssage() {
        System.out.println();
        System.out.println("경기에 참가할 자동차 이름을 입력해주세요.");
        System.out.println("자동차 이름은 5글자 이하, 쉽표(,)로 구분합니다.");
        System.out.print(">>>");
    }

}
