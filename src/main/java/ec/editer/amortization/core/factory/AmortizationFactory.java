package ec.editer.amortization.core.factory;

import ec.editer.amortization.core.enums.CalculusType;
import ec.editer.amortization.core.strategy.*;

public class AmortizationFactory {

    public static IAmortizationCalculus createStyleCalculus(CalculusType type, boolean monthly) {
        if(type.equals(CalculusType.FRENCH_MONT)){
            return new FranceMontCalculus();
        }else if(type.equals(CalculusType.GERMAN_MONT)){
            return new GermanMontCalculus();
        }else if (type.equals(CalculusType.FRENCH) && monthly) {
            return new FranceStyleCalculusByMonth();
        } else if (type.equals(CalculusType.GERMAN) && monthly) {
            return new GermanStyleCalculusByMonth();
        } else if (type.equals(CalculusType.GERMAN) && !monthly) {
            return new GermanStyleCalculusByYear();
        } else {
            return new FranceStyleCalculusByYear();
        }
    }
}
