package org.sergei.hibernate.caching.dto;

/**
 * @author Sergei Visotsky
 * @since 1.0
 */
public class PolicySummaryResponse {

    private String policyNumber;
    private String customerNumber;
    private String productCd;

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
}
