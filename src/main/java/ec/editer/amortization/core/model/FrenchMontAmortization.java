package ec.editer.amortization.core.model;

import ec.editer.amortization.core.enums.CalculusType;
import ec.editer.amortization.core.factory.AmortizationFactory;

import java.math.BigDecimal;

public class FrenchMontAmortization extends Amortization{
    public FrenchMontAmortization(int periods, BigDecimal quote, BigDecimal rateInterests){
        setPeriods(periods);
        setQuote(quote);
        setRateInterests(rateInterests);
        montAmortizationCalculus = AmortizationFactory.createStyleCalculus(CalculusType.FRENCH_MONT, false);
    }
}
