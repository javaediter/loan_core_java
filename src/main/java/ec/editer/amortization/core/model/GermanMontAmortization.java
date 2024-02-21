package ec.editer.amortization.core.model;

import ec.editer.amortization.core.enums.CalculusType;
import ec.editer.amortization.core.factory.AmortizationFactory;

import java.math.BigDecimal;

public class GermanMontAmortization extends Amortization{
    public GermanMontAmortization(int periods, BigDecimal quote, BigDecimal rateInterests){
        setPeriods(periods);
        setQuote(quote);
        setRateInterests(rateInterests);
        montAmortizationCalculus = AmortizationFactory.createStyleCalculus(CalculusType.GERMAN_MONT, false);
    }
}
