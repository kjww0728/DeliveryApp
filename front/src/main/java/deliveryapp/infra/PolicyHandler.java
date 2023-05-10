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
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='CookFinished'"
    )
    public void wheneverCookFinished_Searchable(
        @Payload CookFinished cookFinished
    ) {
        CookFinished event = cookFinished;
        System.out.println(
            "\n\n##### listener Searchable : " + cookFinished + "\n\n"
        );

        // Sample Logic //
        Order.searchable(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='UpdatedSatus'"
    )
    public void wheneverUpdatedSatus_NotifyToUserByKakao(
        @Payload UpdatedSatus updatedSatus
    ) {
        UpdatedSatus event = updatedSatus;
        System.out.println(
            "\n\n##### listener NotifyToUserByKakao : " + updatedSatus + "\n\n"
        );

        // Sample Logic //
        Order.notifyToUserByKakao(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='Informed'"
    )
    public void wheneverInformed_UpdateStatus(@Payload Informed informed) {
        Informed event = informed;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + informed + "\n\n"
        );

        // Sample Logic //
        Order.updateStatus(event);
    }
}
