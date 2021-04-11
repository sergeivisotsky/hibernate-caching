package org.sergei.hibernate.caching.service;

import java.math.BigDecimal;
import java.util.List;

import org.sergei.hibernate.caching.dto.HttpResponse;
import org.sergei.hibernate.caching.dto.PolicySummaryDTO;
import org.sergei.hibernate.caching.dto.PolicySummaryResponse;

/**
 * @author Sergei Visotsky
 * @since 1.0
 */
public interface PolicyService {

    HttpResponse<List<PolicySummaryDTO>> findByMonthAmountRange(BigDecimal from, BigDecimal to);

    HttpResponse<PolicySummaryResponse> createPolicy(PolicySummaryDTO request);

}
