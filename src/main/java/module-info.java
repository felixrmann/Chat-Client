module Chat.Client {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.net.http;
    requires okhttp3;
    requires org.json.chargebee;
    requires com.fasterxml.jackson.databind;
    requires com.google.gson;
    requires slf4j.api;
    requires java.desktop;

    opens Client.Main;
    opens Client.Model;

    exports Client.Model to com.google.gson;
    exports Client.View to javafx.graphics;
}