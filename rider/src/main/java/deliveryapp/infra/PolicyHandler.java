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
    DeliveryMgmtRepository deliveryMgmtRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPicked'"
    )
    public void wheneverOrderPicked_Delivery(@Payload OrderPicked orderPicked) {
        OrderPicked event = orderPicked;
        System.out.println(
            "\n\n##### listener Delivery : " + orderPicked + "\n\n"
        );

        // Sample Logic //
        DeliveryMgmt.delivery(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Searchabled'"
    )
    public void wheneverSearchabled_PickOrder(
        @Payload Searchabled searchabled
    ) {
        Searchabled event = searchabled;
        System.out.println(
            "\n\n##### listener PickOrder : " + searchabled + "\n\n"
        );

        // Sample Logic //
        DeliveryMgmt.pickOrder(event);
    }
}
