module balatro {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.databind;

    exports view;
    exports controller;
    exports model;
}