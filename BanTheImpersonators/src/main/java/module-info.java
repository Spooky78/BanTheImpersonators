module com.example.bantheimpersonators {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bantheimpersonators to javafx.fxml;
    exports com.example.bantheimpersonators;
}