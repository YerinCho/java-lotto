package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyManagerTest {
    @ParameterizedTest
    @DisplayName("로또 구매 매수 계산")
    @CsvSource(value = {"1000,1", "2000,2", "3333,3"})
    void purchaseTest(int money, int result) {
        MoneyManager moneyManager = new MoneyManager(money);
        assertThat(moneyManager.purchase()).isEqualTo(result);
    }

    @DisplayName("금액 1000원 미만 예외처리 테스트")
    @Test
    void purchaseExceptionTest() {
        assertThatThrownBy(() -> MoneyManager.purchaseException(999))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
