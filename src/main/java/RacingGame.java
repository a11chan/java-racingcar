public class RacingGame {
    public static void main(String[] args) {
        InputRepository inputRepo = new InputRepository();
        inputRepo.saveCarNames();
        inputRepo.saveRoundCount();

        String carNames = inputRepo.getCarNames();
        int roundCount = inputRepo.getRoundCount();
    }
}
