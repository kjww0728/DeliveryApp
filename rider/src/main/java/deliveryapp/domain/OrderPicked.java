package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPicked extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long orderId;
    private Long storeId;
    private String deliveryInfo;
    private String status;
    private Long deliveryId;

    public OrderPicked(DeliveryMgmt aggregate) {
        super(aggregate);
    }

    public OrderPicked() {
        super();
    }
}
