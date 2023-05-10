package deliveryapp.domain;

import deliveryapp.domain.*;
import deliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class Searchabled extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long orderId;
    private Long storeId;
    private String deliveryInfo;
    private String status;
}
