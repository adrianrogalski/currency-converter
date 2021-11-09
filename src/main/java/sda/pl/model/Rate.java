package sda.pl.model;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rate {
    private String currency;
    private String code;
    // mid: average currency exchange relative to PLN
    private Double mid;

    @Override
    public String toString() {
        return currency + " - " + code;
    }
}
