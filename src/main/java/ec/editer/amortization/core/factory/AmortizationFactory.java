package ec.editer.amortization.core.factory;

import ec.editer.amortization.core.enums.CalculusType;
import ec.editer.amortization.core.strategy.*;

public class AmortizationFactory {

    public static IAmortizationStyleCalculus createStyleCalculus(CalculusType type, boolean monthly) {
        IAmortizationStyleCalculus styleCalculus = null;
        if (type.equals(CalculusType.FRENCH) && monthly) {
            styleCalculus = new FranceStyleCalculusByMonth();
        } else if (type.equals(CalculusType.GERMAN) && monthly) {
            styleCalculus = new GermanStyleCalculusByMonth();
        } else if (type.equals(CalculusType.GERMAN) && !monthly) {
            styleCalculus = new GermanStyleCalculusByYear();
        } else {
            styleCalculus = new FranceStyleCalculusByYear();
        }
        return styleCalculus;
    }
}
