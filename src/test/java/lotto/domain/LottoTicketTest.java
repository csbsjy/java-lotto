package lotto.domain;

import lotto.domain.ticket.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class LottoTicketTest {

    static Stream<Arguments> lottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @DisplayName("6개가 아닌 숫자로 로또티켓생성을 시도하면 익셉션을 던진다")
    @MethodSource("lottoNumbers")
    @ParameterizedTest
    void generate(List<Integer> numbers) {
        assertThatThrownBy(() -> new LottoTicket(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 반드시 6개여야 합니다");
    }

}