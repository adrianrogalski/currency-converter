package sda.pl.model;

import lombok.*;

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
