package deliveryapp.domain;

import deliveryapp.StoreApplication;
import deliveryapp.domain.Confirmed;
import deliveryapp.domain.Rejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "OrderMgmt_table")
@Data
public class OrderMgmt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long orderId;

    private Long storeId;

    private String deliveryInfo;

    private String menuName;

    private String status;

    private Integer menuQty;

    @PostPersist
    public void onPostPersist() {
        Confirmed confirmed = new Confirmed(this);
        confirmed.publishAfterCommit();

        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();
    }

    public static OrderMgmtRepository repository() {
        OrderMgmtRepository orderMgmtRepository = StoreApplication.applicationContext.getBean(
            OrderMgmtRepository.class
        );
        return orderMgmtRepository;
    }

    public static void confirm(InformedtoStore informedtoStore) {
        /** Example 1:  new item 
        OrderMgmt orderMgmt = new OrderMgmt();
        repository().save(orderMgmt);

        Confirmed confirmed = new Confirmed(orderMgmt);
        confirmed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(informedtoStore.get???()).ifPresent(orderMgmt->{
            
            orderMgmt // do something
            repository().save(orderMgmt);

            Confirmed confirmed = new Confirmed(orderMgmt);
            confirmed.publishAfterCommit();

         });
        */

    }

    public static void reject(InformedtoStore informedtoStore) {
        /** Example 1:  new item 
        OrderMgmt orderMgmt = new OrderMgmt();
        repository().save(orderMgmt);

        Rejected rejected = new Rejected(orderMgmt);
        rejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(informedtoStore.get???()).ifPresent(orderMgmt->{
            
            orderMgmt // do something
            repository().save(orderMgmt);

            Rejected rejected = new Rejected(orderMgmt);
            rejected.publishAfterCommit();

         });
        */

    }
}
