package ru.learnup.java2.antipn.spring.boot.operasales.operasales.loggers;

import org.springframework.stereotype.Component;

@Component
public class Logger {
    public void printing(){
        System.out.println("Логгер активирован");
    }
}
