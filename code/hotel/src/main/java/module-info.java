module com.hotel {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    //requires jdk.javadoc;

    opens com.hotel to javafx.fxml;
    exports com.hotel;
}
