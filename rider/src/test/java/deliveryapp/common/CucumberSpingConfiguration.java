package deliveryapp.common;

import deliveryapp.RiderApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { RiderApplication.class })
public class CucumberSpingConfiguration {}
