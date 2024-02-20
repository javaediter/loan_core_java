package ec.editer.amortization.core.model;

import ec.editer.amortization.core.strategy.IAmortizationStyleCalculus;

import java.math.BigDecimal;
import java.util.List;

public class Amortization {
    private BigDecimal mont;
    private BigDecimal rateInterests;
    private int periods;
    private List<Fee> fees;
    protected IAmortizationStyleCalculus styleCalculus;

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

    public void performanceStyleCalculus(){
        fees = styleCalculus.calculateFee(periods, mont, rateInterests);
    }
    public void displayAmortizationTable(){
        for(Fee fee : fees){
            System.out.println(fee);
        }
    }

}
