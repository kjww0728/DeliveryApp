package deliveryapp.common;

import deliveryapp.InformApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { InformApplication.class })
public class CucumberSpingConfiguration {}
