package PATRONES.singleton;

import java.util.ArrayList;
import java.util.List;

public class LoggerSingleton implements LoggerInterface{
    private static LoggerSingleton instance;

    private List<String> logs;

    public static synchronized LoggerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerSingleton();
        }

        return instance;
    }

    private LoggerSingleton() {
        logs = new ArrayList<>();
    }

    @Override
    public void log(String message){

    }
    
    @Override
    public void showLogs(){

    }
}