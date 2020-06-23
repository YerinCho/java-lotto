package view;

import domain.Lotto;
import domain.Lottos;
import domain.purchase.PurchaseCounts;

public class OutputView {
    public void showPurchaseCount(PurchaseCounts purchaseCounts) {
        System.out.printf("자동으로 %d장, 수동으로 %d장을 구입했습니다.\n", purchaseCounts.getAutoCount(), purchaseCounts.getManualCount());
    }

    public void showLottos(Lottos lottos) {
        for (Lotto lottoNumbers : lottos.getLottos()) {
            showLotto(lottoNumbers);
        }
    }

    private void showLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }
}
