package ec.editer.amortization.core.strategy;

import ec.editer.amortization.core.model.Fee;

import java.math.BigDecimal;
import java.util.List;

public interface IAmortizationStyleCalculus {
    public List<Fee> calculateFee(int periods, BigDecimal mont, BigDecimal rateInterests);
}
