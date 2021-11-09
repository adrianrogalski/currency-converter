package sda.pl.service;

import sda.pl.exception.ApiConnectionException;
import sda.pl.model.CurrencyTable;
import sda.pl.model.Rate;
import sda.pl.repository.ApiSimpleGenericRepository;
import sda.pl.repository.SimpleGenericRepository;

import java.io.IOException;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class NBPAPIService implements NBPService{
    private static final URI NBP_URI = URI.create("http://api.nbp.pl/api/exchangerates/tables/A?format=json");
    SimpleGenericRepository<CurrencyTable[]> rateRepository = new ApiSimpleGenericRepository<>(CurrencyTable[].class);

    /*
        Calculating value relative to PLN exchange

     */
    @Override
    public double calculate(Rate sourceRate, Double amount, Rate targetRate) {
        return (sourceRate.getMid() * amount) / targetRate.getMid();
    }

    /*
    Returns List of rates if successful otherwise throws
     */
    @Override
    public List<Rate> getRates() {
        try {
            final Optional<CurrencyTable[]> optionalCurrencyTable;
            optionalCurrencyTable = rateRepository.findByURI(NBP_URI);
            List<Rate> rates = optionalCurrencyTable.filter(table -> table.length == 1).map(table -> table[0].getRates()).orElse(Collections.emptyList());
            rates.add(
                    // Adding PLN currency because API doesnt provide it
                    Rate.builder()
                            .code("PLN")
                            .currency("złoty")
                            .mid(1.0)
                            .build()
            );
            System.out.println(rates.size());
            return rates;
        } catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
            throw new ApiConnectionException("Problem with NBP Service connection");
        }
    }
}
