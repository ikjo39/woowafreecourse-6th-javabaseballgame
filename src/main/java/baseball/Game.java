package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> computerNumbers = createComputerNumbers();
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> userNumbers = new GameInput().convertInputToUserNumbers();
        Score score = calculateScore(computerNumbers, userNumbers);
    }

    private Score calculateScore(List<Integer> computerNumbers, List<Integer> userNumbers) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < computerNumbers.size(); i++) {
            int nowComputer = computerNumbers.get(i);
            int nowUser = userNumbers.get(i);
            if (nowComputer == nowUser) {
                strike++;
            } else if (computerNumbers.contains(nowUser)) {
                ball++;
            }
        }
        return new Score(strike, ball);
    }

    private List<Integer> createComputerNumbers() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
}
