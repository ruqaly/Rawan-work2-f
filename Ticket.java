/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectgroupd;

/**
 *
 * @author A
 */
public class Ticket implements Displayable{
    
    private String ticketId;
     private String ticketLevel;
     private double ticketPrice;
     

    public Ticket(String ticketId, String ticketLevel, double ticketPrice) {
      this.setTicketId(ticketId);
      this.setTicketLevel(ticketLevel);
      this.setTicketPrice(ticketPrice);
    }

    public Ticket() {
    }

    public void setTicketId(String ticketId) {
        if(ticketId.length()<11&&ticketId.length()>0) this.ticketId = ticketId;
        else System.out.println("ID Length must be 10.");
    }

    public void setTicketLevel(String ticketLevel) {
        switch(ticketLevel.toLowerCase()){case "basic": case"vip" : this.ticketLevel = ticketLevel; break; default: System.out.println("Invalid Level. Please enter Basic or VIP.");}
    } 

    public void setTicketPrice(double ticketPrice) {
      if(this.ticketLevel.equalsIgnoreCase("basic"))  this.ticketPrice = ticketPrice;
      else if(this.ticketLevel.equalsIgnoreCase("vip"))this.ticketPrice = ticketPrice+100;
      else System.out.println("Could not set Price.");
    }

   

    public String getTicketId() {
        return ticketId;
    }

    public String getTicketLevel() {
        return ticketLevel;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    @Override
    public String toString() {
        return "TicketId=" + ticketId + ", TicketLevel=" + ticketLevel + ", TicketPrice=" + ticketPrice ;
    }

   


     
    
    
    
     @Override
       public  void displayInfo(){
       System.out.println("Details of Ticket[ " + "Ticket ID: " + ticketId + "| Ticket Level: " + ticketLevel + "| Ticket Price: " + ticketPrice + " ]" );
       
       }

    
    
    
}
