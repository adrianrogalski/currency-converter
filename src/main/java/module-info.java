module sda{
    requires javafx.graphics;
    requires javafx.controls;
    requires java.net.http;
    exports sda.pl to javafx.graphics, javafx.controls;
    exports sda.pl.model to com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires lombok;
}