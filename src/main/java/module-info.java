module sda{
    requires javafx.graphics;
    requires javafx.controls;
    requires java.net.http;
    exports sda.pl to javafx.controls, javafx.graphics;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
}