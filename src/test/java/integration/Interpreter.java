package integration;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Interpreter {
    public boolean isNameLengthOk(ArrayList<String> carList) {
        long longNameCount = carList.stream().filter(s -> s.length() >= 6).count();
        if (longNameCount >= 1) {
            System.out.println("[ERROR] 자동차 이름은 5글자 이하로 만들어주세요.");
            return false;
        }
        return true;
    }
    public ArrayList<String> getCarList(String inputStr) {
        String[] dividedCar = inputStr.split(",");
        return Stream.of(dividedCar)
            .map(String::trim)
            .collect(Collectors.toCollection(ArrayList::new));
    }
}
