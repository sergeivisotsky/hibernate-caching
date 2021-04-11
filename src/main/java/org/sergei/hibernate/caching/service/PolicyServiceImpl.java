package org.sergei.hibernate.caching.service;

import java.math.BigDecimal;
import java.util.List;

import org.sergei.hibernate.caching.dao.PolicySummaryDao;
import org.sergei.hibernate.caching.dao.domain.PolicySummary;
import org.sergei.hibernate.caching.dto.HttpResponse;
import org.sergei.hibernate.caching.dto.PolicySummaryDTO;
import org.sergei.hibernate.caching.dto.PolicySummaryResponse;
import org.sergei.hibernate.caching.dto.Status;
import org.sergei.hibernate.caching.mapper.PolicyDTOMapper;
import org.sergei.hibernate.caching.mapper.PolicyModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Sergei Visotsky
 * @since 1.0
 */
@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyModelMapper policyModelMapper;
    private final PolicyDTOMapper policyDTOMapper;
    private final PolicySummaryDao policySummaryDao;

    public PolicyServiceImpl(PolicyModelMapper policyModelMapper,
                             PolicyDTOMapper policyDTOMapper,
                             PolicySummaryDao policySummaryDao) {
        this.policyModelMapper = policyModelMapper;
        this.policyDTOMapper = policyDTOMapper;
        this.policySummaryDao = policySummaryDao;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public HttpResponse<List<PolicySummaryDTO>> findByMonthAmountRange(BigDecimal from, BigDecimal to) {
        List<PolicySummaryDTO> policyDTOs = policyDTOMapper.applyList(
                policySummaryDao.findByMonthAmountRange(from, to)
        );
        return new HttpResponse<>(Status.SUCCESS, policyDTOs);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public HttpResponse<PolicySummaryResponse> createPolicy(PolicySummaryDTO request) {
        PolicySummary savedPolicy = policySummaryDao.save(policyModelMapper.apply(request));

        PolicySummaryResponse response = new PolicySummaryResponse();
        response.setPolicyNumber(savedPolicy.getPolicyNumber());
        response.setCustomerNumber(savedPolicy.getCustomerNumber());
        response.setProductCd(savedPolicy.getProductCd());

        return new HttpResponse<>(Status.SUCCESS, response);
    }
}
