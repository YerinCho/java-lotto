package domain.purchase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1000, 3456})
    @DisplayName("정상범위의 구입금액 테스트")
    void money (int value) {
        Money money = new Money(value);
        assertThat(money).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(ints = {-3000, 999})
    @DisplayName("정상범위 외의 구입금액 예외테스트")
    void validateMoney(int value) {
        assertThatThrownBy(() -> new Money(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 이상의 금액을 입력 해 주세요.");
    }

    @Test
    @DisplayName("구매 금액에 따른 몫(구매 가능 로또 갯수) 반환 테스트")
    void calculate() {
        Money money = new Money(3000);
        assertThat(money.calculateCount()).isEqualTo(3);
    }

}