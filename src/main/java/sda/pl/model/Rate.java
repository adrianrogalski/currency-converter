package sda.pl.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Rate {
    private String currency;
    private String code;
    private Double mid;

    @Override
    public String toString() {
        return "currency: '" + currency + '\n' +
                "code: '" + code + '\n' +
                "mid: " + mid;
    }
}
