package hw_01_2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    protected int num = 1;
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        return instance == null ? instance = new Logger() : instance;
    }

    public void log(String msg) {
        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        System.out.println("[" + df.format(new Date()) + " " + num++ + "] " + msg);
    }
}
