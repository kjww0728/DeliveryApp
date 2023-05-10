package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Confirmed extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long orderId;
    private Long storeId;
    private String deliveryInfo;
    private String menuName;
    private String status;
    private Integer menuQty;

    public Confirmed(OrderMgmt aggregate) {
        super(aggregate);
    }

    public Confirmed() {
        super();
    }
}
