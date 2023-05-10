package deliveryapp.infra;

import deliveryapp.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class InformMgmtHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<InformMgmt>> {

    @Override
    public EntityModel<InformMgmt> process(EntityModel<InformMgmt> model) {
        return model;
    }
}
