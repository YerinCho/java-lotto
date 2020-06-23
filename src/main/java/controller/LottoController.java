package controller;

import domain.Money;
import view.InputView;
import view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        buyLotto();
    }

    private void buyLotto() {
        Money money = new Money(inputView.inputMoney());
    }

}
