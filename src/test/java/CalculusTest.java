import ec.editer.amortization.core.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CalculusTest {

    @Test
    public void testFranceByYearStyle() {
        Amortization amortization = new FranceAmortization(3, new BigDecimal("10000"), new BigDecimal("3"), false);
        amortization.performanceTableAmortizationCalculus();
        double sum = amortization.getFees().stream().mapToDouble(x -> x.getInterests().doubleValue()).sum();
        assertEquals(605.91, sum);
    }

    @Test
    public void testFranceMonthlyStyle() {
        Amortization amortization = new FranceAmortization(24, new BigDecimal("12528.28"), new BigDecimal("13.5"), true);
        amortization.performanceTableAmortizationCalculus();
        double sum = amortization.getFees().stream().mapToDouble(x -> x.getInterests().doubleValue()).sum();
        assertEquals(1837.12, sum);
    }

    @Test
    public void testGermanByYearStyle() {
        Amortization amortization = new GermanAmortization(3, new BigDecimal("10000"), new BigDecimal("3"), false);
        amortization.performanceTableAmortizationCalculus();
        double sum = amortization.getFees().stream().mapToDouble(x -> x.getInterests().doubleValue()).sum();
        assertEquals(600.00, sum);
    }

    @Test
    public void testGermanMonthlyStyle() {
        Amortization amortization = new GermanAmortization(24, new BigDecimal("12528.28"), new BigDecimal("13.5"), true);
        amortization.performanceTableAmortizationCalculus();
        double sum = amortization.getFees().stream().mapToDouble(x -> x.getInterests().doubleValue()).sum();
        assertEquals(1761.68, sum);
    }

    @Test
    public void testFrenchMontCalculus() {
        Amortization amortization = new FrenchMontAmortization(24, new BigDecimal("598.56"), new BigDecimal("13.5"));
        amortization.performanceMontAmortizationCalculus();
        double mont = amortization.getMont().doubleValue();
        assertEquals(12528.26, mont);
    }
    @Test
    public void testGermanMontCalculus(){
        Amortization amortization = new GermanMontAmortization(24, new BigDecimal("662.95"), new BigDecimal("13.5"));
        amortization.performanceMontAmortizationCalculus();
        double mont = amortization.getMont().doubleValue();
        assertEquals(12528.19, mont);
    }
}
