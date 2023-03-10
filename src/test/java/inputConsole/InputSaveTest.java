package inputConsole;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputSaveTest {
    String carNames;
    int round;

    public static void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    private static String getOkCarNames(String okInput) {
        setInput(okInput);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    private static String getCarNames(String carNames) {
        setInput(carNames);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int getRound(int inputRound) {
        setInput(String.valueOf(inputRound));
        Scanner roundScanner = new Scanner(System.in);
        return Integer.parseInt(roundScanner.nextLine());
    }

    @DisplayName("자동차 이름: asdf1, 경기 횟수는 1로 가정")
    @Test
    public void 자동차_입력값_저장() {
        String carNames = "asdf1";
        this.carNames = getCarNames(carNames);
        this.round = 1;
        assertThat(this.carNames).isEqualTo("asdf1");
        assertThat(this.round).isEqualTo(1);
    }

    @DisplayName("자동차 이름: qwerty,dvorak, 경기 횟수는 1로 가정")
    @Test
    public void 자동차_입력값_긴이름_저장() {
        String carNames = "qwerty,dvorak";
        this.carNames = getCarNames(carNames);
        assertThat(this.carNames).isEqualTo("qwerty,dvorak");
    }

    @Test
    public void 자동차_이름에_빈문자열시_예외발생() {
        String inputNames = "";
        setInput(inputNames);
        Scanner scanner = new Scanner(System.in);
        assertThatThrownBy(() -> {
            if (!scanner.hasNext()) {
                throw new NoSuchElementException("[ERROR] 자동차 이름을 입력해주세요.");
            }
        });
    }


    @Test
    public void 자동차_이름에_빈문자열시_재입력후_성공() {
        String carNames = "";
        setInput(carNames);
        Scanner emptyNameScanner = new Scanner(System.in);
        if (!emptyNameScanner.hasNext()) {
            System.out.println("[ERROR] 자동차 이름을 입력해주세요.");
            System.out.print(">>> ");
        }
        String okNames = "abc12,abc1,123";
        System.out.println(getOkCarNames(okNames));
        this.carNames = getOkCarNames(okNames);
        assertThat(this.carNames).isEqualTo("abc12,abc1,123");
    }

    @Test
    public void 경기횟수_1_입력성공() {
        int inputRound = 1;
        this.round = getRound(inputRound);
        assertThat(this.round).isEqualTo(1);
    }

    @Test
    public void 경기횟수_5_입력성공() {
        int inputRound = 5;
        this.round = getRound(inputRound);
        assertThat(this.round).isEqualTo(5);
    }

    @Test
    public void 경기횟수가_0이하이면_재입력후_성공() {
        int inputRound = 0;
        int round = getRound(inputRound);
        if (!(round >= 1)) {
            System.out.println("[ERROR] 1이상의 정수로 입력해주세요.");
            System.out.print(">>> ");
        }
        int OkInput = 1;
        System.out.println(getRound(OkInput));
        this.round = getRound(OkInput);
        assertThat(this.round).isEqualTo(1);
    }

    @Test
    public void 경기횟수가_음수이면_재입력후_성공() {
        int inputRound = -1;
        int round = getRound(inputRound);
        if (!(round >= 1)) {
            System.out.println("[ERROR] 1이상의 정수로 입력해주세요.");
            System.out.print(">>> ");
        }
        int OkInput = 1;
        System.out.println(getRound(OkInput));
        this.round = getRound(OkInput);
        assertThat(this.round).isEqualTo(1);
    }
    @Test
    public void 경기횟수에_빈문자열시_재입력후_성공() {
        String emptyRound = "";
        setInput(emptyRound);
        Scanner emptyRoundScanner = new Scanner(System.in);
        if (!emptyRoundScanner.hasNext()) {
            System.out.println("[ERROR] 경기횟수를 입력해주세요.");
            System.out.print(">>> ");
        }
        int OkInput = 1;
        System.out.println(getRound(OkInput));
        this.round = getRound(OkInput);
        assertThat(this.round).isEqualTo(1);
    }
}
