package ru.learnup.java2.antipn.spring.boot.operasales.operasales.services.facade;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.learnup.java2.antipn.spring.boot.operasales.operasales.services.EventManagerImpl;

@Service
@RequiredArgsConstructor
public class OperaFacade {
    private final EventManagerImpl eventManager;
//    private final EventManager1 eventManager1;
//    private final EventManager2 eventManager2;
}