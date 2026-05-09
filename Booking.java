
package projectgroupd;

public class Booking implements Displayable {

    private Costumer customer;
    private Ticket ticket;
    private int quantity;
    private Payment payment;
    private Event event;
    private double total;

    public Booking() {
    }

    public Booking(Costumer customer, Ticket ticket, int quantity,
                   Payment payment, Event event) {

        this.customer = customer;
        this.ticket = ticket;
        this.quantity = quantity;
        this.payment = payment;
        this.event = event;
    }

    public double calculateTotal() {
        total = ticket.getTicketPrice() * quantity;
        return total;
    }

    public void confirmBooking() {
        if (event.isEventFull()) {
            throw new IllegalArgumentException("Event is full.");
        }

        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        total = calculateTotal();

        payment.processPayment(total);

        FileManager.saveBooking(this);
    }

    public Costumer getCustomer() {
        return customer;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public int getQuantity() {
        return quantity;
    }

    public Payment getPayment() {
        return payment;
    }

    public Event getEvent() {
        return event;
    }

    public double getTotal() {
        return total;
    }

    @Override
 public void displayInfo() {
        System.out.println("Booking Details[ Quantity: " + quantity +
                " | Total: " + total + " ]");

        customer.displayInfo();
        event.displayInfo();
        payment.displayInfo();
    }
}