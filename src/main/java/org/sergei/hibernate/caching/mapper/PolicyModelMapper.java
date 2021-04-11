package org.sergei.hibernate.caching.mapper;

import org.mapstruct.Mapper;
import org.sergei.hibernate.caching.dao.domain.PolicySummary;
import org.sergei.hibernate.caching.dto.PolicySummaryDTO;

/**
 * Maps from {@link PolicySummaryDTO} to {@link PolicySummary}.
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
@Mapper
public interface PolicyModelMapper {

    PolicySummary apply(PolicySummaryDTO requestDTO);

}
