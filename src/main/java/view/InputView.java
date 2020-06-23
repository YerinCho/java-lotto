package view;

import utils.StringUtils;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입 금액을 입력해주세요.(숫자만 입력)");
        return StringUtils.parseInt(SCANNER.nextLine());
    }

    public int inputManualCount() {
        System.out.println("구매할 수동 로또 개수를 입력해주세요.(숫자만 입력)");
        return StringUtils.parseInt(SCANNER.nextLine());
    }
}
