package org.sergei.hibernate.caching.dao.domain;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Policy summary entity.
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "policySummaryCache")
public class PolicySummary extends BaseEntity implements Serializable {

    private String policyNumber;
    private String customerNumber;
    private String productCd;
    @Column(name = "LOB")
    private String lob;
    private LocalDate rateEffectiveDate;
    private LocalDate quoteEffectiveDate;
    private String riskStateCd;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "premium_entry_id", referencedColumnName = "id")
    private PremiumEntry premiumEntry;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getProductCd() {
        return productCd;
    }

    public void setProductCd(String productCd) {
        this.productCd = productCd;
    }

    public String getLob() {
        return lob;
    }

    public void setLob(String lob) {
        this.lob = lob;
    }

    public LocalDate getRateEffectiveDate() {
        return rateEffectiveDate;
    }

    public void setRateEffectiveDate(LocalDate rateEffectiveDate) {
        this.rateEffectiveDate = rateEffectiveDate;
    }

    public LocalDate getQuoteEffectiveDate() {
        return quoteEffectiveDate;
    }

    public void setQuoteEffectiveDate(LocalDate quoteEffectiveDate) {
        this.quoteEffectiveDate = quoteEffectiveDate;
    }

    public String getRiskStateCd() {
        return riskStateCd;
    }

    public void setRiskStateCd(String riskStateCd) {
        this.riskStateCd = riskStateCd;
    }

    public PremiumEntry getPremiumEntry() {
        return premiumEntry;
    }

    public void setPremiumEntry(PremiumEntry premiumEntry) {
        this.premiumEntry = premiumEntry;
    }
}
