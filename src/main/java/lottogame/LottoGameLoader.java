package lottogame;

import lottogame.domain.LottoGame;
import lottogame.domain.PrizeRank;
import lottogame.dto.InputDto;
import lottogame.view.InputView;
import lottogame.view.OutputView;

import java.util.InputMismatchException;
import java.util.Map;

public class LottoGameLoader {
    public static void main(String[] args) {
        try {
            InputDto inputDto = InputView.receiveInput();
            LottoGame lottoGame = new LottoGame(inputDto.getLottos());
            Map<PrizeRank, Integer> resultMap = lottoGame.result(inputDto.getWinningLotto());
            OutputView.printResult(inputDto.readMoney(), resultMap);
        } catch (IllegalArgumentException | InputMismatchException e) {
            System.out.println(e.getMessage());
            InputView.clearBuffer();
            main(args);
        }
    }
}
