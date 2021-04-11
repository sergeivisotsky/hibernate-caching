package org.sergei.hibernate.caching.dao.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Premium entry entity
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
@Entity
public class PremiumEntry extends BaseEntity implements Serializable {

    private String premiumCd;

    @Column(name = "monthlyAmt")
    private BigDecimal monthlyAmount;

    @Column(name = "yearlyAmt")
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
