package ru.learnup.java2.antipn.spring.boot.operasales.operasales.dto;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
public class PublicEventDto {
    private int id;
    private String publicEventName;
    private String publicEventStartDate;
    private String publicEventStartTime;
    private int numberHall;
    private String ratingRARS;
    private int ticketsIssued;
    private int soldTicketsCount;
    private List<TicketDto> tickets;
}
