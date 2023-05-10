package deliveryapp.domain;

import deliveryapp.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private Long userId;
    private Long menuId;
    private String deliveryInfo;
    private String menuName;
    private Integer menuQty;
    private String status;
    private Integer price;
}
