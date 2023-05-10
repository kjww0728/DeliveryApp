package deliveryapp.domain;

import deliveryapp.RiderApplication;
import deliveryapp.domain.OrderPicked;
import deliveryapp.domain.PressOkButton;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DeliveryMgmt_table")
@Data
public class DeliveryMgmt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long orderId;

    private Long storeId;

    private String deliveryInfo;

    private String status;

    private Long deliveryId;

    @PostPersist
    public void onPostPersist() {
        OrderPicked orderPicked = new OrderPicked(this);
        orderPicked.publishAfterCommit();

        PressOkButton pressOkButton = new PressOkButton(this);
        pressOkButton.publishAfterCommit();
    }

    public static DeliveryMgmtRepository repository() {
        DeliveryMgmtRepository deliveryMgmtRepository = RiderApplication.applicationContext.getBean(
            DeliveryMgmtRepository.class
        );
        return deliveryMgmtRepository;
    }

    public static void delivery(OrderPicked orderPicked) {
        /** Example 1:  new item 
        DeliveryMgmt deliveryMgmt = new DeliveryMgmt();
        repository().save(deliveryMgmt);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPicked.get???()).ifPresent(deliveryMgmt->{
            
            deliveryMgmt // do something
            repository().save(deliveryMgmt);


         });
        */

    }

    public static void pickOrder(Searchabled searchabled) {
        /** Example 1:  new item 
        DeliveryMgmt deliveryMgmt = new DeliveryMgmt();
        repository().save(deliveryMgmt);

        */

        /** Example 2:  finding and process
        
        repository().findById(searchabled.get???()).ifPresent(deliveryMgmt->{
            
            deliveryMgmt // do something
            repository().save(deliveryMgmt);


         });
        */

    }
}
