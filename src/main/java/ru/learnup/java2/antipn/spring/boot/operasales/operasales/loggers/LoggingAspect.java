

package ru.learnup.java2.antipn.spring.boot.operasales.operasales.loggers;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @After("execution(* ru.learnup.java2.antipn.spring.boot.operasales.operasales.services.PublicEventManagerImpl.sellTicketInDB(..))")
    public void logAfter(JoinPoint joinPoint) {
//        System.out.println("logAfter() is running!");
//        System.out.println("Отслеживаем работу продажи билета в методе : " + joinPoint.getSignature().getName());
        log.info("Письмо об этом событии залогировано"); //@Slf4j
        System.out.println("Письмо об этом событии залогировано");
    }

}