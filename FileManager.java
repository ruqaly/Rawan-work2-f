/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package projectgroupd;
import java.io.*;

import java.util.ArrayList;
import java.util.Formatter;

import java.util.Scanner;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class FileManager {


    public static void saveCustomer(Costumer c) {

        try {

            PrintWriter writer = new PrintWriter( new FileWriter("costumers.txt", true) );

            writer.println(

                    c.getName() + "," +

                    c.getPhone() + "," +

                    c.getCard().getCardId() + "," +

                    c.getCard().getCardHolder() + "," +

                    c.getCard().getCVV() + "," +

                    c.getCard().getExDate()

            );

            writer.close();

        } catch (IOException e) {

            System.out.println(

                    "Error saving customer: " + e.getMessage()

            );

        }

    }

    public static ArrayList<Costumer> readCostumers() {

        ArrayList<Costumer> costumers = new ArrayList<>();

        try {

            File file = new File("costumers.txt");

            if (!file.exists()) {

                System.out.println("File not found.");

                return costumers;

            }

            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {

                String line = input.nextLine();

                String[] data = line.split(",");

                Payment card = new Payment(

                        data[2],

                        data[3],

                        data[4],

                        data[5]

                );

                Costumer costumer =

                        new Costumer(

                                data[0],

                                data[1],

                                card

                        );

                costumers.add(costumer);

            }

            input.close();

        } catch (Exception e) {

            System.out.println(

                    "Error reading costumers: " + e.getMessage()

            );

        }

        return costumers;

    }
public static void saveEvent(Event e) {

        try {

            PrintWriter writer =

                    new PrintWriter(

                            new FileWriter("events.txt", true)

                    );

            writer.println(

                    e.getName() + "," +

                    e.getContactInfo() + "," +

                    e.getCity() + "," +

                    e.getDate() + "," +

                    e.getTime() + "," +

                    e.getLocation() + "," +

                    e.getTicket().getTicketId() + "," +

                    e.getTicket().getTicketLevel() + "," +

                    e.getTicket2().getTicketPrice()
                     +"," +

                    e.getTicket2().getTicketId() + "," +

                    e.getTicket2().getTicketLevel() + "," +

                    e.getTicket2().getTicketPrice()

                    

            );

            writer.close();

        } catch (IOException o) {

            System.out.println(

                    "Error saving event: " + o.getMessage()

            );

        }

    }

    public static ArrayList<Event> readEvents() {

        ArrayList<Event> events = new ArrayList<>();

        try {

            File file = new File("events.txt");

            if (!file.exists()) {

                System.out.println("events.txt not found.");

                return events;

            }

            Scanner input = new Scanner(file);

            while (input.hasNextLine()) {

                String line = input.nextLine();

                String[] data = line.split(",");

                Ticket ticket = new Ticket(

                        data[6],

                        data[7],

                        Double.parseDouble(data[8])

                );
                
                Ticket ticket2 = new Ticket(

                        data[9],

                        data[10],

                        Double.parseDouble(data[11])

                );

                
                Event event = new Event(

                        data[0],

                        data[1],

                        data[2],

                        data[3],

                        data[4],

                        data[5],

                        ticket,
                        ticket2

                );

                events.add(event);

            }

            input.close();

        } catch (Exception e) {

            System.out.println(

                    "Error reading events: " + e.getMessage()

            );

        }

        return events;

    }

public static void saveBooking(Booking b) {

    try {

        Formatter save = new Formatter(
                new FileOutputStream("bookings.txt", true)
        );

        save.format("%s,%s,%s,%s,%s,%s,%s,%.2f%n",
                b.getCustomer().getName(),
                b.getCustomer().getPhone(),
                b.getEvent().getName(),
                b.getEvent().getCity(),
                b.getEvent().getDate(),
                b.getTicket().getTicketId(),
                b.getTicket().getTicketLevel(),
                b.getTicket().getTicketPrice()
        );

        save.close();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}



public static void loadBookingsForUI(String phone, VBox ticketsList) {

    try {

        File file = new File("bookings.txt");

        if (!file.exists()) return;

        Scanner input = new Scanner(file);

        while (input.hasNextLine()) {

            String line = input.nextLine();
            String[] data = line.split(",");

            if (data.length != 8) continue;

            if (!data[1].trim().equals(phone.trim())) continue;

            Label ticketLabel = new Label(
                    "Event: " + data[2] +
                    "\nCity: " + data[3] +
                    "\nDate: " + data[4] +
                    "\nTicket: " + data[6] +
                    "\nPrice: " + data[7]
            );

            Button cancelBtn = new Button("Cancel");

            VBox box = new VBox(5);
            box.setStyle("-fx-border-color: purple; -fx-padding: 10;");

          cancelBtn.setOnAction(e -> {

    try {

        Scanner in = new Scanner(file);

        StringBuilder keep = new StringBuilder();

        while (in.hasNextLine()) {

            String current = in.nextLine();

            if (!current.equals(line)) {
                keep.append(current).append("\n");
            }
        }

        in.close();

        Formatter out = new Formatter(file);
        out.format("%s", keep.toString());
        out.close();

    } catch (Exception ex) {
        System.out.println(ex.getMessage());
    }

    ticketsList.getChildren().clear();
    loadBookingsForUI(phone, ticketsList);
});

            box.getChildren().addAll(ticketLabel, cancelBtn);
            ticketsList.getChildren().add(box);
        }

        input.close();

    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
}

}
