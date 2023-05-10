package deliveryapp.domain;

import deliveryapp.StoreApplication;
import deliveryapp.domain.CookFinished;
import deliveryapp.domain.CookStarted;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Cook_table")
@Data
public class Cook {

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
        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();

        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();
    }

    public static CookRepository repository() {
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(
            CookRepository.class
        );
        return cookRepository;
    }

    public static void cookFinish(CookStarted cookStarted) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        CookFinished cookFinished = new CookFinished(cook);
        cookFinished.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);

            CookFinished cookFinished = new CookFinished(cook);
            cookFinished.publishAfterCommit();

         });
        */

    }

    public static void cookStart(Confirmed confirmed) {
        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        CookStarted cookStarted = new CookStarted(cook);
        cookStarted.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(confirmed.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);

            CookStarted cookStarted = new CookStarted(cook);
            cookStarted.publishAfterCommit();

         });
        */

    }
}
