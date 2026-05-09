
package projectgroupd;
import java.util.ArrayList;
public class BookingSystem implements Displayable {
  private ArrayList<Costumer> customers ;
  private ArrayList<Event> events = new ArrayList<>();
  private Booking booking;
    public BookingSystem() {
    }

    public BookingSystem(ArrayList<Costumer> customers,ArrayList<Event> events,Booking booking ) {
    this.booking = new Booking();
    this.customers =new ArrayList<>();
    this.events =new ArrayList<>();
    }

    public ArrayList<Costumer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Costumer> customers) {
        this.customers = customers;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }
  public Costumer findCustomer (String name){
  for(Costumer c : customers ){
      if(c.getName().equalsIgnoreCase(name)){
       return c;
      }
      
      }
  return null;
  }
  public void addCustomer (Costumer c){
  customers.add(c);
  }
  public void removeCustomer (Costumer c){
  customers.remove(c);
  }
  @Override
  public void displayInfo(){
      for(Costumer e : customers) {
          System.out.println(e);
      }
      for(Event e : events) {
          System.out.println(e);
      }
  }

    
    
  
}
