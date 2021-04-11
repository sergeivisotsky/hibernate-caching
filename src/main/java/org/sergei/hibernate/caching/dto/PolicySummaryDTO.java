package org.sergei.hibernate.caching.dto;

import java.time.LocalDate;

/**
 * @author Sergei Visotsky
 * @since 1.0
 */
public class PolicySummaryDTO {

    private String policyNumber;
    private String customerNumber;
    private String productCd;
    private String lob;
    private LocalDate rateEffectiveDate;
    private LocalDate quoteEffectiveDate;
    private String riskStateCd;
    private PremiumEntryDTO premiumEntry;

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

    public PremiumEntryDTO getPremiumEntry() {
        return premiumEntry;
    }

    public void setPremiumEntry(PremiumEntryDTO premiumEntry) {
        this.premiumEntry = premiumEntry;
    }
}
