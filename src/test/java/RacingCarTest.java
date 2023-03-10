import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;


public class RacingCarTest {
    @Test
    public void emptyTest() {
    }

    @Test
    public void 자동차_이름_분리() {
        String inputStr = "asdf1,qwer2,zxcv3";
        String[] cars = inputStr.split(",");

        assertThat(cars[0]).isEqualTo("asdf1");
        assertThat(cars[1]).isEqualTo("qwer2");
        assertThat(cars[2]).isEqualTo("zxcv3");
    }

    @Test
    public void 자동차_이름_분리_공백포함() {
        String inputStr = " as df1 , qw er2 , zx cv3 ";
        String[] cars = inputStr.split(",");

        assertThat(cars[0]).isEqualTo(" as df1 ");
        assertThat(cars[1]).isEqualTo(" qw er2 ");
        assertThat(cars[2]).isEqualTo(" zx cv3 ");
    }

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

        UserInputRepo userInputRepo = new UserInputRepo(cars, 1);
        assertThat(userInputRepo.getCars()).isEqualTo("asdf1");
        assertThat(userInputRepo.getRound()).isEqualTo(1);
    }
    @DisplayName("자동차 이름: qwerty,dvorak, 경기 횟수는 1로 가정")
    @Test
    public void 자동차_입력값_긴이름_저장() {
        String testString = "qwerty,dvorak";
        setInput(testString);

        Scanner scanner = new Scanner(System.in);
        String cars = scanner.nextLine();

        UserInputRepo userInputRepo = new UserInputRepo(cars, 1);
        assertThat(userInputRepo.getCars()).isEqualTo("qwerty,dvorak");
        assertThat(userInputRepo.getRound()).isEqualTo(1);
    }

    @DisplayName("자동차 이름: qwe rty , dvo rak , 경기 횟수는 1로 가정")
    @Test
    public void 자동차_입력값_공백포함_저장() {
        String testString = " qwe rty , dvo rak ";
        setInput(testString);

        Scanner scanner = new Scanner(System.in);
        String cars = scanner.nextLine();

        UserInputRepo userInputRepo = new UserInputRepo(cars, 1);
        assertThat(userInputRepo.getCars()).isEqualTo(" qwe rty , dvo rak ");
        assertThat(userInputRepo.getRound()).isEqualTo(1);
    }
}
