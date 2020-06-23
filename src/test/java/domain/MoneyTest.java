package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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
    void validateMoney (int value) {
        assertThatThrownBy(() -> new Money(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1000원 이상의 금액을 입력 해 주세요.");
    }

}