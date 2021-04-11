package org.sergei.hibernate.caching.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.sergei.hibernate.caching.dao.domain.PolicySummary;
import org.sergei.hibernate.caching.dto.PolicySummaryDTO;

/**
 * Maps a policy DTO
 *
 * @author Sergei Visotsky
 * @since 1.0
 */
@Mapper
public interface PolicyDTOMapper {

    List<PolicySummaryDTO> applyList(List<PolicySummary> policySummary);
}
