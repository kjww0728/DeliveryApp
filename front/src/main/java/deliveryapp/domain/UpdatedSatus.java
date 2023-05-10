package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class UpdatedSatus extends AbstractEvent {

    private Long id;
    private Long userId;
    private String status;
    private Long orderId;

    public UpdatedSatus(Order aggregate) {
        super(aggregate);
    }

    public UpdatedSatus() {
        super();
    }
}
