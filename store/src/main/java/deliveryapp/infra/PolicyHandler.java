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
    OrderMgmtRepository orderMgmtRepository;

    @Autowired
    CookRepository cookRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='InformedtoStore'"
    )
    public void wheneverInformedtoStore_Confirm(
        @Payload InformedtoStore informedtoStore
    ) {
        InformedtoStore event = informedtoStore;
        System.out.println(
            "\n\n##### listener Confirm : " + informedtoStore + "\n\n"
        );

        // Sample Logic //
        OrderMgmt.confirm(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='InformedtoStore'"
    )
    public void wheneverInformedtoStore_Reject(
        @Payload InformedtoStore informedtoStore
    ) {
        InformedtoStore event = informedtoStore;
        System.out.println(
            "\n\n##### listener Reject : " + informedtoStore + "\n\n"
        );

        // Sample Logic //
        OrderMgmt.reject(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookStarted'"
    )
    public void wheneverCookStarted_CookFinish(
        @Payload CookStarted cookStarted
    ) {
        CookStarted event = cookStarted;
        System.out.println(
            "\n\n##### listener CookFinish : " + cookStarted + "\n\n"
        );

        // Sample Logic //
        Cook.cookFinish(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Confirmed'"
    )
    public void wheneverConfirmed_CookStart(@Payload Confirmed confirmed) {
        Confirmed event = confirmed;
        System.out.println(
            "\n\n##### listener CookStart : " + confirmed + "\n\n"
        );

        // Sample Logic //
        Cook.cookStart(event);
    }
}
