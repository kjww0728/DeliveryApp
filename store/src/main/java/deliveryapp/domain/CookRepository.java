package deliveryapp.domain;

import deliveryapp.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "cooks", path = "cooks")
public interface CookRepository
    extends PagingAndSortingRepository<Cook, Long> {}
