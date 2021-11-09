package sda.pl;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import sda.pl.model.Rate;
import sda.pl.service.NBPAPIService;
import sda.pl.service.NBPService;

import java.util.List;


public class CurrencyConverterApp extends Application {
    NBPService nbpService = new NBPAPIService();
    // UI elements
    VBox root = new VBox();
    Label titleLabel = new Label("Convert");
    Label amountLabel = new Label("Amount");
    Spinner<Double> amount = new Spinner<>(new SpinnerValueFactory.DoubleSpinnerValueFactory(0,1_000_000,1));
    Label sourceCurrencyLabel = new Label("From");
    ComboBox<Rate> sourceCurrency = new ComboBox<>();
    Label targetCurrencyLabel = new Label("To");
    ComboBox<Rate> targetCurrency = new ComboBox<>();
    Label resultLabel = new Label("Result:");
    Label resultValue = new Label("0.0");


    @Override
    public void start(Stage stage){
        createCurrencyCalculatorScene();
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("Currency Exchange");
        stage.show();
    }

    public void createCurrencyCalculatorScene() {
        // Decoration
        root.getChildren().addAll(titleLabel,amountLabel,amount,sourceCurrencyLabel,sourceCurrency,targetCurrencyLabel,targetCurrency, resultLabel, resultValue);
        amount.setEditable(true);
        root.setSpacing(10);
        titleLabel.setFont(Font.font("Verdana", FontWeight.BLACK, 30));
        root.setAlignment(Pos.CENTER);

        // Integration
        // Listing rates
        List<Rate> rates = nbpService.getRates();
        sourceCurrency.getItems().addAll(rates);
        targetCurrency.getItems().addAll(rates);

        // Conversion result
        amount.getEditor().setOnAction(event -> {
            double result = nbpService.calculate(
                    sourceCurrency.getSelectionModel().getSelectedItem(),
                    amount.getValue(),
                    targetCurrency.getSelectionModel().getSelectedItem()
            );
            resultValue.setText(String.format("%.2f", result));
        });

    }

    public static void main(String[] args) {
        launch();
    }
}
