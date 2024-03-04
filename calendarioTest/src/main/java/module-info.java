module com.example.calendariotest {
    requires javafx.controls;
    requires javafx.fxml;
    requires atlantafx.base;

    opens com.example.calendariotest to javafx.fxml;
    exports com.example.calendariotest;
}