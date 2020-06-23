package domain;

import java.util.ArrayList;
import java.util.List;

import static domain.Lotto.LOTTO_LENGTH;

public class LottoFactory {

    private static LottoFactory lottoFactory;
    private final LottoNumbers lottoNumbers;

    private LottoFactory() {
        this.lottoNumbers = LottoNumbers.newLottoNumbers();
    }

    public static LottoFactory getLottoFactory() {
        if (lottoFactory == null) {
            lottoFactory = new LottoFactory();
        }
        return lottoFactory;
    }

    public List<LottoNumber> createAutoLotto() {
        lottoNumbers.shuffleLottoNumbers();
        List<LottoNumber> lottoNumbers = this.lottoNumbers.getLottoNumbers();
        List<LottoNumber> lotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_LENGTH; i++) {
            lotto.add(lottoNumbers.get(i));
        }
        return lotto;
    }

    public List<LottoNumber> createManualLotto(List<Integer> manualLottoNumbers) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int lottoNumber : manualLottoNumbers) {
            lottoNumbers.add(this.lottoNumbers.valueOf(lottoNumber));
        }
        return lottoNumbers;
    }

}
