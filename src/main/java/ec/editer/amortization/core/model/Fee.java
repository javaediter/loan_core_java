package ec.editer.amortization.core.model;

import java.math.BigDecimal;

public class Fee {
    public Fee(int period, BigDecimal capital, BigDecimal interests, BigDecimal partial, BigDecimal total) {
        this.period = period;
        this.capital = capital;
        this.interests = interests;
        this.partial = partial;
        this.total = total;
    }

    private final int period;
    private final BigDecimal capital;
    private final BigDecimal interests;
    private final BigDecimal partial;
    private final BigDecimal total;

    public int getPeriod() {
        return period;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public BigDecimal getInterests() {
        return interests;
    }

    public BigDecimal getPartial() {
        return partial;
    }

    public BigDecimal getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "### " + period + " - " + capital + " - " + interests + " - " + partial + " - " + total + " ###";
    }
}
