// SingletonPattern.java
public class Logger {
    private static Logger instance;

    private Logger() {
        // private constructor
    }

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        logger.log("This is a singleton logger.");
    }
}
