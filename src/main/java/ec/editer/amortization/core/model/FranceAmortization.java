package ec.editer.amortization.core.model;

import ec.editer.amortization.core.enums.CalculusType;
import ec.editer.amortization.core.factory.AmortizationFactory;

import java.math.BigDecimal;

public class FranceAmortization extends Amortization{
    public FranceAmortization(int periods, BigDecimal mont, BigDecimal rateInterests, boolean monthly){
        setPeriods(periods);
        setMont(mont);
        setRateInterests(rateInterests);
        styleCalculus = AmortizationFactory.createStyleCalculus(CalculusType.FRENCH, monthly);
    }
}
