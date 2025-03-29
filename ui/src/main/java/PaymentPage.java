import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {

    public static PaymentPage open() {
        Selenide.open("");
        return new PaymentPage();
    }

    private final SelenideElement amountTicketField = $("[data-qa-id='payment_amount_input']");
    private final SelenideElement cardNumberField = $("[data-qa-id='payment_card_number_input']");
    private final SelenideElement cardHolderField = $("[data-qa-id='payment_card_holder_input']");
    private final SelenideElement cardCVVField = $("[data-qa-id='payment_card_cvc_input']");
    private final SelenideElement cardMonthField = $x("//select[@aria-hidden='true' and preceding-sibling::button[@id='month']]");
    private final SelenideElement cardYearField = $x("//select[@aria-hidden='true' and preceding-sibling::button[@id='year']]");
    private final SelenideElement submitBtn = $("[data-qa-id='payment_submit_button']");


    private final String VALID_CARD_NUMBER = "4242424242424242";
    private final String VALID_CARD_MONTH = "Декабрь";
    private final String VALID_CARD_YEAR = "2025";
    private final String VALID_CARD_SVV = "123";
    private final String VALID_CARD_HOLDER = "Ivan Ivanov";

    public void inputCardData(String amountOfTicket) {
        amountTicketField.clear();
        amountTicketField.setValue(amountOfTicket);
        cardNumberField.setValue(VALID_CARD_NUMBER);
        cardHolderField.setValue(VALID_CARD_HOLDER);
        cardCVVField.setValue(VALID_CARD_SVV);
        cardMonthField.selectOption(VALID_CARD_MONTH);
        cardYearField.selectOption(VALID_CARD_YEAR);
    }

    public void sendCardData() {
        submitBtn.click();
    }
}
