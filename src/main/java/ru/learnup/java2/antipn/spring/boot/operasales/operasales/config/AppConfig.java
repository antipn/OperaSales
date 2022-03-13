package ru.learnup.java2.antipn.spring.boot.operasales.operasales.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.reporsitories.EventRepository;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.reporsitories.PublicEventDAO;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.reporsitories.PublicEventDataJpa;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.reporsitories.TicketRepository;

@Configuration
public class AppConfig {
    @Bean
    public PublicEventDAO publicEventDataJpa(EventRepository eventRepository, TicketRepository ticketRepository) {
        return new PublicEventDataJpa(eventRepository, ticketRepository);
    }
}
