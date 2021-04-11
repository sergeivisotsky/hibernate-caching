package org.sergei.hibernate.caching.dao;

import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Query;

import org.sergei.hibernate.caching.dao.domain.PolicySummary;
import org.springframework.stereotype.Repository;

/**
 * @author Sergei Visotsky
 * @since 1.0
 */
@Repository
public class PolicySummaryDao extends GenericJPADAO<PolicySummary, Long> {

    private static final String QUERY_FIND_BY_MONTH_AMT_IN_RANGE = "SELECT p FROM PolicySummary p " +
            "LEFT JOIN FETCH p.premiumEntry as pe " +
            "WHERE pe.monthlyAmount IN (:from, :to)";

    public PolicySummaryDao() {
        super(PolicySummary.class);
    }

    @SuppressWarnings("unchecked")
    public List<PolicySummary> findByMonthAmountRange(BigDecimal from, BigDecimal to) {
        Query query = getEntityManager().createQuery(QUERY_FIND_BY_MONTH_AMT_IN_RANGE);

        query.setHint("org.hibernate.cacheable", true);
        query.setParameter("from", from);
        query.setParameter("to", to);

        return query.getResultList();
    }
}
