package deliveryapp.domain;

import deliveryapp.InformApplication;
import deliveryapp.domain.Informed;
import deliveryapp.domain.InformedtoStore;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "InformMgmt_table")
@Data
public class InformMgmt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;

    private Long orderId;

    private Long menuId;

    private Long storeId;

    private String deliveryInfo;

    private String menuName;

    private String status;

    private Integer menuQty;

    private Long deliveryId;

    @PostPersist
    public void onPostPersist() {
        InformedtoStore informedtoStore = new InformedtoStore(this);
        informedtoStore.publishAfterCommit();

        Informed informed = new Informed(this);
        informed.publishAfterCommit();
    }

    public static InformMgmtRepository repository() {
        InformMgmtRepository informMgmtRepository = InformApplication.applicationContext.getBean(
            InformMgmtRepository.class
        );
        return informMgmtRepository;
    }

    public static void informToStore(Paid paid) {
        /** Example 1:  new item 
        InformMgmt informMgmt = new InformMgmt();
        repository().save(informMgmt);

        InformedtoStore informedtoStore = new InformedtoStore(informMgmt);
        informedtoStore.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(paid.get???()).ifPresent(informMgmt->{
            
            informMgmt // do something
            repository().save(informMgmt);

            InformedtoStore informedtoStore = new InformedtoStore(informMgmt);
            informedtoStore.publishAfterCommit();

         });
        */

    }

    public static void informToStore(OrderCancelled orderCancelled) {
        /** Example 1:  new item 
        InformMgmt informMgmt = new InformMgmt();
        repository().save(informMgmt);

        InformedtoStore informedtoStore = new InformedtoStore(informMgmt);
        informedtoStore.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(informMgmt->{
            
            informMgmt // do something
            repository().save(informMgmt);

            InformedtoStore informedtoStore = new InformedtoStore(informMgmt);
            informedtoStore.publishAfterCommit();

         });
        */

    }

    public static void informToStore(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        InformMgmt informMgmt = new InformMgmt();
        repository().save(informMgmt);

        InformedtoStore informedtoStore = new InformedtoStore(informMgmt);
        informedtoStore.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(informMgmt->{
            
            informMgmt // do something
            repository().save(informMgmt);

            InformedtoStore informedtoStore = new InformedtoStore(informMgmt);
            informedtoStore.publishAfterCommit();

         });
        */

    }

    public static void informFromStore(CookStarted cookStarted) {
        /** Example 1:  new item 
        InformMgmt informMgmt = new InformMgmt();
        repository().save(informMgmt);

        Informed informed = new Informed(informMgmt);
        informed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(informMgmt->{
            
            informMgmt // do something
            repository().save(informMgmt);

            Informed informed = new Informed(informMgmt);
            informed.publishAfterCommit();

         });
        */

    }

    public static void informFromStore(CookFinished cookFinished) {
        /** Example 1:  new item 
        InformMgmt informMgmt = new InformMgmt();
        repository().save(informMgmt);

        Informed informed = new Informed(informMgmt);
        informed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookFinished.get???()).ifPresent(informMgmt->{
            
            informMgmt // do something
            repository().save(informMgmt);

            Informed informed = new Informed(informMgmt);
            informed.publishAfterCommit();

         });
        */

    }

    public static void informFromStore(Rejected rejected) {
        /** Example 1:  new item 
        InformMgmt informMgmt = new InformMgmt();
        repository().save(informMgmt);

        Informed informed = new Informed(informMgmt);
        informed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(informMgmt->{
            
            informMgmt // do something
            repository().save(informMgmt);

            Informed informed = new Informed(informMgmt);
            informed.publishAfterCommit();

         });
        */

    }

    public static void informFromStore(Confirmed confirmed) {
        /** Example 1:  new item 
        InformMgmt informMgmt = new InformMgmt();
        repository().save(informMgmt);

        Informed informed = new Informed(informMgmt);
        informed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(confirmed.get???()).ifPresent(informMgmt->{
            
            informMgmt // do something
            repository().save(informMgmt);

            Informed informed = new Informed(informMgmt);
            informed.publishAfterCommit();

         });
        */

    }

    public static void infromFromRider(OrderPicked orderPicked) {
        /** Example 1:  new item 
        InformMgmt informMgmt = new InformMgmt();
        repository().save(informMgmt);

        Informed informed = new Informed(informMgmt);
        informed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderPicked.get???()).ifPresent(informMgmt->{
            
            informMgmt // do something
            repository().save(informMgmt);

            Informed informed = new Informed(informMgmt);
            informed.publishAfterCommit();

         });
        */

    }

    public static void infromFromRider(PressOkButton pressOkButton) {
        /** Example 1:  new item 
        InformMgmt informMgmt = new InformMgmt();
        repository().save(informMgmt);

        Informed informed = new Informed(informMgmt);
        informed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(pressOkButton.get???()).ifPresent(informMgmt->{
            
            informMgmt // do something
            repository().save(informMgmt);

            Informed informed = new Informed(informMgmt);
            informed.publishAfterCommit();

         });
        */

    }
}
