package pl.training.shop.common;

import lombok.extern.java.Log;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Log
public class ContextListener {

    @EventListener
    public void onContextRefreshed(ContextRefreshedEvent refreshedEvent){
        log.info("context has been refreshed");
    }

}
