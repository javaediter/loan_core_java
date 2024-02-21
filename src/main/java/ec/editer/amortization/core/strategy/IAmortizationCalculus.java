package ec.editer.amortization.core.strategy;

import java.math.BigDecimal;

public interface IAmortizationCalculus<T> {
    public T calculate(int n, BigDecimal v, BigDecimal i);
}
