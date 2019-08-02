package com.stackroute.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class CommandLineAppStartUpRunner implements CommandLineRunner { //Implements CommandLineRunner which executes once in application lifetime
    private static final Logger logger = LoggerFactory.getLogger(CommandLineAppStartUpRunner.class);

    @Override
    public void run(String... args) throws Exception {
        logger.info("Application started with command-line arguments: {} . \n To kill this application, press Ctrl + C.", Arrays.toString(args));
    }
}