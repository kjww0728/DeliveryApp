package deliveryapp.infra;

import deliveryapp.config.kafka.KafkaProcessor;
import deliveryapp.domain.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class DashboardViewHandler {

    @Autowired
    private DashboardRepository dashboardRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1(
        @Payload OrderPlaced orderPlaced
    ) {
        try {
            if (!orderPlaced.validate()) return;

            // view 객체 생성
            Dashboard dashboard = new Dashboard();
            // view 객체에 이벤트의 Value 를 set 함
            dashboard.setOrderId(orderPlaced.getId());
            dashboard.setMenuId(orderPlaced.getMenuId());
            dashboard.setMenuName(orderPlaced.getMenuName());
            dashboard.setMenuQty(orderPlaced.getMenuQty());
            dashboard.setStatus(orderPlaced.getStatus());
            // view 레파지 토리에 save
            dashboardRepository.save(dashboard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenUpdatedSatus_then_UPDATE_1(
        @Payload UpdatedSatus updatedSatus
    ) {
        try {
            if (!updatedSatus.validate()) return;
            // view 객체 조회

            List<Dashboard> dashboardList = dashboardRepository.findByOrderId(
                updatedSatus.getOrderId()
            );
            for (Dashboard dashboard : dashboardList) {
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                dashboard.setStatus(updatedSatus.getStatus());
                // view 레파지 토리에 save
                dashboardRepository.save(dashboard);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
