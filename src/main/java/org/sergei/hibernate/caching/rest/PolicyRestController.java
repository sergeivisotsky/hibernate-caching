package org.sergei.hibernate.caching.rest;

import java.math.BigDecimal;
import java.util.List;

import org.sergei.hibernate.caching.dto.HttpResponse;
import org.sergei.hibernate.caching.dto.PolicySummaryDTO;
import org.sergei.hibernate.caching.dto.PolicySummaryResponse;
import org.sergei.hibernate.caching.service.PolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Policy REST controller
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
@RestController("/api/v1/policy")
public class PolicyRestController {

    private final PolicyService policyService;

    public PolicyRestController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping("/findInAmountRange")
    public ResponseEntity<HttpResponse<List<PolicySummaryDTO>>> findAllWithMonthAmtRange(@RequestParam("fromRange") BigDecimal fromRange,
                                                                                         @RequestParam("toRange") BigDecimal toRange) {
        return ResponseEntity.ok(policyService.findByMonthAmountRange(fromRange, toRange));
    }

    @PostMapping("/init")
    public ResponseEntity<HttpResponse<PolicySummaryResponse>> savePolicy(PolicySummaryDTO request) {
        return ResponseEntity.ok(policyService.createPolicy(request));
    }

}
