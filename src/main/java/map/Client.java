package map;

import common.Logger;

public class Client {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMapInBst<>();

        map.add("11", "Bob");
        map.add("12", "Lucy");
        map.add("89", "Tina");
        Logger.logln(map);

        Logger.logln("size=" + map.getSize());

        Logger.logln("map.get(13)=" + map.get("13"));

        Logger.logln(map.contains("12"));

        map.set("18","18");
        Logger.logln(map);

        Logger.logln(map.remove("18"));
        Logger.logln(map);
    }
}
