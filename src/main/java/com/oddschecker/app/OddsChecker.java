package com.oddschecker.app;

import org.apache.log4j.Logger;

import java.io.IOException;

public class OddsChecker {

    static Logger log = Logger.getLogger(OddsChecker.class);

    public static void main(String[] args) throws IOException {
        validateInput(args);
        Long eventId = Long.valueOf(args[0]);
        new Scheduler().process(eventId);
    }

    private static void validateInput(String[] input) {
        if (input.length == 0 || !input[0].matches("[0-9]")) {
            log.warn("Please enter single valid MATCH eventId!");
            System.exit(0);
        }
    }
}
