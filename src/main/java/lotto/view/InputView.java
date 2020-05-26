package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {
    public static final Scanner SCANNER = new Scanner(System.in);
    private static final String WINNING_NUMBER_DELIMITER = ",";

    private InputView() {
    }

    public static Long askTotalMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return Long.valueOf(SCANNER.nextLine());
    }

    public static Set<Integer> askLastWeekWinningNumbers() {
        System.out.println("지난주 당첨번호를 입력해주세요.");
        String winningNumbers = SCANNER.nextLine();
        return Arrays.stream(winningNumbers.split(WINNING_NUMBER_DELIMITER))
                .map(String::trim)
                .map(Integer::valueOf)
                .collect(Collectors.toSet());
    }

    public static int askBonusNumber() {
        System.out.println("보너스 볼을 입력해주세요");
        return Integer.parseInt(SCANNER.nextLine());
    }
}
