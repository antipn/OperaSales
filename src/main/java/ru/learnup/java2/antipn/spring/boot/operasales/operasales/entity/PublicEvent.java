package ru.learnup.java2.antipn.spring.boot.operasales.operasales.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "events")
public class PublicEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "events_seq")
    @SequenceGenerator(name = "events_seq",
            sequenceName = "hibernate_sequence_event", allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String publicEventName; // Название

    @Column(name = "date")
    private String publicEventStartDate; //Дата начала dd/mm/yyyy

    @Column(name = "time")
    private String publicEventStartTime; //Время начала  hh:mm

    @Column(name = "hall")
    private Integer numberHall; // the number of Hall where will be event

    @Column(name = "rars")
    private String ratingRARS; //Russian Age Rating System +0 +6 +12 +16 +18

    @Column(name = "tickets_issued")
    private int ticketsIssued; // билетов всего

    @Column(name = "tickets_sold")
    private int soldTicketsCount;// всего продано билетов

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets; //= new ArrayList<>(); // list of ticket for event

    public PublicEvent(Integer id, String publicEventName, String publicEventStartDate, String publicEventStartTime, int numberHall, String ratingRARS, int ticketsCount) {
        this.id = id;
        this.publicEventName = publicEventName;
        this.publicEventStartDate = publicEventStartDate;
        this.publicEventStartTime = publicEventStartTime;
        this.ratingRARS = ratingRARS;
        this.numberHall = numberHall;
        this.ticketsIssued = ticketsCount;
    }

    public void increaseSoldTicket() {
        this.soldTicketsCount++;

    }

    public void decreaseSoldTicket() {
        this.soldTicketsCount--;
    }


    @Override
    public String toString() {
        return "ID  " + (id == null ? "" : id) + "  название: " + publicEventName + "\nАттрибуты: " + publicEventStartDate + "\t" + publicEventStartTime + "\t" + ratingRARS + "\t Номер зала " + numberHall + "\t Выпущено " + ticketsIssued + "\t Билетов продано " + soldTicketsCount;
    }
}
