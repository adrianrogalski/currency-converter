package sda.pl;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class CurrencyConverterApp extends Application {
    // UI elements
    VBox root = new VBox();
    Label titleLabel = new Label("Convert");
    Label amountLabel = new Label("Amount");
    Spinner<Double> amount = new Spinner<>(new SpinnerValueFactory.DoubleSpinnerValueFactory(0,1_000_000,1));
    Label sourceCurrencyLabel = new Label("From");
    ComboBox<String> sourceCurrency = new ComboBox<>();
    Label targetCurrencyLabel = new Label("To");
    ComboBox<String> targetCurrency = new ComboBox<>();
    Label resultLabel = new Label("Result:");
    TextField result = new TextField("0.0");


    @Override
    public void start(Stage stage) throws Exception {
        root.getChildren().addAll(titleLabel,amountLabel,amount,sourceCurrencyLabel,sourceCurrency,targetCurrencyLabel,targetCurrency, resultLabel, result);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Currency Exchange");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}