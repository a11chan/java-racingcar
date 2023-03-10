import java.util.Scanner;

public class InputRepository {
    private String carNames;
    private int totalRound;

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

    public int getTotalRound() {
        return totalRound;
    }

    public void saveTotalRound() {
        System.out.println("경기할 횟수를 입력해주세요.");
        System.out.println("(1 이상의 정수)");
        Scanner inputScanner = new Scanner(System.in);

        if (inputScanner.hasNextInt()) {
            totalRound = inputScanner.nextInt();
        } else {
            System.out.println("[ERROR] 1이상의 정수로 입력해주세요.");
            saveTotalRound();
        }
        while (totalRound <= 0) {
            System.out.println("[ERROR] 1이상의 정수로 입력해주세요.");
            System.out.print(">>>");
            if(!inputScanner.hasNextInt()) {
                System.out.println("[ERROR] 1이상의 정수로 입력해주세요.");
                saveTotalRound();
            } else {
                totalRound = inputScanner.nextInt();
            }
            if (1 <= totalRound) break;
        }
    }


    private static boolean isNotBlank(String carNames) {
        return !carNames.isBlank();
    }

    private static boolean isNotEmpty(String carNames) {
        return !carNames.isEmpty();
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
