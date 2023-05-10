package deliveryapp.domain;

import deliveryapp.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "informMgmts",
    path = "informMgmts"
)
public interface InformMgmtRepository
    extends PagingAndSortingRepository<InformMgmt, Long> {}
