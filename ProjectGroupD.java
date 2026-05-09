package projectgroupd;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ProjectGroupD extends Application {

    private Event selectedEvent;

    @Override
    public void start(Stage stage) {

        Ticket ct1 = new Ticket(
                "T101",
                "Basic",
                80
        );
        
        Ticket ct2 = new Ticket(
                "T102",
                "VIP",
                100
        );

      CityEvent city1= new CityEvent("Ryiadh seasaon", "riyadhSeason@gmail.com", "Al-Riyadh",  "2026/6/20", "15:00", "North",ct1,ct2, "Alyasmin", "Alnarjes");

        Ticket ft1 = new Ticket(
                "T204",
                "Basic",
                100
        );
        
         Ticket ft2 = new Ticket(
                "T205",
                "VIP",
                200
        );

       
        Football football1= new  Football("Final Match", "dammamFootball@gmail.com","Al-Dammam", "2026/8/5","19:00", "Dammam stadium", ft1,ft2,"Alhilal","Alnassar");
                    
                    
         
         


        Label title = new Label("⭐ Event Ticket Booking System ⭐");

        title.setStyle(
                "-fx-font-size: 24px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: purple;"
        );
        
        
        Label welcome = new Label("Welcome! Please login to continue.");

        welcome.setStyle(
                "-fx-font-size: 14px;" +
                "-fx-text-fill: purple;"
        );
        

        Label nameLabel = new Label("👤 Name:");
        TextField nameField = new TextField();

        Label phoneLabel = new Label("📱 Phone:");
        TextField phoneField = new TextField();

        Button loginBtn = new Button("Login");

        Label loginMessage = new Label();

        GridPane loginGrid = new GridPane();

        loginGrid.setHgap(10);
        loginGrid.setVgap(10);

        loginGrid.add(nameLabel, 0, 0);
        loginGrid.add(nameField, 1, 0);

        loginGrid.add(phoneLabel, 0, 1);
        loginGrid.add(phoneField, 1, 1);

        VBox loginRoot = new VBox(15);

        loginRoot.setAlignment(Pos.CENTER);

        loginRoot.getChildren().addAll(
                title,welcome,
                loginGrid,
                loginBtn,
                loginMessage
        );

        Scene loginScene = new Scene(loginRoot, 500, 400);

        // ================= DASHBOARD SCENE =================

      // ================= DASHBOARD SCENE =================

BorderPane dashboardRoot = new BorderPane();

Label dashboardTitle = new Label("🎟 Event Dashboard");

dashboardTitle.setStyle(
        "-fx-font-size: 22px;" +
        "-fx-font-weight: bold;" +
        "-fx-text-fill: purple;"
);

HBox topBar = new HBox(dashboardTitle);

topBar.setAlignment(Pos.CENTER);
topBar.setPadding(new Insets(20));

dashboardRoot.setTop(topBar);

// ================= EVENTS PAGE =================

// ----- EVENT 1 -----

Label event1Info = new Label(
        "Event 1 info :\n" +city1
);

Button buy1Basic = new Button("Buy Basic");
Button buy1VIP = new Button("Buy VIP");

VBox eventBox1 = new VBox(10);

eventBox1.setPrefWidth(220);
eventBox1.setMaxSize(320, 320);

eventBox1.setPadding(new Insets(20));

eventBox1.setStyle(
        "-fx-border-color: purple;" +
        "-fx-border-radius: 10;" +
        "-fx-background-radius: 10;"
);

eventBox1.getChildren().addAll(
        event1Info,
        buy1Basic,buy1VIP
);

// ----- EVENT 2 -----

Label event2Info = new Label(
        "Event 2 name:\n"+ football1
);

Button buy2Basic = new Button("Buy Basic");
Button buy2VIP = new Button("Buy VIP");

VBox eventBox2 = new VBox(10);

eventBox2.setPrefWidth(220);
eventBox2.setMaxSize(320, 320);

eventBox2.setPadding(new Insets(20));

eventBox2.setStyle(
        "-fx-border-color: purple;" +
        "-fx-border-radius: 10;" +
        "-fx-background-radius: 10;"
);

eventBox2.getChildren().addAll(
        event2Info,
        buy2Basic,buy2VIP
);

HBox eventsLayout = new HBox(30);

eventsLayout.setAlignment(Pos.CENTER);

eventsLayout.getChildren().addAll(
        eventBox1,
        eventBox2
);

// ================= MY TICKETS PAGE =================

Label myTicketsLabel = new Label("🎫 My Tickets");

myTicketsLabel.setStyle(
        "-fx-font-size: 24px;" +
        "-fx-text-fill: purple;"
);

VBox ticketsList = new VBox(10);

ticketsList.setAlignment(Pos.CENTER);

VBox ticketsPage = new VBox(20);

ticketsPage.setAlignment(Pos.CENTER);




ticketsPage.getChildren().addAll(
        myTicketsLabel,
        ticketsList
        
        
);




// ================= LEFT MENU =================

Button eventsBtn = new Button("Available Events");
Button ticketsBtn = new Button("My Tickets");
eventsBtn.setStyle("-fx-background-color: purple; -fx-text-fill: white;");

        
        
eventsBtn.setPrefWidth(120);
ticketsBtn.setPrefWidth(120);
ticketsBtn.setStyle("-fx-background-color: purple; -fx-text-fill: white;");

VBox leftMenu = new VBox(15);

leftMenu.setPadding(new Insets(20));

leftMenu.getChildren().addAll(
        eventsBtn,
        ticketsBtn
);

dashboardRoot.setLeft(leftMenu);

// DEFAULT PAGE

dashboardRoot.setCenter(eventsLayout);

// SWITCH PAGES

eventsBtn.setOnAction(e -> {
    dashboardRoot.setCenter(eventsLayout);
});

ticketsBtn.setOnAction(e -> {

    ticketsList.getChildren().clear();

    FileManager.loadBookingsForUI(
            phoneField.getText().trim(),
            ticketsList
    );

    dashboardRoot.setCenter(ticketsPage);
});

Scene dashboardScene = new Scene(dashboardRoot, 800, 500);

        // ================= PAYMENT SCENE =================

        Label paymentTitle = new Label("💳 Confirm Payment");

        paymentTitle.setStyle(
                "-fx-font-size: 22px;" +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: purple;"
        );

        Label holderLabel = new Label("💳 Card Holder:");
        TextField holderField = new TextField();

        Label cardLabel = new Label("💳 Card ID:");
        TextField cardField = new TextField();

        Label cvvLabel = new Label("🔒 CVV:");
        PasswordField cvvField = new PasswordField();

        Label dateLabel = new Label("🧾 Expiry Date:");
        TextField dateField = new TextField();

        Button confirmBtn = new Button("Confirm Payment");

        Label paymentMessage = new Label();

        GridPane paymentGrid = new GridPane();

        paymentGrid.setHgap(10);
        paymentGrid.setVgap(10);

        paymentGrid.add(holderLabel, 0, 0);
        paymentGrid.add(holderField, 1, 0);

        paymentGrid.add(cardLabel, 0, 1);
        paymentGrid.add(cardField, 1, 1);

        paymentGrid.add(cvvLabel, 0, 2);
        paymentGrid.add(cvvField, 1, 2);

        paymentGrid.add(dateLabel, 0, 3);
        paymentGrid.add(dateField, 1, 3);

        VBox paymentRoot = new VBox(15);

        paymentRoot.setAlignment(Pos.CENTER);

        paymentRoot.getChildren().addAll(
                paymentTitle,
                paymentGrid,
                confirmBtn,
                paymentMessage
        );

        Scene paymentScene = new Scene(paymentRoot, 500, 400);

        // ================= LOGIN BUTTON =================

        loginBtn.setOnAction(e -> {

            try {

                Costumer c = new Costumer();

                c.setName(nameField.getText());
                c.setPhone(phoneField.getText());

                loginMessage.setText("");
                ticketsList.getChildren().clear();



                stage.setScene(dashboardScene);

            } catch (IllegalArgumentException ex) {

                loginMessage.setText(ex.getMessage());
            }
        });

        // ================= EVENT BUTTONS =================

        
        
        
        
        buy1Basic.setOnAction(e -> {

            Alert alert = new Alert(
                    Alert.AlertType.CONFIRMATION
            );

            alert.setTitle("Confirm");
            alert.setHeaderText(null);

            alert.setContentText(
                     "Do you want to buy $"+city1.getTicket().getTicketPrice()+" a ticket for event "+city1.getName()+" ?"
            );

            if (alert.showAndWait().get() == ButtonType.OK) {

                if (city1.isFull()) {

  alert.setAlertType(Alert.AlertType.ERROR);
    alert.setTitle("Full Event");
    alert.setHeaderText(null);
    alert.setContentText("This event is fully booked.");
    alert.showAndWait();

    return;
}

selectedEvent = city1;
stage.setScene(paymentScene);
                
                selectedEvent = city1;
                city1.capacity++;

                stage.setScene(paymentScene);
            }
        });

        
          
        buy1VIP.setOnAction(e -> {

            Alert alert = new Alert(
                    Alert.AlertType.CONFIRMATION
            );

            alert.setTitle("Confirm");
            alert.setHeaderText(null);

            alert.setContentText(
                     "Do you want to buy $"+city1.getTicket2().getTicketPrice()+" a ticket for event "+city1.getName()+" ?"
                             );
            

            if (alert.showAndWait().get() == ButtonType.OK) {

                 if (city1.isFull()) {

  alert.setAlertType(Alert.AlertType.ERROR);
    alert.setTitle("Full Event");
    alert.setHeaderText(null);
    alert.setContentText("This event is fully booked.");
    alert.showAndWait();

    return;
}
                
                selectedEvent = city1;
                city1.capacity++;

                stage.setScene(paymentScene);
            }
        });

        
        
        
        
        buy2Basic.setOnAction(e -> {

            Alert alert = new Alert(
                    Alert.AlertType.CONFIRMATION
            );

            alert.setTitle("Confirm");
            alert.setHeaderText(null);

            alert.setContentText(
                    "Do you want to buy $"+football1.getTicket().getTicketPrice()+" a ticket for event "+football1.getName()+" ?"
            );

            if (alert.showAndWait().get() == ButtonType.OK) {

 if (football1.isFull()) {

  alert.setAlertType(Alert.AlertType.ERROR);
    alert.setTitle("Full Event");
    alert.setHeaderText(null);
    alert.setContentText("This event is fully booked.");
    alert.showAndWait();

    return;
}
                
                selectedEvent = football1;
                football1.capacity++;

                stage.setScene(paymentScene);
            }
        });

        
         buy2VIP.setOnAction(e -> {

            Alert alert = new Alert(
                    Alert.AlertType.CONFIRMATION
            );

            alert.setTitle("Confirm");
            alert.setHeaderText(null);

            alert.setContentText(
                     "Do you want to buy $"+football1.getTicket2().getTicketPrice()+" a ticket for event "+football1.getName()+" ?"
            );

            if (alert.showAndWait().get() == ButtonType.OK) {

                if (football1.isFull()) {

  alert.setAlertType(Alert.AlertType.ERROR);
    alert.setTitle("Full Event");
    alert.setHeaderText(null);
    alert.setContentText("This event is fully booked.");
    alert.showAndWait();

    return;
}
                
                selectedEvent = football1;
                football1.capacity++;

                stage.setScene(paymentScene);
            }
        });
        
        
        
        // ================= CONFIRM PAYMENT =================

        confirmBtn.setOnAction(e -> {

            try {

                String name = nameField.getText();
                String phone = phoneField.getText();

                String holder = holderField.getText();
                String cardId = cardField.getText();
                String cvv = cvvField.getText();
                String date = dateField.getText();

                Payment payment = new Payment(
                        cardId,
                        holder,
                        cvv,
                        date
                );

                Costumer customer = new Costumer(
                        name,
                        phone,
                        payment
                );

                
                
                FileManager.saveCustomer(customer);
                
                Booking booking = new Booking(
        customer,
        selectedEvent.getTicket(),
        1,
        payment,
        selectedEvent);

FileManager.saveBooking(booking);

                // CLEAR FIELDS

                holderField.clear();
                cardField.clear();
                cvvField.clear();
                dateField.clear();

                // RETURN TO DASHBOARD
Alert success = new Alert(Alert.AlertType.INFORMATION);
success.setTitle("Success");
success.setHeaderText(null);
success.setContentText("Payment successful!");
success.showAndWait();

stage.setScene(dashboardScene);

            } catch (IllegalArgumentException ex) {

                paymentMessage.setText(ex.getMessage());
                
            }
        });

        // ================= STAGE =================

        stage.setTitle("Event Ticket Booking System");
        stage.setScene(loginScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
