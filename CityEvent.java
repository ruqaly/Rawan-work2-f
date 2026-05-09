
package projectgroupd;

public class CityEvent extends Event {

    public static int capacity;
    private String district1;
    private String district2;

    public CityEvent() {
    }

    public CityEvent(String name, String contactInfo, String city,
                     String date, String time, String location,
                     Ticket ticket,Ticket ticket2, String district1, String district2) {

        super(name, contactInfo, city, date, time, location, ticket,ticket2);
        this.district1 = district1;
        this.district2 = district2;
    }

    public String getDistrict1() {
        return district1;
    }

    public void setDistrict1(String district1) {
        this.district1 = district1;
    }

    public String getDistrict2() {
        return district2;
    }

    public void setDistrict2(String district2) {
        this.district2 = district2;
    }

    public void about() {
        System.out.println("This is a city event.");
    }

    public boolean isFull(){
    return (capacity>2);
    }
    
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("District Details[ District 1: " + district1 +
                " | District 2: " + district2 + " ]");
    }

    @Override
    public String toString() {
        return super.toString() + "\nDistrict1: " + district1 + "\nDistrict2: " + district2;
    }
}