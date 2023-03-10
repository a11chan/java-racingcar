package interpreter;

import inputConsole.InputRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class InterpreterTest {
    @Test
    public void 자동차_이름_분리() {
        String inputStr = "asdf1,qwer2,zxcv3";
        String[] dividedCar = inputStr.split(",");

        assertThat(dividedCar[0]).isEqualTo("asdf1");
        assertThat(dividedCar[1]).isEqualTo("qwer2");
        assertThat(dividedCar[2]).isEqualTo("zxcv3");
    }

    @Test
    public void 자동차_이름_분리_공백포함() {
        String inputStr = " as df1 , qw er2 , zx cv3 ";
        String[] dividedCar = inputStr.split(",");

        assertThat(dividedCar[0]).isEqualTo(" as df1 ");
        assertThat(dividedCar[1]).isEqualTo(" qw er2 ");
        assertThat(dividedCar[2]).isEqualTo(" zx cv3 ");
    }


    @Test
    public void 입력값을_trim후_스트림으로_변환() {
        String inputStr = " as df1 , qw er2 ";
        ArrayList<String> carList = getCarList(inputStr);
        assertThat(carList.get(0)).isEqualTo("as df1");
        assertThat(carList.get(1)).isEqualTo("qw er2");
    }

    @Test
    public void 입력값을_trim후_스트림으로_변환_1대일경우() {
        String inputStr = " as df1 ";
        ArrayList<String> carList = getCarList(inputStr);
        assertThat(carList.get(0)).isEqualTo("as df1");
    }


    @Test
    public void 자동차이름이_6글자인_경우_확인() {
        String inputStr = "123456,12345";

        ArrayList<String> carList = getCarList(inputStr);

        Long longNameCount = carList.stream().filter(s -> s.length() >= 6).count();
        assertThat(longNameCount).isEqualTo(1);
    }

    @Test
    public void 자동차이름이_6글자인_경우_예외_던짐() {
        //입력 저장소에서 입력값 불러오기
        String inputStr = "123456,12345";

        assertThatThrownBy(() -> validateCarNameAndThrow(getCarList(inputStr)))
            .isInstanceOf(IllegalArgumentException.class);

        // To do : 박재성 님 강의 코드 컨벤션 확인
    }

    @Test
    public void 자동차이름이_6글자인_경우_재입력안내() {
        //입력 저장소에서 입력값 불러오기
        String inputStr = "123456,12345";
        assertThat(isNameLengthOk(getCarList(inputStr))).isEqualTo(false);
    }

    @Test
    public void 자동차이름이_정상인_경우_통과() {
        //입력 저장소에서 입력값 불러오기
        String inputStr = "1234,12345";
        assertThat(isNameLengthOk(getCarList(inputStr))).isEqualTo(true);
    }

    @Test
    public void 경기횟수가_1이상일_경우_통과() {
        String inputStr = "1234,12345";
        int round = 1;
        InputRepository savedInput = new InputRepository(inputStr, round);
        assertThat(savedInput.getRound()).isEqualTo(1);
    }

    private static boolean isNameLengthOk(ArrayList<String> carList) {
        long longNameCount = carList.stream().filter(s -> s.length() >= 6).count();
        if(longNameCount != 0) {
            System.out.println("[ERROR] 자동차 이름은 5글자 이하로 만들어주세요.");
            System.out.println("입력콘솔에서 입력기 호출");
            return false;
        }
        return true;
    }

    private static ArrayList<String> getCarList(String inputStr) {
        String[] dividedCar = inputStr.split(",");
        return Stream.of(dividedCar)
            .map(String::trim)
            .collect(Collectors.toCollection(ArrayList::new));
    }

    //미사용, 참고용
    private static void validateCarNameAndThrow(ArrayList<String> carList) {
        long longNameCount = carList.stream().filter(s -> s.length() >= 6).count();
        if(longNameCount != 0) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 5글자 이하로 만들어주세요.");
        }
        //이후 입력콘솔에서 입력기 호출
    }
}
