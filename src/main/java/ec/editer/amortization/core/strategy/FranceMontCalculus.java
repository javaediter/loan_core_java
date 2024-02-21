package ec.editer.amortization.core.strategy;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class FranceMontCalculus implements IAmortizationMontCalculus{
    @Override
    public BigDecimal calculate(int n, BigDecimal v, BigDecimal i) {
        BigDecimal rate = new BigDecimal(0).add(i).divide(new BigDecimal(1200), MathContext.DECIMAL32);
        BigDecimal a = new BigDecimal(1).add(rate);
        BigDecimal b = new BigDecimal(0).add(a).pow(n);
        BigDecimal c = new BigDecimal(1).divide(b, MathContext.DECIMAL32).setScale(5, RoundingMode.HALF_DOWN);
        return new BigDecimal(1).subtract(c).multiply(v).divide(rate, MathContext.DECIMAL32);
    }
}
