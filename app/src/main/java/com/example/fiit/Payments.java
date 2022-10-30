package com.example.fiit;

public class Payments {

    String cardNumber, cardName, cardEp, cardCvv;

    public Payments() {
    }

    public Payments(String cardNumber, String cardName, String cardEp, String cardCvv) {
        this.cardNumber = cardNumber;
        this.cardName = cardName;
        this.cardEp = cardEp;
        this.cardCvv = cardCvv;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public String getCardEp() {
        return cardEp;
    }

    public void setCardEp(String cardEp) {
        this.cardEp = cardEp;
    }

    public String getCardCvv() {
        return cardCvv;
    }

    public void setCardCvv(String cardCvv) {
        this.cardCvv = cardCvv;
    }
}
