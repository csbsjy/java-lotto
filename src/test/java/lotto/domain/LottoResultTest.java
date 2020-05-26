package lotto.domain;

import lotto.domain.result.LottoPrize;
import lotto.domain.result.LottoResult;
import lotto.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoResultTest {

    @DisplayName("구매금액에 따른 이익률을 반환한다")
    @Test
    void profit() {
        List<LottoPrize> statistics = createStatistics();
        LottoResult lottoResult = new LottoResult(statistics);

        assertAll(
                () -> assertThat(lottoResult.getRateOfProfit(new Money(60000))).isEqualTo(1),
                () -> assertThat(lottoResult.getRateOfProfit(new Money(120000))).isEqualTo(0.5)
        );
    }

    private List<LottoPrize> createStatistics() {
        return Arrays.asList(LottoPrize.FIFTH, LottoPrize.FIFTH, LottoPrize.FOURTH);
    }

}
