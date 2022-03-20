package ru.learnup.java2.antipn.spring.boot.operasales.operasales.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.dto.EntityNotFoundResponse;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.dto.PublicEventDto;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.dto.TicketDto;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.exception.EntityNotFoundException;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.services.PublicEventManager;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/app/v1/events") //наше контроллер начинает с этого пути + остальное методами и их маппингом

public class PublicEventController {
    private final PublicEventManager eventManager;

    @Autowired
    public PublicEventController(PublicEventManager eventManager) {
        this.eventManager = eventManager;
    }

    //Show all events in DB in browser --> 1 task done
    // http://localhost:8080/app/v1/events/all
    @GetMapping("/all")
    public Collection<PublicEventDto> eventsAll() {
        for (PublicEventDto eventDto : eventManager.findAllEvents()) {
            System.out.println(eventDto); //вывод в консоль
        }
        return eventManager.findAllEvents();
    }

    // http://localhost:8080/app/v1/events/1
    @GetMapping("/{id}")
    public PublicEventDto getEvent(@PathVariable int id) {
        chekingID(id); //если не находим то выкинем исключение
        return eventManager.findEventById(id);
    }

    //Delete event in DB through browser  --> 3 task done
    // http://localhost:8080/app/v1/events/1
    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable int id) {
        chekingID(id); //если не находим то выкинем исключение
        eventManager.deleteEventByID(id);
    }

    //Post -> save record  --> 2 task done
    // http://localhost:8080/app/v1/events/new
    @PostMapping("/new")
    public PublicEventDto addProduct(@RequestBody PublicEventDto eventDto) {
        return eventManager.saveEvent(eventDto);
    }

    //Put --> update record --> 4 task done
    // http://localhost:8080/app/v1/events/update/5
    @PutMapping("/update/{id}")
    public PublicEventDto updateEvent(@RequestBody PublicEventDto eventDto, @PathVariable(name = "id") int id) {
        chekingID(id); //проверяем что есть что обновлять
        eventDto.setId(id); //специально делаем так как может прийти eventDto с ID
        System.out.println("Updating record...");
        return eventManager.updateEvent(eventDto);
    }

    //просмотр билетов на событие вернее посадочных мест for 5 task done
    // http://localhost:8080/app/v1/events/1/sell
    @GetMapping("/{id}/sell")
    public List<TicketDto> viewTickets(@PathVariable(name = "id") int id) {
        chekingID(id);
        PublicEventDto eventDto = eventManager.findEventById(id);
        List<TicketDto> ticketsDto = eventDto.getTickets();
        return ticketsDto;
    }

    //продажа билета --> 5 task done
    // http://localhost:8080/app/v1/events/1/sell/1
    @PostMapping("/{event_id}/sell/{ticket_seat}")
    public TicketDto sellTicket(@PathVariable(name = "event_id") int eventId, @PathVariable(name = "ticket_seat") int ticketSeat) {
        chekingID(eventId);
        System.out.println("Purchasing process...");
        return eventManager.sellTicket(eventId, ticketSeat);
    }

    //возврат билета 6 task done
    // http://localhost:8080/app/v1/events/return/ticket/2
    @PutMapping("/return/ticket/{id}")
    public TicketDto returnTicket(@PathVariable(name = "id") int id) {
        chekingTicketID(id);
        System.out.println("Return the ticket...");
        return eventManager.updateTicket(id);
    }

    //проверяем что событие есть в базе
    private void chekingID(@PathVariable int id) {
        if (!eventManager.existEventByID(id)) {
            throw new EntityNotFoundException("PublicEvent", id, "PublicEvent not found");
        }
    }

    //проверяем что билет есть в базе
    private void chekingTicketID(@PathVariable int id) {
        if (!eventManager.existTicketByID(id)) {
            throw new EntityNotFoundException("Ticket", id, "Ticket not found");
        }
    }

    @ExceptionHandler
    public ResponseEntity<EntityNotFoundResponse> handleException(EntityNotFoundException ex) {
        EntityNotFoundResponse response = new EntityNotFoundResponse();
        response.setEntityName(ex.getEntityName());
        response.setEntityId(ex.getEntityId());
        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}