/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectgroupd;

import java.util.Objects;

/**
 *
 * @author A
 */
public class Costumer implements Displayable {
    
    private String name;
    private String phone;
    private Payment card;

    public Costumer(String name, String phone, Payment card) {
        this.name = name;
        this.phone = phone;
        this.card = card;
    }

    public Costumer() {
    }

    @Override
    public String toString() {
        return "Name=" + name + ", Phone=" + phone + ", Card=" + card ;
    }

    public void setName(String name) {

    if(name != null &&
            name.length() > 0 &&
            name.length() <= 25) {

        this.name = name;
    }

    else {

        throw new IllegalArgumentException(
                "Name must be between 1 and 25 characters."
        );
    }
}

public void setPhone(String phone) {

    if(phone != null && phone.length() == 10) {
        this.phone = phone;
    }

    else {
        throw new IllegalArgumentException(
                "Phone number must be exactly 10 digits." );
    }
}

    public void setCard(Payment card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Payment getCard() {
        return card;
    }
    
    
    
    
    
    
    
    
    
    
    @Override
       public void displayInfo(){
       System.out.println("Costumer details [" + "Name: " + name + "| Phone:" + phone + " ]");
       card.displayInfo();
       }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
         Costumer other = (Costumer) obj;
        return this.phone.equals(other.phone) ;
    }

       
    
}
