package utils;

import org.assertj.core.internal.bytebuddy.build.ToStringPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Test
    @DisplayName("string->int 변경 예외처리 테스트")
    void parseInt() {
        String input = "스물셋";
        assertThatThrownBy(() -> StringUtils.parseInt("스물셋"))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("잘못된 문자 입력: "+input);
    }

}