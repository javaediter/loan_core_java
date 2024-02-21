package ec.editer.amortization.core.strategy;

import ec.editer.amortization.core.model.Fee;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class FranceStyleCalculusByMonth implements IAmortizationStyleCalculus{
    @Override
    public List<Fee> calculate(int periods, BigDecimal mont, BigDecimal rateInterests) {
        List<Fee> fees = new ArrayList<>();

        BigDecimal balance = new BigDecimal(0).add(mont, MathContext.DECIMAL32);
        BigDecimal rate = new BigDecimal(0).add(rateInterests, MathContext.DECIMAL32).divide(new BigDecimal(1200), MathContext.DECIMAL32);
        BigDecimal quote = getQuoteValue(periods, rate, balance);

        for(int k = 0; k < periods; k++){
            BigDecimal interests = new BigDecimal(0).add(balance, MathContext.DECIMAL32).multiply(rate, MathContext.DECIMAL32).setScale(2, RoundingMode.FLOOR);
            BigDecimal partial = new BigDecimal(0).add(quote, MathContext.DECIMAL32).subtract(interests, MathContext.DECIMAL32);
            fees.add(new Fee(k + 1, balance, interests, partial, quote));
            balance = balance.subtract(partial, MathContext.DECIMAL32);
        }

        return fees;
    }
    private static BigDecimal getQuoteValue(int periods, BigDecimal rate, BigDecimal balance) {
        BigDecimal a = new BigDecimal(1).add(rate, MathContext.DECIMAL32);
        BigDecimal b = new BigDecimal(0).add(a, MathContext.DECIMAL32).pow(periods, MathContext.DECIMAL32).setScale(5, RoundingMode.FLOOR);
        BigDecimal c = new BigDecimal(1).divide(b, MathContext.DECIMAL32);
        BigDecimal d = new BigDecimal(1).subtract(c, MathContext.DECIMAL32);
        BigDecimal e = new BigDecimal(0).add(rate, MathContext.DECIMAL32).divide(d, MathContext.DECIMAL32);
        return new BigDecimal(0).add(balance, MathContext.DECIMAL32).multiply(e, MathContext.DECIMAL32);
    }
}
