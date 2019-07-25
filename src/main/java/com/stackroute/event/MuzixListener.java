package com.stackroute.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class MuzixListener implements ApplicationListener<ContextRefreshedEvent> {  //Implements ApplicaionListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("ApplicationListener Invoked At Spring Container Startup");
    }
}


