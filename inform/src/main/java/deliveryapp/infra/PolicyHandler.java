package deliveryapp.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import deliveryapp.config.kafka.KafkaProcessor;
import deliveryapp.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    InformMgmtRepository informMgmtRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Paid'"
    )
    public void wheneverPaid_InformToStore(@Payload Paid paid) {
        Paid event = paid;
        System.out.println(
            "\n\n##### listener InformToStore : " + paid + "\n\n"
        );

        // Sample Logic //
        InformMgmt.informToStore(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancelled'"
    )
    public void wheneverOrderCancelled_InformToStore(
        @Payload OrderCancelled orderCancelled
    ) {
        OrderCancelled event = orderCancelled;
        System.out.println(
            "\n\n##### listener InformToStore : " + orderCancelled + "\n\n"
        );

        // Sample Logic //
        InformMgmt.informToStore(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_InformToStore(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener InformToStore : " + orderPlaced + "\n\n"
        );

        // Sample Logic //
        InformMgmt.informToStore(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_InformFromStore(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener InformFromStore : " + cookStarted + "\n\n"
        );

        // Sample Logic //
        InformMgmt.informFromStore(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_InformFromStore(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener InformFromStore : " + cookFinished + "\n\n"
        );

        // Sample Logic //
        InformMgmt.informFromStore(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Rejected'"
    )
    public void wheneverRejected_InformFromStore(@Payload Rejected rejected) {
        Rejected event = rejected;
        System.out.println(
            "\n\n##### listener InformFromStore : " + rejected + "\n\n"
        );

        // Sample Logic //
        InformMgmt.informFromStore(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Confirmed'"
    )
    public void wheneverConfirmed_InformFromStore(
        @Payload Confirmed confirmed
    ) {
        Confirmed event = confirmed;
        System.out.println(
            "\n\n##### listener InformFromStore : " + confirmed + "\n\n"
        );

        // Sample Logic //
        InformMgmt.informFromStore(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPicked'"
    )
    public void wheneverOrderPicked_InfromFromRider(
        @Payload OrderPicked orderPicked
    ) {
        OrderPicked event = orderPicked;
        System.out.println(
            "\n\n##### listener InfromFromRider : " + orderPicked + "\n\n"
        );

        // Sample Logic //
        InformMgmt.infromFromRider(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PressOkButton'"
    )
    public void wheneverPressOkButton_InfromFromRider(
        @Payload PressOkButton pressOkButton
    ) {
        PressOkButton event = pressOkButton;
        System.out.println(
            "\n\n##### listener InfromFromRider : " + pressOkButton + "\n\n"
        );

        // Sample Logic //
        InformMgmt.infromFromRider(event);
    }
}
