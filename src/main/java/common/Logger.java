package common;

public class Logger {
    public static void logln(Object msg) {
        System.out.println(msg.toString());
    }

    public static void log(Object msg) {
        System.out.print(msg.toString());
    }
}
