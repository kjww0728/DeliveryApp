package deliveryapp.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Dashboard_table")
@Data
public class Dashboard {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long orderId;
    private Long storeId;
    private Long menuId;
    private String menuName;
    private Integer menuQty;
    private String status;
    private Integer price;
    private Long deliveryId;
}
