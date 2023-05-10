package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class InformedtoStore extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long orderId;
    private Long menuId;
    private String deliveryInfo;
    private String menuName;
    private String status;
    private Integer menuQty;

    public InformedtoStore(InformMgmt aggregate) {
        super(aggregate);
    }

    public InformedtoStore() {
        super();
    }
}
