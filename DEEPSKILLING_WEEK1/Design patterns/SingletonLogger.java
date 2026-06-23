public class SingletonLogger {
    private static SingletonLogger instance;
    private SingletonLogger() {}

    public static synchronized SingletonLogger getInstance() {
        if (instance == null) instance = new SingletonLogger();
        return instance;
    }

    public void log(String msg) { System.out.println("[LOG] " + msg); }

    public static void main(String[] args) {
        SingletonLogger a = SingletonLogger.getInstance();
        SingletonLogger b = SingletonLogger.getInstance();
        a.log("Hello from a");
        b.log("Hello from b");
        System.out.println("Same instance? " + (a == b));
    }
}
