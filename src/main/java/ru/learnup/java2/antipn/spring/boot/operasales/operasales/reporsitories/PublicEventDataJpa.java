package ru.learnup.java2.antipn.spring.boot.operasales.operasales.reporsitories;

import ru.learnup.java2.antipn.spring.boot.operasales.operasales.entity.PublicEvent;

import java.util.List;
import java.util.Optional;


//этот класс реализует интерфейс с методами работы с таблицами
//APPLICATION BEAN!!! DAODATAJPA

public class PublicEventDataJpa implements PublicEventDAO {
    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;

    public PublicEventDataJpa(EventRepository eventRepository, TicketRepository ticketRepository) {
        this.eventRepository = eventRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public PublicEvent addPublicEvent(PublicEvent event) {
        return eventRepository.save(event);
    }

    @Override
    public Optional<PublicEvent> getPublicEventById(Integer id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<PublicEvent> getAllPPublicEvent() {
        return eventRepository.findAll();
    }

    @Override
    public PublicEvent updatePublicEvent(PublicEvent event) {
        return addPublicEvent(event);
    }

    @Override
    public boolean deletePublicEventById(Integer id) {
        eventRepository.deleteById(id);
        return true;
    }
}
