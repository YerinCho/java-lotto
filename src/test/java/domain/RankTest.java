package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @Test
    @DisplayName("로또 한장에 따른 등수 구하기")
    void calculate() {
        Lotto firstLotto = Lotto.createManualLotto(StringUtils.splitToInteger("1,2,3,4,5,6"));
        Lotto thirdLotto = Lotto.createManualLotto(StringUtils.splitToInteger("1,2,3,4,5,7"));
        Lotto secondLotto = Lotto.createManualLotto(StringUtils.splitToInteger("1,2,3,4,5,8"));
        Lotto fifthLotto = Lotto.createManualLotto(StringUtils.splitToInteger("1,2,3,10,15,16"));
        Lotto noneLotto = Lotto.createManualLotto(StringUtils.splitToInteger("11,12,13,14,15,16"));

        WinningLotto winningLotto = new WinningLotto(
                Lotto.createManualLotto(StringUtils.splitToInteger("1,2,3,4,5,6")), new LottoNumber(8));

        assertThat(Rank.findRank(firstLotto, winningLotto)).isEqualTo(Rank.FIRST);
        assertThat(Rank.findRank(secondLotto, winningLotto)).isEqualTo(Rank.SECOND);
        assertThat(Rank.findRank(thirdLotto, winningLotto)).isEqualTo(Rank.THIRD);
        assertThat(Rank.findRank(fifthLotto, winningLotto)).isEqualTo(Rank.FIFTH);
        assertThat(Rank.findRank(noneLotto, winningLotto)).isEqualTo(Rank.NONE);
    }

}