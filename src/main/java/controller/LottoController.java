package controller;

import domain.purchase.Count;
import domain.purchase.Money;
import domain.purchase.PurchaseCounts;
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
        Count manualCount = Count.createManualCount(money, inputView.inputManualCount());
        PurchaseCounts purchaseCounts = new PurchaseCounts(Count.createAutoCount(money, manualCount), manualCount);
    }

}
