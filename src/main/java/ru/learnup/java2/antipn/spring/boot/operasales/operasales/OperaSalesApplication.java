package ru.learnup.java2.antipn.spring.boot.operasales.operasales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.services.EventManagerImpl;

@SpringBootApplication
public class OperaSalesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OperaSalesApplication.class, args);
        EventManagerImpl manager = context.getBean(EventManagerImpl.class);

        manager.showEventsInDB();
    }
}
