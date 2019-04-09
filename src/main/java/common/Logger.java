package common;

public class Logger {
    public static void logln(Object msg) {
        System.out.println(msg.toString());
    }

    public static void logln(String method,Object msg){
        System.out.println(method+":     "+msg.toString());
    }

    public static void logTag(String str){
        System.out.println("------------------"+str+"------------------");
    }

    public static void log(Object msg) {
        System.out.print(msg.toString());
    }
}
