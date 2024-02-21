package ec.editer.amortization.core.model;

import ec.editer.amortization.core.strategy.IAmortizationCalculus;
import ec.editer.amortization.core.strategy.IAmortizationStyleCalculus;

import java.math.BigDecimal;
import java.util.List;

public class Amortization {
    private BigDecimal mont;
    private BigDecimal rateInterests;
    private int periods;
    private List<Fee> fees;
    private BigDecimal quote;
    protected IAmortizationCalculus<List<Fee>> tableAmortizationCalculus;
    protected IAmortizationCalculus<BigDecimal> montAmortizationCalculus;

    public BigDecimal getMont() {
        return mont;
    }

    public void setMont(BigDecimal mont) {
        this.mont = mont;
    }

    public BigDecimal getRateInterests() {
        return rateInterests;
    }

    public void setRateInterests(BigDecimal rateInterests) {
        this.rateInterests = rateInterests;
    }

    public int getPeriods() {
        return periods;
    }

    public void setPeriods(int periods) {
        this.periods = periods;
    }

    public List<Fee> getFees() {
        return fees;
    }

    public void setFees(List<Fee> fees) {
        this.fees = fees;
    }

    public BigDecimal getQuote() {
        return quote;
    }

    public void setQuote(BigDecimal quote) {
        this.quote = quote;
    }

    public void performanceTableAmortizationCalculus() {
        fees = tableAmortizationCalculus.calculate(periods, mont, rateInterests);
    }

    public void performanceMontAmortizationCalculus() {
        mont = montAmortizationCalculus.calculate(periods, quote, rateInterests);
    }

    public void displayAmortizationTable() {
        for (Fee fee : fees) {
            System.out.println(fee);
        }
    }

}
