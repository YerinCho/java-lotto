package domain.purchase;

public class Money {
    private static final String MONEY_INPUT_ERROR_MESSAGE = "1000원 이상의 금액을 입력 해 주세요.";
    private static final int MIN_MONEY = 1000;
    private final int money;

    public Money(final int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < MIN_MONEY) {
            throw new IllegalArgumentException(MONEY_INPUT_ERROR_MESSAGE);
        }
    }

    public int calculateCount() {
        return this.money / MIN_MONEY;
    }
}
