package com.craftdemo.contentauthoringtool.utility;

/**
 * This interface defines the methods to log events
 */
public interface ILogger<T> {
    /**
     * Logs the information
     * @param log the actual message to be printed
     *
     */
    void logInfo(T log);

    /**
     * Logs the error
     * @param log the error message to be printed
     *
     */
    void logError(T log);
}
