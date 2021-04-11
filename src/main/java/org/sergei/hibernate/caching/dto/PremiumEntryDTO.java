package org.sergei.hibernate.caching.dto;

import java.math.BigDecimal;

/**
 * @author Sergei Visotsky
 * @since 1.0
 */
public class PremiumEntryDTO {

    private String premiumCd;
    private BigDecimal monthlyAmount;
    private BigDecimal yearlyAmount;

    public String getPremiumCd() {
        return premiumCd;
    }

    public void setPremiumCd(String premiumCd) {
        this.premiumCd = premiumCd;
    }

    public BigDecimal getMonthlyAmount() {
        return monthlyAmount;
    }

    public void setMonthlyAmount(BigDecimal monthlyAmount) {
        this.monthlyAmount = monthlyAmount;
    }

    public BigDecimal getYearlyAmount() {
        return yearlyAmount;
    }

    public void setYearlyAmount(BigDecimal yearlyAmount) {
        this.yearlyAmount = yearlyAmount;
    }
}
