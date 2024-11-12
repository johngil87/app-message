package com.app.messages.infrastructure.helpers.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UtilLogger {

    public static void info(Class<?> clazz,String message, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.info(message, args);
    }

    public static void error(Class<?> clazz,String message, Object... args) {
        Logger logger = LoggerFactory.getLogger(clazz);
        logger.error(message, args);
    }
}
