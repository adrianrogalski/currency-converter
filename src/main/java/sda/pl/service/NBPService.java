package sda.pl.service;

import sda.pl.model.Rate;

import java.util.List;

public interface NBPService {
    double calculate(Rate sourceRate, Double amount, Rate targetRate);
    List<Rate> getRates();
}
