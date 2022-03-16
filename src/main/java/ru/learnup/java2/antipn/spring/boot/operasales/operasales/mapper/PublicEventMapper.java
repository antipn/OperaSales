package ru.learnup.java2.antipn.spring.boot.operasales.operasales.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.dto.PublicEventDto;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.entity.PublicEvent;

import java.util.List;

@Mapper
public interface PublicEventMapper {

    PublicEventMapper MAPPER = Mappers.getMapper(PublicEventMapper.class);

    PublicEvent toEntity(PublicEventDto eventDto);

    List<PublicEvent> toEntityList(List<PublicEventDto> eventsDto);

    @InheritInverseConfiguration
    PublicEventDto toDto(PublicEvent event);

    List<PublicEventDto> toDtoList(List<PublicEvent> events);

}
