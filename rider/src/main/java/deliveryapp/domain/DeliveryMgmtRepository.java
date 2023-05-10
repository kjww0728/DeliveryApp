package deliveryapp.domain;

import deliveryapp.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "deliveryMgmts",
    path = "deliveryMgmts"
)
public interface DeliveryMgmtRepository
    extends PagingAndSortingRepository<DeliveryMgmt, Long> {}
