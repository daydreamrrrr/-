module com.mycompany.lab16 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.lab16 to javafx.fxml;
    exports com.mycompany.lab16;
}
