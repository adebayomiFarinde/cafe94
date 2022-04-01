module com.example.cafesystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.cafesystem to javafx.fxml;
    exports com.example.cafesystem;

}