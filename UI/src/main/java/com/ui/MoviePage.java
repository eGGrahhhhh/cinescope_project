package com.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MoviePage {

    public static MoviePage open() {
        Selenide.open("/movies"); //Добавить возможность открыть конкретный фильм/страницу?
        return new MoviePage();
    }

    private final SelenideElement buyTicketBtn = $(byText("Купить билет"));
    private final SelenideElement feedbackField = $(byName("text"));
    private final SelenideElement sendFeedbackBtn = Selenide.$("[type='submit']");
    private final SelenideElement listOfEstimate = Selenide.$("[role='combobox']");

    public void addToBucket(){
        buyTicketBtn.click();
    }

}
