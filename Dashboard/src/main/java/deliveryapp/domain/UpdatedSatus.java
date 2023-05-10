package deliveryapp.domain;

import deliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class UpdatedSatus extends AbstractEvent {

    private Long id;
    private Long userId;
    private String status;
    private Long orderId;
}
