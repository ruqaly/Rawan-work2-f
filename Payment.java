/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectgroupd;

/**
 *
 * @author A
 */
public class Payment implements Displayable{
    
    private String cardId;
        private String cardHolder;
    private String CVV;
    private String exDate;

    public Payment(String cardId, String cardHolder, String CVV, String exDate) {
       this.setCardId(cardId);
       this.setCardHolder(cardHolder);
       this.setCVV(CVV);
       this.setExDate(exDate);
    }
public void setCardId(String cardId) {

    if(cardId.length() == 16) {
        this.cardId = cardId;
    }

    else {
        throw new IllegalArgumentException(
                "Card ID must be exactly 16 digits."
        );
    }
}

public void setCardHolder(String cardHolder) {

    if(cardHolder != null &&
            cardHolder.length() > 0 &&
            cardHolder.length() <= 25) {

        this.cardHolder = cardHolder;
    }

    else {

        throw new IllegalArgumentException(
                "Card holder name is invalid."
        );
    }
}

public void setCVV(String CVV) {

    if(CVV != null && CVV.length() == 3) {
        this.CVV = CVV;
    }

    else {
        throw new IllegalArgumentException(
                "CVV must be exactly 3 digits."
        );
    }
}

public void setExDate(String exDate) {

    if(exDate.length() > 0) {
        this.exDate = exDate;
    }
    else {
        throw new IllegalArgumentException(
                "Expiry date cannot be empty."
        );
    }
}

    public String getCardId() {
        return cardId;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public String getCVV() {
        return CVV;
    }

    public String getExDate() {
        return exDate;
    }

    
    
    
    public Payment() {
    }

    public void processPayment(double amount){
         if(amount> 100&& amount<300)System.out.println("You got 10% discount! Price: $"+ (amount-(amount*0.1)));
         else if (amount>=300)System.out.println("You got 20% discount! Price: $"+ (amount-(amount*0.20)) );
         else System.out.println("Price: $"+amount);
         
         
    }

    @Override
    public String toString() {
        return  "CardId=" + cardId + ", CardHolder=" + cardHolder + ", CVV=" + CVV + ", ExpairyDate=" + exDate ;
    }
    
    
    
    @Override
     public   void displayInfo(){
     System.out.println("Card details[ " + "Card Id: " + cardId + "| Card Holder: " + cardHolder + "| CVV: " + CVV + "| Expairy Date: " + exDate + " ]");
     }
    

    
}
