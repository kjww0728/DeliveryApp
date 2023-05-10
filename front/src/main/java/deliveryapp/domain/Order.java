package deliveryapp.domain;

import deliveryapp.FrontApplication;
import deliveryapp.domain.OrderCancelled;
import deliveryapp.domain.OrderPlaced;
import deliveryapp.domain.Searchabled;
import deliveryapp.domain.UpdatedSatus;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long menuId;

    private Long storeId;

    private String deliveryInfo;

    private String menuName;

    private Integer menuQty;

    private String status;

    private Integer price;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderCancelled orderCancelled = new OrderCancelled(this);
        orderCancelled.publishAfterCommit();

        Searchabled searchabled = new Searchabled(this);
        searchabled.publishAfterCommit();

        UpdatedSatus updatedSatus = new UpdatedSatus(this);
        updatedSatus.publishAfterCommit();
    }

    @PreRemove
    public void onPreRemove() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void searchable(CookFinished cookFinished) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        Searchabled searchabled = new Searchabled(order);
        searchabled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            Searchabled searchabled = new Searchabled(order);
            searchabled.publishAfterCommit();

         });
        */

    }

    public static void notifyToUserByKakao(UpdatedSatus updatedSatus) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        */

        /** Example 2:  finding and process
        
        repository().findById(updatedSatus.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);


         });
        */

    }

    public static void updateStatus(Informed informed) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        UpdatedSatus updatedSatus = new UpdatedSatus(order);
        updatedSatus.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(informed.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            UpdatedSatus updatedSatus = new UpdatedSatus(order);
            updatedSatus.publishAfterCommit();

         });
        */

    }
}
