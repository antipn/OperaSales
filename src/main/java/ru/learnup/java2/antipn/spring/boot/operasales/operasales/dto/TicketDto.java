package ru.learnup.java2.antipn.spring.boot.operasales.operasales.dto;

import lombok.*;

@Data
@Getter
@Setter
public class TicketDto {

    private Integer id;
    private PublicEventDto event;
    private Integer seatNumberTicket;
    private boolean ticketStatus;
}


