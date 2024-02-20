package ec.editer.amortization.core.model;

import ec.editer.amortization.core.enums.CalculusType;
import ec.editer.amortization.core.factory.AmortizationFactory;

import java.math.BigDecimal;

public class GermanAmortization extends Amortization{
    public GermanAmortization(int periods, BigDecimal mont, BigDecimal rateInterests, boolean monthly){
        setPeriods(periods);
        setMont(mont);
        setRateInterests(rateInterests);
        styleCalculus = AmortizationFactory.createStyleCalculus(CalculusType.GERMAN, monthly);
    }
}
