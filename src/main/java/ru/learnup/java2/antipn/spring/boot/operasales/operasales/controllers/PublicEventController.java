package ru.learnup.java2.antipn.spring.boot.operasales.operasales.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.dto.PublicEventDto;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.entity.PublicEvent;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.services.PublicEventManager;

import java.util.ArrayList;
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

    //ALL events
    @GetMapping
    public Collection<PublicEventDto> events() {
              return eventManager.findAllEvents();
    }

    @GetMapping("/{id}")
    public PublicEventDto getEvent(@PathVariable int id){
        return eventManager.findEventById(id);
    }


}