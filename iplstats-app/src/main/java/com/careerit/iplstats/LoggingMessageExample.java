package com.careerit.iplstats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingMessageExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingMessageExample.class);
    public static void main(String[] args) {
        logger.debug("This is debug message");
        logger.info("This is info message");
        logger.warn("This is warning message");
        logger.error("This is error message");
        try {
            int result = 10 / 0; // Will cause exception
        } catch (Exception e) {
            logger.error("Exception occurred: ", e);
        }
    }
}
