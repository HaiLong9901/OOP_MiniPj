module com.example.oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oop to javafx.fxml;
    opens com.example.oop.controller to javafx.fxml;
    opens com.example.oop.model to javafx.base;
    exports com.example.oop;
}