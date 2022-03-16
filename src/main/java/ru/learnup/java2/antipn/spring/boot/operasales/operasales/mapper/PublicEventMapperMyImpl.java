package ru.learnup.java2.antipn.spring.boot.operasales.operasales.mapper;

import ru.learnup.java2.antipn.spring.boot.operasales.operasales.dto.PublicEventDto;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.entity.PublicEvent;

import java.util.List;

public class PublicEventMapperMyImpl implements PublicEventMapper {
    @Override
    public PublicEvent toEntity(PublicEventDto eventDto) {
        PublicEvent event = null;
        if (eventDto == null) {
            return null;
        } else {
            event.setId(eventDto.getId());
            event.setPublicEventName(eventDto.getPublicEventName());
            event.setPublicEventStartDate(eventDto.getPublicEventStartDate());
            event.setPublicEventStartTime(eventDto.getPublicEventStartTime());
            event.setNumberHall(eventDto.getNumberHall());
            event.setRatingRARS(eventDto.getRatingRARS());
            event.setTicketsIssued(eventDto.getTicketsIssued());
            event.setSoldTicketsCount(eventDto.getSoldTicketsCount());
            //           event.setTickets(eventDto.getTickets()); // Написать тикет -> dto!!!!
        }

        return event;
    }

    @Override
    public List<PublicEvent> toEntityList(List<PublicEventDto> eventsDto) {
        return null;
    }

    @Override
    public PublicEventDto toDto(PublicEvent event) {
        return null;
    }

    @Override
    public List<PublicEventDto> toDtoList(List<PublicEvent> events) {
        return null;
    }
}
