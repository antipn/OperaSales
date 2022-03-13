package ru.learnup.java2.antipn.spring.boot.operasales.operasales.reporsitories;


import ru.learnup.java2.antipn.spring.boot.operasales.operasales.entity.PublicEvent;

import java.util.List;
import java.util.Optional;

//методы работы с таблицами и данными
//описываем общие методы по работе с данными в таблицах
public interface PublicEventDAO {

    PublicEvent addPublicEvent(PublicEvent event);

    Optional<PublicEvent> getPublicEventById(Integer id);

    List<PublicEvent> getAllPPublicEvent();

    PublicEvent updatePublicEvent(PublicEvent event); //+

    boolean deletePublicEventById(Integer id); //+

}
