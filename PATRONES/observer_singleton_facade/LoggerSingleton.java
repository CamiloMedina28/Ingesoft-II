package PATRONES.observer_singleton_facade;

import java.util.ArrayList;
import java.util.List;

public class LoggerSingleton {
    private static LoggerSingleton instance;

    private List<String> logs;

    private LoggerSingleton() {
        logs = new ArrayList<>();
    }

    public static synchronized LoggerSingleton getInstance() {

        if (instance == null) {
            instance = new LoggerSingleton();
        }

        return instance;
    }

    public void addLog(String log) {
        logs.add(log);
        System.out.println("[LOGGER - Mensaje] " + log);
    }

    public List<String> getLogs() {
        return logs;
    }
}
