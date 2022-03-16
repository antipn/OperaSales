package ru.learnup.java2.antipn.spring.boot.operasales.operasales.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tickets_seq")
    @SequenceGenerator(name = "tickets_seq", sequenceName = "hibernate_sequence_tickets", allocationSize = 1)
    @Column(name = "id")
    private Integer id; // номер билета

    @JoinColumn(name = "event_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private PublicEvent event;  //номер события для этого билета

    @Column(name = "seat_number")
    private Integer seatNumberTicket; // номер места билета

    @Column(name = "ticket_status") //продано не продано
    private boolean ticketStatus;

    @Override
    public String toString() {
        return "Номер билета = " + id + " , Номер места = " + seatNumberTicket + " , Билет доступен: " + (!ticketStatus ? "Да" : "Нет");
    }
}
