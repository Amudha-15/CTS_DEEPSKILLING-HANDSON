package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingExample {
    private static final Logger logger = LoggerFactory.getLogger(LoggingExample.class);

    public static void main(String[] args) {
        // Demonstrating different logging levels
        logger.error("This is an error message");
        logger.warn("This is a warning message");
        logger.info("This is an info message");
        logger.debug("This is a debug message");
        logger.trace("This is a trace message");

        // Logging with exceptions
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("An arithmetic error occurred", e);
        }

        // Logging with parameters
        String username = "john_doe";
        int loginAttempts = 3;
        logger.warn("User {} has failed login {} times", username, loginAttempts);
    }
}
