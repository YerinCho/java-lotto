package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int LOTTO_LENGTH = 6;
    private static final LottoFactory lottoFactory = LottoFactory.getLottoFactory();
    private final List<LottoNumber> lotto;

    private Lotto(final List<LottoNumber> lotto) {
        validate(lotto);
        this.lotto = lotto;
    }

    public static Lotto createAutoLotto() {
        return new Lotto(lottoFactory.createAutoLotto());
    }

    public static Lotto createManualLotto(List<Integer> manualLottoNumbers) {
        return new Lotto(lottoFactory.createManualLotto(manualLottoNumbers));
    }

    private void validate(List<LottoNumber> lotto) {
        if (lotto == null || lotto.isEmpty() || lotto.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 한장은 6개의 숫자로 이루어져 있어야 합니다.");
        }
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    @Override
    public String toString() {
        Collections.sort(lotto);
        return lotto.toString();
    }

}
