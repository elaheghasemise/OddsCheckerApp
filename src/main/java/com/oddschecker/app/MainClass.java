package com.oddschecker.app;

import org.apache.log4j.Logger;

import java.io.IOException;

public class MainClass {

    static Logger log = Logger.getLogger(MainClass.class);

    public static void main(String[] args) throws IOException {
        validateInput(args);
        Long eventId = Long.valueOf(args[0]);
        new Scheduler().process(eventId);
    }

    private static void validateInput(String[] input) {
        if (input.length == 0) {
            log.warn("Please enter single valid MATCH eventId!");
            System.exit(0);
        }
    }
}
