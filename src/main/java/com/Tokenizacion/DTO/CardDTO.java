package com.Tokenizacion.DTO;

public class CardDTO {
    private String cardNumber;
    private String expiredDate;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(String expiredDate) {
        this.expiredDate = expiredDate;
    }

    @Override
    public String toString() {
        return "CardDTO{" +
                "cardNumber='" + cardNumber + '\'' +
                ", expiredDate='" + expiredDate + '\'' +
                '}';
    }
}
