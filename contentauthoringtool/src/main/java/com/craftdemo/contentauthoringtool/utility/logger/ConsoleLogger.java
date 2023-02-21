package com.craftdemo.contentauthoringtool.utility.logger;

import com.craftdemo.contentauthoringtool.utility.ILogger;
import org.springframework.stereotype.Service;

@Service
public class ConsoleLogger<T> implements ILogger<T> {

    @Override
    public void logInfo( T log) {
        System.out.println(log);
    }

    @Override
    public void logError(T log) {
        System.err.println(log);
    }
}
