package ru.learnup.java2.antipn.spring.boot.operasales.operasales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.dto.TicketDto;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.entity.Ticket;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.services.PublicEventManager;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/app/v1/tickets") //наше контроллер начинает с этого пути + остальное методами и их маппингом

public class TicketController {
    private final PublicEventManager eventManager;

    @Autowired
    public TicketController(PublicEventManager eventManager) {
        this.eventManager = eventManager;
    }

    //all tickets
    @GetMapping
    public Collection<TicketDto> tickets() {
    return eventManager.findAllTickets();
    }

    //get one ticket by id
    @GetMapping("/{id}")
    public TicketDto getTicket(@PathVariable int id){
        return eventManager.findTicketById(id);
    }

}
