package inputConsole;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class InputSaveTest {


    public void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    @DisplayName("자동차 이름: asdf1, 경기 횟수는 1로 가정")
    @Test
    public void 자동차_입력값_저장() {
        String testString = "asdf1";
        setInput(testString);

        Scanner scanner = new Scanner(System.in);
        String cars = scanner.nextLine();

        InputRepository userInputRepo = new InputRepository(cars, 1);
        assertThat(userInputRepo.getName()).isEqualTo("asdf1");
        assertThat(userInputRepo.getRound()).isEqualTo(1);
    }
    @DisplayName("자동차 이름: qwerty,dvorak, 경기 횟수는 1로 가정")
    @Test
    public void 자동차_입력값_긴이름_저장() {
        String testString = "qwerty,dvorak";
        setInput(testString);

        Scanner scanner = new Scanner(System.in);
        String cars = scanner.nextLine();

        InputRepository userInputRepo = new InputRepository(cars, 1);
        assertThat(userInputRepo.getName()).isEqualTo("qwerty,dvorak");
        assertThat(userInputRepo.getRound()).isEqualTo(1);
    }

    @DisplayName("자동차 이름: qwe rty , dvo rak , 경기 횟수는 1로 가정")
    @Test
    public void 자동차_입력값_공백포함_저장() {
        String testString = " qwe rty , dvo rak ";
        setInput(testString);

        Scanner scanner = new Scanner(System.in);
        String cars = scanner.nextLine();

        InputRepository userInputRepo = new InputRepository(cars, 1);
        assertThat(userInputRepo.getName()).isEqualTo(" qwe rty , dvo rak ");
        assertThat(userInputRepo.getRound()).isEqualTo(1);
    }
}
