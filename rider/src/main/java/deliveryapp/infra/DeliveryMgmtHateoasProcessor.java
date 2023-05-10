package deliveryapp.infra;

import deliveryapp.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class DeliveryMgmtHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<DeliveryMgmt>> {

    @Override
    public EntityModel<DeliveryMgmt> process(EntityModel<DeliveryMgmt> model) {
        return model;
    }
}
