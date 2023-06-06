package seminar.lastseminar;

import java.util.Random;

public class Seminar4 {
    public static void main(String[] args) {
        Mapa<String, String> mapa = new Mapa<>();
        for (int i = 0; i < 5; i++) {
            mapa.put(Integer.toString(i + 10), Integer.toString(i));
        }
        // System.out.println(mapa.get("11"));
        System.out.println(mapa.remove("14"));
    }
}