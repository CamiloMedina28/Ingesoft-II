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
        logs.add(message);
    }
    
    @Override
    public void showLogs(){
        System.out.println("--------LOGS--------");
        for (String log : logs) {
            System.out.println(log);
        }
    }
}