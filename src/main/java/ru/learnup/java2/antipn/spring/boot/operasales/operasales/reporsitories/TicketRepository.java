package ru.learnup.java2.antipn.spring.boot.operasales.operasales.reporsitories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.entity.Ticket;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    List<Ticket> getTicketsByTicketStatus(boolean statusTicket); //по статусу билета продан не продан
}
