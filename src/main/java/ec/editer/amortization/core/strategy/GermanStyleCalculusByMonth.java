package ec.editer.amortization.core.strategy;

import ec.editer.amortization.core.model.Fee;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class GermanStyleCalculusByMonth implements IAmortizationStyleCalculus{
    @Override
    public List<Fee> calculate(int periods, BigDecimal mont, BigDecimal rateInterests) {
        List<Fee> fees = new ArrayList<>();

        BigDecimal balance = new BigDecimal(0).add(mont, MathContext.DECIMAL32);
        BigDecimal rate = new BigDecimal(0).add(rateInterests, MathContext.DECIMAL32).divide(new BigDecimal(1200), MathContext.DECIMAL32);
        BigDecimal partial = new BigDecimal(0).add(mont, MathContext.DECIMAL32).divide(new BigDecimal(periods), MathContext.DECIMAL32);

        for(int k = 0; k < periods; k++){
            BigDecimal interests = new BigDecimal(0).add(balance, MathContext.DECIMAL32).multiply(rate, MathContext.DECIMAL32).setScale(2, RoundingMode.FLOOR);
            BigDecimal quote = new BigDecimal(0).add(partial, MathContext.DECIMAL32).add(interests, MathContext.DECIMAL32);
            fees.add(new Fee(k + 1, balance, interests, partial, quote));
            balance = balance.subtract(partial, MathContext.DECIMAL32);
        }

        return fees;
    }
}
