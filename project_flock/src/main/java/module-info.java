module com.ampalaya {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ampalaya to javafx.fxml;
    exports com.ampalaya;
}
