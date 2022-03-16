package ru.learnup.java2.antipn.spring.boot.operasales.operasales.mapper;

import ru.learnup.java2.antipn.spring.boot.operasales.operasales.dto.PublicEventDto;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.dto.TicketDto;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.entity.Ticket;

import java.util.List;

public class TicketMapperMyImpl implements TicketMapper {


    @Override
    public TicketDto toDto(Ticket ticket) {
        return null;
    }

    @Override
    public List<TicketDto> toDtoList(List<Ticket> tickets) {
        List<TicketDto> list = null;
        TicketDto ticketDto = null;
        PublicEventDto eventDto = null;
        if (tickets == null) {
            return null;
        } else {

            for (Ticket ticket : tickets
            ) {
                ticketDto.setId(ticket.getId());
                // ticketDto.setEvent(ticket.getEvent()); // --перепсиать в событиеDto
                eventDto.getId();
                ticketDto.setSeatNumberTicket(ticket.getSeatNumberTicket());
                ticketDto.setTicketStatus(ticket.isTicketStatus());

            }
        }

        return null;
    }

    @Override
    public Ticket toEntity(TicketDto ticketDto) {
        return null;
    }

    @Override
    public List<Ticket> toEntityList(List<TicketDto> ticketsDto) {
        return null;
    }
}

