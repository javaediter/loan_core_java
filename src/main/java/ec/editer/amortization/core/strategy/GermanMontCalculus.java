package ec.editer.amortization.core.strategy;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class GermanMontCalculus implements IAmortizationMontCalculus{
    @Override
    public BigDecimal calculate(int n, BigDecimal v, BigDecimal i) {
        BigDecimal rate = new BigDecimal(0).add(i).divide(new BigDecimal(1200), MathContext.DECIMAL32).setScale(5, RoundingMode.HALF_DOWN);
        BigDecimal a = new BigDecimal(1).divide(new BigDecimal(n), MathContext.DECIMAL32).add(rate);
        return new BigDecimal(0).add(v).divide(a, MathContext.DECIMAL32);
    }
}
