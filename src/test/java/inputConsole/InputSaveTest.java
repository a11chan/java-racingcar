package inputConsole;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputSaveTest {

    public void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @DisplayName("자동차 이름: asdf1, 경기 횟수는 1로 가정")
    @Test
    public void 자동차_입력값_저장() {
        String inputNames = "asdf1";
        setInput(inputNames);

        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();

        InputRepository userInputRepo = new InputRepository(carNames, 1);
        assertThat(userInputRepo.getName()).isEqualTo("asdf1");
        assertThat(userInputRepo.getRound()).isEqualTo(1);
    }

    @DisplayName("자동차 이름: qwerty,dvorak, 경기 횟수는 1로 가정")
    @Test
    public void 자동차_입력값_긴이름_저장() {
        String inputNames = "qwerty,dvorak";
        setInput(inputNames);

        Scanner scanner = new Scanner(System.in);
        String carNames = scanner.nextLine();

        assertThat(carNames).isEqualTo("qwerty,dvorak");
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
        String inputNames = "";
        setInput(inputNames);
        Scanner emptyNameScanner = new Scanner(System.in);
        if (!emptyNameScanner.hasNext()) {
            System.out.println("[ERROR] 자동차 이름을 입력해주세요.");
            System.out.print(">>> ");
        }
        String OkInput = "abc12,abc1,123";
        setInput(OkInput);
        Scanner OkInputScanner = new Scanner(System.in);
        String carNames = OkInputScanner.nextLine();
        System.out.println(carNames);
        assertThat(carNames).isEqualTo("abc12,abc1,123");
    }

    @Test
    public void 경기횟수_1_입력성공() {
        int inputRound = 1;
        setInput(String.valueOf(inputRound));
        Scanner roundScanner = new Scanner(System.in);
        int round = Integer.parseInt(roundScanner.nextLine());
        assertThat(round).isEqualTo(1);
    }
    @Test
    public void 경기횟수_5_입력성공() {
        int inputRound = 5;
        setInput(String.valueOf(inputRound));
        Scanner roundScanner = new Scanner(System.in);
        int round = Integer.parseInt(roundScanner.nextLine());
        assertThat(round).isEqualTo(5);
    }

}
